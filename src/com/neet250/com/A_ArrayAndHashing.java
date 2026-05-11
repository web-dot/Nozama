package com.neet250.com;

import java.util.Arrays;

public class A_ArrayAndHashing {
	
	// rotate array
	public static int[] rotate(int[] nums, int n) {
		n = n % nums.length;
		if(nums.length == 0 || nums.length == 1) {
			return nums;
		}
		for(int i=0; i<n; i++) {
			int temp = nums[nums.length-1];
			for(int j=nums.length-1; j>0; j--) {
				nums[j] = nums[j-1];
			}
			nums[0] = temp;
		}
		return nums;
	}

	public static void main(String[] args) {
		int[] nums = {3,4};
		System.out.println(Arrays.toString(rotate(nums, 2)));
	}

}
