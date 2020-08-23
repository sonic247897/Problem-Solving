package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

// '방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문' 조건 
//	=> 정렬
public class Graph_1260 {
	static ArrayList<Integer>[] a;
	static boolean[] check;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] tmp = br.readLine().split(" ");
			int n = Integer.parseInt(tmp[0]);
			int m = Integer.parseInt(tmp[1]);
			int start = Integer.parseInt(tmp[2]);
			
			a = (ArrayList<Integer>[]) new ArrayList[n+1]; // 정점번호 1~N
			for(int i=1; i<=n; ++i)
				a[i] = new ArrayList<Integer>();
			for(int i=0; i<m; ++i) {
				tmp = br.readLine().split(" ");
				int u = Integer.parseInt(tmp[0]);
				int v = Integer.parseInt(tmp[1]);
				a[u].add(v);
				a[v].add(u);
			}
			// 정렬
			for(int i=1; i<=n; ++i)
				Collections.sort(a[i]);
			
			StringBuilder sb = new StringBuilder();
			check = new boolean[n+1];
			dfs(start, sb);
			sb.append('\n');
			
			check = new boolean[n+1];
			bfs(start, sb);
			
			bw.write(sb.toString());
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void dfs(int x, StringBuilder sb) {
		check[x] = true;
		sb.append(x).append(' ');
		for(int y : a[x]) {
			if(check[y] == false)
				dfs(y, sb);
		}
	}
	
	static void bfs(int start, StringBuilder sb) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		check[start] = true;
		while(!q.isEmpty()) {
			int x = q.remove();
			sb.append(x).append(' ');
			for(int y : a[x]) {
				if(check[y] == false) {
					check[y] = true;
					q.add(y);
				}
			}
		}
	}
	
	
}
