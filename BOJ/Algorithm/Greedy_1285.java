package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Greedy_1285 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			char[][] A = new char[n][n];
			for(int i=0; i<n; ++i) {
				String tmp = br.readLine();
				for(int j=0; j<n; ++j) {
					A[i][j] = tmp.charAt(j);
				}
			}
			// 모든 행에 대해서 바꿀지/ 안바꿀지 정해서 2^N번 풀어야 한다. 
			// 열은 T의 개수에 따라서 뒤집을지 말지 바로 정해진다.
			// 	=> 시간복잡도 O(2^N * N^2)
			int answer = go(A, n, 0);
			bw.write(Integer.toString(answer));
			bw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static int go(char[][] A, int n, int idx) {
		if(idx == n) {
			// 행을 뒤집는 여부를 전부 결정했으면, 열의 뒤집는 여부는 저절로 정해진다. 
			// 실제로 뒤집지 않고 T와 H 개수 중에 더 적은 것만 찾으면 됨 => O(n^2)
			int cnt = 0;
			for(int j=0; j<n; ++j) {
				int cnt_T = 0;
				for(int i=0; i<n; ++i) {
					if(A[i][j] == 'T')
						++cnt_T;
				}
				cnt_T = cnt_T <= (n-cnt_T) ? cnt_T : (n-cnt_T);
				cnt += cnt_T;
			}
			return cnt;
		}
		// 뒤집지 않는 경우
		int result1 = go(A, n, idx+1);
		// 뒤집는 경우
		for(int j=0; j<n; ++j) {
			if(A[idx][j] == 'H') 
				A[idx][j] = 'T';
			else 
				A[idx][j] = 'H';
		}
		int result2 = go(A, n, idx+1);
		
		return result1 <= result2 ? result1: result2;
	}
	
}
