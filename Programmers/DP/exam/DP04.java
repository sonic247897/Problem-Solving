package DP.exam;

// x, y��ǥ �ٲ���� ���� Ǯ �� ��������..
public class DP04 {
	public static void main(String[] args) {
		//int[][] puddles = {{2, 2}};
		//System.out.println(solution(4, 3, puddles));
		//int[][] puddles = {{1,3},{2,2},{3,3},{4,2}};
		//System.out.println(solution(4, 3, puddles));
		int[][] puddles = {};
		System.out.println(solution(2, 1, puddles));
	}

	// �ִܰ�� = ����, �Ʒ������� �������� �͸� �ִܰ��(������, ���� �̵��� ������)
	public static int solution(int m, int n, int[][] puddles) {
		int mod = 1000000007;
		int[][] d = new int[n][m];
		// �������� �̸� ǥ���ؾ� �ϴµ�, �������� ĭ�� �ִܰ�� ��=0�̹Ƿ� d[][]�� -1�� �ʱ�ȭ �ؾ���
		for(int i=0; i<n; ++i) {
			for(int j=0; j<m; ++j) {
				d[i][j] = -1;
			}
		}
		// �������̴� �ִܰ�� �� =0
		for(int i=0; i < puddles.length; ++i)
			d[puddles[i][1]-1][puddles[i][0]-1] = 0;
		// �׵θ��� �ִܰ�� �� =1 (@ ���� ������ �� ���ķ� 0�� �ȴ�!)
		int path = 1;
		for(int i=1; i<m; ++i) {
			if(d[0][i] == 0) path=0;
			d[0][i] = path;
			
		}
		path = 1;
		for(int i=1; i<n; ++i) {
			if(d[i][0] == 0) path=0;
			d[i][0] = path;
		}
		
		for(int i = 1; i<n; ++i) {
			for(int j = 1; j<m; ++j) {
				// ������ ���� ��� ��� 
				if(d[i][j] == -1)
					d[i][j] = (d[i-1][j] + d[i][j-1]) % mod;
			}
		}
		
		return d[n-1][m-1];
    }
}
