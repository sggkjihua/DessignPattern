package Constructor;

public class PrototypePattern {
    public static void main(String[] args){
        BigProject b1 = new BigProject(20000);
        try {
            BigProject b2 = b1.cloneItself();
            b2.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

// 因为java里面object都已经有了cloneable的接口还有clone()的方法，只要处理好exception即可
// protected native Object clone() throws CloneNotSupportedException;
// protected 所以所有子类都可以使用，访问权限可以放开

// 子类不能缩小父类方法的访问权限。
//如果父类是protected，子类可以是public类型的。子类可以扩大访问权限。
class BigProject implements Cloneable{
    int size;
    public BigProject(int size){
        this.size = size;
    }
    public BigProject cloneItself() throws CloneNotSupportedException{
        return (BigProject) this.clone();
    }

    public void show(){
        System.out.println("My size is: "+size);
    }
}
