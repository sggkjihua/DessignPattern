package Structural;

public class AdaptorPattern {
    public static void main(String[] args){
        // class实现接口，但是同样的功能已经有别的class能够实现了，就是接口名字不同而已，那么就额可以通过适配器模式进行拓展
        // 类适配器模式：extends通过继承，然后调用super.method()即可
        // 对象适配器模式：通过将该类作为某个成员然后调用其方法即可

        // 一个程序想使用已经存在的类，但是该类所实现的接口和当前程序所使用的接口不一致时
        // 就看作函数名称不一致吧， 人家是playMP3，但你类的定义一定要实现playFlac，可以调用别人的playMP3来实现
        // 这就是接口不同的定义

        // 类适配器与对象适配器的区别就是类适配器需要继承被适配者
        // 而Java的单继承的，所以通常情况下，使用对象适配器更好。
        // 如果目标接口中的方法数与被适配器者中的数目相同，就是完全适配
        // 若目标接口中的方法更多，则是剩余适配，反之，为不完全适配。


        iPhone x = new iPhone(10);
        x.play("何日君再来");
        mIphone x1 = new mIphone(11);
        x1.play("明日君不在");
    }
}

interface Player{
    void play(String name);
}

class MusicPlayer{
    public void run(String name){
        System.out.println("Playing "+name);
    }
}

// 这是一个class adaptor，通过继承来获得
// 类适配器 Class Adaptor
class iPhone extends MusicPlayer implements Player{
    int edition;
    public iPhone(int edition){
        this.edition = edition;
    }
    @Override
    public void play(String name) {
        super.run(name);
    }
}

// 对象适配器 Object Adaptor
// 这是通过将adaptee作为自己的field来实现adaptor
class mIphone implements Player{
    int edition;
    MusicPlayer musicPlayer;
    public mIphone(int edition){
        this.edition = edition;
        musicPlayer = new MusicPlayer();
    }
    @Override
    public void play(String name) {
        musicPlayer.run(name);
    }
}