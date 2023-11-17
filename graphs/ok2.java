public class ok2 {
    
        public class ListNode {
            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                this.val = val;
            }

            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }

        public static void main(String args[]){

        public ListNode reverseList(ListNode head) {
            ListNode prev_p = null;
            ListNode next_p = head.next;
            ListNode curr = head;

            while (curr != null) {
                curr.next = prev_p;
                next_p.next = curr;
                prev_p = curr;
                curr = next_p;
            }
            return curr;

        }
    
}
