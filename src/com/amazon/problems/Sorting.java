package com.amazon.problems;

import java.util.Arrays;

public class Sorting {
	
	public static void bubbleSort(int[] nums) {
		for(int i=0; i<nums.length-1; i++){
			int flag = 0;
			for(int j=0; j<nums.length-1-i; j++) {
				if(nums[j] > nums[j+1]) {
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
					flag = 1;
					System.out.println(Arrays.toString(nums));
				}
			}
			if(flag == 0) {
				break;
			}
		}
	}
	
	public static void quickSort(int[] nums, int low, int high) {
		if(low < high) {
			int pivotIndex = partition(nums, low, high);
			quickSort(nums, low, pivotIndex - 1);
			quickSort(nums, pivotIndex + 1, high);
		}
	}
	
	public static int partition(int[] nums, int low, int high) {
		int pivot = nums[high];
		int i = low - 1;
		for(int j = low; j < high; j++) {
			if(nums[j] <= pivot) {
				i++;
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}
		// place pivot in correct position
		int temp = nums[i+1];
		nums[i+1] = nums[high];
		nums[high] = temp;
		
		return i+1;
	}
	
	
	public static void insertionSort(int[] nums) {
		for(int i=0; i<nums.length; i++){
			int temp = nums[i];
			int j = i-1;
			while(j>=0 && nums[j] > temp) {
				nums[j+1] = nums[j];
				j--;
			}
			nums[j+1] = temp;
		}
	}
	
	public static void selectionSort(int[] nums) {
		for(int i=0; i<nums.length-1; i++) {
			int min = i;
			for(int j=i+1; j<nums.length; j++) {
				if(nums[j] < nums[min]) {
					min = j;
				}
			}
			if(min != i) {
				int temp = nums[i];
				nums[i] = nums[min];
				nums[min] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[] nums = {15,16,6,8,5};
		selectionSort(nums);
		System.out.println(Arrays.toString(nums));
	}

}
