package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 순환선에서부터의 거리(최단거리) - BFS
public class Graph_16947 {
	static ArrayList<Integer>[] a;
	static int[] dist; // 사이클: -2, 방문x: -1, 사이클 외 정점: 거리 
	// @ 시작점이 여러개인 BFS를 해야할 때는 dist[] 배열을 0이 아니라 -1로 초기화 시켜줘야 한다!
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			a = (ArrayList<Integer>[]) new ArrayList[n+1];
			dist = new int[n+1];
			Arrays.fill(dist, -1);
			for(int i=1; i<=n; ++i) {
				a[i] = new ArrayList<>();
			}
			// n개의 간선
			for(int i=0; i<n; ++i) {
				String[] tmp = br.readLine().split(" ");
				int u = Integer.parseInt(tmp[0]);
				int v = Integer.parseInt(tmp[1]);
				a[u].add(v);
				a[v].add(u);
			}
			
			// bfs
			// 사이클이 한 개밖에 없으므로 사이클 발견한 순간 되돌아감 => 스택이나 재귀 필요
			// 사이클의 시작점을 어떻게 판별하는가? -> 역추적 했을 때 처음으로 다시 같은 정점으로 돌아가면 그 정점이 사이클의 시작점!
			// 그럼 dfs랑 똑같으니 먼저 dfs로 사이클 찾고, 사이클 제외하고 bfs 하는게 나을듯 
			dfs(0, 1); // 사이클 체크(0번 노드는 없으므로 임의로 사용 가능)
			
			// [1,n] 오름차순으로 시작하는게 아니라 사이클에 근접한 정점부터 시작해야함
			for(int i=1; i<=n; ++i) {
				// 사이클에 포함된 정점에서부터 bfs 시작
				if(dist[i] == -2) 
					bfs(i);
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i=1; i<=n; ++i) {
				if(dist[i] == -2)
					sb.append(0).append(' ');
				else
					sb.append(dist[i]).append(' ');
			}
			bw.write(sb.toString());
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static int dfs(int prev, int cur) {
		if(dist[cur] == 0) return cur; // 사이클 시작점 찾음 => 시작점 리턴 + 사이클 포함된 정점 -2로 셋팅
		
		// 방문한 정점: 0, 사이클로 확정나면 다시 -2로 저장
		dist[cur] = 0;
		int result = -100;
		for(int next : a[cur]) {
			if(next == prev) continue;
			result = dfs(cur, next);
			if(result != -100) { //사이클 찾으면 사이클이 아닌 다른 경로 탐색할 필요 없음
				dist[cur] = -2;
				if(cur == result) return -100; //시작점까지 되돌아가면 그 이전 정점은 또 사이클 밖이므로 -100 리턴
				else return result;
			}
		}
		// 이쪽에 사이클 없으면 없는 정점 리턴(-100)
		dist[cur] = -1; // 사이클 외의 정점은 다시 -1로 셋팅
		return result;
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		dist[start] = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int next : a[cur]) {
				if(dist[next] != -1) continue;
				q.add(next);
				dist[next] = dist[cur] + 1;
			}
		}
	}
}
