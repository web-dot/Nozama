package com.amazon.problems;

public class DFS_Problems {

	// number of islands
	public static int numIslands(char[][] grid) {
		int count = 0;
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				if(grid[i][j] == '1') {
					count++;
					printGrid(grid);
					dfs(grid, i, j);
				}
			}
		}
		return count;
	}
	
	public static void dfs(char[][] grid, int i, int j) {
		if(i < 0 || j < 0 || i >= grid.length || j>=grid[0].length || grid[i][j] == '0') {
			return;
		}
		grid[i][j] = '0';
		System.out.println();
		printGrid(grid);
		dfs(grid, i-1, j); // up
		dfs(grid, i+1, j); // down
		dfs(grid, i, j+1); // right
		dfs(grid, i-1, j-1); // left
	}
	
	public static void printGrid(char[][] grid) {
	    for (int i = 0; i < grid.length; i++) {
	        for (int j = 0; j < grid[0].length; j++) {
	            System.out.print(grid[i][j] + " "); // same line
	        }
	        System.out.println(); // new line after each row
	    }
	}
	
	public static void main(String[] args) {
		char[][] arr = {{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
		System.out.println(numIslands(arr));
	}

}
