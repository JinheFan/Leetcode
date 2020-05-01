package HashTable.OpenAddressing;

public class OpenAddressingImpl<K, V> {
    private int capacity;
    private int size;
    private HashNode[] hashNodes;

    public OpenAddressingImpl() {
        this.capacity = 10;
        hashNodes = new HashNode[capacity];
    }

    public OpenAddressingImpl(int capacity) {
        this.capacity = capacity;
        hashNodes = new HashNode[capacity];
    }

    public int Hash(K key){
        return key.hashCode() % capacity;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void put(K key, V val){
        HashNode hashNode = new HashNode(key, val);
        int index = Hash(key);
        int startIndex = index;

        while(hashNodes[index] != null){
            if(hashNodes[index].key.equals(key)){
                hashNodes[index].val = val;
                return;
            }
            ++index;
            index %= capacity;
            if(index == startIndex){
                resize();
                index = Hash(key);
                startIndex = index;
            }
        }
        hashNodes[index] = hashNode;
        size++;
    }

    public void resize(){
        HashNode[] oldHashNode = hashNodes;
        capacity = capacity * 2;
        hashNodes = new HashNode[capacity];
        for(int i = 0; i < oldHashNode.length; i++){
            if(oldHashNode[i] != null){
                put((K) oldHashNode[i].key, (V) oldHashNode[i].val);
            }
        }
    }

    public V get(K key){
        int index = Hash(key);
        while(hashNodes[index] != null){
            if(hashNodes[index].key.equals(key)){
                return (V) hashNodes[index].val;
            }
            ++index;
            index %= capacity;
        }
        return null;
    }

    public V delete(K key){
        int index = Hash(key);
        while(hashNodes[index] != null){
            if(hashNodes[index].key.equals(key)){
                V res = (V) hashNodes[index].val;
                hashNodes[index] = null;
                return res;
            }
            ++index;
            index %= capacity;
        }
        return null;
    }
}
