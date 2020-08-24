package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Graph_1707 {
	static ArrayList<Integer>[] a;
	// check�迭�� ����
	// 0: �湮x, 1: �׷�A, 2: �׷�B
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
				for(int i=1; i<=V; ++i) // ����: 1~V
					a[i] = new ArrayList<Integer>();
				for(int i=0; i<E; ++i) {
					tmp = br.readLine().split(" ");
					int u = Integer.parseInt(tmp[0]);
					int v = Integer.parseInt(tmp[1]);
					a[u].add(v);
					a[v].add(u);
				}
				
				//@ ��ü �׷����� ����׷������� �� �ʿ�� ����!
				boolean valid = false;
				for(int i=1; i<=V; ++i) {
					if(color[i] == 0)
						valid = dfs(i,1); // i�� ����-A�׷���� ����
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
	// group: ���� �׷� ��ȣ(1�� �׷�, 2�� �׷�) 
	static boolean dfs(int x, int group) {
		color[x] = group;
		for(int y : a[x]) {
			// ���� ���� ����Ǿ� ������ �̺б׷��� X
			if(color[y] == group) {
				return false;
			}
			if(color[y] == 0) {
				if(dfs(y, 3-group) == false) return false; // �ϳ��� false�� false
			}
			// color[y] == 3-group�� ���� �˻����� �ʰ� �Ѿ��.
		}
		return true;
	}
}
