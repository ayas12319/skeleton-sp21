package deque;

public class ArrayDeque<T> implements Deque <T>{
    private T[] items;
    private int sizes;
    private int nextFirst;
    private int nextLast;
    private int capability;

    public ArrayDeque(){
        sizes = 0;
        capability = 8;
        nextFirst = 0;
        nextLast = 1;
        items = (T[]) new Object[capability];
    }

    @Override
    public int size(){
        return sizes;
    }

    private void resize() {
        int newcapability = 2 * capability;
        T[] temp = (T[]) new Object[newcapability];
        for (int i = 0; i < sizes; ++i) {
            int index = (nextFirst + 1 + i) % capability;
            temp[i] = items[index];
        }
        items = temp;
        capability = newcapability;
        nextFirst = capability - 1;
        nextLast = sizes;
    }

    @Override
    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        sizes -= 1;
        int index = (nextFirst + 1) % capability;
        T temp = items[index];
        items[index] = null;
        nextFirst = index;
        return temp;
    }

    @Override
    public T removeLast(){
        sizes -= 1;
        int index = (nextLast - 1 + capability) % capability;
        T temp = items[index];
        items[index] = null;
        nextLast = index;
        return temp;
    }

    @Override
    public void addFirst(T it){
        if(sizes == capability){
            resize();
        }
        sizes += 1;
        items[nextFirst] = it;
        nextFirst = (nextFirst - 1 + capability) % capability;
    }

    @Override
    public void addLast(T it){
        if(sizes + 1 == capability){
            resize();
        }
        sizes += 1;
        items[nextLast] = it;
        nextLast = (nextLast + 1 + capability) % capability;
    }

    @Override
    public T get() {
        T ele = items[(nextFirst + 1 + capability) % capability];
        return ele;
    }


}
