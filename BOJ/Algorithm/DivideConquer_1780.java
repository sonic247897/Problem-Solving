package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DivideConquer_1780 {
	static int[][] A = new int[2187][2187]; // 3^7 = 2187
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			for(int i=0; i<n; ++i) {
				String[] tmp = br.readLine().split(" ");
				// 배열을 이용해 개수를 계산하면 매개변수 인자를 정수형 3개->정수형 배열 1개로 
				// 간편화 할 수 있기 때문에 -1,0,1에 +1해줘서 index범위로 만들어준다.
				for(int j=0; j<n; ++j) {
					A[i][j] = 1 + Integer.parseInt(tmp[j]);
				}
			}
			int[] cnt = new int[3]; // -1종이 개수, 0종이 개수, 1종이 개수
			solve(0, 0, n, cnt);
			
			for(int i=0; i<3; ++i) {
				bw.write(Integer.toString(cnt[i]));
				bw.write(' ');
			}
			bw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean same(int y, int x, int n) {
		// 크기 n*n 행렬의 원소가 모두 같으면 true
		for(int i=y; i<y+n; ++i) {
			for(int j=x; j<x+n; ++j) {
				if(A[y][x] != A[i][j])
					return false; //하나라도 다른게 있으면 false
			}
		}
		return true;
	}
	
	public static void solve(int y, int x, int n, int[] cnt) {
		// 분할 - pivot을 결정하고 자름(재귀호출)
		if(same(y, x, n)) { // 원소가 모두 같으면 종이 개수 더해주고 더이상 자르지 X
			++cnt[A[y][x]];
			return;
		}
		int m = n/3;
		for(int i=0; i<3; ++i) {
			for(int j=0; j<3; ++j) {
				solve(y+i*m, x+j*m, m, cnt);
			}
		}
	}
}
