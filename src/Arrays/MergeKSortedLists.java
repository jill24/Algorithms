package Arrays;

import java.util.PriorityQueue;

/*
Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
Time complexity : O(N\log k)O(Nlogk) where \text{k}k is the number of linked lists.

The comparison cost will be reduced to O(\log k)O(logk) for every pop and insertion to priority queue. But finding the node with the smallest value just costs O(1)O(1) time.
There are NN nodes in the final linked list.
Space complexity :

O(n)O(n) Creating a new linked list costs O(n)O(n) space.
O(k)O(k) The code above present applies in-place method which cost O(1)O(1) space. And the priority queue (often implemented with heaps) costs O(k)O(k) space (it's far less than NN in most situations).

 */
public class MergeKSortedLists {
    public static void main(String[] args) {
        MergeKSortedLists m =new MergeKSortedLists();
        ListNode [] lists = m.getInput();
        ListNode result = m.mergeKLists(lists);
        m.printListNode(result);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return  null;
        }
        ListNode temp = new ListNode(0);
        ListNode result = temp;

//        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
//            @Override
//            public int compare( ListNode o1, ListNode o2){
//               return o1.val-o2.val;
//            }});

        PriorityQueue<ListNode> queue = new PriorityQueue<>((ListNode o1, ListNode o2)->o1.val-o2.val);


        for(int i = 0; i <lists.length ; i++){
            queue.offer(lists[i]);
        }

        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            result.next = node;
            node = node.next;
            result = result.next;
            result.next = null;
            if(node != null){
                queue.offer(node);
            }
        }
        return temp.next;
    }

    private void printListNode(ListNode result) {
        while(result != null){
            System.out.print(result.val+" ");
            result = result.next;
        }
        System.out.println();
    }

    private ListNode[] getInput() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        ListNode [] lists = {l1,l2,l3};
        return lists;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

}
