package code.advent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KDiffPairs {
    public int findPairs(int[] nums, int k) {
        if (nums.length < 2) {
            return 0;
        }
        Map<Integer, Set<Integer>> result = new HashMap<>();
        for(int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    // found a pair
                    int min = Math.min(nums[i], nums[j]);
                    int max = Math.max(nums[i], nums[j]);
                    if (result.containsKey(min)) {
                        Set<Integer> resultSet = result.get(min);
                        if (!resultSet.contains(max)) {
                            resultSet.add(max);
                        }
                    } else {
                        // new pair found
                        Set<Integer> resultSet = new HashSet<>();
                        resultSet.add(max);
                        result.put(min, resultSet);
                    }
                } else {
                    // not a pair
                }
            }
        }
        int count = 0;
        for (int val : result.keySet()) {
            count += result.get(val).size();
        }
        return count;
    }
}
