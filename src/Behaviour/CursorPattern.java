import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class CursorPattern {
    public static  void main(String[] args){
        Map<String, Integer> map = new Map<String, Integer>();
        map.put("Xiaolin",1);
        map.put("Jihua",2);
        mIterator<String> mIterator = map.iterator();
        System.out.println(map.size());
        while(mIterator.hasNext()){
            System.out.println(mIterator.next());
        }
    }
}


interface mIterator<T>{
    boolean hasNext();
    T next();
}

class Map<K,V> extends HashMap<K,V>{
    public mIterator<K> iterator(){
        Set<K> set = this.keySet();
        return new conIterator(set);
    }
}

class conIterator<T> implements mIterator<T>{
    Iterator<T> tIterator;
    public conIterator(Set<T> set){
        tIterator = set.iterator();
    }
    @Override
    public boolean hasNext() {
        return tIterator.hasNext();
    }

    @Override
    public T next() {
        return tIterator.next();
    }
}
