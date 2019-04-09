package Constructor;

public class SingeletonPattern {
    public static void main(String[] args){
        //单例模式的懒汉式写法，线程不安全
        Single one = Single.getInstance(20);
        Single two = Single.getInstance(220);
        // 因为只有一个实例，所以后面生成的220已经没有用了
        System.out.println(two.getEdition());

    }
}





class Single{
    private static Single instance;
    int edition;
    private Single(int edition){
        this.edition = edition;
    }
    public static Single getInstance(int edition){
        if(instance==null){
            instance = new Single(edition);
        }
        return instance;
    }

    public int getEdition(){
        return edition;
    }
}

class ThreadSafeSingle{
    private int edition;
    private static ThreadSafeSingle instance;
    private ThreadSafeSingle(int edition){
        this.edition = edition;
    }
    //添加了synchronized之后就是线程安全的了
    //但一般不建议使用，一般是直接在类初始化的时候就进行instance = new Constructor.Single()
    public static synchronized ThreadSafeSingle getInstance(){
        if(instance==null){
            instance = new ThreadSafeSingle(20);
        }
        return instance;
    }
}
