package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 1) DFS
// 	2���� �迭 �� ���� �� ������ Ž���ϸ� �� - DFS
//	 ���� �ٷ� ������ ����� ������ �����ϰ� Ž���ϴµ�, �̹� Ž���� ��ġ&���� �����̸� ����Ŭ ����
//		=> �̵��迭�� �� ¥�� ������ �� ��������. (���� �ð���� ���)
// 2) BFS
// 	distance[] �迭���� �� ������ �Ǵ�?
// 	BFS�� �ִܰŸ��� ����ϴµ� �ִܰŸ��� ã�°� �ƴϹǷ� BFS ���x 

public class Graph_16929 {
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	static boolean[][] check;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] tmp = br.readLine().split(" ");
			int n = Integer.parseInt(tmp[0]);
			int m = Integer.parseInt(tmp[1]);
			char[][] a = new char[n][m];
			check = new boolean[n][m];
			for(int i=0; i<n; ++i) {
				String str = br.readLine();
				for(int j=0; j<m; ++j)
					a[i][j] = str.charAt(j);
			}
			
			// DFS - ��� ���� ���ؼ� ���ÿ� ó�� �Ұ���.
			// why? ���, �������� ���� => �ٷ� ���� ���������� ������ �˾Ƴ� �� �����Ƿ�
			//		(�̹� �б���� ���Ŀ� ��θ� �ǵ��ư��� �˰���~�迭 �̿�~���� �˾Ƴ� �� �ִ�)
			for(int i=0; i<n; ++i) {
				for(int j=0; j<m; ++j) {
					if(!check[i][j]) {
						if(dfs(i, j, -1, n, m, a)) {
							bw.write("Yes");
							bw.flush();
							return;
						}
					}
				}
			}
			bw.write("No");
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// dir - 0,1,2,3: ������ �Դ� ����
	// 0<->2, 1<->3 (������ �Դ� ������ �ݴ�������� ���� �ȵȴ�)
	static boolean dfs(int y, int x, int dir, int n, int m, char[][] a) {
		check[y][x] = true;
		for(int i=0; i<4; ++i) {
			if(dir != -1 && i == (dir+2)%4) continue; // �ٷ� ������ �湮�� ���� pass
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(nx >=0 && nx <m && ny >=0 && ny <n) {
				if(a[y][x] == a[ny][nx]) {
					if(check[ny][nx]) return true;
					if(dfs(ny, nx, i, n, m, a)) return true;
				}
			}
		}
		return false;
	}
}
