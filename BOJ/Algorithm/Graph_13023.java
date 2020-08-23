package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

// 사이클을 제외하고 길이가 5 이상인 경로가 있는지 확인
//	-> DFS로 풀 수 없다. 순회 순서에 따라 최대 길이가 달라지기 때문 
//		ex) {a,b},{a,c},{b,c},{c,d}일 때 a->c->d의 경로 길이는 3이지만 a->b->c->d로 순회할 때는 길이가 4가 된다.
//	-> BFS 불가능 (최소길이로는 놓치는 정보가 많음)
// => 모든 경로를 전부 탐색? (브루트 포스)
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
			// 	-> generic타입의 배열은 생성 불가능 (배열의 공변 속성과 제네릭의 타입소거 속성 때문)
			//	=> 해결방법: raw 타입의 배열을 생성 후, generic 타입의 배열로 형변환 해준다.
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
				if(dfs(i, 1)) { // 자기 자신 포함
					bw.write('1');
					bw.flush();
					return; // 프로그램 종료
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
