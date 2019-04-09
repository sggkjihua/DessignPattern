import java.util.HashMap;
import java.util.Map;

public class FlyWeightPattern {
    public static void main(String[] args){
        //    一个应用程序使用大量的对象，这些对象之间部分属性本质上是相同的，这时应使用享元来封装相同的部分
        //    对象的多数状态都可变为外部状态，就可以考虑将这样的对象作为系统中发的享元来使用


        //  优点:
        //
        //   使用享元可以节省内存的开销，特别适合处理大量细粒度对象，
        //    这些对象的许多属性值是相同的，而且一旦创建则不允许修改
        //   享元模式中的享元可以使用方法的参数接收外部状态中的数据
        //     但外部状态数据不会干扰到享元中的内部数据，这就使享元可以在不同的环境中被共享。

        //   在JAVA语言中，String类型就是使用了享元模式。
        //    String对象是final类型，对象一旦创建就不可改变。
        //    在JAVA中字符串常量都是存在常量池中的，JAVA会确保一个字符串常量在常量池中只有一个拷贝。
        //    String str="string"，其中"str"就是一个字符串常量。

        // 一般而言，享元工厂对象在整个系统中只有一个，因此也可以使用单例模式。


        mFlyWeight mFlyWeight = FlyWeightFactory.getFlyWeight("Xiaolin",98);
        mFlyWeight mFlyWeight2 = FlyWeightFactory.getFlyWeight("Xiaolin",100);
        mFlyWeight mFlyWeight3 = FlyWeightFactory.getFlyWeight("Jihua",144);
        mFlyWeight mFlyWeight4 = FlyWeightFactory.getFlyWeight("Jihua",144);
        mFlyWeight.method();
        mFlyWeight2.method();
        mFlyWeight3.method();
        mFlyWeight4.method();

    }
}

interface FlyWeight{
    void method();
}


class mFlyWeight implements FlyWeight{
    String name;
    int size;
    public mFlyWeight(String name, int size){
        this.name = name;
        this.size = size;
    }
    @Override
    public void method() {
        System.out.println("My name is "+ name +" size: "+size
        );
    }
}

class FlyWeightFactory{
    private static Map<String, mFlyWeight> map = new HashMap<>();
    public static mFlyWeight getFlyWeight(String name, int size){
        map.putIfAbsent(name, new mFlyWeight(name, size));
        return map.get(name);
    }

}

