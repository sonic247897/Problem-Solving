package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// @ 백준 예제출력의 공백이랑 ' '랑 똑같이 스페이스바(아스키 32번)인데 왜 틀리지..

// 문제 - 재귀적인 패턴으로 별을 찍어 보자
// 출력 어떻게? => 실제 배열 사용해서 배열에 저장한다. (좌표 이용)
public class DivideConquer_2447 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			char[][] A = new char[n][n];
			
			go(A, 0, 0, n);
			
			for(int i=0; i<n; ++i) {
				for(int j=0; j<n; ++j)
					bw.write(A[i][j]);
				bw.write('\n');
			}
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static void go(char[][] A, int y, int x, int n) {
		if(n == 3) {
			// n->3, m->1 이므로 아래 재귀호출 식들과 같은 형태이다.
			for(int i=x; i<x+3; ++i)
				A[y][i] = '*';
			A[y+1][x] = '*'; A[y+1][x+1]=' '; A[y+1][x+2] = '*';
			for(int i=x; i<x+3; ++i)
				A[y+2][i] = '*';
			return;
		}
		int m = n/3; // 3등분 씩 분할정복
		for(int i=x; i<x+n; i += m) 
			go(A, y, i, m);
		
		go(A, y+m, x, m);
		for(int i=x+m; i<x+2*m; ++i)
			A[y+m][i] = ' '; // 가운데 빈 칸 채우기
		go(A, y+m, x+2*m, m);
		
		for(int i=x; i<x+n; i += m) 
			go(A, y+2*m, i, m);
	}
	
}
