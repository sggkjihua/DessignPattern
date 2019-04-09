package Structural;

public class DecoratorPattern {
    public static void main(String[] args){
        // 写一个Beverage的接口，然后让Decorator来实现这个接口
        // 继承decorator的类都获取之前完成的Decorator作为参数，这样最后的成品就是最后的decorator了
        // 动态的给对象添加额外的职责。就功能来说，装饰模式比生产子类更为灵活。
        //
        //    程序希望动态的增强类的某对对象的功能，而不影响其他对象时
        //    采用继承来增强对象功能不利于系统的扩展和维护时
        //   
        //
        //      优点
        //    被装饰者和装饰者是松耦合关系。
        //    满足开-闭原则
        //    可以使用多个具体装饰器装饰具体组件的实例

        Beverage coffee = new Coffee();
        coffee = new Milk(coffee);
        coffee = new Pearl(coffee);
        System.out.println(coffee.describ());
        System.out.println("total price is :"+ coffee.getPrice());
    }
}


interface Beverage{
    double getPrice();
    String describ();
}

class Coffee implements Beverage{
    private String desc = "Choosing the maoshi coffee bean";
    @Override
    public double getPrice() {
        return 40;
    }
    @Override
    public String describ() {
        return desc;
    }
}


abstract class Decorator implements Beverage {
    private String desc = "I know nothing about the beverage, I am simply a decorator";
    Beverage beverage;
    public Decorator(Beverage beverage){
        this.beverage = beverage;
    }
    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String describ() {
        return desc;
    }
}

class Milk extends Decorator{
    private String desc = "Adding milk to beverage...";
    public Milk(Beverage beverage) {
        super(beverage);
    }
    @Override
    public double getPrice() {
        return 20+ beverage.getPrice();
    }

    @Override
    public String describ() {
        return beverage.describ()+ '\n' +desc;
    }
}

class Pearl extends Decorator{
    private String desc = "Adding Pearls to beverage...";
    public Pearl(Beverage beverage) {
        super(beverage);
    }
    @Override
    public double getPrice() {
        return 40+ beverage.getPrice();
    }

    @Override
    public String describ() {
        return beverage.describ()+ '\n' +desc;
    }
}
