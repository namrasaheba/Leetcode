/**
* Problem: https://leetcode.com/problems/pascals-triangle-ii/
* Name: Pascal's Triangle II
* 
* Difficulty: Easy
*
* Time complexity: O(n*n)
* Space complexity: O(rowIndex)
*
* @author: Namra A. Saheba
*
*/

/**
*
* Logic:
* It is similar to Pascal's Triangle.
* The only difference is that we keep removing the previous result after we have the result for current row.
* This is helpful in optimizing for space since we only need the answer for the last row.
*
*/

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) { 
            List<Integer> currentRowResult = new ArrayList<>();
            currentRowResult.add(1);
            if (i > 0) {
                for (int j = 0; j < i - 1; j++) {
                    currentRowResult.add(result.get(0).get(j) + result.get(0).get(j+1));
                }
                currentRowResult.add(1);
                result.remove(0);
            }
            result.add(currentRowResult);
        }
        return result.get(0);
    }
}
