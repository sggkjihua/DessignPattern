package Behaviour;

import java.nio.channels.MembershipKey;
import java.util.HashSet;
import java.util.Set;

public class CommandPattern {
    public static void main(String[] args){
        //  将一个请求封装为一个对象，从而使用户可用 不同的请求 对客户进行 参数化；
        //  对请求排队或记录请求日志，以及支持可撤销的操作。

        // 这个例子里面，makeFile是真正的执行者，有create 和delete方法
        // command 类代表create和delete,里面封装了makeFile类，然后分别执行create和delete
        // client封装了command,可以切换，delete或者create,然后接受传入的参数进行execute
        // client --> command --> makefile.execute
        MakeFile makeFile = new MakeFile();
        Delete delete = new Delete(makeFile);
        Create create = new Create(makeFile);
        Client client = new Client(delete);
        client.execute("tsilaji.txt");
        client.setCommand(create);
        client.execute("Guoxiaolinaiwo");
    }
}

class MakeFile{
    Set<String> files;
    public MakeFile(){
        files = new HashSet<>();
    }
    public String  createFile(String name){
        files.add(name+".txt");
        System.out.println("file "+name+" successfully added");
        return name+".txt";
    }
    public boolean deleteFile(String name){
        return files.remove(name);
    }
}


interface Command{
    void execute(String fileName);
}

class Delete implements Command{
    MakeFile makeFile;
    public Delete(MakeFile makeFile){
        this.makeFile = makeFile;
    }
    @Override
    public void execute(String fileName) {
        makeFile.deleteFile(fileName);
    }
}

class Create implements Command{
    MakeFile makeFile;
    public Create(MakeFile makeFile){
        this.makeFile = makeFile;
    }
    @Override
    public void execute(String fileName) {
        makeFile.createFile(fileName);
    }
}

class Client{
    Command command;
    public Client(Command command){
        this.command = command;
    }

    public void setCommand(Command command){
        this.command = command;
    }
    public void execute(String name){
        command.execute(name);
    }
}