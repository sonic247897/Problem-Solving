package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// (r, c)의 값만 구하면 됨 -> 이분탐색과 같으므로 범위에 맞지 않는곳은 검사X
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
			// 배열을 실제로 만들면 N=15일 때 메모리초과 남
			//	=> 다른 배열값은 필요없으므로 이럴 때는 배열을 특별히 만들 필요 없다.
			//int[][] A = new int[length][length]; 
			//go(A, 0, 0, r, c, length, 0);
			int ans = go(0, 0, r, c, length, 0);
			
			bw.write(Integer.toString(ans));
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
	//		-> X. 그러면 뒤에는 검사 안 하지만, 앞에 쓸데 없는 것들은 다 계산함
	
	//	@ 순서가 정해진(=정렬된) 문제이므로 이분탐색처럼 필요한 범위만 찾아볼 수 있다. [사분탐색]
	static int go(int y, int x, int r, int c, int length, int cnt) {
		if(length == 2) { // 가장 작은 단위의 Z가 나오면 방문
			for(int i=y; i<y+2; ++i) {
				for(int j=x; j<x+2; ++j) {
					if(i == r && j == c) return cnt; // 찾으면 값 리턴
					++cnt;
				}
			}
			return -1; // 못 찾으면 -1 리턴
		}
		int mid = length/2;
		int add_cnt = mid*mid;
		int ans = -1;
		
		if(y <= r && r < y+mid && x <= c &&  c < x+mid)
			ans = go(y, x, r, c, mid, cnt);
		
		if(y <= r && r < y+mid && x+mid <= c)
			ans = go(y, x+mid, r, c, mid, cnt+add_cnt);
		
		if(y+mid <= r && x <= c &&  c < x+mid)
			ans = go(y+mid, x, r, c, mid, cnt+add_cnt*2);
		
		if(y+mid <= r && x+mid <= c)
			ans = go(y+mid, x+mid, r, c, mid, cnt+add_cnt*3);
		
		return ans;
	}
}
