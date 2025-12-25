/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        ListNode newHead = null;
        ListNode newTail = null;

        for(ListNode node : lists){
            if(node != null) pq.offer(node);
        }

        while(!pq.isEmpty()){
            ListNode tempNode = pq.poll();
            if(newHead == null){
                newHead = new ListNode(tempNode.val);
                newTail = newHead;
            }else{
                newTail.next = new ListNode(tempNode.val);
                newTail = newTail.next;
            }
            if(tempNode.next != null){
                pq.offer(tempNode.next);
            }
        }

        return newHead;
    }
}