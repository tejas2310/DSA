/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
public Node cloneGraph(Node node) {
        if(node == null) return null;
        if(node.neighbors.isEmpty()) return new Node(node.val);
        Deque<Node> queue = new ArrayDeque<>();
        HashMap<Integer, Node> newNodeMap = new HashMap<>();

        Node result = new Node(node.val, new ArrayList<>(node.neighbors));

        queue.offer(result);
        newNodeMap.put(node.val, result);

        while(!queue.isEmpty()){
            Node curr = queue.poll();

            for (int i = 0; i < curr.neighbors.size(); i++) {
                Node prev = curr.neighbors.get(i);
                if (!newNodeMap.containsKey(prev.val)) {
                    newNodeMap.put(prev.val, new Node(prev.val, new ArrayList<>(prev.neighbors)));
                    queue.offer(newNodeMap.get(prev.val));
                }
                curr.neighbors.set(i, newNodeMap.get(prev.val));
            }

        }

        return newNodeMap.get(node.val);

    }
}