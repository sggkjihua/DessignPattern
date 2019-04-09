import javafx.util.Pair;

public class Dispatch {
    public static  void main(String[] args){
        // 静态类型: Parent, 动态类型: Child
        Parent p = new Child();
        // 过程--> 静态为parent,但实际调用方法是child里面的accept
        // accept里面通过visitor的visit方法将动态类型Child传进自己的visit方法中
        // 识别为Child动态类而不是Parent类！
        // 这就避免了动态类直接作为重载被识别成静态类别

        //静态分派发生在编译时期，分派根据静态类型信息发生，如方法重载就是静态分派
        //动态分派发生在运行时期，动态分派动态地转换掉某个方法，面向对象的语言利用动态分派来实现方法转换产生多态性.

        //一个方法根据两个宗量的类型来决定执行不同的代码，这就是"双分派"或者"双重分派"
        // Java 支持静态多分派，但是是动态单分派
        // visitor pattern 就是为了让java
        // 可以通过接收者和参数（实际类型）来判断方法的调用，
        // 但是，Java是动态单分派的，只能通过接收者来动态分派，
        // 但使用访问者模式，通过两次方法调用，我们依然实现了双重分派
        p.accept(new Visitor());
        // 但是只能调用父类里面同样拥有的方法
        // 如果是父类里面没有的，那么就只能显式地将其cast成为子类然后才能调用相应的方法，否则编译不通过

        // 一个对象又叫做它所包含的方法的接收者，java中的动态分派，要调用哪一个方法，是由这个对象的(runtime type)真实类型决定的。

        // 调用方式实际上调用的是动态类型的方法，意即Child里面重写的方法
        // 但是作为参数而言，还是认作Parent

        // 静态分派(Static Dispatch)发生在编译时期，分派根据静态类型信息发生。
        // 静态分派对于我们来说并不陌生，方法重载就是静态分派。
        // [重载]的分派是根据静态类型进行的。

        // 动态分派(Dynamic Dispatch)发生在运行时期，动态分派动态地置换掉某个方法。


        //p.print();
        // 重载的方法调用的实际上是景甜类型及
        //TestDispatch.print(p);
    }
}

class Visitor{
    public void visit(Child c){
        c.print();
    }
    public void visit(Parent p){
        p.print();
    }
}

class Parent{
    public Parent(){
        //System.out.println("Initializing parent...");
    }
    public void print(){
        System.out.println("I am parent!");
    }
    public void accept(Visitor v){
        v.visit(this);
    }

}
class TestDispatch{
    static void print(Parent p){
        System.out.println("Printing parent...");
    }
    static void print(Child c){
        System.out.println("Printing child...");
    }
}

class Child extends Parent{
    public Child(){
        //System.out.println("Initializing child...");
    }

    public void doNothing(){
        System.out.println("Runtime type is child");
    }
    @Override
    public void print(){
        System.out.println("I am child!");
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}
