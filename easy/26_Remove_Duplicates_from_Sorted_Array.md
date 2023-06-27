# Problem
26. Remove Duplicates from Sorted Array https://leetcode.com/problems/remove-duplicates-from-sorted-array/
# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->

Since the problem asks us to do things "in-place" - it was pretty clear that we had to solve this by iterating the array only once. Any solution that required us to iterate twice was not solving the problem "in-place". Hence, I forced my solutions that were possible within single iteration.

Since, the array is sorted and the constraints of the problem mention that there will be at least one element in the array, we know that there can be at least one unique number. Hence, we initialize the "indexToReplace" variable to 1.

Next question comes, how do we know if two numbers are duplicate? Simple - by comparing the current number with previous number.

When the number is equal, we do nothing and iterate to the next element. When it is not equal, we know that we have landed on a unique element and hence we simply assign the current index that needs to be replaced ("indexToReplace" variable) with the current number.

This way we know that the last index that we replaced was the total number of unique elements in the array.

# Approach
<!-- Describe your approach to solving the problem. -->
Explained in intution.

# Complexity
## Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
O(n) - since we iterate the array only once.

## Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
O(1) - we use single variable to store the result.

# Code
```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int indexToReplace = 1;
        for (int i = 1; i < nums.length; i++) {
            // Comparing with the previous value will tell us if it is a duplicate or not since the array is sorted
            if (nums[i] != nums[i-1]) {
                // We have a new unique number
                // In case of unique number we replace the indexToReplace with the current number
                // & increment the indexToReplace variable
                nums[indexToReplace] = nums[i];            
                indexToReplace++;                
            }
        }
        return indexToReplace;
    }
}
```
