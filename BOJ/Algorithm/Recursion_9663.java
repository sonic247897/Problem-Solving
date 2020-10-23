package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// N-Queen 문제는 크기가 N × N인 체스판 위에 퀸 N개를 서로 공격할 수 없게 놓는 문제
// O(2^(15*15)) => 백트래킹 없이 브루트포스하면 시간초과
// 행, 열, 대각선을 check로 표시해두면 놓을 수 있는지 검사를 O(1)만에 할 수 있다.
//	=> 전체시간복잡도는 O(N^2)이 된다.
public class Recursion_9663 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			// 2차원 배열을 1차원 배열로 check하기
			//	=> 한번에 여러개 칸을 채우고 + 규칙이 있다면, 1차원 배열이 더 쉽게 채울 수 있다.
			boolean[] col_check = new boolean[n];
			int size = 2*n; // 범위: 0~2*(n-1) =>크기: 2*n-1
			boolean[] diag1_check = new boolean[size];
			boolean[] diag2_check = new boolean[size];
			int ans = go(0, n, col_check, diag1_check, diag2_check); // 0행부터 시작
			bw.write(Integer.toString(ans));
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int go(int row, int n, boolean[] col_check, boolean[] diag1_check, boolean[] diag2_check) {
		if(row == n) return 1; // 모든 행을 검사했으므로 경우의 수 1 추가
		
		// 이번 row에서 놓을 col의 위치
		int ans = 0;
		for(int i=0; i<n; ++i) {
			if(col_check[i] || diag1_check[row+i] || diag2_check[row-i+(n-1)]) continue; 
			col_check[i] = true;
			diag1_check[row+i] = true;
			diag2_check[row-i+(n-1)] = true;
			ans += go(row+1, n, col_check, diag1_check, diag2_check);
			col_check[i] = false;
			diag1_check[row+i] = false;
			diag2_check[row-i+(n-1)] = false;
		}
		return ans;
	}
}
