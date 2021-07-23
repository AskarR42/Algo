class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        ListNode pointer = head;

        ListNode prevNode = null;
        for (int i = 0; i < left - 2; i++) {
            pointer = pointer.next;
        }
        if (left != 1) {
            prevNode = pointer;
            pointer = pointer.next;
        }

        ListNode nextNode = null;
        if (left == right - 1) {
            ListNode tail = pointer;
            pointer = pointer.next;

            nextNode = pointer.next;
            pointer.next = tail;

            tail.next = nextNode;
            if (prevNode != null) {
                prevNode.next = pointer;
            }

            return left == 1 ? pointer : head;
        }

        ListNode tail = pointer;

        ListNode t1 = pointer;
        pointer = pointer.next;
        ListNode t2 = pointer;
        pointer = pointer.next;

        for (int i = left + 1; i < right - 1; i++) {
            t2.next = t1;
            t1 = t2;
            t2 = pointer;
            pointer = pointer.next;
        }

        t2.next = t1;
        nextNode = pointer.next;
        pointer.next = t2;

        if (prevNode != null) {
            prevNode.next = pointer;
        }
        tail.next = nextNode;

        return left == 1 ? pointer : head;
    }
}
