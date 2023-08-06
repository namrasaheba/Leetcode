# Problem
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
The problem already mentions that we need to find the solution in Olog(n) time which means that we have to use the binary search.

# Approach
<!-- Describe your approach to solving the problem. -->
We first check for the 3 base conditions:
1. if the input array is empty.
2. if the target is greater than the last element. We could also add smaller than the first element for minor optimization.
3. if the entire array is target

Then we find any index of the element using Binary Search. Once we find the index, we simply keep traversing left to find the first index and right to find the last index. 

# Complexity
## Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
O(n) - since we use binary search which takes Olog(n) and then we could potentially traverse the entire array so O(n).

## Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
O(1) - since we do not use any additional data structure for storing anything extra.

# Code
```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int answer[] = {-1, -1};

        // Base conditions
        // 1. If input array is empty
        if (nums.length == 0) {
            return answer;
        }
        // 2. If the last number in the array is smaller than the target return.
        if (nums[nums.length-1] < target) {
            return answer;
        }
        // 3. If the entire array is target
        if (nums[0] == target && nums[nums.length - 1] == target) {
            answer[0] = 0;
            answer[1] = nums.length - 1;
            return answer;
        }
        
        // First, we will fetch any index of the target.
        int anyIndexOfTarget = binarySearch(nums, target, 0, nums.length - 1);

        // We did not find the target element in array
        if (anyIndexOfTarget == -1) {
            return answer;
        }
        
        // Write logic for finding the first and last index of the element
        int firstIndex = anyIndexOfTarget;
        int lastIndex = anyIndexOfTarget;
        while (firstIndex > 0) {
            if (nums[firstIndex - 1] == target) {
                System.out.println("Coming here in first index: " + firstIndex);
                firstIndex--;
            } else {
                break;
            }
        }                
        
        while (lastIndex < (nums.length - 1)) {
            if (nums[lastIndex + 1] == target) {
                System.out.println("Coming here in last index: " + lastIndex);
                lastIndex++;
            } else {
                break;
            }
        }                        
        answer[0] = firstIndex;
        answer[1] = lastIndex;
        return answer;        
    }

    private int binarySearch(int nums[], int target, int start, int end) {
        // If start is greater than end then element is not found.
        if (start > end) return -1;
        
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            // search right half
            return binarySearch(nums, target, mid + 1, end);
        } else {
            // search left half
            return binarySearch(nums, target, start, mid - 1);
        }
    }
}
```
