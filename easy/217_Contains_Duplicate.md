# Problem
217. Contains Duplicate: https://leetcode.com/problems/contains-duplicate/description/

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
This is really simple - you just have to find the frequency of each number. So immediately hashmap came to mind for storing the frequency. Also, since the answer is to return true for even a single number getting repeated, we can short circuit our code as soon as we find the first duplicate.

# Approach
<!-- Describe your approach to solving the problem. -->
We initialize a hashmap. We iterate through the array and check if the hashmap contains the number. If it does then that means that we had earlier put that value in the hashmap which means it got repeated - so we immediately return. Otherwise, we add it to the hashmap.

If the entire array iteration completes, then that means that the entire array did not have any duplicates and hence return false.

# Complexity
## Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
O(n) - for the worst case, we might have to iterate through the entire array.

## Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
O(n) - since we might have to store entire the array in the map.

# Code
```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int i : nums) {
            if(frequencyMap.containsKey(i)) {
                return true;
            }
            frequencyMap.put(i,1);
        }
        return false;
    }
}
```
