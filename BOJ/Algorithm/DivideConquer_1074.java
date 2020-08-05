package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// (r, c)�� ���� ���ϸ� �� -> �̺�Ž���� �����Ƿ� ������ ���� �ʴ°��� �˻�X
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
			// �迭�� ������ ����� N=15�� �� �޸��ʰ� ��
			//	=> �ٸ� �迭���� �ʿ�����Ƿ� �̷� ���� �迭�� Ư���� ���� �ʿ� ����.
			//int[][] A = new int[length][length]; 
			//go(A, 0, 0, r, c, length, 0);
			int ans = go(0, 0, r, c, length, 0);
			
			bw.write(Integer.toString(ans));
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
	//		-> X. �׷��� �ڿ��� �˻� �� ������, �տ� ���� ���� �͵��� �� �����
	
	//	@ ������ ������(=���ĵ�) �����̹Ƿ� �̺�Ž��ó�� �ʿ��� ������ ã�ƺ� �� �ִ�. [���Ž��]
	static int go(int y, int x, int r, int c, int length, int cnt) {
		if(length == 2) { // ���� ���� ������ Z�� ������ �湮
			for(int i=y; i<y+2; ++i) {
				for(int j=x; j<x+2; ++j) {
					if(i == r && j == c) return cnt; // ã���� �� ����
					++cnt;
				}
			}
			return -1; // �� ã���� -1 ����
		}
		int mid = length/2;
		int add_cnt = mid*mid;
		int ans = -1;
		
		if(y <= r && r < y+mid && x <= c &&  c < x+mid)
			ans = go(y, x, r, c, mid, cnt);
		
		if(y <= r && r < y+mid && x+mid <= c)
			ans = go(y, x+mid, r, c, mid, cnt+add_cnt);
		
		if(y+mid <= r && x <= c &&  c < x+mid)
			ans = go(y+mid, x, r, c, mid, cnt+add_cnt*2);
		
		if(y+mid <= r && x+mid <= c)
			ans = go(y+mid, x+mid, r, c, mid, cnt+add_cnt*3);
		
		return ans;
	}
}
