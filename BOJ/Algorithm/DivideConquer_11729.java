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
			cnt = solve(n, 1, 3, sb); // n개 원판(1~n 원판)을 1에서 3으로 옮기는 함수
			
			bw.write(Integer.toString(cnt));
			bw.write('\n');
			bw.write(sb.toString());
			bw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// public static int solve(int n, int from, int to, int cnt, StringBuilder sb) 
	//	=> 이미 리턴하는 int가 cnt와 같은 의미이기 때문에 매개변수로 cnt를 넘기면 안된다.
	public static int solve(int n, int from, int to, StringBuilder sb) {
		if(n == 1) {
			sb.append(from).append(' ').append(to).append('\n');
			return 1; // 옮길 원판이 1개이면 1번 바로 옮기고 종료
		}
		int cnt = 0; // @ 이번 호출에서부터 개수를 다시 세서 넘겨줘야 한다! - 작은 문제에서부터 세는 것이기 때문에 리턴값으로 넘김
		// @@ 큰 문제에서부터 받아와야 하는 것은 매개변수로 받아온다.
		
		// sb.append(from).append(' ').append(6-from-to).append('\n');
		// -> 여기서 출력하면 안된다. 함수의 정의가 => 'n개의 원판을 옮기는 문제'인데, 실제로는 한번에 원판 한개씩만 움직일 수 있다.
		// => 따라서 원판이 1개일 때만 출력해줘야 한다.
		cnt += solve(n-1, from, 6-from-to, sb); // 1+2+3 = 6
		
		// 원판 한 개를 이동시키는 것은 solve 재귀함수의 정의와 다르므로 재귀로 표현할 수 없다.
		sb.append(from).append(' ').append(to).append('\n');
		++cnt;
		
		//sb.append(6-from-to).append(' ').append(to).append('\n');
		cnt += solve(n-1, 6-from-to, to, sb);
		
		return cnt;
	}
}
