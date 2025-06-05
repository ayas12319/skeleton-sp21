package deque;

import java.util.Iterator;
//双向循环链表的实现
public class LinkedListDeque<T> implements Deque <T> {
        private class IntNode{
            public T item;
            public IntNode next;
            public IntNode prev;
            public IntNode(T i){
                next = null;
                prev = null;
                item = i;
            }
        }
        private IntNode sential;
        private IntNode tail;
        private int sizes;

        public LinkedListDeque() {
             sizes = 0;
             sential = new IntNode(null);
             sential.next = sential;
             sential.prev = sential;
             tail = sential;
        }

        @Override
        public int size(){
            return sizes;
        }

        @Override
        public void addFirst(T it) {
            sizes += 1;
            IntNode temp = new IntNode(it);
            temp.next = sential.next;
            temp.prev = sential;
            sential.next.prev = temp;
            sential.next = temp;
        }

        @Override
        public void addLast(T it){
            sizes += 1;
            IntNode temp = new IntNode(it);
            temp.prev = tail;
            temp.next = sential; //循环链表
            tail.next = temp;
            sential.prev = temp;
            tail = temp;
        }


        public void printDeque(){
            IntNode temp = sential.next;
            while(temp.next != sential){
                System.out.println(temp.next.item + " ");
                temp = temp.next;
            }
            System.out.println(tail.item + " ");
            System.out.println();
        }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public T removeFirst(){
            if(size() == 0) return null;
            sizes -= 1;
            T it = sential.next.item;
            sential.next = sential.next.next;
            sential.next.prev = sential;
            return it;
        }

    @Override
    public boolean isEmpty() {
        return Deque.super.isEmpty();
    }

    @Override
    public T removeLast(){
            if(size() == 0) return null;
            sizes -= 1;
            T it = tail.item;
            tail.prev.next = sential;
            sential.prev = tail.prev;
            tail = tail.prev;
            return it;
        }

        public T get(int index){
            if(index >= sizes) return null;
            IntNode temp = sential;
            while(index != 0){
                temp = temp.next;
                index --;
            }
            T it = temp.item;
            return it;
        }

        public boolean equals(LinkedListDeque other){
            IntNode temp1 = sential;
            IntNode temp2 = other.sential;
            temp1 = temp1.next;
            temp2 = temp2.next;
            while(temp1 != null){
                if(temp1.item != temp2.item) return false;
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            return true;
        }

        @Override
    public T get(){
            T ele = sential.next.item;
            return ele;
        }

}
