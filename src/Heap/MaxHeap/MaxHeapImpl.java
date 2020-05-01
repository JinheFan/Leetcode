package Heap.MaxHeap;

public class MaxHeapImpl<E extends Comparable<E>> {

    private int capacity;
    private int size;
    private E[] data;

    public MaxHeapImpl(E[] data) {
        this.data = data;
        this.capacity = data.length;
        this.size = data.length;
    }

    public MaxHeapImpl() {
        this.capacity = 10;
        this.data = (E[]) new Comparable[capacity];
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private int getParentIndex(int childIndex){
        return (childIndex - 1) / 2;
    }

    private int getLeftChildIndex(int index){
        return index * 2 + 1;
    }

    private int getRightchildIndex(int index){
        return index * 2 + 2;
    }

    private E getParent(int index){
        return data[getParentIndex(index)];
    }

    private E getLeftChild(int index){
        return data[getLeftChildIndex(index)];
    }

    private E getRightIndex(int index){
        return data[getRightchildIndex(index)];
    }

    private void swap(int i, int j){
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private void siftUp(){
        int index = size - 1;
        while(getParentIndex(index) >= 0 && getParent(index).compareTo(data[index]) < 0){
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void siftDown(){
        int index = 0;
        while(getLeftChildIndex(index) < size){
            int biggerChildIndex = getLeftChildIndex(index);
            if(getRightchildIndex(index) < size && getLeftChild(index).compareTo(getRightIndex(index)) < 0){
                biggerChildIndex = getRightchildIndex(index);
            }
            if(data[index].compareTo(data[biggerChildIndex]) < 0){
                swap(index, biggerChildIndex);
            }else {
                break;
            }
            index = biggerChildIndex;
        }
    }

    public void put(E e){
        if(data.length == capacity){
            expandCapacity();
        }
        data[size] = e;
        size++;
        siftUp();
    }

    private void expandCapacity(){
        E[] newData = (E[]) new Comparable[capacity * 2];
        for(int i = 0; i < data.length; i++){
            if(data[i] != null){
                newData[i] = data[i];
            }
        }
        capacity *= 2;
        data = newData;
    }

    public E peek(){
        if(size == 0){
            return null;
        }
        return data[0];
    }

    public E poll(){
        if(size == 0){
            return null;
        }
        E res = data[0];
        data[0] = data[size - 1];
        data[size - 1] = null;
        siftDown();
        size--;
        return res;
    }

    public void print(){
        for(int i = 0; i < data.length; i++){
            System.out.println(data[i]);
        }
    }

    public static void main(String[] args) {
        MaxHeapImpl<Integer> maxHeap = new MaxHeapImpl<>();
        Integer[] nums = new Integer[]{2, 4, 5, 7, 9};
        for(Integer num : nums){
            maxHeap.put(num);
        }
        maxHeap.print();
    }
}
