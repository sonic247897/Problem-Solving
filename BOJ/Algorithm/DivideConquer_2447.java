package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// @ ���� ��������� �����̶� ' '�� �Ȱ��� �����̽���(�ƽ�Ű 32��)�ε� �� Ʋ����..

// ���� - ������� �������� ���� ��� ����
// ��� ���? => ���� �迭 ����ؼ� �迭�� �����Ѵ�. (��ǥ �̿�)
public class DivideConquer_2447 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			char[][] A = new char[n][n];
			
			go(A, 0, 0, n);
			
			for(int i=0; i<n; ++i) {
				for(int j=0; j<n; ++j)
					bw.write(A[i][j]);
				bw.write('\n');
			}
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void go(char[][] A, int y, int x, int n) {
		if(n == 3) {
			// n->3, m->1 �̹Ƿ� �Ʒ� ���ȣ�� �ĵ�� ���� �����̴�.
			for(int i=x; i<x+3; ++i)
				A[y][i] = '*';
			A[y+1][x] = '*'; A[y+1][x+1]=' '; A[y+1][x+2] = '*';
			for(int i=x; i<x+3; ++i)
				A[y+2][i] = '*';
			return;
		}
		int m = n/3; // 3��� �� ��������
		for(int i=x; i<x+n; i += m) 
			go(A, y, i, m);
		
		go(A, y+m, x, m);
		for(int i=x+m; i<x+2*m; ++i)
			A[y+m][i] = ' '; // ��� �� ĭ ä���
		go(A, y+m, x+2*m, m);
		
		for(int i=x; i<x+n; i += m) 
			go(A, y+2*m, i, m);
	}
	
}
