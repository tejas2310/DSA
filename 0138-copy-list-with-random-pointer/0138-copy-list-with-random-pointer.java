/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
            if(head == null) return null;
            Node it = head;
            HashMap<Node,Node> map = new HashMap<>();

            while(it!=null){
                map.put(it,new Node(it.val));
                it = it.next;
            }

            it = head;
            Node result = map.get(head);
            Node headResult = result; 

            while(it!=null){
                if(it.random == null){
                    result.random = null;
                }else{
                    result.random = map.get(it.random);
                }
                if(it.next == null){
                    result.next = null;
                }else{
                    result.next = map.get(it.next);
                }
                result = result.next;
                it = it.next;
            }
            return headResult;
        }
}