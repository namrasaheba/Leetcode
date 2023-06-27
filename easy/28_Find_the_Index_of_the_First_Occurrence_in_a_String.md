# Problem

28. Find the Index of the First Occurrence in a String https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string
# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
Since, we need to find the index, the first thing that came to mind was to convert them to arrays. Once they are converted to arrays, we immediately know the solution - to simply keep searching for the first character from "needle" in "haystack" and once we find it - we then search for all the characters in the "needle" with the next characters in "haystack".

If we find the needle, then we return the index we started off with otherwise we simply return -1 if we end up iterating the "haystack" array.

# Approach
<!-- Describe your approach to solving the problem. -->
As explained above and well documented in the code.

# Complexity
## Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
O(n) - since only iterate the "haystack" once, where n is the length of the haystack.

## Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
O(n+m) - where n & m are the lengths of the arrays for stroing "haystack" and "needle" respectively.

# Code
```java
class Solution {
    public int strStr(String haystack, String needle) {
        // Convert both the strings to arrays.
        char[] haystackArr = haystack.toCharArray();
        char[] needleArr = needle.toCharArray();

        // Iterate over the haystack
        for (int answer = 0; answer < haystackArr.length; answer++) {

            // If the current character in haystack matches with the needle's starting character
            // there is a possibility that we might have found the needle
            if (haystackArr[answer] == needleArr[0]) {
                // Hence, being optimistic that we have found the needel
                // we initialize a variables called foundNeedle to true.
                boolean foundNeedle = true;

                // Now, we keep iterating over the needle array and keep comparing the characters
                // of the haystack array and needle array.
                int i = answer;
                for (int j = 0; j < needleArr.length; j++) {
                    // This is an edge-case where we might be out of bounds for the haystack
                    // which means we can never find our needle in the haystack
                    // so we return -1.
                    if (i >= haystackArr.length)
                        return -1;

                    // If there is even a single mismatch of characters, we should stop iterating
                    // and make the "foundNeedle" to false.
                    if (haystackArr[i] != needleArr[j]) {
                        foundNeedle = false;
                        break;
                    }
                    i++;
                }

                // If the needle is indeed found then return the answer
                if (foundNeedle)
                    return answer;
            }
        }

        // No needle found so return -1.
        return -1;
    }
}
```
