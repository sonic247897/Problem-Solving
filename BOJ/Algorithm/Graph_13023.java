package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

// ����Ŭ�� �����ϰ� ���̰� 5 �̻��� ��ΰ� �ִ��� Ȯ��
//	-> DFS�� Ǯ �� ����. ��ȸ ������ ���� �ִ� ���̰� �޶����� ���� 
//		ex) {a,b},{a,c},{b,c},{c,d}�� �� a->c->d�� ��� ���̴� 3������ a->b->c->d�� ��ȸ�� ���� ���̰� 4�� �ȴ�.
//	-> BFS �Ұ��� (�ּұ��̷δ� ��ġ�� ������ ����)
// => ��� ��θ� ���� Ž��? (���Ʈ ����)
// => union-find?
public class Graph_13023 {
	static ArrayList<Integer>[] a;
	static boolean[] check;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] tmp = br.readLine().split(" ");
			int n = Integer.parseInt(tmp[0]);
			int m = Integer.parseInt(tmp[1]);
			
			// ArrayList<Integer>[] a = new ArrayList<Integer>[n];
			// 	-> genericŸ���� �迭�� ���� �Ұ��� (�迭�� ���� �Ӽ��� ���׸��� Ÿ�ԼҰ� �Ӽ� ����)
			//	=> �ذ���: raw Ÿ���� �迭�� ���� ��, generic Ÿ���� �迭�� ����ȯ ���ش�.
			a = (ArrayList<Integer>[]) new ArrayList[n];  
			check = new boolean[n];
			for(int i=0; i<n; ++i) 
				a[i] = new ArrayList<Integer>();
			
			for(int i=0; i<m; ++i) {
				tmp = br.readLine().split(" ");
				int u = Integer.parseInt(tmp[0]);
				int v = Integer.parseInt(tmp[1]);
				a[u].add(v);
				a[v].add(u);
			}
			
			for(int i=0; i<n; ++i) {
				if(check[i] == true) continue;
				if(dfs(i, 1)) { // �ڱ� �ڽ� ����
					bw.write('1');
					bw.flush();
					return; // ���α׷� ����
				}
			}
			bw.write('0');
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean dfs(int x, int cnt) {
		if(cnt >= 5) return true;
		
		boolean result = false;
		check[x] = true;
		for(int y : a[x]) {
			if(check[y] == false) 
				result = dfs(y, cnt+1);
		}
		return result
	}
}
