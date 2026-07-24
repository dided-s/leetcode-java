package utils;

public class GeneralNode<T extends GeneralNode<T>> {

    public int val;
    public T next;

    public GeneralNode() {
    }

    public GeneralNode(int val) {
        this.val = val;
    }

    public GeneralNode(int val, T next) {
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

    public void print() {
        GeneralNode<T> node = this;

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public void print(String message) {
        System.out.println(message);
        print();
    }
}