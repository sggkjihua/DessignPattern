public class ChainOfResponsibility {
    public static void main(String[] args){
        // 使很多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系。
        // 将这些对象连成一条链，并沿着这条链传递该请求，直到有一个对象处理它为止。
        //
        // 何时使用
        // 有许多对象可以处理用户请求，希望程序在运行期间自动确定处理用户的那个对象。
        // 希望用户不必明确指定接收者的情况下，想多个接受者的一个提交请求
        // 程序希望动态的指定可处理用户请求的对象集合
        // 
        // 优点
        //
        // 低耦合
        // 可以动态的添加删除处理者或重新指派处理者的职责
        // 可以动态改变处理者之间的先后顺序

        Handler h3 = new Handler(null,1000,3);
        Handler h2 = new Handler(h3, 500, 2);
        Handler h1 = new Handler(h2, 10, 1);
        h1.handle(900);
    }
}

class Handler{
    Handler next;
    int bound;
    int seq;
    public Handler(Handler next, int bound, int seq){
        this.next = next;
        this.bound = bound;
        this.seq = seq;
    }
    public void handle(int num){
        if(num>=bound){
            System.out.println("Sorry I am seq "+seq+" I am not capable of handling this number");
            if(next==null){
                System.out.println("Nobody could handle this number");
            }else{
                next.handle(num);
            }
        }else{
            System.out.println("I am seq: "+ seq+" I am currently handling number "+num);
        }
    }
}


