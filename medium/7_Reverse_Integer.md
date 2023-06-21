# Problem 
7. Reverse Integer https://leetcode.com/problems/reverse-integer/

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
To reverse any number, you need the last digit first. This means that you can get the last digit of the number and then keep multiplying the new number by 10 and adding the last digit. So, let's say if we want to reverse 123 then we would first get the last digit by doing modulo.

123 % 10 = 3.
Next, we start off with an int that will store the result and initialize it to 0.
So, result = 0;

Now, let's use the last digit and add it to the final result.
So, result * 10 + 3 = (0 * 10) + 3 = 3.

If we repeat the above steps then it becomes,
last digit = 2, so the result = (3 * 10) + 2 = 32.

Finally repeating once again, we get (32 * 10) + 1 = 321.

How do we check for out of bounds?

We need to stop and return 0 when result is already greater than MAX_VALUE /10 or smaller than MIN_VALUE / 10. Why? Because if they are greater than MAX_VALUE / 10 then multipling it by 10 will make the number bigger than MAX_VALUE. The same logic applies for smaller than MIN_VALUE.

Now, the second condition, if the result == MAX_VALUE / 10, then that means that the last digit should not be greater than 7. Why? Because MAX_VALUE is 2147483647 (i.e. 2 ^ 31 - 1), so 2147483647 / 10 = 214748364, and now if the last digit is greater than 7 then the final result would be out of bound. The same logic applies to the lower bound where the last digit should not be smaller than -8 (since the lower bound is -2147483648 (i.e. -2 ^ 31)).

# Approach
<!-- Describe your approach to solving the problem. -->
Explained in intuition.

# Complexity
## Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
O(log10(x)) - since there exists only There are roughly log⁡10(x) digits in x.

## Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
O(1) - since we are not using any extra space.

# Code
```java
class Solution {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int unitsDigit = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && unitsDigit > 7)) return 0;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && unitsDigit < -8)) return 0;
            result = result * 10 + unitsDigit;
        }
        return result;
    }
}
```
