# Problem
13. Roman to Integer https://leetcode.com/problems/roman-to-integer/

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
Reading the problem the first thing that came to mind was that we would need to store the roman to integer values in a map. The problem talks about 6 unique use-cases, which I felt could be easily coded (since they will always behave the same).

# Approach
<!-- Describe your approach to solving the problem. -->

The approach is same as explained in intuition. However, there are some other good approaches in solutions provided by others. One of the best ones that I came across was this: https://www.youtube.com/watch?v=tsmrUi5M1JU

# Complexity
## Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
O(n): where n is the length of the roman string. Since, we iterate over the entire string.

## Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
O(1): since we use constant space to store the roman to integer values.

# Code
```java
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> symbolToValue = new HashMap<>();
        symbolToValue.put('I', 1);
        symbolToValue.put('V', 5);
        symbolToValue.put('X', 10);
        symbolToValue.put('L', 50);
        symbolToValue.put('C', 100);
        symbolToValue.put('D', 500);
        symbolToValue.put('M', 1000);

        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            char symbol = s.charAt(i);
            if(symbol == 'I' && (i + 1) < s.length()) {
                if (s.charAt(i+1) == 'V') {
                    answer += 4;
                    i++;
                } else if (s.charAt(i+1) == 'X') {
                    answer += 9;
                    i++;
                } else {
                    answer += symbolToValue.get(symbol);
                }
            } else if (symbol == 'X' && (i + 1) < s.length()) {
                if (s.charAt(i+1) == 'L') {
                    answer += 40;
                    i++;
                } else if (s.charAt(i+1) == 'C') {
                    answer += 90;
                    i++;
                } else {
                    answer += symbolToValue.get(symbol);
                }
            } else if (symbol == 'C' && (i + 1) < s.length()) {
                if (s.charAt(i+1) == 'D') {
                    answer += 400;
                    i++;
                } else if (s.charAt(i+1) == 'M') {
                    answer += 900;
                    i++;
                } else {
                    answer += symbolToValue.get(symbol);
                }
            } else {
                answer += symbolToValue.get(symbol);
            }                    
        }
        return answer;
    }
}
```
