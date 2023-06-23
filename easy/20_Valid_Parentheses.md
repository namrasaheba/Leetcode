# Problem
20. Valid Parentheses https://leetcode.com/problems/valid-parentheses/
# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
Since, we need to check for correct order - I believe the easiest data structure would be Stack. Why? Because it has LIFO order. Which means if everything is in correct order then we can easily keep pushing as we encounter new opening brackets and pop when we encounter closing brackets. If they mismatch or if the Stack is not empty by the end of the string then it is invalid otherwise it is valid.

# Approach
<!-- Describe your approach to solving the problem. -->
Same as above.

# Complexity
## Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
O(n) - where n is the length of the input string

## Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
O(n) - since we store the brackets in the stack.
# Code
```java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> braces = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character bracket = s.charAt(i);
            if(isOpenBracket(bracket)) {
                // It is opening bracket so keep pushing to the Stack
                braces.push(bracket);
            } else {
                // It is a closing bracket so do the following
                // 1. Pop the last bracket from Stack
                // 2. See if it is a matching bracket
                if (braces.empty()) 
                    return false;
                Character lastBracket = braces.pop();
                if (!isMatchingBracket(lastBracket, bracket))
                    return false;
            }
        }
        return braces.empty() ? true : false;
    }

    private boolean isMatchingBracket(Character c1, Character c2) {
        if ((c1 == '{' && c2 == '}') || (c1 == '(' && c2 == ')') || (c1 == '[' && c2 == ']'))
            return true;
        return false;
    }

    private boolean isOpenBracket(Character c) {
        switch(c) {
            case '(':
            case '{':
            case '[':
                return true;                
        }
        return false;
    }
}
```
