# Problem
2661. First completely Painter Row or column: https://leetcode.com/problems/first-completely-painted-row-or-column/description/

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
We need to know when a row/column is painted.
How do we know if a cell is painted?

We can create a row and column identifiers and keep incrementing them by 1 when a cell gets painted in them.
Whenever the total for a row reaches "m" then we know that the row has been painted.
Whenever the total for a column reaches "n" then we know that the column has been painted.

At this moment we stop painting and return the index at which the column or row were painted.

How do we store the row and column identifiers? We could use a hashmap.

How do we name the identifiers? We could use the rx and cx where x would be the index/number of the row/column.


# Approach
<!-- Describe your approach to solving the problem. -->
We start by iterating over the input array.
In every iteration, we find the cell and paint it.
What do we mean paint it? We simply find its (row, column) identifier and increment the total of that column/row.

How do we find the cell location aka (row, column) identifier?
Iterate over the 2-dimensional array and store the row, column identifier for each number in hashmap. The insertion and lookup will be O(1).

# Complexity
## Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
O(m * n) - this is the time complexity for pre-processing the matrix and storing the cell locations in the hashmap.
O(m * n) - this is the time complexity for traversing through the final array of numbers.
Since, insertion and lookup in hashmap is of complexity O(1), it can be ignored.

Total time complexity = O (m * n)

## Space complexity:
O(m + n) - for storing the painted cells in rows and columns
O(m * n) - for storing the cell locations since there would be (m * n) cells.
<!-- Add your space complexity here, e.g. $$O(n)$$ -->

# Code
```java
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        // A map that store the key as the number and value as its cell location in form (row, col).
        Map<Integer, String> cellLocations = new HashMap<>();
        // A map that will store the key as each individual row and column,
        // the value will be total cells in that row/column that have been painted.
        Map<String, Integer> totalCellsPaintedInRowCol = new HashMap<>();
        int totalRows = mat.length;
        int totalColumns = mat[0].length;
        int answer = 0;

        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[row].length; col++) {
                cellLocations.put(mat[row][col], row + "," + col);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            String currentCellLocation = cellLocations.get(arr[i]);
            String row = "r" + currentCellLocation.split(",")[0];
            String col = "c" + currentCellLocation.split(",")[1];

            // Update the total for the number's row
            if (totalCellsPaintedInRowCol.containsKey(row)) {
                totalCellsPaintedInRowCol.put(row, totalCellsPaintedInRowCol.get(row) + 1);
            } else {
                totalCellsPaintedInRowCol.put(row, 1);
            }
            // Update the total for the number's column
            if (totalCellsPaintedInRowCol.containsKey(col)) {
                totalCellsPaintedInRowCol.put(col, totalCellsPaintedInRowCol.get(col) + 1);
            } else {
                totalCellsPaintedInRowCol.put(col, 1);
            }
            // By updating the row and column total, we have completed painting the cell.
            // Now, we will check if that current row or column have been completely painted or not?
            // If they have then we simply return the current index as the answer or else we iterate to the next number is arr.
            if (totalCellsPaintedInRowCol.get(row) == totalColumns || totalCellsPaintedInRowCol.get(col) == totalRows) {
                answer = i;
                break;
            }

        }
        return answer;
    }
}
```
