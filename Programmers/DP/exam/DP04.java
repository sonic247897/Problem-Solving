package DP.exam;

// x, y좌표 바꿨더니 문제 풀 때 복잡해짐..
public class DP04 {
	public static void main(String[] args) {
		//int[][] puddles = {{2, 2}};
		//System.out.println(solution(4, 3, puddles));
		//int[][] puddles = {{1,3},{2,2},{3,3},{4,2}};
		//System.out.println(solution(4, 3, puddles));
		int[][] puddles = {};
		System.out.println(solution(2, 1, puddles));
	}

	// 최단경로 = 왼쪽, 아래쪽으로 내려가는 것만 최단경로(오른쪽, 위쪽 이동은 후진임)
	public static int solution(int m, int n, int[][] puddles) {
		int mod = 1000000007;
		int[][] d = new int[n][m];
		// 물웅덩이 미리 표시해야 하는데, 물웅덩이 칸의 최단경로 수=0이므로 d[][]를 -1로 초기화 해야함
		for(int i=0; i<n; ++i) {
			for(int j=0; j<m; ++j) {
				d[i][j] = -1;
			}
		}
		// 물웅덩이는 최단경로 수 =0
		for(int i=0; i < puddles.length; ++i)
			d[puddles[i][1]-1][puddles[i][0]-1] = 0;
		// 테두리는 최단경로 수 =1 (@ 연못 만나면 그 이후로 0이 된다!)
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
				// 계산되지 않은 경우 계산 
				if(d[i][j] == -1)
					d[i][j] = (d[i-1][j] + d[i][j-1]) % mod;
			}
		}
		
		return d[n-1][m-1];
    }
}
