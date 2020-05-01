package HashTable.SeperateChaining;

public class SeperateChainingImpl<K, V> {
    private int capacity;
    private int size;
    private HashNode[] hashNodes;

    public SeperateChainingImpl() {
        this.capacity = 10;
        this.hashNodes = new HashNode[capacity];
    }

    public SeperateChainingImpl(int capacity) {
        this.capacity = capacity;
        this.hashNodes = new HashNode[capacity];
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int Hash(K key){
        return key.hashCode() % capacity;
    }

    public void put(K key, V val){
        HashNode hashNode = new HashNode(key, val);
        int index = Hash(key);
        HashNode curNode = hashNodes[index];
        HashNode preNode = null;

        if(curNode == null){
            hashNodes[index] = hashNode;
        }else {
            while(curNode != null){
                if(curNode.key.equals(key)){
                    curNode.val = val;
                    return;
                }
                preNode = curNode;
                curNode = curNode.next;
            }
        }
        preNode.next = hashNode;
        size++;
    }

    public V get(K key){
        int index = Hash(key);
        HashNode curNode = hashNodes[index];

        while(curNode != null){
            if(curNode.key.equals(key)){
                return (V) curNode.val;
            }
            curNode = curNode.next;
        }
        return null;
    }

    public V delete(K key){
        int index = Hash(key);
        HashNode curNode = hashNodes[index];
        HashNode preNode = null;

        while(curNode != null){
            if(curNode.key.equals(key)){
                break;
            }
            preNode = curNode;
            curNode = curNode.next;
        }

        if(curNode == null){
            return null;
        }else if (preNode == null){
            hashNodes[index] = curNode.next;
        }else {
            preNode.next = curNode.next;
        }
        size--;
        return (V) curNode.val;
    }
}
