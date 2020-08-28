package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// 1. ���� bfs �غ��鼭 Ȯ��?
// 	- BFS ���� �� bfs_result�� ������� ��ȸ�ϸ鼭 dist�� ���������� �ƴ��� �˻�
//	 => O(N)
//	 -> �ܰ躰 ��ȸ �� �ƴ϶�, ť�� �ִ� ������ �߿��ϴ�! (�θ����� ������ �ʿ�)
/*	�ݷ�) 7
		1 2
		1 3
		2 4
		2 5
		3 6
		3 7
		1 3 2 4 5 6 7 */
// 2. ����κ��� ����
public class Graph_16940 {
	static ArrayList<Integer>[] a;
	static int[] dist;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			dist = new int[n+1]; // 1~n
			a = (ArrayList<Integer>[]) new ArrayList[n+1];
			for(int i=1; i<=n; ++i)
				a[i] = new ArrayList<Integer>();
			
			String[] tmp;
			for(int i=0; i<n-1; ++i) {
				tmp = br.readLine().split(" ");
				int u = Integer.parseInt(tmp[0]);
				int v = Integer.parseInt(tmp[1]);
				a[u].add(v);
				a[v].add(u);
			}
			
			int[] bfs_result = new int[n];
			tmp = br.readLine().split(" ");
			for(int i=0; i<n; ++i)
				bfs_result[i] = Integer.parseInt(tmp[i]);
			
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(1);
			dist[1] = 1;
			while(!q.isEmpty()) {
				int cur = q.poll();
				for(int next : a[cur]) {
					if(dist[next] != 0) continue;
					q.add(next);
					dist[next] = dist[cur] +1;
				}
			}

			int order = 1;
			for(int i=1; i<n; ++i) {
				if(order > dist[bfs_result[i]]) { // ���������̸� Ʋ�� ����
					bw.write('0');
					bw.flush();
					return;
				}
				order = dist[bfs_result[i]];
			}
			bw.write('1');
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
