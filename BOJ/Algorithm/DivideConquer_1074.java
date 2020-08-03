package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DivideConquer_1074 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] tmp = br.readLine().split(" ");
			int N = Integer.parseInt(tmp[0]);
			int r = Integer.parseInt(tmp[1]);
			int c = Integer.parseInt(tmp[2]);
			// 2���� �迭 ������
			int length = 1<<N;
			int[][] A = new int[length][length]; 
			go(A, 0, 0, r, c, length, 0);
			
			bw.write(Integer.toString(A[r][c]));
			bw.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// �湮 Ƚ�� ���� -> ���������������� ���� ���������� �ö�� => ���ϰ� (X. �׻� ���� ���� �����Ƿ� cnt�� ���� �����༭ �ѱ�� �ȴ�)
	//	=> ������������ ���������� �Ѱ���� �� ���� ���� => �Ű����� (O)
	//	 ex) ù��° z ��ȣ ���� �ι��� z�� �Ѿ �� ù��° z���� ���� ���� �Ѱ���� ��
	// �ٵ� ������ �� ������ (r,c) ���� �������� �����ϰ� �����ϰ� ������ ��� ����?
	//	=> dfs���� for�� �ȿ��� �˻��ϰ� ���Ϲ� �־��� ��ó��, ��� ȣ���� ������ ã�Ҵ��� �˻��ϸ� �ȴ�.
	static void go(int[][] A, int y, int x, int r, int c, int length, int cnt) {
		if(length == 2) { // ���� ���� ������ Z�� ������ �湮
			for(int i=y; i<y+2; ++i) {
				for(int j=x; j<x+2; ++j) {
					A[i][j] = cnt++;
				}
			}
			return;
		}
		int mid = length/2;
		int add_cnt = mid*mid;
		go(A, y, x, r, c, mid/2, cnt);
		if(A[r][c] != 0) return; // �̹� ã�Ҵ��� �˻��ϰ� ����
		
		go(A, y, x+mid, r, c, mid/2, cnt+add_cnt);
		if(A[r][c] != 0) return;
		
		go(A, y+mid, x, r, c, mid/2, cnt+add_cnt*2);
		if(A[r][c] != 0) return;
		
		go(A, y+mid, x+mid, r, c, mid/2, cnt+add_cnt*3);
		// ������ ��� ������ ���ϵ�
	}
}
