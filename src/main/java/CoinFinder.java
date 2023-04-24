import java.util.ArrayList;
import java.util.List;

class CoinFinder {
    public int coinChange(int[] coins, int amount) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> currSet = new ArrayList<>();
        backtrack(coins, subsets, currSet, amount, 0);

        int minNumOfCoins = Integer.MAX_VALUE;

        for(List<Integer> set : subsets){
            minNumOfCoins = Math.min(set.size(), minNumOfCoins);
        }

        return minNumOfCoins == Integer.MAX_VALUE ? -1 : minNumOfCoins;
    }

    public void backtrack(int[] nums, List<List<Integer>> subsets, List<Integer> currSet, int target, int start){
        if(target == 0){  //target reached, add current set to subset
            subsets.add(new ArrayList<>(currSet));
        }else if(target > 0){
            for(int i = start; i < nums.length; i++){
                currSet.add(nums[i]);
                backtrack(nums, subsets, currSet, target - nums[i], i);
                currSet.remove(currSet.size() - 1);
            }
        }else{
            return;
        }
    }
}