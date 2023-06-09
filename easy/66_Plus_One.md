# Problem
66. Plus One: https://leetcode.com/problems/plus-one/description/
# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
Usually when you want to add a 1 to a number the last digit is all that needs to be incremented, that's it. So ideally when you update the last digit you should immediately return. However, when the last digit is 9 then you simply update that number by 0 and increment the number ahead of it by 1.

For the only edge case, when the number is all 9s you would need to create a new array and change the first value to 1.

# Approach
<!-- Describe your approach to solving the problem. -->
As described in intuition section.

# Complexity
## Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
O(n) - In worst case (all 9s), we will have to iterate the entire array.

## Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
O(n) - For the worst case, we will need to create a new array. 

# Code
```java
class Solution {
    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1]; 
        int carry = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } 
            digits[i] = 0;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
```
