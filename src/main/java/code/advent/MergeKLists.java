package code.advent;

/**
 * Tested using...
 *
 *         MergeKLists mergeKLists = new MergeKLists();
 *
 *         ListNode node1 = new ListNode(1,
 *                 new ListNode(4,
 *                  new ListNode(5)));
 *         ListNode node2 = new ListNode(1,
 *                 new ListNode(3,
 *                  new ListNode(4)));
 *         ListNode node3 = new ListNode(2,
 *                 new ListNode(6));
 *         ListNode[] nodes = { node1, node2, node3 };
 *         ListNode result = mergeKLists.mergeKLists(nodes);
 *
 *         while (result != null) {
 *             System.out.println(result.val);
 *             result = result.next;
 *         }
 */
class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        boolean done = false;
        ListNode root = new ListNode();
        ListNode node = root;
        int min;

        while (!done) {
            // Prepare to exit loop if all nodes are null
            done = true;
            int minIndex = 0;
            // Reset minimum value for finding smallest node
            min = Integer.MAX_VALUE;
            for (int i = 0 ; i < lists.length; i++) {
                ListNode list = lists[i];
                if (list != null) {
                    // found a node, we are not done
                    done = false;
                    if (list.val < min) {
                        // Found the minimum
                        min = list.val;
                        minIndex = i;
                    }
                }
            }
            if (lists[minIndex] != null) {
                node.next = new ListNode(lists[minIndex].val);
                node = node.next;
                lists[minIndex] = lists[minIndex].next;
            } else {
                // abort
                done = true;
            }
        }
        return root.next;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}