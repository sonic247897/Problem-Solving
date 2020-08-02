package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DivideConquer_1780 {
	static int[][] A = new int[2187][2187]; // 3^7 = 2187
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			for(int i=0; i<n; ++i) {
				String[] tmp = br.readLine().split(" ");
				// �迭�� �̿��� ������ ����ϸ� �Ű����� ���ڸ� ������ 3��->������ �迭 1���� 
				// ����ȭ �� �� �ֱ� ������ -1,0,1�� +1���༭ index������ ������ش�.
				for(int j=0; j<n; ++j) {
					A[i][j] = 1 + Integer.parseInt(tmp[j]);
				}
			}
			int[] cnt = new int[3]; // -1���� ����, 0���� ����, 1���� ����
			solve(0, 0, n, cnt);
			
			for(int i=0; i<3; ++i) {
				bw.write(Integer.toString(cnt[i]));
				bw.write(' ');
			}
			bw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean same(int y, int x, int n) {
		// ũ�� n*n ����� ���Ұ� ��� ������ true
		for(int i=y; i<y+n; ++i) {
			for(int j=x; j<x+n; ++j) {
				if(A[y][x] != A[i][j])
					return false; //�ϳ��� �ٸ��� ������ false
			}
		}
		return true;
	}
	
	public static void solve(int y, int x, int n, int[] cnt) {
		// ���� - pivot�� �����ϰ� �ڸ�(���ȣ��)
		if(same(y, x, n)) { // ���Ұ� ��� ������ ���� ���� �����ְ� ���̻� �ڸ��� X
			++cnt[A[y][x]];
			return;
		}
		int m = n/3;
		for(int i=0; i<3; ++i) {
			for(int j=0; j<3; ++j) {
				solve(y+i*m, x+j*m, m, cnt);
			}
		}
	}
}
