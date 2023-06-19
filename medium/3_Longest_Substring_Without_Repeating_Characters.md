# Problem

3. Longest Substring Without Repeating Characters https://leetcode.com/problems/longest-substring-without-repeating-characters/

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
The intuition was for the Brute-Force approach - simply iterating through the string and then keep storing the visited characters in a hashmap. As soon as we find the visited character, we simply calculate the lenght of the current substring and store the max of the current max-length v/s the new length as our max-length.

# Approach
<!-- Describe your approach to solving the problem. -->
Same as intuition. 

However, the sliding window approach is musch faster and the most optimized. Follow this solution: https://leetcode.com/problems/longest-substring-without-repeating-characters/solutions/3606981/video-visualization-and-intuitive-proof-of-o-n-sliding-window-solution/ and this video explanation of the sliding window approach: https://www.youtube.com/watch?v=pY2dYa1m2VM 

# Complexity
## Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
O(n^2) - where n is the length of the string. This is because we iterate over the length of the string, and within each iteration we check for the prefix match which takes O(n) time.

## Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
O(n) - since in the worst case we store the entire string in the hashmap.

# Code
```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> visited;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            int j = i;
            visited = new HashMap<>();
            while(j < s.length() && !visited.containsKey(s.charAt(j))) {
                visited.put(s.charAt(j), 0);
                j++;
            }
            result = Math.max(result, visited.size());
        } 
        return result;
    }
}
```
