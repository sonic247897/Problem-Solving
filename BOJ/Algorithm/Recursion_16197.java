package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// �� ���� �� �ϳ��� ���忡�� ����߸��� ���� ��ư�� �ּ� �� �� �������ϴ���
// ��ư�� 10������ ���� ������ �Ѵٸ�, -1�� ����Ѵ�. => 4^10. �� ���� ������ ����Ž�� ����
// �ּ� �Ÿ��ε� BFS�� �ƴ� ����?
//	=> ������ 2���ε� �ٸ� ������ �̹� �湮�� ĭ(check[y][x]=true)�� �� �湮�ؾ� �ϱ� ����
// check�迭�� �ʿ� ����. �ٸ� ������ �������� ���� �̹� ������ ��η� ���ư��� �ϴ� ��쵵 �־
public class Recursion_16197 {
	static int[] dy = {0,0,-1,1};
	static int[] dx = {1,-1,0,0};
	static int N, M;
	static char[][] map;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] tmp = br.readLine().split(" ");
			N = Integer.parseInt(tmp[0]);
			M = Integer.parseInt(tmp[1]);
			
			map = new char[N][M];
			// ���� ó����ġ
			int y1=-1, x1=-1, y2=-1, x2=-1;
			for(int i=0; i<N; ++i) {
				String str = br.readLine();
				for(int j=0; j<M; ++j) {
					// �ٸ� ������ �ִ� ��쿡�� �̵��� �� �����Ƿ� ������ ��ġ�� �̵��� �߿����� �ʴ�.
					map[i][j] = str.charAt(j);
					if(map[i][j] == 'o') {
						//map[i][j] = '.';
						if(y1 == -1) {
							y1 = i; x1 = j;
						}else { // ù��° ���� �ʱ�ȭ������ �ι�° ���� ����
							y2 = i; x2 = j;
						}
					}
				}
			}
			int ans = go(y1, x1, y2, x2, 1);
			if(ans == 987654321) ans = -1;
			bw.write(Integer.toString(ans));
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// ��ư ���� Ƚ�� ����
	public static int go(int y1, int x1, int y2, int x2, int cnt) {
		if(cnt > 10) return 987654321;

		int min = 987654321;
		for(int i=0; i<4; ++i) {
			int ny1 = y1+dy[i]; int nx1 = x1+dx[i];
			int ny2 = y2+dy[i]; int nx2 = x2+dx[i];
			// �� �� ���ÿ� ����߸��� �ȵ�
			boolean fall1 = false, fall2 = false;
			if((ny1 >= N || ny1 < 0)||(nx1 >= M || nx1 < 0)) fall1 = true;
			if((ny2 >= N || ny2 < 0)||(nx2 >= M || nx2 < 0)) fall2 = true;
			if(fall1 ^ fall2) // �� �� �Ѱ��� ����߸��� ���� (xor ����)
				return cnt;
			// �� �� ���ÿ� ����߷����� ��� ���̻� �����ϸ� �ȵ�
			if(fall1 && fall2) continue;
			
			// ���� ��� ���� - ��
			if(map[ny1][nx1] == '#') {
				ny1 = y1; nx1 = x1;
			}
			if(map[ny2][nx2] == '#') {
				ny2 = y2; nx2 = x2;
			}
			int res = go(ny1, nx1, ny2, nx2, cnt+1);
			if(min > res) min = res;
		}
		return min;
	}
	
}
