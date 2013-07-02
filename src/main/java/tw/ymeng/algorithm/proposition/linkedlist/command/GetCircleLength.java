package tw.ymeng.algorithm.proposition.linkedlist.command;

import tw.ymeng.algorithm.proposition.Command;
import tw.ymeng.algorithm.proposition.linkedlist.LinkedList;

public class GetCircleLength implements Command<Integer> {

    private LinkedList start;

    public GetCircleLength(LinkedList circleStartPoint) {
        this.start = circleStartPoint;
    }

    @Override
    public Integer execute() {
        int length = 1;
        LinkedList current = start;

        while (current.next() != start) {
            length++;
            current = current.next();
        }

        return length;
    }
}
