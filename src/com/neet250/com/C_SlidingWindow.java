package com.neet250.com;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class C_SlidingWindow {
	
	// contains duplicate - {1,2,3,1,2,3}
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new HashSet<>();
		int left = 0;
		
		for(int right=0; right<nums.length; right++) {
			if(set.contains(nums[right])) {
				return true;
			}
			set.add(nums[right]);
			if(right - left >= k) {
				set.remove(nums[left]);
				left++;
			}
		}
		return false;
	}
	
	// best time to buy sell stock
	public static int maxProfit1(int[] prices) {
		int left = 0;
		int right = 1;
		int maxProfit = 0;
		while(right < prices.length) {
			if(prices[left] < prices[right]) {
				int profit = prices[right] - prices[left];
				maxProfit = Math.max(maxProfit, profit);
			}else {
				left = right;
			}
			right++;
		}
		return maxProfit;
	}
	
	// best time to buy sell stock
	public static int maxProfit2(int[] prices) {
		int minPrice = 0;
		int maxProfit = 0;
		for(int price : prices) {
			if(price < minPrice) {
				minPrice = price;
			}else {
				int profit = price-minPrice;
				maxProfit = Math.max(maxProfit, profit);
			}
		}
		return maxProfit;
	}
	
	// Longest Substring Without Repeating Characters
	public static int lengthOfLongestSubstring(String s) {
		Set<Character> set = new HashSet<>();
		int left = 0;
		int maxLen = 0;
		for(int right=0; right<s.length(); right++) {
			while(set.contains(s.charAt(right))) {
				set.remove(s.charAt(left));
				left++;
			}
			set.add(s.charAt(right));
			maxLen = Math.max(maxLen, right - left + 1);
		}
		return maxLen;
	}

	public static int lengthOfLongestSubstringUsingArray(String s) {
		boolean[] seen = new boolean[128];
		int left = 0;
		int maxLen = 0;
		for(int right=0; right<s.length(); right++) {
			while(seen[s.charAt(right)]) {
				seen[s.charAt(left)] = false;
				left++;
			}
			seen[s.charAt(right)] = true;
			maxLen = Math.max(maxLen, right - left + 1);
		}
		
		return maxLen;
	}
	
	
	public static void main(String[] args) {
		String s = "abcabcbb";
		System.out.println(lengthOfLongestSubstringUsingArray(s));
	}

}
