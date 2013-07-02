package tw.ymeng.algorithm.proposition.linkedlist.command;

import tw.ymeng.algorithm.proposition.Command;
import tw.ymeng.algorithm.proposition.linkedlist.LinkedList;

public class CheckCircle implements Command<Boolean> {

    private LinkedList start;

    public CheckCircle(LinkedList circleStartPoint) {
        this.start = circleStartPoint;
    }

    /**
     * 建立两个指针, 从header一起向前跑，一个步长为1，一个步长为2，用while（直到步长2的跑到结尾）检查两个指针是否相等，
     * 直到找到为止。
     * */
    @Override
    public Boolean execute() {
        LinkedList first = start, second = start;
        while (second.next() != null && second.next().next() != null) {
            second = second.next().next();
            first = first.next();
            if (second == first) {
                return true;
            }
        }
        return false;
    }
}
