package Constructor;

public class FactoryMethod {
    public static void main(String[] args){
        // 工厂方法模式
        // 和工厂模式不同在于，之前的产品完全由一个工厂调用一个静态方法来生成，不过是根据传入参数不同来进行产品的区分
        // 现在是先建立一个抽象的工厂接口然后让每个工厂具体去继承这个接口，之后的生产在这一步就确定了


        // arraylist的iterator实现就是通过工厂方法模式的，或者说每个collection都是
        //具体：定义iterator接口，在具体的collection比如list里面定义自己的iterator实现这个接口，然后返回myIterator
        //在这里面，每个具体的collection就是具体的工厂，iterator就是产品

        //优点
        //更符合开-闭原则
        //新增一种产品时，只需要增加相应的具体产品类和相应的工厂子类即可
               // 简单工厂模式需要修改工厂类的判断逻辑，比如传进去的参数是ios还是 android
        //符合单一职责原则
               //每个具体工厂类只负责创建对应的产品 苹果工厂负责苹果，安卓工厂负责安卓
        //简单工厂中的工厂类存在复杂的switch逻辑判断，传入参数的判断
        //不使用静态工厂方法，可以形成基于继承的等级结构。原本由一个工厂全部完成，生成实例只需要类名.static方法


        //缺点
        //添加新产品时，除了增加新产品类外，还要提供与之对应的具体工厂类，系统类的个数将成对增加
        //由于考虑到系统的可扩展性，需要引入抽象层，在客户端代码中均使用抽象层进行定义，增加了系统的抽象性和理解难度

        //虽然保证了工厂方法内的对修改关闭，但对于使用工厂方法的类，如果要更换另外一种产品，仍然需要修改实例化的具体工厂类
        //一个具体工厂只能创建一种具体产品

       new AppleFactory().create().run();
       new AndroidFactory().create().run();

        // 开闭原则的定义
        // 定义：一个软件实体如类、模块和函数应该对扩展开放，对修改关闭。
        // 问题由来：在软件的生命周期内，因为变化、升级和维护等原因需要对软件原有代码进行修改时，可能会给旧代码中引入错误，也可能会使我们不得不对整个功能进行重构，并且需要原有代码经过重新测试。
        // 解决方案：当软件需要变化时，尽量通过扩展软件实体的行为来实现变化，而不是通过修改已有的代码来实现变化。
    }

}

interface Factory{
    Phone create();
}

class AppleFactory implements Factory{
    @Override
    public Phone create() {
        return new iPhone(10);
    }
}
class AndroidFactory implements Factory{

    @Override
    public Phone create() {
        return new Android(20);
    }
}


