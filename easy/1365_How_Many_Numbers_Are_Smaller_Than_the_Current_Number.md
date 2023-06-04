# Problem
1365. How Many Numbers Are Smaller Than the Current Number: https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/description/
# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
We have to find for each number ohow many numbers are smaller.
The immediate next question comes to my mind is how do we store the results of each number? Hashmap or directly into an array.


# Approach
<!-- Describe your approach to solving the problem. -->
The approach is pretty simple and straight-forward.
Iterate through the array and perform the following during each iteration:
Iterate through the array again and do the following:
Check if the nums[j] < nums[i]
if it is true then increase the counter for the nums[i] in hashmap/array

 
This is the brute force approach where we incure time complexity of O(n * n). n = nums.length


To optimize for time complexity, we can sort the array. That way all the numbers after the current number are greater than that number.
Which means, for the first element we need to iterate until the number to its right are equal to the current number. All the numbers after this would be greater than the current number.
We store the same result for all the elements that have the same value.

We keep iterating further.

———

Since, we will lose the index position of the element, we will need to store the index positions of each element in the hashmap so that we can return the answer in correct order.

# Complexity
## Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
O(n * n) - for the brute force approach
O(n) - for iterating over the array and storing it's index locations in the hashmap
O(n) - for iterating through the array again.

## Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
O(1) - for the brute force approach
O(n) - for the optimized approach.

# Code 
## Optimized Code
```java
class Solution {
    // Optimized Approach
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        Map<Integer, List<Integer>> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> indices;
            if (numToIndex.containsKey(nums[i])) {
                indices = numToIndex.get(nums[i]);
                indices.add(i);
                numToIndex.put(nums[i], indices);    
            } else {
                indices = new ArrayList<>();
                indices.add(i);
                numToIndex.put(nums[i], indices);    
            }
            
        }

        Arrays.sort(nums);
        for (int i = nums.length-1; i >= 0;) {
            int currentIndex = i;
            int currentNumber = nums[i];
            int equalNumbers = 0;
            while (currentIndex > 0 && nums[currentIndex] == nums[currentIndex-1]) {
                currentIndex--;
                equalNumbers++;
            }
            int numbersSmallerThanCurrentNumber = currentIndex;
            if (equalNumbers != 0) {
                numToIndex.get(currentNumber).forEach(index -> {
                    result[index] = numbersSmallerThanCurrentNumber;
                });
            i = i - equalNumbers;
            } else {
                result[numToIndex.get(currentNumber).get(0)] = numbersSmallerThanCurrentNumber;
                i--;
            }           
        }
        return result;
    }
}
```

## Brute Force Approach
```java
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 0);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if ( j != i && nums[j] < nums[i]) {
                    result[i]++;
                }
            }
        }
        return result;
    }
}
```
