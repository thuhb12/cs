/*
23. Merge k Sorted Lists
 */
public class MergeList {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length < 1) {
            return null;
        }
        return merge(lists, 0, lists.length-1);
    }

    private ListNode merge(ListNode[] lists, int i, int j) {
        if (i == j) {
            return lists[i];
        } else if (j == i + 1) {
            return mergeTwo(lists[i], lists[j]);
        } else {
            int mid = i + (j - i) / 2;
            return mergeTwo(merge(lists, i, mid), merge(lists, mid+1, j));
        }
    }

    private ListNode mergeTwo(ListNode a, ListNode b) {
        ListNode senti = new ListNode(0);
        ListNode pre = senti;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                pre.next = a;
                pre = pre.next;
                a = a.next;
            } else {
                pre.next = b;
                pre = pre.next;
                b = b.next;
            }
        }
        a = a == null ? b : a;
        while (a != null) {
            pre.next = a;
            pre = pre.next;
            a = a.next;
        }
        return senti.next;
    }
}
