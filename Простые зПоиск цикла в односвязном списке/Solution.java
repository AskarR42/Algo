public class Solution {
    public ListNode detectCycle(ListNode head) {
        Map<ListNode, Integer> dic = new HashMap<>();
        int pos = 0;
        while (!dic.containsKey(head)) {
            if (head == null) {
                break;
            }
            dic.put(head, pos);
            head = head.next;
            pos++;
        }
        return head;
    }
}
