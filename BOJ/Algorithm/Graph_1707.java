package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Graph_1707 {
	static ArrayList<Integer>[] a;
	// check배열을 변형
	// 0: 방문x, 1: 그룹A, 2: 그룹B
	static int[] color; 
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int k = Integer.parseInt(br.readLine());
			String[] tmp;
			while(k-- > 0) {
				tmp = br.readLine().split(" ");
				int V = Integer.parseInt(tmp[0]);
				int E = Integer.parseInt(tmp[1]);
				
				a = (ArrayList<Integer>[]) new ArrayList[V+1];
				color = new int[V+1];
				for(int i=1; i<=V; ++i) // 정점: 1~V
					a[i] = new ArrayList<Integer>();
				for(int i=0; i<E; ++i) {
					tmp = br.readLine().split(" ");
					int u = Integer.parseInt(tmp[0]);
					int v = Integer.parseInt(tmp[1]);
					a[u].add(v);
					a[v].add(u);
				}
				
				//@ 전체 그래프가 연결그래프여야 할 필요는 없다!
				boolean valid = false;
				for(int i=1; i<=V; ++i) {
					if(color[i] == 0)
						valid = dfs(i,1); // i번 정점-A그룹부터 시작
					if(valid == false) break;
				}
				if(valid) {
					bw.write("YES");
				}else {
					bw.write("NO");
				}
				bw.write('\n');
			}
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// group: 현재 그룹 번호(1번 그룹, 2번 그룹) 
	static boolean dfs(int x, int group) {
		color[x] = group;
		for(int y : a[x]) {
			// 같은 색과 연결되어 있으면 이분그래프 X
			if(color[y] == group) {
				return false;
			}
			if(color[y] == 0) {
				if(dfs(y, 3-group) == false) return false; // 하나라도 false면 false
			}
			// color[y] == 3-group인 경우는 검사하지 않고 넘어간다.
		}
		return true;
	}
}
