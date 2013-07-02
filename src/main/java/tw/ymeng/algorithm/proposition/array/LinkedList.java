package tw.ymeng.algorithm.proposition.array;

public class LinkedList {

    private int data;
    private LinkedList next;

    public LinkedList(int data) {
        this.data = data;
    }

    public LinkedList next() {
        return next;
    }

    public void next(LinkedList list) {
        this.next = list;
    }

    public int data() {
        return data;
    }

    /**
     * 建立两个指针, 从header一起向前跑，一个步长为1，一个步长为2，用while（直到步长2的跑到结尾）检查两个指针是否相等，
     * 直到找到为止。
     * */
    public boolean hasCircle() {
        LinkedList first = this, second = this;
        while (second.next() != null && second.next().next() != null) {
            second = second.next().next();
            first = first.next();
            if (second == first) {
                return true;
            }
        }
        return false;
    }

    public int getCircleLength() {
        int length = 1;
        LinkedList current = this;

        while (current.next() != this) {
            length++;
            current = current.next();
        }

        return length;
    }
}
