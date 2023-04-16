package com.algorithmclass.task.LessonTask001;

import java.util.HashMap;
import java.util.Map;

public class LessonE001 {

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > 0; j--) {

                if (nums[i] + nums[j] == target && i != j) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }

    /**
     * 暴力解法
     * 
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumOverForce(int[] nums, int target) {
        System.out.println("start");
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > 0; j--) {
                result[0] = i;
                result[1] = j;
            }
        }
        return result;
    }
    /**
     * 使用哈希法
     * 速度极快
     * 原理：做一张Map表，用Key值存一个加数:add1，Value存下标
     *      使用时，遍历Map中包不包含 值为 （和-第二加数）的key,
     *      if (key = sum - add2) -> key + add2 = sum
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 98.64% 的用户 
     * 内存消耗： 41.7 MB , 在所有 Java 提交中击败了 38.01% 的用户
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumHash(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[] { hashtable.get(target - nums[i]), i };
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 3, 4, 2 };
        int target = 6;
        for (int twoSum : LessonE001.twoSumOverForce(nums, target)) {
            System.out.println(twoSum);
        }
        ;
    }
}
