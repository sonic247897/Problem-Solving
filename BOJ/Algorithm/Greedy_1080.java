package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 'N�� M�� 50���� �۰ų� ���� �ڿ���' ���ǿ��� N, M < 3�� ��� ����ó��
// �������� �� �������� 3*3���� ���� ũ�� ����� ������ ������ �� �� ����.
public class Greedy_1080 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] tmp = br.readLine().split(" ");
			int N = Integer.parseInt(tmp[0]);
			int M = Integer.parseInt(tmp[1]);
			int[][] A = new int[N][M];
			int[][] B = new int[N][M];
			for(int i=0; i<N; ++i) {
				String str = br.readLine();
				for(int j=0; j<M; ++j) {
					A[i][j] = str.charAt(j)-'0';
				}
			}
			for(int i=0; i<N; ++i) {
				String str = br.readLine();
				for(int j=0; j<M; ++j) {
					B[i][j] = str.charAt(j)-'0';
				}
			}
			
			// ����ó�� - ������ ������ �� �� ���� ��쿡�� A�� B�� �������� �˻�
			if(N<3 || M<3) {
				for(int i=0; i<N; ++i) {
					for(int j=0; j<M; ++j) {
						if(A[i][j] != B[i][j]) {
							bw.write(Integer.toString(-1));
							bw.flush();
							return;
						}
					}
				}
				bw.write(Integer.toString(0));
				bw.flush();
				return;
			}
			
			// �׸��� �˰��� - ���� �� ���� A=B �ǰ� ���߱�
			int cnt = 0;
			for(int i=0; i<N-2; ++i) {
				for(int j=0; j<M-2; ++j) {
					if(A[i][j] == B[i][j]) continue;
					flip(A, i, j);
					++cnt;
				}
			}
			// ���� ������ ���� ��ġ�ϴ��� �˻�
			for(int i=N-2; i<N; ++i) {
				for(int j=0; j<M; ++j) {
					if(A[i][j] != B[i][j]) {
						bw.write(Integer.toString(-1));
						bw.flush();
						return;
					}
				}
			}
			for(int i=0; i<N-2; ++i) {
				for(int j=M-2; j<M; ++j) {
					if(A[i][j] != B[i][j]) {
						bw.write(Integer.toString(-1));
						bw.flush();
						return;
					}
				}
			}
			// ���� ��ġ�ϸ� Ƚ�� ����
			bw.write(Integer.toString(cnt));
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// flip �Լ�
	// ��Ʈ����ũ? - 3*3�̴ϱ� ��Ʈ����ũ 3�� �ؾ��ϴµ� 9�� �ٲٴ� �����̶� �� ���� �ȳ�
	// ��� �𵨸� - ���ڿ�? ����? 
	//		=> index ���� ������ + ���� ������ �ؾ��ϹǷ� char[][] vs int[][]
	// ��� ������ ���ڷ� �ϴ°� �� ������.. (�׸��� �Ϲ������� ���ڷ� �𵨸� ��)
	public static void flip(int[][] A, int i, int j) {
		for(int k=i; k<i+3; ++k) {
			for(int l=j; l<j+3; ++l) {
				A[k][l] = 1 - A[k][l];
			}
		}
	}
	
}
