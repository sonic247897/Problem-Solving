package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// �� �� ���� ��ȯ�ϸ� 3�� ���� �ٲ�µ�, �Ź� �����·� ������ �ٽ� 3�� ���� �ٲ�� �ϹǷ�
// �� ó���� �ٲ�� �� ���¿��� max�� ���س��´�. (�� max�� 3�� �� �ٲﰪ�� ��)
public class BruteForce_3085 {
	static char[][] board = new char[50][50];
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n= Integer.parseInt(br.readLine());
			// �� �����ִ���� ���ϱ�
			int max_len = 0;
			for(int i=0; i<n; ++i) {
				String tmp = br.readLine();
				board[i][0] = tmp.charAt(0);
				int cnt = 1;
				for(int j=1; j<n; ++j) {
					board[i][j] = tmp.charAt(j);
					if(board[i][j] == board[i][j-1]) {
						++cnt;
					}else {
						if(cnt > max_len) max_len = cnt; // �ִ�����ΰ�?
						cnt = 1; // �ٽ� ����
					}
					// ������
					if(cnt > max_len) max_len = cnt;
				}
			}
			// �� �����ִ���� ���ϱ�
			for(int j=0; j<n; ++j) {
				int cnt = 1;
				for(int i=1; i<n; ++i) {
					if(board[i][j] == board[i-1][j]) {
						++cnt;
					}else {
						if(cnt > max_len) max_len = cnt;
						cnt = 1;
					}
				}
				// ������
				if(cnt > max_len) max_len = cnt;
			}
			
			// ���ӽ���!!
			// ����, �Ʒ��ʸ� �ٲٱ�(������� �ٲٸ� ��, �������� �ߺ��̹Ƿ�)
			for(int i=0; i<n; ++i) {
				for(int j=0; j<n; ++j) {
					if(j+1 < n) {
						swap_left(i, j); // ����
						// i��, j��, j+1�� �˻�
						int max = Math.max(Math.max(check_row(n, i), check_col(n, j)), check_col(n, j+1));
						if(max > max_len) max_len = max;
						swap_left(i, j); // ���󺹱�
					}
					if(i+1 < n) {
						swap_down(i, j); // �Ʒ���
						// i��, i+1��, j��
						int max = Math.max(Math.max(check_row(n, i), check_row(n, i+1)), check_col(n, j));
						if(max > max_len) max_len = max;
						swap_down(i, j); // ���󺹱�
					}
				}
			}
			
			bw.write(Integer.toString(max_len));
			bw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void swap_left(int i, int j) {
		char tmp = board[i][j];
		board[i][j] = board[i][j+1];
		board[i][j+1] = tmp;
	}
	
	public static void swap_down(int i, int j) {
		char tmp = board[i][j];
		board[i][j] = board[i+1][j];
		board[i+1][j] = tmp;
	}
	
	public static int check_row(int n, int row) {
		int max_len = 0;
		int count = 1;
		for(int i=1; i<n; ++i) {
			if(board[row][i] == board[row][i-1]) {
				++count;
			}else {
				if(count > max_len) max_len = count;
				count = 1;
			}
		}
		if(count > max_len) max_len = count;
		return max_len;
	}
	
	public static int check_col(int n, int col) {
		int max_len =0;
		int count = 1;
		for(int i=1; i<n; ++i) {
			if(board[i][col] == board[i-1][col]) {
				++count;
			}else {
				if(count > max_len) max_len = count;
				count = 1;
			}
		}
		if(count > max_len) max_len = count;
		return max_len;
	}
	
	
}
