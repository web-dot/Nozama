package com.amazon.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointers {

	
	
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
	
	public static void main(String[] args) {
		int[] people = {3};
		System.out.println(numRescueBoats(people, 3));
	}

}
