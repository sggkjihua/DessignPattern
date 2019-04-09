package Constructor;

public class BuilderPattern {
    public static void main(String[] args){
        //本质上就是让director委托一个具体的builder去创建产品
        //builder作为参数传进director里面，虽然是director调用的build，但实际上是这个concrete builder创建的
        //这里区别在于可以有很多个concrete builder，例如 iphonebuilder, android builder等等，但是director只是作为
        //接受这些 builder的中介而已，比如waiter和pizza maker的关系

        //感觉就像是在 abstract factory上面多添加了一层而已啊
        // 简化来说,建造者就是一条流水线,用来组装对象,知晓对象组装时的各个细节，建造者对细节的把控比抽象工厂深
        // 工厂不需要知道生产的具体细节,只要告诉下属(建造者)生产什么东西就行了，比如直接iPhone，都一样

        //优点
        //易于解耦
        //将产品本身与产品创建过程进行解耦，可以使用相同的创建过程来得到不同的产品。也就说细节依赖抽象，电脑的不同配置？。
        //易于精确控制对象的创建
        //将复杂产品的创建步骤分解在不同的方法中，使得创建过程更加清晰
        //易于拓展
        //增加新的具体建造者无需修改原有类库的代码，易于拓展，符合“开闭原则“。
        //每一个具体建造者都相对独立，而与其他的具体建造者无关，因此可以很方便地替换具体建造者或增加新的具体建造者，用户使用不同的具体建造者即可得到不同的产品对象。
        //3.2 缺点
        //建造者模式所创建的产品一般具有较多的共同点，其组成部分相似；如果产品之间的差异性很大，则不适合使用建造者模式，因此其使用范围受到一定的限制。
        //如果产品的内部变化复杂，可能会导致需要定义很多具体建造者类来实现这种变化，导致系统变得很庞大。
        //4. 应用场景
        //需要生成的产品对象有复杂的内部结构，这些产品对象具备共性；
        //隔离复杂对象的创建和使用，并使得相同的创建过程可以创建不同的产品


        Director director = new Director(new concereBuilder());
        director.build("i7",4);
        /*
        mDate mdate = new mDate();
        Constructor.Director director = new Constructor.Director(new conBuilder1(mdate));
        System.out.println(director.genDate(2019,4,9));
        director = new Constructor.Director(new conBuilder2(mdate));
        System.out.println(director.genDate(2018,4,10));
        */
    }
}

class Computer{
    String cpu;
    int memory;
    public Computer(){}
    public void setCpu(String core){
        this.cpu = core;
    }
    public void setMemory(int size){
        this.memory = size;
    }
}

interface Builder{
    void buildCPU(String core);
    void buildMemory(int size);
    Computer getProduct();
}

class concereBuilder implements Builder{
    Computer computer = new Computer();
    @Override
    public void buildCPU(String core) {
        computer.setCpu(core);
    }

    @Override
    public void buildMemory(int size) {
        computer.setMemory(size);
    }
    @Override
    public Computer getProduct(){
        return computer;
    }
}


class Director{
    Builder builder;
    public Director(Builder builder){
        this.builder = builder;
    }
    public Computer build(String core, int size){
        System.out.println("Building the cpu "+core);
        builder.buildCPU(core);
        System.out.println("Building the memory "+size);
        builder.buildMemory(size);
        return builder.getProduct();
    }
}


/*
class mDate{
    String date;
}

interface Constructor.Builder{
    mDate getDate();
    Constructor.Builder initBuilder(int y, int m, int d);
}


class conBuilder1 implements Constructor.Builder{
    private mDate mydate;
    public conBuilder1(mDate mydate){
        this.mydate = mydate;
    }

    @Override
    public mDate getDate() {
        return mydate;
    }
    @Override
    public conBuilder1 initBuilder(int y ,int m, int d){
        mydate.date = y+" year "+ m+"month "+ d+ "day";
        return this;
    }
}


class conBuilder2 implements Constructor.Builder{
    private mDate mydate;
    public conBuilder2(mDate mydate){
        this.mydate = mydate;
    }

    @Override
    public mDate getDate() {
        return mydate;
    }
    @Override
    public conBuilder2 initBuilder(int y ,int m, int d){
        mydate.date = y+" yy "+ m+"mm "+ d+ "dd";
        return this;
    }
}

class Constructor.Director{
    private Constructor.Builder builder;
    public Constructor.Director(Constructor.Builder builder){
        this.builder = builder;
    }
    public String genDate(int y, int m, int d){
        builder.initBuilder(y,m,d);
        return builder.getDate().date;
    }
}

*/
