package tw.ymeng.algorithm.proposition.linkedlist;

import tw.ymeng.algorithm.proposition.linkedlist.command.CheckCircle;

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

    public boolean hasCircle() {
        return new CheckCircle(this).execute();
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
