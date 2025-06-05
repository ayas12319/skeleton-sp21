package deque;

public interface Deque<T>{

    int size();

    default public boolean isEmpty(){
        if(size() == 0) return true;
        else return false;
    }

    void addFirst(T item);
    void addLast(T item);
    T removeFirst();
    T removeLast();
    T get();
}
