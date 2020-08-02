package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DivideConquer_11729 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			// StringBuilder도 char[] 배열이므로 call by reference
			int cnt = 0;
			StringBuilder sb = new StringBuilder(); 
			cnt = solve(n, 1, 3, cnt, sb); // n개 원판(1~n 원판)을 1에서 3으로 옮기는 함수
			
			bw.write(Integer.toString(cnt));
			bw.write('\n');
			bw.write(sb.toString());
			bw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int solve(int n, int from, int to, int cnt, StringBuilder sb) {
		if(n == 0) {
			return cnt; // 옮길 원판이 0개이면 종료
		}
		sb.append(from).append(' ').append(6-from-to).append('\n');
		solve(n-1, from, 6-from-to, cnt, sb); // 1+2+3 = 6
		++cnt;
		
		// 원판 한 개를 이동시키는 것은 solve 재귀함수의 정의와 다르므로 재귀로 표현할 수 없다.
		sb.append(from).append(' ').append(to).append('\n');
		++cnt;
		
		sb.append(6-from-to).append(' ').append(to).append('\n');
		solve(n-1, 6-from-to, to, cnt, sb);
		++cnt;
		
		return cnt;
	}
}
