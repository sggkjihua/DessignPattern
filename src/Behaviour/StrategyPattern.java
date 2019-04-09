public class StrategyPattern {
    public  static void main(String[] args){
        //策略模式在每一个时刻只能使用一个具体的策略实现对象
        //虽然可以动态地在不同的策略实现中切换，但是同时只能使用一个
        //切换可以使用那些 set Field来实现

        // 就好像你可以让自己的客户端设置成不同的加密方法这样
        // 策略模式在每一个时刻只能使用一个具体的策略实现对象
        // 虽然可以动态地在不同的策略实现中切换，但是同时只能使用一个

        Method local = new SaveLocal();
        Method internet = new SaveInternet();
        SaveClient saveClient = new SaveClient(local);
        saveClient.save("Xiaolinguo");
        saveClient.setMethod(internet);
        saveClient.save("Xujihua");
    }

}

interface Method{
    public void save(String data);
}

class SaveLocal implements Method{
    @Override
    public void save(String data) {
        System.out.println("Saving to local: "+ data);
    }
}

class SaveInternet implements Method{
    @Override
    public void save(String data) {
        System.out.println("Saving to internet: "+data);
    }
}

class SaveClient{
    Method method;
    public SaveClient(Method method){
        this.method = method;
    }
    public void setMethod(Method method){
        this.method = method;
    }
    public void save(String data){
        method.save(data);
    }
}


