package Constructor;

public class FactoryPattern {
    public static void main(String[] args){
        // factory pattern工厂模式

        // Pros
        // 一个调用者想创建一个对象，只要知道其名称就可以了
        // 扩展性高，如果想增加一个产品，只要扩展一个工厂类就可以
        // 屏蔽产品的具体实现，调用者只关心产品的接口。


        // Cons
        // 工厂类集中了所有实例（产品）的创建逻辑，一旦这个工厂不能正常工作，整个系统都会受到影响；
        //违背“开放 - 关闭原则”，一旦添加新产品就不得不修改工厂类的逻辑，这样就会造成工厂逻辑过于复杂。
        //简单工厂模式由于使用了静态工厂方法，静态方法不能被继承和重写，会造成工厂角色无法形成基于继承的等级结构。

        // 同一个工厂，根据不同的传入参数生产不同的产品
        Phone ip = PhoneFactory.createPhone("ios");
        ip.run();
        Phone huawei = PhoneFactory.createPhone("android");
        huawei.run();


    }

}

class PhoneFactory{
    public static Phone createPhone(String os){
        if(os.equals("ios")) {
            return new iPhone(10);
        }
        else{
            return new Android(20);
        }
    }
}


interface Phone{
     void run();
     int getEdition();
}

class iPhone implements Phone{
    int edition;
    public iPhone(int edition){
        this.edition = edition;
    }

    @Override
    public void run() {
        System.out.println("Iphone xs is currently running");
    }

    @Override
    public int getEdition() {
        return edition;
    }
}

class Android implements Phone{
    int edition;
    public Android(int edition){
        this.edition = edition;
    }

    @Override
    public void run() {
        System.out.println("Huawei 20 is currently running");
    }

    @Override
    public int getEdition() {
        return edition;
    }
}