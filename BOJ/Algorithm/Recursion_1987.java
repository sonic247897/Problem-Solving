package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// ���� ���ĺ��� ���� ĭ�� �� �� ���� �� ����.
// �ִ� ��ĭ �̵�?
// ���� ���ĺ��� �ѹ����� �� �� �����Ƿ� O(26) (�˻縦 O(1)���� �Ѵٸ�)
public class Recursion_1987 {
	static int[] dy = {0,0,1,-1};
	static int[] dx = {1,-1,0,0};
	static int R;
	static int C;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] tmp = br.readLine().split(" ");
			R = Integer.parseInt(tmp[0]);
			C = Integer.parseInt(tmp[1]);
			
			char[][] board = new char[R][C];
			for(int i=0; i<R; ++i) {
				String str = br.readLine();
				for(int j=0; j<C; ++j) {
					board[i][j] = str.charAt(j);
				}
			}
			boolean[] check = new boolean[26];
			// ����ϴ� ĭ(0,0)�� ����
			check[board[0][0]-'A'] = true;
			int ans = go(1, 0, 0, board, check);
			
			bw.write(Integer.toString(ans));
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int go(int cnt, int y, int x, char[][] board, boolean[] check) {
		// �� �̻� �̵����� ���� �� ����Ǵ� ����Լ�
		// => for�� 4���� �� ���ƾ� ���ٸ� ������ �Ǻ��� �� �ִ�.
		int max = cnt; // ���� ��� ��ο��� ������ �� �ִ� �ּҰ� 
		for(int i=0; i<4; ++i) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			if(ny<0 || ny>=R || nx<0 || nx>=C) continue;
			if(check[board[ny][nx]-'A']) continue;
			check[board[ny][nx]-'A'] = true;
			int res = go(cnt+1, ny, nx, board, check);
			if(res > max) max = res;
			check[board[ny][nx]-'A'] = false; // DFS�� BFS�� �ƴ� ����Ž���� ����
		}
		return max; // ���ٸ� ���̶� 4 �� �� continue�� �Ѿ�� cnt�� �����Ѵ�.
	}
}
