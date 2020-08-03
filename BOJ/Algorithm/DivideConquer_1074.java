package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DivideConquer_1074 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] tmp = br.readLine().split(" ");
			int N = Integer.parseInt(tmp[0]);
			int r = Integer.parseInt(tmp[1]);
			int c = Integer.parseInt(tmp[2]);
			// 2차원 배열 사이즈
			int length = 1<<N;
			int[][] A = new int[length][length]; 
			go(A, 0, 0, r, c, length, 0);
			
			bw.write(Integer.toString(A[r][c]));
			bw.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 방문 횟수 세기 -> 하위문제에서부터 세서 상위문제로 올라옴 => 리턴값 (X. 항상 세는 개수 같으므로 cnt에 직접 더해줘서 넘기면 된다)
	//	=> 상위문제에서 하위문제로 넘겨줘야 할 때도 있음 => 매개변수 (O)
	//	 ex) 첫번째 z 번호 세고 두번재 z로 넘어갈 때 첫번째 z에서 받은 값을 넘겨줘야 함
	// 근데 끝까지 안 돌리고 (r,c) 만난 시점에서 리턴하고 종료하고 싶은데 방법 없나?
	//	=> dfs에서 for문 안에서 검사하고 리턴문 넣었던 것처럼, 재귀 호출할 때마다 찾았는지 검사하면 된다.
	static void go(int[][] A, int y, int x, int r, int c, int length, int cnt) {
		if(length == 2) { // 가장 작은 단위의 Z가 나오면 방문
			for(int i=y; i<y+2; ++i) {
				for(int j=x; j<x+2; ++j) {
					A[i][j] = cnt++;
				}
			}
			return;
		}
		int mid = length/2;
		int add_cnt = mid*mid;
		go(A, y, x, r, c, mid/2, cnt);
		if(A[r][c] != 0) return; // 이미 찾았는지 검사하고 리턴
		
		go(A, y, x+mid, r, c, mid/2, cnt+add_cnt);
		if(A[r][c] != 0) return;
		
		go(A, y+mid, x, r, c, mid/2, cnt+add_cnt*2);
		if(A[r][c] != 0) return;
		
		go(A, y+mid, x+mid, r, c, mid/2, cnt+add_cnt*3);
		// 어차피 재귀 끝나서 리턴됨
	}
}
