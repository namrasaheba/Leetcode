/**
* Problem: https://leetcode.com/problems/number-of-1-bits/
* Name: 191. Number of 1 Bits
*
* Difficulty: Easy
*
* Time complexity: O(number.length)
* Space complexity: O(1)
*
* @author Namra A. Saheba
*/

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        
        // Convert integer to binary string
        String number = Integer.toBinaryString(n);
        int totalBits = 0;
        for (int i = 0; i < number.length(); i++) {
            if(number.charAt(i) == '1')
                totalBits++;
        }
        return totalBits;
    }
}
