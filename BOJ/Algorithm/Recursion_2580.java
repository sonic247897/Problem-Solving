package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 스도쿠 판을 채우는 방법이 여럿인 경우는 그 중 하나만을 출력한다.
public class Recursion_2580 {
	static int[] sudoku = new int[9*9];
	static int[] zero = new int[9*9]; 
	// (위치, 숫자): 해당 위치에 해당 숫자가 있으면 true. 검사 시간 =O(1) 
	// N-Queen에서는 해당 위치에 퀸이 있냐 없냐만 체크하면 됐으므로 true/false만 저장하는 1차원 boolean[] 배열로 가능했다.
	// 스도쿠에서는 있냐/없냐 가 아니라 1~9 전부 체크해야 하므로 2차원 boolean[][]배열 사용
	
	// 행에 없는 번호 저장
	//int[] row_check = new int[9]; -> 불가능. 같은 행에 없는 번호가 2개 이상 있을 수 있다. 
	static boolean[][] row_check = new boolean[9][10]; // 9개 행
	static boolean[][] col_check = new boolean[9][10]; // 9개 열
	static boolean[][] square_check = new boolean[9][10]; // 9개 정사각형
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 2차원 배열을 1차원 배열로 만들면 유리한 경우
		// 	1) 점(y,x)를 많이 저장해야 해서 따로 Pair[] 배열을 만들거나 int[] 배열을 2개 만들어야 할 때
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
		
		// 칸에 수를 넣고 이 수가 이미 있는지 검사(행, 열, 정사각형 검사)
		int p = zero[idx]; // row*9+col
		int row = p/9; 
		int col = p%9;
		int square = (row/3)*3 + col/3; // row + col/3 과 같지 않다. row/3은 내림이기 때문
		for(int i=1; i<=9; ++i) {
			if(row_check[row][i] || col_check[col][i] || square_check[square][i]) continue;
			sudoku[p] = i; // 스도쿠에 수 넣기
			row_check[row][i] = true;
			col_check[col][i] = true;
			square_check[square][i] = true;
			if(go(idx+1, zero_size)) return true; // 찾았으면 종료
			row_check[row][i] = false;
			col_check[col][i] = false;
			square_check[square][i] = false;
		}
		return false; // for문을 끝까지 돌았는데 못 찾았으면 답이 아니다.
	}
	
}
