package DP.exam;

public class DP03 {
	public static void main(String[] args) {

	}
	
	public static int solution(int[][] triangle) {
        // 일반적인 2차원 배열 -> 2차원 dp
        // d[i][j] = i행 j번째 숫자까지 더했을 때 최대값
        int size = triangle.length;
        int[][] d = new int[size][size];
        d[0][0] = triangle[0][0];
        for(int i=1; i<size; ++i) {
        	// 양 끝만 점화식 다름
        	d[i][0] = d[i-1][0] + triangle[i][0];
        	for(int j=1; j<i; ++j)
        		d[i][j] = Math.max(d[i-1][j-1], d[i-1][j]) + triangle[i][j];
        	d[i][i] = d[i-1][i-1] + triangle[i][i];
        }
        
        int max = -1;
        for(int i=0; i<size; ++i) {
        	if(d[size-1][i] > max) max = d[size-1][i];
        }
        
        return max;
    }
}
