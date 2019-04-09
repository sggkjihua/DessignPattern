import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ComponentPattern {
    public static void main(String[] args){
        /*
        关键词为一致对待，相同接口

        当想表示对象的部分-整体层次结构。
        希望用户用一致的方式处理个体对象和组合对象。

        优点：
        组合模式中包含个体对象和组合对象，并形成树形结构，使用户可以方便地处理个体对象和组合对象。
        组合对象和个体对象实现了相同的接口，用户一般无须区分个体对象和组合对象。
        当增加新的Composite节点和Leaf节点时，用户的重要代码不需要做出修改
         */

         // 文件和目录（Composite和Leaf）实现了相同的接口，所以操作起来很方便，包括迭代。

        Folder r = new Folder("root");
        File file1 = new File("Document1.txt");
        File file2 = new File("Resume.pdf");
        Folder image = new Folder("image");
        r.addFolder(image);
        r.addFile(file1);
        r.addFile(file2);
        Iterator<Component> it = r.ITERATOR();
        while(it.hasNext()){
            Component component = it.next();
            if(component instanceof File){
                System.out.print("File: ");
            }else{
                System.out.print("Folder: ");
            }
            component.display();
        }
    }




}


interface Component{
    void addFile(Component file);
    Component addFolder(Component folder);
    void deleteFolder(Component folder);
    void deleteFile(Component file);
    Iterator<Component> ITERATOR();
    List<Component> getFile();
    List<Component> getFolder();
    List<Component> getAll();
    void display();
}

class Folder implements Component{
    private String name;
    private List<Component> files;
    private List<Component> folders;

    public Folder(String name) {
        this.name = name ;
        files = new ArrayList<>();
        folders = new ArrayList<>();
    }
    @Override
    public void addFile(Component file) {
        files.add(file);
    }

    @Override
    public Component addFolder(Component folder) {
        folders.add(folder);
        return this;
    }

    @Override
    public void deleteFolder(Component folder) {
        folders.remove(folder);
    }

    @Override
    public void deleteFile(Component file) {
        files.remove(file);
    }

    @Override
    public Iterator<Component> ITERATOR() {
        List<Component> all = getAll();
        return all.iterator();
    }

    @Override
    public List<Component> getFile() {
        return files;
    }

    @Override
    public List<Component> getFolder() {
        return folders;
    }

    @Override
    public List<Component> getAll() {
        List<Component> list = new ArrayList<>(files);
        list.addAll(folders);
        return list;
    }

    @Override
    public void display() {
        System.out.println(name);
    }
}


class File implements Component{
    String name;
    public File(String name){
        this.name = name;
    }

    @Override
    public void addFile(Component file) {

    }

    @Override
    public Component addFolder(Component folder) {
        return null;
    }

    @Override
    public void deleteFolder(Component folder) {

    }

    @Override
    public void deleteFile(Component file) {

    }

    @Override
    public Iterator<Component> ITERATOR() {
        return null;
    }

    @Override
    public List<Component> getFile() {
        return null;
    }

    @Override
    public List<Component> getFolder() {
        return null;
    }

    @Override
    public List<Component> getAll() {
        return null;
    }

    @Override
    public void display() {
        System.out.println(name);
    }
}