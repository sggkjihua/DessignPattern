package Structural;

public class BridgePattern {
    public static void main(String[] args){
        // 抽象类里面某个field可以是多种同类型的继承，实际上调用某个function的时候里面用的是这个field里面的方法

        // 抽象和实现者都可以继承当方式独立地扩充而互不影响，
        // 程序在运行期间可能需要动态的将一个抽象的子类的实例与一个实现者的子类的实例进行组合。

        // 抽象的类可以自由地变，里面这个field也可以自己变，所以抽象类本身是一个接口，这个field也是以一个接口来实现的

        //意图：将抽象部分与实现部分分离，使它们都可以独立的变化。

        //主要解决：在有多种可能会变化的情况下，用继承会造成类爆炸问题，扩展起来不灵活。

        //何时使用：实现系统可能有多个角度分类，每一种角度都可能变化。

        //如何解决：把这种多角度分类分离出来，让它们独立变化，减少它们之间耦合。

        //关键代码：抽象类依赖实现类

        //    抽象 abstract
        //    细化抽象 extend abstract
        //    实现者  interface
        //    具体实现者 implement interface

        Object data = "Xiaolin Guo";
        SaveToFile saveToFile = new SaveToFile();
        SaveToDB saveToDB = new SaveToDB();
        LocalSave localSave = new LocalSave(saveToFile);
        InternetSave internetSave = new InternetSave(saveToDB);
        localSave.save(data);
        internetSave.save(data);
    }
}

interface mSaveData{
    void save(Object data);
}

class SaveToFile implements mSaveData{
    @Override
    public void save(Object data) {
        System.out.println(data+" saving to file");
    }
}

class SaveToDB implements mSaveData{
    @Override
    public void save(Object data){
        System.out.println(data+ " saving to database");
    }
}


// 抽象类也可以有构造函数
abstract class AbstractSave{
    mSaveData data;
    public AbstractSave(mSaveData data){
        this.data = data;
    }
    abstract void save(Object saveData);
}

class LocalSave extends AbstractSave{
    public LocalSave(mSaveData data){
        super(data);
    }
    @Override
    void save(Object mdata) {
        System.out.print("Saving local: ");
        data.save(mdata);
    }
}

class InternetSave extends AbstractSave{
    public InternetSave(mSaveData data){
        super(data);
    }
    @Override
    void save(Object mdata) {
        System.out.print("Saving to Internet: ");
        data.save(mdata);
    }
}


