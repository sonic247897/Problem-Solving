package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

// ����Ŭ�� �����ϰ� ���̰� 5 �̻��� ��ΰ� �ִ��� Ȯ��
//	=> DFS (�ּұ��̰� �ƴϹǷ� BFS �� �ᵵ ��)
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
			// 	-> genericŸ���� �迭�� new�� ���� �Ұ��� 
			//	  (ArrayList<T>�� ���� ���׸� Ÿ�Ե��� ó���� �޸𸮸� �󸶳� �Ҵ������ �ϴ��� �� �� �����Ƿ� �迭�� ����� ��ƴ�) 
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
