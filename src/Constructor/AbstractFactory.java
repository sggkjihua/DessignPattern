package Constructor;

public class AbstractFactory {
    public static void main(String[] args){
        /*
        提供一个创建一系列或相互依赖对象的接口，而无须指定他们的具体的类。
        上述生成魅族产品的例子中，我们只生产了手机，但是它不止有手机一种产品，可能还有其他的
        比如耳机，为了还可以生成耳机，我们需要对上例进行扩展

        在只有一个产品族的情况下，抽象工厂模式实际上退化到工厂方法模式（不如上例减去耳机这种产品，就回到工厂方法模式了
         */

        // 所以工厂方法模式和抽象工厂模式的区别在于产品数量的多少

        // 如果都希望通过一个接口来获得Iterator，
        // 写Interator接口，要求实现next, hasNext
        // map和collection的Iterator都继承这个接口，然后重写里面的方法
        // 大的Iterator factory 写两个函数，分别返回mapIterator和collection的Iterator
        // 生成两个map和list之后，用父类IIterator去接map.iterator() 和 list.iterator()
        // 所以在这里面，factory是根据传进来的map或者是collection来返回相应的iterator的



        // 简单工厂模式是由一个具体的类去创建其他类的实例，父类是相同的，父类是具体的。
        // 工厂方法模式是有一个抽象的父类定义公共接口，子类负责生成具体的对象，这样做的目的是将类的实例化操作延迟到子类中完成。
        // 抽象工厂模式提供一个创建一系列相关或相互依赖对象的接口，而无须指定他们具体的类。它针对的是有多个产品的等级结构。而工厂方法模式针对的是一个产品的等级结构。

        IphoneAbstractFactory iphoneAbstractFactory = new IphoneAbstractFactory();
        AndroidAbstractFactory androidAbstractFactory = new AndroidAbstractFactory();
        iPhone x = iphoneAbstractFactory.createPhone();
        Airpods airpods = iphoneAbstractFactory.createHandset();
        Android huawei = androidAbstractFactory.createPhone();
        XiaomiHandset xiaomiHandset = androidAbstractFactory.createHandset();
        x.run();
        airpods.run();
        huawei.run();
        xiaomiHandset.run();
    }
}

interface Handset{
    void run();
}

class Airpods implements Handset{
    @Override
    public void run(){
        System.out.println("乔帮主的BGM");
    }
}

class XiaomiHandset implements Handset{
    @Override
    public void run(){
        System.out.println("金轮法王的BGM");
    }
}


interface Abstractf{
    Phone createPhone();
    Handset createHandset();
}

class IphoneAbstractFactory implements Abstractf{
    @Override
    public iPhone createPhone() {
        return new iPhone(10);
    }

    @Override
    public Airpods createHandset() {
        return new Airpods();
    }
}


class AndroidAbstractFactory implements Abstractf{
    // 重写的方法返回的值可以比之前定义的范围要小
    // 比如这里就用了Phone的子类iPhone和Android
    @Override
    public Android createPhone() {
        return new Android(20);
    }

    @Override
    public XiaomiHandset createHandset() {
        return new XiaomiHandset();
    }
}