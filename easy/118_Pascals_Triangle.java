/**
* Problem: https://leetcode.com/problems/pascals-triangle/
* Name: Pascal's Triangle
* 
* Difficulty: Easy
*
* Time complexity: O(n*n)
* Space complexity: O(n)
*
* @author: Namra A. Saheba
*
*/

/**
*
* Logic:
* It is similar to Fibonacci number.
* First we have solved the problem using recursion
* and then added memoization to reduce the time complexity.
*
*/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> answer = new ArrayList<>();
        // This map will store each row's results against the row number.
        Map<Integer, List<Integer>> rowToResultMap = new HashMap<>();

        for (int i = 1; i <= numRows; i++) {
            if (i == 1) {
                // First row is the base case
                List<Integer> firstRow = Collections.singletonList(1);
                // Store the row's results in the hashmap for easy reference later on.
                rowToResultMap.put(i, firstRow);
                answer.add(firstRow);
            } else if (i == 2) {
                // Second row is the base case
                List<Integer> secondRow = new ArrayList<>();
                secondRow.add(1);
                secondRow.add(1);
                // Store the row's results in the hashmap for easy reference later on.
                rowToResultMap.put(i, secondRow);
                answer.add(secondRow);
            } else {
                List<Integer> currentRowResult = new ArrayList<>();
                // We add the first '1' by default irrespective of the row
                currentRowResult.add(1);
                // Fetch previous row's results.
                List<Integer> previousRowResult = rowToResultMap.get(i - 1);
                // 1. Iterate over previous row's results
                // 2. Keep adding two consecutive digits
                // 3. Store the result of addition to the current row's results
                for (int j = 0; j < previousRowResult.size() - 1; j++) {
                    currentRowResult.add(previousRowResult.get(j) + previousRowResult.get(j+1));
                }
                // We add the last '1' by default irrespective of the row
                currentRowResult.add(1);
                // Store the row's results in the hashmap for easy reference later on.
                rowToResultMap.put(i, currentRowResult);
                answer.add(currentRowResult);
            }
        }
        return answer; 
    }
}
