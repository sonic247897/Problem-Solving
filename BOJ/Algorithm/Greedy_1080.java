package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 'N과 M은 50보다 작거나 같은 자연수' 조건에서 N, M < 3인 경우 예외처리
// 문제에는 안 써있지만 3*3보다 작은 크기 행렬은 뒤집기 연산을 할 수 없다.
public class Greedy_1080 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] tmp = br.readLine().split(" ");
			int N = Integer.parseInt(tmp[0]);
			int M = Integer.parseInt(tmp[1]);
			int[][] A = new int[N][M];
			int[][] B = new int[N][M];
			for(int i=0; i<N; ++i) {
				String str = br.readLine();
				for(int j=0; j<M; ++j) {
					A[i][j] = str.charAt(j)-'0';
				}
			}
			for(int i=0; i<N; ++i) {
				String str = br.readLine();
				for(int j=0; j<M; ++j) {
					B[i][j] = str.charAt(j)-'0';
				}
			}
			
			// 예외처리 - 뒤집기 연산을 쓸 수 없는 경우에는 A와 B가 같은지만 검사
			if(N<3 || M<3) {
				for(int i=0; i<N; ++i) {
					for(int j=0; j<M; ++j) {
						if(A[i][j] != B[i][j]) {
							bw.write(Integer.toString(-1));
							bw.flush();
							return;
						}
					}
				}
				bw.write(Integer.toString(0));
				bw.flush();
				return;
			}
			
			// 그리디 알고리즘 - 왼쪽 맨 위만 A=B 되게 맞추기
			int cnt = 0;
			for(int i=0; i<N-2; ++i) {
				for(int j=0; j<M-2; ++j) {
					if(A[i][j] == B[i][j]) continue;
					flip(A, i, j);
					++cnt;
				}
			}
			// 남은 범위에 대해 일치하는지 검사
			for(int i=N-2; i<N; ++i) {
				for(int j=0; j<M; ++j) {
					if(A[i][j] != B[i][j]) {
						bw.write(Integer.toString(-1));
						bw.flush();
						return;
					}
				}
			}
			for(int i=0; i<N-2; ++i) {
				for(int j=M-2; j<M; ++j) {
					if(A[i][j] != B[i][j]) {
						bw.write(Integer.toString(-1));
						bw.flush();
						return;
					}
				}
			}
			// 전부 일치하면 횟수 리턴
			bw.write(Integer.toString(cnt));
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// flip 함수
	// 비트마스크? - 3*3이니까 비트마스크 3번 해야하는데 9번 바꾸는 연산이랑 별 차이 안남
	// 행렬 모델링 - 문자열? 숫자? 
	//		=> index 접근 여러번 + 수정 여러번 해야하므로 char[][] vs int[][]
	// 토글 연산은 숫자로 하는게 더 빠를듯.. (그리고 일반적으로 숫자로 모델링 함)
	public static void flip(int[][] A, int i, int j) {
		for(int k=i; k<i+3; ++k) {
			for(int l=j; l<j+3; ++l) {
				A[k][l] = 1 - A[k][l];
			}
		}
	}
	
}
