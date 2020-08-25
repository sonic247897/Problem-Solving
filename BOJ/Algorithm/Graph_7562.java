package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 최소 이동 거리 - BFS
// 300^2 = 90000. 모든 칸 한 번씩 탐색해본다.
public class Graph_7562 {
	static int[] dy = {-1,-2,-2,-1, 1,2,2,1};
	static int[] dx = {-2,-1,1,2, 2,1,-1,-2};
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc;
		try {
			tc = Integer.parseInt(br.readLine());
			while(tc-- > 0) {
				int n = Integer.parseInt(br.readLine());
				String[] tmp = br.readLine().split(" ");
				int start_y = Integer.parseInt(tmp[0]);
				int start_x = Integer.parseInt(tmp[1]);
				
				tmp = br.readLine().split(" ");
				int goal_y = Integer.parseInt(tmp[0]);
				int goal_x = Integer.parseInt(tmp[1]);
				
				// BFS 최단거리 문제 - check배열을 변형한 distance 배열 사용
				int[][] d = new int[n][n];
				for(int i=0; i<n; ++i)
					Arrays.fill(d[i], -1);
				
				Queue<Integer> q = new LinkedList<Integer>();
				q.add(start_y); 
				q.add(start_x);
				d[start_y][start_x] = 0;
				while(!q.isEmpty()) {
					int y = q.poll();
					int x = q.poll();
					for(int i=0; i<8; ++i) {
						int ny = y + dy[i];
						int nx = x + dx[i];
						if(ny >= 0 && ny <n && nx>=0 && nx <n) {
							if(d[ny][nx] != -1) continue;
							d[ny][nx] = d[y][x] +1;
							if(ny == goal_y && nx == goal_x) break;
							q.add(ny);
							q.add(nx);
						}
					}
					if(d[goal_y][goal_x] != -1) break; // 찾았으면 bfs 종료
				}
				
				bw.write(Integer.toString(d[goal_y][goal_x]));
				bw.write('\n');
			}
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
