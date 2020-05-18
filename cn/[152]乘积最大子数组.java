//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //优化前
    public int maxProduct(int[] nums) {
        //使用max和min两个数组保存 以i结尾的子数组 最大的绝对值的两种情况
        //即最大值和最小值
        int[] max = new int[nums.length], min = new int[nums.length];
        //dp数组状态初始化
        max[0] = nums[0];
        min[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //转移方程
            //Fmax(i)=max{ai,Fmax(i-1)*ai,Fmin(i-1)*ai }
            //Fmin(i)=min{ai,Fmax(i-1)*ai,Fmin(i-1)*ai }
            max[i] = Math.max(nums[i], Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]));
            min[i] = Math.min(nums[i], Math.min(max[i - 1] * nums[i], min[i - 1] * nums[i]));
            res = Math.max(max[i], res);
        }
        return res;
    }

    //因为每次状态转移只用到了F(i)和F(i-1)故可进行优化
    public int maxProduct(int[] nums) {
        int max, min;
        max = nums[0];
        min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int preMax = max;
            max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            min = Math.min(nums[i], Math.min(preMax * nums[i], min * nums[i]));
            res = Math.max(max, res);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
