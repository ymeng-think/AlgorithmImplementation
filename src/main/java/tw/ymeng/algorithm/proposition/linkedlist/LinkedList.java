package tw.ymeng.algorithm.proposition.linkedlist;

import sun.jvm.hotspot.utilities.ReversePtrs;
import tw.ymeng.algorithm.proposition.linkedlist.command.CheckCircle;
import tw.ymeng.algorithm.proposition.linkedlist.command.GetCircleLength;
import tw.ymeng.algorithm.proposition.linkedlist.command.Reverse;

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
        return new GetCircleLength(this).execute();
    }

    public LinkedList reverse() {
        return new Reverse(this).execute();
    }
}
