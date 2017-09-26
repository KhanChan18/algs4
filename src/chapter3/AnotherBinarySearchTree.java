package chapter3;

import java.util.Comparator;

public class AnotherBinarySearchTree<AnyType> {
    private BinaryNode<AnyType> root;
    private Comparator<? super AnyType> cmp;

    private static class BinaryNode<AnyType> {
        AnyType element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;

        BinaryNode(AnyType theElement) {
            this(theElement, null, null);
        }

        BinaryNode(AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt) {
            element = theElement;
            left = lt;
            right = rt;
        }
    }

    public AnotherBinarySearchTree() {
        this(null);
    }

    public AnotherBinarySearchTree(Comparator<? super AnyType> c) {
        root = null;
        cmp = c;
    }

    private int myCompare(AnyType lhs, AnyType rhs) {
        if (cmp != null)
            return cmp.compare(lhs, rhs);
        else
            return ((Comparable) lhs).compareTo(rhs);
    }

    private boolean contains(AnyType x, BinaryNode<AnyType> t) {
        if (t==null)
            return false;
        int compareResult = myCompare(x, t.element);
        if (compareResult < 0)
            return contains(x, t.left);
        else if (compareResult > 0)
            return contains(x, t.right);
        else
            return true;
    }

    public static void main(String[] args) {

    }

}
