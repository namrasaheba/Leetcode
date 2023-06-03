# Problem details
Two Sum: https://leetcode.com/problems/two-sum/

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
The intuition of using Hashmap came from the fact that we are only required to find exactly two numbers. This means that we could store the remainder number after subtracting the number at every index with the current number.

# Approach
<!-- Describe your approach to solving the problem. -->
Explaned inline in the code.

# Complexity
## Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
O(n) - since we iterate over the array twice.

O(1) - insertion and lookup from hashmap.

## Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
O(n) - the space for creating the hashmap.

# Code
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> remainingSumToIndexMap = new HashMap<>();

        // Iterate over the loop and store the following key value pair:
        // Key: the remainder sum after subtracting the number at current index from target
        // Value: index of the current number
        for(int i = 0; i < nums.length; i++) {
            int remainingSum = target - nums[i];
            remainingSumToIndexMap.put(remainingSum, i);
        }

        // Iterate over the array again.
        // For each number, try to find if the current number exists in the hashmap.
        // If it does then that means there exists a number at a certain index with the remainder value.
        // The second check ensures that we don't use the same number again.
        for (int i = 0; i < nums.length; i++) {
            int remainingSum = target - nums[i];
            if (remainingSumToIndexMap.containsKey(nums[i]) && i != remainingSumToIndexMap.get(nums[i])) {
                int[] result = {i, remainingSumToIndexMap.get(nums[i])};
                return result;
            }
        }
        return null;
    }
}
```
