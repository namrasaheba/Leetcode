746. Min Cost Climbing Stairs

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        Map<Integer, Integer> memoForStep0 = new HashMap<>();
        Map<Integer, Integer> memoForStep1 = new HashMap<>();

        // Calculate the cost of climbing stairs at step 0
        int costOfClimbingStairsAtStep0 = calculateMinCostClimbingStairs(cost, 0, memoForStep0);

        // Calculate the cost of climbing stairs at step 1
        int costOfClimbingStairsAtStep1 = calculateMinCostClimbingStairs(cost, 1, memoForStep1);

        // Calculate the min. cost by comparing cost of starting at step 0 or 1.
        return Math.min(costOfClimbingStairsAtStep0, costOfClimbingStairsAtStep1);
    }

    public int calculateMinCostClimbingStairs(int[] cost, int step, Map<Integer, Integer> memo) {
        // Memoiztion
        if(memo.containsKey(step)) {
            return memo.get(step);
        }
        // If it is the last or second last step
        // then return the cost of the step.
        if (step == cost.length - 1 || step == cost.length - 2)
            return cost[step];
        
        // Calculate the min. cost between taking 1 step or 2 steps.
        memo.put(step, 
                 Math.min(cost[step] + calculateMinCostClimbingStairs(cost, step + 1, memo), 
                          cost[step] + calculateMinCostClimbingStairs(cost, step + 2, memo)));
        
        return memo.get(stair);
    }
}
