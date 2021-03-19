import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Set;

public class NewLinkedHashMap<K,O> extends LinkedHashMap<K, O>  implements GeneralMap<K, O> {

    @Override
    public void Put(K key, O object) {
        put(key,object);
    }

    @Override
    public void Remove(K key) {
        remove(key);
    }

    @Override
    public Set KeySet() {
        return keySet();
    }

    @Override
    public boolean ContainsValue(O o) {
        return containsValue(o);
    }

    @Override
    public O Get(K key) {
        return get(key);
    }

    @Override
    public boolean IsEmpty() {
        return isEmpty();
    }

    @Override
    public void Replace(K key, O object) {
        replace(key,object);
    }

    @Override
    public int Size() {
        return size();
    }

    @Override
    public boolean ContainsKey(K key) {
        return containsKey(key);
    }

    @Override
    public Collection<O> Values() {
        return values();
    }
}
