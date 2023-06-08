# Problem
2140. Solving Questions With Brainpower: https://leetcode.com/problems/solving-questions-with-brainpower/description/
# Intuition
<!-- Describe your first thoughts on how to solve this problem. -->
At each question we have two choices: skip or attempt:
- if we skip then the maximum points, we can earn is from next question onwards till the end of the list. We calculate the points from this approach.
- if we attempt, we skip the next "brainpower" number of questions and then chose the maximum from the next question until the end of the list. We calculate the points from this approach.
- We compare the points from both the approaches and return the maximum of both.
- the base case would reach when there are no further questions to attempt in the list.

# Approach
<!-- Describe your approach to solving the problem. -->
This can be solved using Dynamic Programming technique and use Memoization to optimize for time complexity. Hashmap will store the maximum points that can be earned for each index in the list.

# Complexity
## Time complexity:
<!-- Add your time complexity here, e.g. $$O(n)$$ -->
O(n) - since we call the recursive function for each question index exactly once.

## Space complexity:
<!-- Add your space complexity here, e.g. $$O(n)$$ -->
O(n) - For the list that we create initially from the array.
O(n) - For the hashmap that we create for memo.

Honestly, time and space complexity could have been reduced by avoiding to create a list everytime and using an array only (as shown in the editorial).

# Code
```java
class Solution {
    public long mostPoints(int[][] questions) {
        List<List<Integer>> questionsList = new ArrayList<>();
        for (int i = 0; i < questions.length; i++) {
            List<Integer> questionAsList = Arrays.stream(questions[i]).boxed().toList();
             questionsList.add(questionAsList);
        }
        Map<Integer, Long> memo = new HashMap<>();
        return mostPoints(questionsList, 0, memo);
    }

    private long mostPoints(List<List<Integer>> questions, int currentIndex, Map<Integer, Long> memo) {

        // If question index is out of bounds
        if (currentIndex >= questions.size()) {
            return 0;
        }

        // Check if we have the answer for the index already calculated.
        if (memo.containsKey(currentIndex)) {
            return memo.get(currentIndex);
        }

        // Calculate the points collected by attempting this question
        int brainpower = questions.get(currentIndex).get(1);

        // The maximum points for any question can be either of two:
        // 1. By skipping the current question and calculating maximum points by attempting the question after that
        // 2. By attempting the question and calculating maximum points by skipping the next "brainpower" worth questions.
        long maxPoints = maxPoints = Math.max(mostPoints(questions, currentIndex + 1, memo), 
                            questions.get(currentIndex).get(0) + mostPoints(questions, currentIndex + brainpower + 1, memo));
        memo.put(currentIndex, maxPoints);
        return memo.get(currentIndex);            
    }
}

```
