package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 두 개 사탕 교환하면 3개 줄이 바뀌는데, 매번 원상태로 돌리고 다시 3개 줄을 바꿔야 하므로
// 맨 처음에 바뀌기 전 상태에서 max를 구해놓는다. (그 max와 3개 줄 바뀐값을 비교)
public class BruteForce_3085 {
	static char[][] board = new char[50][50];
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n= Integer.parseInt(br.readLine());
			// 행 연속최대길이 구하기
			int max_len = 0;
			for(int i=0; i<n; ++i) {
				String tmp = br.readLine();
				board[i][0] = tmp.charAt(0);
				int cnt = 1;
				for(int j=1; j<n; ++j) {
					board[i][j] = tmp.charAt(j);
					if(board[i][j] == board[i][j-1]) {
						++cnt;
					}else {
						if(cnt > max_len) max_len = cnt; // 최대길이인가?
						cnt = 1; // 다시 세기
					}
					// 마지막
					if(cnt > max_len) max_len = cnt;
				}
			}
			// 열 연속최대길이 구하기
			for(int j=0; j<n; ++j) {
				int cnt = 1;
				for(int i=1; i<n; ++i) {
					if(board[i][j] == board[i-1][j]) {
						++cnt;
					}else {
						if(cnt > max_len) max_len = cnt;
						cnt = 1;
					}
				}
				// 마지막
				if(cnt > max_len) max_len = cnt;
			}
			
			// 게임시작!!
			// 왼쪽, 아래쪽만 바꾸기(순서대로 바꾸면 위, 오른쪽은 중복이므로)
			for(int i=0; i<n; ++i) {
				for(int j=0; j<n; ++j) {
					if(j+1 < n) {
						swap_left(i, j); // 왼쪽
						// i행, j열, j+1열 검사
						int max = Math.max(Math.max(check_row(n, i), check_col(n, j)), check_col(n, j+1));
						if(max > max_len) max_len = max;
						swap_left(i, j); // 원상복귀
					}
					if(i+1 < n) {
						swap_down(i, j); // 아래쪽
						// i행, i+1행, j열
						int max = Math.max(Math.max(check_row(n, i), check_row(n, i+1)), check_col(n, j));
						if(max > max_len) max_len = max;
						swap_down(i, j); // 원상복귀
					}
				}
			}
			
			bw.write(Integer.toString(max_len));
			bw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void swap_left(int i, int j) {
		char tmp = board[i][j];
		board[i][j] = board[i][j+1];
		board[i][j+1] = tmp;
	}
	
	public static void swap_down(int i, int j) {
		char tmp = board[i][j];
		board[i][j] = board[i+1][j];
		board[i+1][j] = tmp;
	}
	
	public static int check_row(int n, int row) {
		int max_len = 0;
		int count = 1;
		for(int i=1; i<n; ++i) {
			if(board[row][i] == board[row][i-1]) {
				++count;
			}else {
				if(count > max_len) max_len = count;
				count = 1;
			}
		}
		if(count > max_len) max_len = count;
		return max_len;
	}
	
	public static int check_col(int n, int col) {
		int max_len =0;
		int count = 1;
		for(int i=1; i<n; ++i) {
			if(board[i][col] == board[i-1][col]) {
				++count;
			}else {
				if(count > max_len) max_len = count;
				count = 1;
			}
		}
		if(count > max_len) max_len = count;
		return max_len;
	}
	
	
}
