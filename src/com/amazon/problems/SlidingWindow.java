package com.amazon.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlidingWindow {

	
	// longest substring with non-repeating chars
	public static int lengthOfLongestSubstring(String s) {
		int start = 0;
		int end = 0;
		int maxLength = 0;
		int currentStart = 0;
		
		Map<Character, Integer> currentIndexMap = new HashMap<>();
		if(s==null || s.isEmpty()) {
			return 0;
		}
		
		for(int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if(currentIndexMap.containsKey(c) 
					&& currentIndexMap.get(c)>=currentStart) {
				currentStart = currentIndexMap.get(c) + 1;
			}
			currentIndexMap.put(c, i);
			if(i-currentStart+1 > maxLength) {
				maxLength = i - currentStart + 1;
				end = i;
				start = currentStart;
			}
		}
		return s.substring(start, end+1).length();
	}
	
	// max avg subarray
	public static double findMaxAverage(int[] nums, int k) {
		int sum = 0;
		for(int i=0; i<k; i++) {
			sum = sum + nums[i];
		}
		int maxSum = sum;
		
		for(int i=k; i<nums.length; i++) {
			sum = sum - nums[i-k] + nums[i];
			maxSum = Math.max(maxSum, sum);
		}
		return (double)maxSum/k;
	}
	
	
	// find all anagrams
	public static List<Integer> findAnagrams(String s, String p){
		List<Integer> result = new ArrayList<>();
		
		if (s.length() < p.length()) return result;
		
		int[] pcount = new int[26];
		int[] window = new int[26];
		
		for(char c : p.toCharArray()) {
			pcount[c - 'a']++;
		}
		
		int k = p.length();
		
		// first window
		for(int i=0; i<k; i++) {
			window[s.charAt(i) - 'a']++;
		}
		
		
		if(Arrays.equals(pcount, window)) {
			result.add(0);
		}
		
		// slide window cbaebabacd
		for(int i=k; i<s.length(); i++) {
			// add new char
			window[s.charAt(i) - 'a']++;
			// remove old char
			window[s.charAt(i-k) - 'a']--;
			if(Arrays.equals(pcount, window)) {
				result.add(i-k+1);
			}
		}
		return result;
	}
	
	// permutation i nstring
	public static boolean checkInclusion(String s1, String s2) {
		if (s2.length() < s1.length()) return false;
		int[] pcount = new int[26];
		int[] window = new int[26];
		
		int k = s1.length();
		
		for(char c : s1.toCharArray()) {
			pcount[c-'a']++;
		}
		
		for(int i=0; i<k; i++) {
			window[s2.charAt(i) - 'a']++;
		}
		
		if(Arrays.equals(pcount, window)) return true;
		
		for(int i=k; i<s2.length(); i++) {
			window[s2.charAt(i) - 'a']++;
			window[s2.charAt(i-k) - 'a']--;
			if(Arrays.equals(pcount, window)) return true;
		}
		return false;
	}
	
	// max sum of distinct subarray
	public static long maximumSubarraySum(int[] nums, int k) {
	    Map<Integer, Integer> map = new HashMap<>();
	    long sum = 0;
	    long maxSum = 0;

	    // first window
	    for(int i = 0; i < k; i++) {
	        sum += nums[i];
	        map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
	    }
	   
	    if(map.size() == k) {
	        maxSum = sum;
	    }
	   
	    // sliding window
	    for(int i = k; i < nums.length; i++) {
	    	
	        // add new element
	        sum += nums[i];
	        map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
	        
	        
	        
	        // remove old element
	        int left = nums[i - k];
	        sum = sum - left;
	        map.put(left, map.get(left) - 1);
	      
	        if(map.get(left) == 0) {
	            map.remove(left);
	        }
	        
	        if(map.size() == k) {
	            maxSum = Math.max(maxSum, sum);
	        }
	    }

	    return maxSum;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,5,4,2,9,9,9};
		System.out.println(maximumSubarraySum(arr, 3));

	}

}
