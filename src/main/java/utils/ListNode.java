package utils;

public class ListNode<T extends ListNode<T>> {
    public int val;
    public T next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, T next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }

    public int getVal() {
        return val;
    }

    public T getNext() {
        return next;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(T next) {
        this.next = next;
    }
}