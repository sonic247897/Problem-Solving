package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// �ð����⵵: 2^20
public class BruteForce_15661 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			int[][] s = new int[n][n];
			String[] tmp;
			for(int i=0; i<n; ++i) {
				tmp = br.readLine().split(" ");
				for(int j=0; j<n; ++j)
					s[i][j] = Integer.parseInt(tmp[j]);
			}
			
			boolean[] t1 = new boolean[n];
			boolean[] t2 = new boolean[n];
			int ans = go(0, t1, t2, n, s);
			
			bw.write(Integer.toString(ans));
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static int go(int idx, boolean[] t1, boolean[] t2, int n, int[][] s) {
		if(idx == n) {
			// �� ���� �ּ� �� ���� �־�� �ϹǷ�, �� ���� 0�� �ִ� ���� �����Ѵ�.
			// Sij >= 1 �̹Ƿ� score�� 0�� ��� ����
			int team1 = 0, team2 = 0;
			boolean isEmpty1 = true, isEmpty2 = true;
			for(int i=0; i<n; ++i) {
				if(t1[i] == true) {
					isEmpty1 = false;
					for(int j=0; j<n; ++j) {
						if(t1[j] == true)
							//team1 += (s[i][j]+s[j][i]); => �̷��� �ϸ� i, j�� �ڹٲ� �� �� �� �� �������� �ߺ����� ���ȴ�.
							team1 += s[i][j];
					}
				}else {
					isEmpty2 = false;
					for(int j=0; j<n; ++j) {
						if(t2[j] == true)
							team2 += s[i][j];
					}
				}
			}
			// @ �̷� ����ó�� �ȵ� -> �� ���� ���� ��쿡�� �ڱ� �ڽŰ��� �ó���=0 �̱� ������ ������ 0�� ��
			//if(team1 == 0 || team2 == 0) return 987654321;
			if(isEmpty1 == true || isEmpty2 == true) return 987654321;
			int diff = team1 - team2;
			if(diff < 0) diff = -diff;
			return diff;
		}
		t1[idx] = true;
		int team1 = go(idx+1, t1, t2, n, s);
		t1[idx] = false;
		
		t2[idx] = true;
		int team2 = go(idx+1, t1, t2, n, s);
		t2[idx] = false;
		
		return team1 <= team2 ? team1: team2;
	}
}
