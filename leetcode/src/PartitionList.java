/*
86 Partition List
 */

public class PartitionList {
    public static void main(String[] args) {
        PartitionList partitionList = new PartitionList();

    }

    public ListNode partition(ListNode head, int x) {
        ListNode first = new ListNode(0);
        ListNode second = new ListNode(0);
        ListNode firstCurrent = first;
        ListNode secondCurrent = second;
        while (head != null) {
            if (head.val < x) {
                firstCurrent.next = head;
                firstCurrent = firstCurrent.next;
            } else {
                secondCurrent.next = head;
                secondCurrent = secondCurrent.next;
            }
            head = head.next;
        }
        firstCurrent.next = second.next;
        secondCurrent.next = null;
        return first.next;
    }
}
