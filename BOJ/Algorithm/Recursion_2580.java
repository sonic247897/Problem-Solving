package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// ������ ���� ä��� ����� ������ ���� �� �� �ϳ����� ����Ѵ�.
public class Recursion_2580 {
	static int[] sudoku = new int[9*9];
	static int[] zero = new int[9*9]; 
	// (��ġ, ����): �ش� ��ġ�� �ش� ���ڰ� ������ true. �˻� �ð� =O(1) 
	// N-Queen������ �ش� ��ġ�� ���� �ֳ� ���ĸ� üũ�ϸ� �����Ƿ� true/false�� �����ϴ� 1���� boolean[] �迭�� �����ߴ�.
	// ���������� �ֳ�/���� �� �ƴ϶� 1~9 ���� üũ�ؾ� �ϹǷ� 2���� boolean[][]�迭 ���
	
	// �࿡ ���� ��ȣ ����
	//int[] row_check = new int[9]; -> �Ұ���. ���� �࿡ ���� ��ȣ�� 2�� �̻� ���� �� �ִ�. 
	static boolean[][] row_check = new boolean[9][10]; // 9�� ��
	static boolean[][] col_check = new boolean[9][10]; // 9�� ��
	static boolean[][] square_check = new boolean[9][10]; // 9�� ���簢��
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 2���� �迭�� 1���� �迭�� ����� ������ ���
		// 	1) ��(y,x)�� ���� �����ؾ� �ؼ� ���� Pair[] �迭�� ����ų� int[] �迭�� 2�� ������ �� ��
		try {
			int idx=0; int zero_size = 0;
			for(int i=0; i<9; ++i) {
				String[] tmp = br.readLine().split(" ");
				for(int j=0; j<9; ++j) {
					sudoku[idx] = Integer.parseInt(tmp[j]);
					row_check[i][sudoku[idx]] = true;
					col_check[j][sudoku[idx]] = true;
					square_check[(i/3)*3+j/3][sudoku[idx]] = true;
					if(sudoku[idx] == 0)
						zero[zero_size++] = idx;
					++idx;
				}
			}

			go(0, zero_size);
			
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<9*9; ++i) {
				sb.append(sudoku[i]);
				if((i+1)%9 ==0) sb.append('\n');
				else sb.append(' ');
			}
			bw.write(sb.toString());
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean go(int idx, int zero_size) {
		if(idx == zero_size) return true;
		
		// ĭ�� ���� �ְ� �� ���� �̹� �ִ��� �˻�(��, ��, ���簢�� �˻�)
		int p = zero[idx]; // row*9+col
		int row = p/9; 
		int col = p%9;
		int square = (row/3)*3 + col/3; // row + col/3 �� ���� �ʴ�. row/3�� �����̱� ����
		for(int i=1; i<=9; ++i) {
			if(row_check[row][i] || col_check[col][i] || square_check[square][i]) continue;
			sudoku[p] = i; // ������ �� �ֱ�
			row_check[row][i] = true;
			col_check[col][i] = true;
			square_check[square][i] = true;
			if(go(idx+1, zero_size)) return true; // ã������ ����
			row_check[row][i] = false;
			col_check[col][i] = false;
			square_check[square][i] = false;
		}
		return false; // for���� ������ ���Ҵµ� �� ã������ ���� �ƴϴ�.
	}
	
}
