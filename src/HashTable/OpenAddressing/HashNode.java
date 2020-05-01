package HashTable.OpenAddressing;

public class HashNode<K, V> {
    public K key;
    public V val;

    public HashNode(K key, V val) {
        this.key = key;
        this.val = val;
    }
}
