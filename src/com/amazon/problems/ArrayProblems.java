package com.amazon.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayProblems {
	
	
	// two sum [1,2,7,4]  //8
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<nums.length; i++) {
			int complement = target - nums[i];
			if(map.containsKey(complement)) {
				int[] arr = {map.get(complement), i};
				return arr;
			}
			map.put(nums[i], i);
		}
		
		return new int[0];
	}
	
	// maximum sum subarray - kadens algorithm
	public static int maxSubArray(int[] nums) {
		int maxSum = Integer.MIN_VALUE;
		int currentSum = 0;
		
		for(int i=0; i<nums.length; i++) {
			currentSum = currentSum + nums[i];
			maxSum = Math.max(maxSum, currentSum);
			if(currentSum < 0) {
				currentSum = 0;
			}
		}
		return maxSum;
	}
	
	// rotate array
	public static void rotate(int[] nums, int k) {
		int n = nums.length;
		k = k % n;
		reverse(nums, 0, n-1);
		reverse(nums, 0, k-1);
		reverse(nums, k, n-1);
	}
	
	public static void reverse(int[] nums, int start, int end) {
		while(start<end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
	
	// buy sell stock
	public static int maxProfit(int[] prices) {
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		for(int price : prices) {
			if(price<minPrice) {
				minPrice = price;
			}else {
				maxProfit = Math.max(maxProfit, price-minPrice);
			}
		}
		return maxProfit;
	}
	
	public static void main(String[] args) {
		int[] nums = {7,1,5,3,6,4};
		System.out.println(maxProfit(nums));
	}

}
