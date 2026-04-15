package com.amazon.problems;

import java.util.Arrays;

public class TwoPointer_Sorting {
	
	
	// Problem 1: Pair Sum Equals Target
	public static boolean hasPair(int[] arr, int target) {
		Arrays.sort(arr);
		int left = 0;
		int right = arr.length-1;
		int sum = 0;
		while(left<right) {
			sum = arr[left] + arr[right];
			if(sum == target) {
				return true;
			}
			else if(sum > target) {
				right--;
			}else {
				left++;
			}
		}
		return false;
	}
	
	//Count Pairs Less Than Target [1, 3, 4, 6, 8] t = 8
	public static int countPairs(int[] nums, int target) {
		Arrays.sort(nums);
		int left = 0;
		int right = nums.length - 1;
		int count = 0;
		while(left<right) {
			int sum = nums[left] + nums[right];
			if(sum < target) {
				count = count + (right - left);
				left++;
			}else {
				right--;
			}
		}
		return count;
	}
	
	// amazon oa - get number of teams
	public static long  getNumTeams(int[] cost, int min_cost, int max_cost) {
		Arrays.sort(cost);
		long maxCount = countLessOrEqual(cost, max_cost);
		long minCount = countLess(cost, min_cost);
		return maxCount - minCount;
	}
	
	public static int countLessOrEqual(int[] cost, int target) {
		int left = 0;
		int right = cost.length - 1;
		int count = 0;
		while(left < right) {
			int sum = cost[left] + cost[right];
			if(sum <= target) {
				count = count + (right - left);
				left++;
			}else {
				right--;
			}
		}
		return count;
	}
	
	public static int countLess(int[] cost, int target) {
		int left = 0;
		int right = cost.length - 1;
		int count = 0;
		while(left < right) {
			int sum = cost[left] + cost[right];
			if(sum < target) {
				count = count + (right - left);
				left++;
			}else {
				right--;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] arr = {2,3,4,5};
		System.out.println(getNumTeams(arr, 5, 7));
	}

}
