package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 두 동전 중 하나만 보드에서 떨어뜨리기 위해 버튼을 최소 몇 번 눌러야하는지
// 버튼을 10번보다 많이 눌러야 한다면, -1을 출력한다. => 4^10. 이 조건 때문에 완전탐색 가능
// 최소 거리인데 BFS가 아닌 이유?
//	=> 구슬이 2개인데 다른 구슬이 이미 방문한 칸(check[y][x]=true)을 또 방문해야 하기 때문
// check배열은 필요 없다. 다른 구슬이 떨어지기 위해 이미 지나온 경로로 돌아가야 하는 경우도 있어서
public class Recursion_16197 {
	static int[] dy = {0,0,-1,1};
	static int[] dx = {1,-1,0,0};
	static int N, M;
	static char[][] map;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] tmp = br.readLine().split(" ");
			N = Integer.parseInt(tmp[0]);
			M = Integer.parseInt(tmp[1]);
			
			map = new char[N][M];
			// 동전 처음위치
			int y1=-1, x1=-1, y2=-1, x2=-1;
			for(int i=0; i<N; ++i) {
				String str = br.readLine();
				for(int j=0; j<M; ++j) {
					// 다른 동전이 있는 경우에도 이동할 수 있으므로 동전의 위치는 이동시 중요하지 않다.
					map[i][j] = str.charAt(j);
					if(map[i][j] == 'o') {
						//map[i][j] = '.';
						if(y1 == -1) {
							y1 = i; x1 = j;
						}else { // 첫번째 구슬 초기화했으면 두번째 구슬 저장
							y2 = i; x2 = j;
						}
					}
				}
			}
			int ans = go(y1, x1, y2, x2, 1);
			if(ans == 987654321) ans = -1;
			bw.write(Integer.toString(ans));
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// 버튼 누른 횟수 리턴
	public static int go(int y1, int x1, int y2, int x2, int cnt) {
		if(cnt > 10) return 987654321;

		int min = 987654321;
		for(int i=0; i<4; ++i) {
			int ny1 = y1+dy[i]; int nx1 = x1+dx[i];
			int ny2 = y2+dy[i]; int nx2 = x2+dx[i];
			// 두 개 동시에 떨어뜨리면 안됨
			boolean fall1 = false, fall2 = false;
			if((ny1 >= N || ny1 < 0)||(nx1 >= M || nx1 < 0)) fall1 = true;
			if((ny2 >= N || ny2 < 0)||(nx2 >= M || nx2 < 0)) fall2 = true;
			if(fall1 ^ fall2) // 둘 중 한개만 떨어뜨리면 리턴 (xor 연산)
				return cnt;
			// 두 개 동시에 떨어뜨렸으면 재귀 더이상 진행하면 안됨
			if(fall1 && fall2) continue;
			
			// 다음 재귀 진행 - 벽
			if(map[ny1][nx1] == '#') {
				ny1 = y1; nx1 = x1;
			}
			if(map[ny2][nx2] == '#') {
				ny2 = y2; nx2 = x2;
			}
			int res = go(ny1, nx1, ny2, nx2, cnt+1);
			if(min > res) min = res;
		}
		return min;
	}
	
}
