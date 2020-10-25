package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 같은 알파벳이 적힌 칸을 두 번 지날 수 없다.
// 최대 몇칸 이동?
// 같은 알파벳은 한번씩만 갈 수 있으므로 O(26) (검사를 O(1)만에 한다면)
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
			// 출발하는 칸(0,0)도 포함
			check[board[0][0]-'A'] = true;
			int ans = go(1, 0, 0, board, check);
			
			bw.write(Integer.toString(ans));
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int go(int cnt, int y, int x, char[][] board, boolean[] check) {
		// 더 이상 이동하지 못할 때 종료되는 재귀함수
		// => for문 4번을 다 돌아야 막다른 길인지 판별할 수 있다.
		int max = cnt; // 현재 재귀 경로에서 리턴할 수 있는 최소값 
		for(int i=0; i<4; ++i) {
			int ny = y+dy[i];
			int nx = x+dx[i];
			if(ny<0 || ny>=R || nx<0 || nx>=C) continue;
			if(check[board[ny][nx]-'A']) continue;
			check[board[ny][nx]-'A'] = true;
			int res = go(cnt+1, ny, nx, board, check);
			if(res > max) max = res;
			check[board[ny][nx]-'A'] = false; // DFS나 BFS가 아닌 완전탐색인 이유
		}
		return max; // 막다른 길이라 4 번 다 continue로 넘어가면 cnt를 리턴한다.
	}
}
