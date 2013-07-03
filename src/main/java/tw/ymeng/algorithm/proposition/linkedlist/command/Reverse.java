package tw.ymeng.algorithm.proposition.linkedlist.command;

import tw.ymeng.algorithm.proposition.Command;
import tw.ymeng.algorithm.proposition.linkedlist.LinkedList;

public class Reverse implements Command<LinkedList> {

    private LinkedList linkedList;

    public Reverse(LinkedList linkedList) {
        this.linkedList = linkedList;
    }

    @Override
    public LinkedList execute() {
        LinkedList prev = null, next, head = linkedList;

        while (head != null) {
            next = head.next();
            head.next(prev);
            prev = head;
            head = next;
        }
        head = prev;

        return head;
    }
}
