# Problem
219. Contains Duplicate II: https://leetcode.com/problems/contains-duplicate-ii/description/
# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
This is really simple - you just have to find the first pair of duplicates. So immediately hashmap came to mind for storing the visited number's index. As soon as we find the same number again we need to check if the absolute difference of their indices is <= k, and return true. Otherwise return false if the entire iteration of the array completes.

# Approach
<!-- Describe your approach to solving the problem. -->
Explained above.

# Complexity
## Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
O(n) - iteration of the entire array in worst case. 

## Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
O(n) - storing the entire array in hashmap in worst case.

# Code
```java
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (frequencyMap.containsKey(nums[i])) {
                if (Math.abs(i - frequencyMap.get(nums[i])) <= k) {
                    return true;
                }
            }
            frequencyMap.put(nums[i], i);
        }
        return false;
    }
}
```
