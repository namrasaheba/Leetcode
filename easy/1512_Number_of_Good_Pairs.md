# Problem

1512. Number of Good Pairs: https://leetcode.com/problems/number-of-good-pairs/

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
Total good pairs means total combinations where num[i] == num[j] where i < j. This means that we have to simply count the frequence of each integer and then calculate the total pairs by simple mathematical formula of finding sum(n) = n * (n-1) / 2.

# Approach
<!-- Describe your approach to solving the problem. -->
We iterate over the array and store the frequency of each integer in the hashmap. Later we simply iterate over the entire hashmap and calculate the total pairs using the above formula.

# Complexity
## Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
O(n) - since we iterate over the array once. 
Insertion and lookup in hashmap is O(1).

## Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
O(n) - since we store the integers in hashmap. In worst case, if all integers are unique then we will occupy the entire space of n integers. 
n = length of array.

# Code
```java
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int goodPairs = 0;
        Map<Integer, Integer> numberToFrequencyMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numberToFrequencyMap.containsKey(nums[i])) {
                numberToFrequencyMap.put(nums[i], numberToFrequencyMap.get(nums[i])+1);
            } else {
                numberToFrequencyMap.put(nums[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> numberToFrequency: numberToFrequencyMap.entrySet()) {
            goodPairs += calculateTotalPairs(numberToFrequency.getValue());
        }

        return goodPairs;
    }

    private int calculateTotalPairs(int number) {
        return (number * (number - 1)) / 2;
    }
}
```
