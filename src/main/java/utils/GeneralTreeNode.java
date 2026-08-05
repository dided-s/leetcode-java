package utils;

import java.lang.reflect.Array;

public class GeneralTreeNode<T extends GeneralTreeNode<T>> {

    public int val;
    private final int childCounts;
    private final T[] children;

    @SuppressWarnings("unchecked")
    public GeneralTreeNode(Class<T> type, int childCounts, int val) {
        this.childCounts = childCounts;
        this.children = (T[]) Array.newInstance(type, childCounts);
        this.val = val;
    }

    public GeneralTreeNode(T[] children, int val) {
        this.childCounts = children.length;
        this.children = children;
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public int getChildCounts() {
        return childCounts;
    }

    public T[] getChildren() {
        return children;
    }

    public void setVal(int val) {
        this.val = val;
    }
}