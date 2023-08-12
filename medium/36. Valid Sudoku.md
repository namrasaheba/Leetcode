# Problem
https://leetcode.com/problems/valid-sudoku/

# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
Since we only have to find the validity of Sudoku, the first intuition that came was to check for all the rows and columns whether the number is present in them agan or not. 

After that we had to identify whether the number is getting repeated again in the same sub-grid or not.

# Approach
<!-- Describe your approach to solving the problem. -->
We iterate over the rows and have a hashset for storing the numbers present in that row. Whenever we encounter a number, we first check if it is present in the row hashset or not. If it is present then we return false as our answer since a number cannot be repeated in the same row. If it is not present then we add it to the hashmap and continue.

We do similar thing for columns.

For grids, we create a hashmap with each grid as a key and the corresponding hashset as the number of values in that grid. We follow the same pattern as row/column to check validity of a grid and return.

# Complexity
## Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
O(n) - since we iterate two times - one for row/grid, and second for column.

## Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
O(1) - since we have a hashmap with 9 keys, and another hashset.

# Code
```java
class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        // Create a hashset for row
        HashSet<Character> row;
        Map<String, HashSet<Character>> subGrid = new HashMap<String, HashSet<Character>>();

        // First we will iterate through the entire rows
        for (int i = 0; i < board.length; i++) {
            row = new HashSet<Character>();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    if (row.contains(board[i][j])) {
                        return false;
                    } else {
                        row.add(board[i][j]);
                    }

                    // sub-grid
                    String subGridId = getSubGrid(i, j);
                    if (subGrid.containsKey(subGridId)) {
                        HashSet<Character> numbers = subGrid.get(subGridId);
                        if (numbers.contains(board[i][j])) {
                            return false;
                        } else {
                            numbers.add(board[i][j]);
                        }
                    } else {
                        // Sub-grid doesn't exist in hashmap so we need to create and add it.
                        HashSet<Character> numbers = new HashSet<>();
                        numbers.add(board[i][j]);
                        subGrid.put(subGridId, numbers);
                    }
                }
            }
        }

        // HashSet<Character> col;
        // then we will iterate through the entire columns
        for (int j = 0; j < board[0].length; j++) {
            row = new HashSet<Character>();
            for (int i = 0; i < board.length; i++) {                
                if (board[i][j] != '.') {
                    if (row.contains(board[i][j])) {
                        return false;
                    } else {
                        row.add(board[i][j]);
                    }
                }
            }
        }

        return true;        
    }

    private String getSubGrid(int row, int col) {
        int rowId = row / 3;
        int colId = col / 3;
        return rowId + "," + colId;
    }
}
```
