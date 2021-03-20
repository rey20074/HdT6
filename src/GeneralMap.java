import java.util.Collection;
import java.util.Set;

public interface GeneralMap<K,O> {

    public void Put(K key, O object);
    public void Remove(K key);
    public Set<K> KeySet();
    public boolean ContainsValue(O o);
    public O Get(K key);
    public boolean IsEmpty();
    public void Replace(K key, O object);
    public int Size();
    public boolean ContainsKey(K key);
    public Collection<O> Values();

}
