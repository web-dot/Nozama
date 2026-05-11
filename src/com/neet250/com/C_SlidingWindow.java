package com.neet250.com;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class C_SlidingWindow {
	
	/**
	 * contains duplicate
	 * best time to buy sell stock
	 * longest substring without repeating char
	 * permutations in a string
	 * min size subarray
	 * 27-04-26
	 * */
	
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
	
	// permutations in string - lc- 567 // abc, lecabee
	public static boolean checkInclusion(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		if(n > m) return false;
		
		int[] sfreq = new int[26];
		int[] window = new int[26];
		
		for(int i=0; i<n; i++) {
			sfreq[s1.charAt(i) - 'a']++;
			window[s2.charAt(i) - 'a']++;
		}

		if(matches(sfreq, window)) return true;
		for(int i=n; i<m; i++) {
			window[s2.charAt(i) - 'a']++;
			window[s2.charAt(i - n) - 'a']--;
			if(matches(sfreq, window)) return true;
		}
		return false;
	}
	
	public static boolean matches(int[] a, int[] b) {
		for(int i=0; i<26; i++) {
			if(a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}
	
	
	// minimum size subarray sum - lc- 209
	public static int minSubArrayLen(int target, int[] nums) {
		int left = 0;
		int currentSum = 0;
		int n = nums.length;
		int minLen = n + 1;
		for(int right=0; right<n-1; right++) {
			currentSum = currentSum + nums[right];
			while(currentSum >= target) {
				minLen = Math.min(minLen, right - left + 1);
				currentSum = currentSum - nums[left];
				left++;
			}
		}
		return minLen == n + 1 ? 0 : minLen;
	}
	
	
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "lecabee";
		System.out.println(checkInclusion(s1, s2));
	}

}
