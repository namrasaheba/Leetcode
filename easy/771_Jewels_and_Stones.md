# Problem
Jewels and Stones: https://leetcode.com/problems/jewels-and-stones/

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
The choice for Hashmap is clear because it requires us to find if the characters in one string exist in another one.

# Approach
<!-- Describe your approach to solving the problem. -->
We simply store all the characters from "jewels" string into a hashmap and then iterate over all the characters for the "stones" string.

# Complexity
## Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
O(n+m) - since we iterate over both the input strings. 
n = length of "jewels"
m = length of "stones"

## Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
O(n) - since we store all the characters of the input string "jewels".
n = length of "jewels"

# Code
```
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        int result = 0;
        // Store the jewels in a hashmap.
        Map<Character, Integer> jewelMap = new HashMap<>();  
        for (char jewel : jewels.toCharArray()) {
            jewelMap.put(jewel, 0);
        }

        for (char stone : stones.toCharArray()) {
            if (jewelMap.containsKey(stone)) {
                result++;
            }
        }
        return result;
    }
}
```
