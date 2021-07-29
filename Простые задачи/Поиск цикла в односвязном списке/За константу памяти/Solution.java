class Solution {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }

        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p1 != p2) {
            if (p2.next == null || p2.next.next == null) {
                return null;
            }
            p1 = p1.next;
            p2 = p2.next.next;
        }

        int cycleLength = 1;
        ListNode cycleStart = p1;
        p1 = p1.next;
        while (p1 != cycleStart) {
            cycleLength++;
            p1 = p1.next;
        }

        p1 = head;
        for (int i = 0; i < cycleLength; i++) {
            p1 = p1.next;
        }

        p2 = head;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }
}
