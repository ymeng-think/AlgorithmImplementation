package tw.ymeng.algorithm.proposition.linkedlist.command;

import tw.ymeng.algorithm.proposition.Command;
import tw.ymeng.algorithm.proposition.linkedlist.LinkedList;

public class FindNToLastNode implements Command<Integer> {

    private final LinkedList root;
    private int n;

    public FindNToLastNode(LinkedList linkedList, int n) {
        this.root = new LinkedList(Integer.MIN_VALUE);
        this.root.next(linkedList);
        this.n = n;
    }

    /**
     * 不管是顺数n个还是倒数n个，其实都是距离-标尺问题。标尺是一段距离可以用线段的两个端点来衡量，我们能够判断倒数第一个节点，
     * 因为他的next==NULL。如果我们用两个指针，并保持他们的距离为n，那么当这个线段的右端指向末尾节点时，左端节点就指向倒数第n个节点。
     * 所以思路出来了：建立两个指针，第一个先走n步，然后第2个指针也开始走，两个指针步伐（前进速度）一致。当第一个结点走到链表末尾时，
     * 第二个节点的位置就是我们需要的倒数第n个节点的值。
     * */
    @Override
    public Integer execute() {
        LinkedList p1 = root, p2 = root;
        int index = 0;

        while (index < n && p1.next() != null) {
            index++;
            p1 = p1.next();
        }

        if (index < n && p1.next() == null) {
            throw new IllegalArgumentException("N is larger than length of linked list");
        }

        while (p1 != null){
            p1 = p1.next();
            p2 = p2.next();
        }

        return p2.data();
    }
}
