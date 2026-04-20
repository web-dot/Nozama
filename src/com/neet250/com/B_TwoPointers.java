package com.neet250.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * remove duplicates from sorted array
 * valid palindrome 2
 * check palindrome
 * two sum
 * three sum
 * max area 
 * rescue boats
 * k sum pairs
 * */
public class B_TwoPointers {
	
	// remove duplictes {0,0,1,1,1,2,2,3,3,4}
	public static int removeDuplicates(int[] nums) {
		int i = 0;
		for(int j=1; j<nums.length; j++) {
			if(nums[i] !=nums[j]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
	}
	
	// valid palindrome 2
	public static boolean validPalindrome(String s) {
		int left = 0;
		int right = s.length()-1;
		while(left < right) {
			if(s.charAt(left) != s.charAt(right)) {
				return isPalindrome(s, left+1, right) ||
						isPalindrome(s, left, right-1);
			}
			left++;
			right--;
		}
		return true;
	}
	
	public static boolean isPalindrome(String s, int left, int right) {
		while(left < right) {
			if(s.charAt(left) != s.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	
	// merge strings
	public static String mergeAlternately(String word1, String word2) {
		int i = 0;
		int j = 0;
		
		StringBuilder result = new StringBuilder();
		while(i < word1.length() && j < word2.length()) {
			result.append(word1.charAt(i));
			result.append(word2.charAt(j));
			i++;
			j++;
		}
		
		while(i < word1.length()) {
			result.append(word1.charAt(i));
			i++;
		}
		
		while(j < word2.length()) {
			result.append(word2.charAt(j));
			j++;
		}
		
		return result.toString();
	}

	// two sum
	public int[] twoSum(int[] numbers, int target) {
        Arrays.sort(numbers);
        int left = 0;
        int right = numbers.length - 1;
        while(left < right) {
        	int sum = numbers[left] + numbers[right];
        	if(sum == target) {
        		return new int[] {left+1, right+1};
        	}else if(sum < target) {
        		left++;
        	}else {
        		right--;
        	}
        }
        return new int[] {};
    }
	
	// three sum [ -3, -2, -1, 0, 1, 2, 3, 4 ]
	public static List<List<Integer>> threeSum(int[] nums){
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for(int i=0; i<nums.length-2; i++) {
			if(i > 0 && nums[i] == nums[i-1]) continue;
			int left = i+1;
			int right = nums.length-1;
			while(left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if(sum == 0) {
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));
					while(left < right && nums[left] == nums[left+1]) left++;
					while(left < right && nums[right] == nums[right - 1]) right--;
					left++;
					right--;
				}else if(sum < 0) {
					left++; // increase sum
				}else {
					right--; // decrease sum
				}
			}
		}
		return result;
	}
	
	// max area - brute force
	public static int maxAreaBF(int[] heights) {
		int maxWater = 0;
		for(int i=0; i<heights.length; i++) {
			for(int j=i+1; j<heights.length; j++) {
				int h = Math.min(heights[i], heights[j]);
				int width = j - i;
				int area = h * width;
				maxWater = Math.max(maxWater, area);
			}
		}
		return maxWater;
	}
	
	 public static int maxArea(int[] heights) {
	        int left = 0;
	        int right = heights.length - 1;
	        int maxWater = 0;
	        while(left < right){
	            int h = Math.min(heights[left], heights[right]);
	            int width = right - left;
	            int area = h * width;
	            maxWater = Math.max(maxWater, area);
	            if(heights[left] < heights[right]){
	                left++;
	            }else{
	                right--;
	            }
	        }
	        return maxWater;
	    }
	 
	 // number of boats
		public static int numRescueBoats(int[] people, int limit) {
			Arrays.sort(people);
			int left = 0;
			int right = people.length-1;
			int boats = 0;
			while(left <= right) {
				int weight = people[left] + people[right];
				if(weight <= limit) {
					left++;
				}
				boats = boats + 1;
				right--;
			}
			return boats;
		}
		
		// max number of ksum pairs - lc 1679
		public int maxOperations(int[] nums, int k) {
	        Arrays.sort(nums);
	        int left = 0;
	        int right = nums.length-1;
	        int ops = 0;
	        while(left < right) {
	        	int sum = nums[left] + nums[right];
	        	if(sum == k) {
	        		ops++;
	        		left++;
	        		right--;
	        	}else if(sum < k) {
	        		left++;
	        	}else {
	        		right--;
	        	}
	        }
	        return ops;
	    }
	
	public static void main(String[] args) {
		String s = "abecbea";
		System.out.println(validPalindrome(s));
	}

}
