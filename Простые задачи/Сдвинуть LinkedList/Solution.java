class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        
        ListNode tail = head;
        ListNode KNode = head;
        
        for (int i = 0; i < k % length(head); i++) {
            tail = tail.next;
        }
        
        while (tail.next != null) {
            KNode = KNode.next;
            tail = tail.next;
        }
        
        tail.next = head;
        head = KNode.next;
        KNode.next = null;
        
        return head;
    }

    private int length(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
