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

// ��ȯ������������ �Ÿ�(�ִܰŸ�) - BFS
public class Graph_16947 {
	static ArrayList<Integer>[] a;
	static int[] dist; // ����Ŭ: -2, �湮x: -1, ����Ŭ �� ����: �Ÿ� 
	// @ �������� �������� BFS�� �ؾ��� ���� dist[] �迭�� 0�� �ƴ϶� -1�� �ʱ�ȭ ������� �Ѵ�!
	
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
			// n���� ����
			for(int i=0; i<n; ++i) {
				String[] tmp = br.readLine().split(" ");
				int u = Integer.parseInt(tmp[0]);
				int v = Integer.parseInt(tmp[1]);
				a[u].add(v);
				a[v].add(u);
			}
			
			// bfs
			// ����Ŭ�� �� ���ۿ� �����Ƿ� ����Ŭ �߰��� ���� �ǵ��ư� => �����̳� ��� �ʿ�
			// ����Ŭ�� �������� ��� �Ǻ��ϴ°�? -> ������ ���� �� ó������ �ٽ� ���� �������� ���ư��� �� ������ ����Ŭ�� ������!
			// �׷� dfs�� �Ȱ����� ���� dfs�� ����Ŭ ã��, ����Ŭ �����ϰ� bfs �ϴ°� ������ 
			dfs(0, 1); // ����Ŭ üũ(0�� ���� �����Ƿ� ���Ƿ� ��� ����)
			
			// [1,n] ������������ �����ϴ°� �ƴ϶� ����Ŭ�� ������ �������� �����ؾ���
			for(int i=1; i<=n; ++i) {
				// ����Ŭ�� ���Ե� ������������ bfs ����
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
		if(dist[cur] == 0) return cur; // ����Ŭ ������ ã�� => ������ ���� + ����Ŭ ���Ե� ���� -2�� ����
		
		// �湮�� ����: 0, ����Ŭ�� Ȯ������ �ٽ� -2�� ����
		dist[cur] = 0;
		int result = -100;
		for(int next : a[cur]) {
			if(next == prev) continue;
			result = dfs(cur, next);
			if(result != -100) { //����Ŭ ã���� ����Ŭ�� �ƴ� �ٸ� ��� Ž���� �ʿ� ����
				dist[cur] = -2;
				if(cur == result) return -100; //���������� �ǵ��ư��� �� ���� ������ �� ����Ŭ ���̹Ƿ� -100 ����
				else return result;
			}
		}
		// ���ʿ� ����Ŭ ������ ���� ���� ����(-100)
		dist[cur] = -1; // ����Ŭ ���� ������ �ٽ� -1�� ����
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
