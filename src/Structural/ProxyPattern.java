package Structural;

import java.util.Iterator;
import java.util.LinkedList;

public class ProxyPattern {
    public static void main(String[] args){
        // 和适配器模式的区别，适配器模式下接口不同，或者简单的说是实现方法名字不同，旧的接口不能重构掉
        // 而代理模式实现的方式接口名字是相同的


        //    程序可能不希望用户直接访问该对象，而是提供一个特殊的对象以控制对当前对象的访问。
        //    如果一个对象（例如很大的图像）需要很长时间才能完成加载。
        //    如果对象位于远程主机上，需要为用户提供访问该远程对象的能力

        // 好处
        // 代理模式可以屏蔽用户真正请求的对象，是用户程序和正在的对象解耦
        // 使用代理来担当那些创建耗时的对象的替身

        //Structural.Proxy proxy = new Structural.Proxy();
        //proxy.method(55);

        // 一个用户不想或者不能够直接引用一个对象（或者设计者不希望用户直接访问该对象
        // 而代理对象可以在客户端和目标对象之间起到中介的作用。
        // 而且这个代理对象中，我们可以做更多的操作。

        //相比于适配器的应用场景，代理就不一样了，
        //虽然代理也同样是增加了一层，但是，代理提供的接口和原本的接口是一样的
        //代理模式的作用是不把实现直接暴露给client，而是通过代理这个层，代理能够做一些处理；

        Stack<Integer> st = new Stack<>();
        for(int i=0;i<10;i++) st.push(i);
        while(!st.isEmpty())System.out.print(st.pop()+" ");
    }
}


// 很使用使用代理模式利用LinkedList实现一个栈
// 方法名字都一样，不过是让字面上的功能更为明确
// LinkedList竟然可以直接作为stack还有双端队列来使用
class Stack<T> implements Iterable<T>{
    LinkedList<T> stack = new LinkedList<>();
    public Stack(){
        stack = new LinkedList<>();
    }
    public T peek(){
        return stack.peek();
    }

    public T pop(){
        return stack.pop();
    }
    public void push(T t){
        stack.push(t);
    }
    public boolean isEmpty(){
        return stack.isEmpty();
    }


    @Override
    public Iterator<T> iterator() {
        return stack.iterator();
    }
}




interface Target{
    void method(int num);
}

class ConcreteTarget implements Target{
    @Override
    public void method(int num) {
        System.out.print(num);
    }
}

class Proxy implements Target{
    ConcreteTarget target;
    @Override
    public void method(int num) {
        if(target==null) target = new ConcreteTarget();
        target.method(num);
    }
}