/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null ){
            return null;
        }
        if(headA == headB){
            return headA;
        }
        int lengthA = 0;
        ListNode iteratorA = headA;
        while(iteratorA != null){
            lengthA++;
            iteratorA = iteratorA.next;
        }
        int lengthB = 0;
        ListNode iteratorB = headB;
        while(iteratorB!=null){
            lengthB++;
            iteratorB = iteratorB.next;
        }

        iteratorA = headA;
        iteratorB = headB;
        int i;

        if(lengthA > lengthB){
            for(i = 0; i < lengthA-lengthB;i++){
                iteratorA = iteratorA.next;
            }
        }else if(lengthA < lengthB){
            for(i = 0; i < lengthB-lengthA;i++){
                iteratorB = iteratorB.next;
            }
        }

        while(iteratorA != null && iteratorB != null){
            if(iteratorA == iteratorB) return iteratorA;
            iteratorA =iteratorA.next;
            iteratorB = iteratorB.next;
        }
        return null;
    }
}