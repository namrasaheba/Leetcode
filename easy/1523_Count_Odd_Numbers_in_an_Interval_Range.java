/**
* Problem: https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/
* Name: 1523. Count Odd Numbers in an Interval Range
*
* Difficulty: Easy
*
* Time complexity: O(1)
* Space complexity: O(1)
*
* @author Namra A. Saheba
*/
class Solution {
    public int countOdds(int low, int high) {
        if (isEven(low) && isEven(high)) {
            return (high-low)/2;
        } else if (isOdd(low) && isOdd(high)) {
            return (high-low)/2 + 1;
        } else {
            return (int)Math.ceil(((double)high-low) / 2);
        }       
    }

    private boolean isEven(int number) {
        return number % 2 == 0 ? true : false;
    }

    private boolean isOdd(int number) {
        return !isEven(number);
    }
}
