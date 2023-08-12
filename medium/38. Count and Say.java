# Problem
https://leetcode.com/problems/count-and-say/

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
Since the problem description itself gives the hint that the output of any number is dependent on the previous number's output, I thought of creating a function that acts on the previous number's output.

Now, we simply write the function that will take the output of previous function and do what the problem asks us to do - count the digits and then append the count of the digit and the digit itself to the answer. This is exactly what the function does.
# Approach
<!-- Describe your approach to solving the problem. -->

# Complexity
- Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->

- Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java
class Solution {
    public String countAndSay(int n) {

        // The result for 1 is constant so we return it.
        if (n == 1)
            return "1";
        // Since we already return the result for 1 we start with 2 as the base-case, and we initiate the result with it.        
        String result = "11";

        // We keep iteratively calling the countAndSayIt() function until we reach our base-condition.
        while (n-- > 2) {
            result = countAndSayIt(result);
        }
        return result;
    }

    private String countAndSayIt(String sayn) {
        // Every digit will have at least 1 count.
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sayn.length()-1; i++) {
            // For each digit that is repeating we keep updating the count of it.
            if (sayn.charAt(i) == sayn.charAt(i+1)) {
                count++;
            } else {
                // We append the count of the digit to the string and also the digit
                sb.append(count);
                sb.append(sayn.charAt(i));
                // We reset the count to 1 for next digit.
                count = 1;
            }

            // For the last digit, we simply append the count of the digit and the digit to the string.
            if (i == sayn.length() - 2) {
                sb.append(count);
                sb.append(sayn.charAt(i+1));
            }
        }
        return sb.toString();
    }
}
```
