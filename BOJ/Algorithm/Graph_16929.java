package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 1) DFS
// 	2차원 배열 각 정점 한 번씩만 탐색하면 됨 - DFS
//	 내가 바로 직전에 출발한 방향을 제외하고 탐색하는데, 이미 탐색한 위치&같은 색깔이면 사이클 존재
//		=> 이동배열을 잘 짜면 구현이 더 쉬워진다. (보통 시계방향 사용)
// 2) BFS
// 	distance[] 배열에서 뺀 값으로 판단?
// 	BFS는 최단거리를 기록하는데 최단거리를 찾는게 아니므로 BFS 사용x 

public class Graph_16929 {
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	static boolean[][] check;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] tmp = br.readLine().split(" ");
			int n = Integer.parseInt(tmp[0]);
			int m = Integer.parseInt(tmp[1]);
			char[][] a = new char[n][m];
			check = new boolean[n][m];
			for(int i=0; i<n; ++i) {
				String str = br.readLine();
				for(int j=0; j<m; ++j)
					a[i][j] = str.charAt(j);
			}
			
			// DFS - 모든 색에 대해서 동시에 처리 불가능.
			// why? 재귀, 스택으로 구현 => 바로 직전 정점까지의 정보만 알아낼 수 있으므로
			//		(이번 분기까지 거쳐온 경로만 되돌아가기 알고리즘~배열 이용~으로 알아낼 수 있다)
			for(int i=0; i<n; ++i) {
				for(int j=0; j<m; ++j) {
					if(!check[i][j]) {
						if(dfs(i, j, -1, n, m, a)) {
							bw.write("Yes");
							bw.flush();
							return;
						}
					}
				}
			}
			bw.write("No");
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// dir - 0,1,2,3: 직전에 왔던 방향
	// 0<->2, 1<->3 (직전에 왔던 방향의 반대방향으로 가면 안된다)
	static boolean dfs(int y, int x, int dir, int n, int m, char[][] a) {
		check[y][x] = true;
		for(int i=0; i<4; ++i) {
			if(dir != -1 && i == (dir+2)%4) continue; // 바로 직전에 방문한 정점 pass
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(nx >=0 && nx <m && ny >=0 && ny <n) {
				if(a[y][x] == a[ny][nx]) {
					if(check[ny][nx]) return true;
					if(dfs(ny, nx, i, n, m, a)) return true;
				}
			}
		}
		return false;
	}
}
