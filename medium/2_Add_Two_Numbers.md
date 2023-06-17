# Problem
2. Add Two Numbers https://leetcode.com/problems/add-two-numbers/
# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
As soon as I saw the problem, it seemed straight-forward that we will have to do some iterations. So the first thing that I thought was that we will have to run the iterations until there is a node remaining in either of the lists. 

Next, I also figured that instead of maintaining a separate carry variable, we could directly create the next node and have its value as the carry.

# Approach
<!-- Describe your approach to solving the problem. -->
We create a result node with its value initialized to 0. Then we start iterating with a while loop until either of the lists are non-null. We check for each node's value and add it to the current node's value. 

Here's the catch: 
1. For the first iteration that current node's value will be 0.
2. For the future iterations, the current node's value will be either 1 or 0 depending on whether the previous total had a carry or not.

We then assign the current value's total to be total % 10.
And then we create the next node and assign it the value of carry i.e. total / 10.

We move to the next nodes (if they exist) for the next iteration.

Once again, we only want to create a next node if:
1. There is a carry remaining which means the next node's value is 1
2. or if either of the input lists have node remaining

# Complexity
## Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
O (max(n, m)) - since we will iterate for the longest input list.
m : the length of input list 1.
n : the length of input list 2.

## Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
O(1) - since the max length of the output will be O(max(m, n) + 1) but since we don't count the space complexity of the answer it will be O(1).

# Code
```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *   int val;
 *   ListNode next;
 *   ListNode() {}
 *   ListNode(int val) { this.val = val; }
 *   ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 
 
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode curr = result;        
        while (l1 != null || l2 != null) {            
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int total = curr.val + x + y;            
            
            // Current node's value is the total % 10
            curr.val = total % 10;
            // Next node's value will be determined by dividing the total with 10.
            // So if total > 9 then it is 1 otherwise 0.
            ListNode nextNode = new ListNode(total / 10);
                        
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
            // We add a next node only in below conditions:
            // 1. Either of the lists have nodes remaining
            // 2. There is a carry remaining from the current total
            curr.next = (l1 != null || l2 != null || nextNode.val == 1) ? nextNode : null;            
            curr = curr.next;
        }
        return result;
    }
}
```
