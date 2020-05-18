//给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。 
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
// 
//
// 说明 : 
//
// 
// 数组的长度为 [1, 20,000]。 
// 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。 
// 
// Related Topics 数组 哈希表


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] pre = new int[nums.length];
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                pre[i] = nums[0];
            } else {
                pre[i] = pre[i - 1] + nums[i];

            }
            if (map.containsKey(pre[i] - k)) {
                count += map.get(pre[i] - k);
            }
            if (map.containsKey(pre[i])) {
                map.put(pre[i], map.get(pre[i]) + 1);
            } else {
                map.put(pre[i], 1);
            }

        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
