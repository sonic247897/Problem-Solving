package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

// 사이클을 제외하고 길이가 5 이상인 경로가 있는지 확인
//	=> DFS (최소길이가 아니므로 BFS 안 써도 됨)
public class Graph_13023 {
	static ArrayList<Integer>[] a;
	static boolean[] c;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] tmp = br.readLine().split(" ");
			int n = Integer.parseInt(tmp[0]);
			int m = Integer.parseInt(tmp[1]);
			
			// ArrayList<Integer>[] a = new ArrayList<Integer>[n];
			// 	-> generic타입의 배열은 new로 생성 불가능 
			//	  (ArrayList<T>와 같은 제네릭 타입들은 처음에 메모리를 얼마나 할당해줘야 하는지 알 수 없으므로 배열을 만들기 어렵다) 
			a = (ArrayList<Integer>[]) new ArrayList[n+1];
			for(int i=0; i<m; ++i) {
				tmp = br.readLine().split(" ");
				a.add(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
				
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
