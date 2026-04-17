package com.oa_patterns.problems;

public class BinarySearchOnAnswer {

	// KOKO eating banana
	public static int minEatingSpeed(int[] piles, int h) {
		int start = 1;
		int end = 1;
		
		for(int i=0; i<piles.length; i++) {
			end = Math.max(end, piles[i]);
		}
		
		int ans = 0;
		
		while(start <= end) {
			int mid = start + (end - start) / 2;
			
			if(isPossible(piles, mid, h)) {
				ans = Math.min(end, mid);
				end = mid-1;
			}else {
				start = mid + 1;
			}
		}
		return ans;
	}
	
	public static boolean isPossible(int[] piles, int c, int h) {
		long hour = 0;
		for(int p : piles) {
			hour = hour + p/c;
			if(p % c > 0) {
				hour++;
			}
		}
		
		return hour <= h;
	}
	
	public static void main(String[] args) {
		int[] piles = {3,6,7,11};
		int h = 8;
		System.out.println(minEatingSpeed(piles, h));

	}

}
