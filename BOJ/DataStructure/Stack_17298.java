package DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Stack_17298 {
	// Ai보다 큰 수 중에서 가장 왼쪽에 있는 수 = 인접한 수
	//	-> 스택
	// 스택은 index를 유지할 수는 없음 => 원소 대신 index를 넣어준다!
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			// index로 접근하기 위한 input배열 필요
			int n = Integer.parseInt(br.readLine());
			String[] tmp = br.readLine().split(" ");
			int[] input = new int[n];
			for(int i=0; i<n; ++i) {
				input[i] = Integer.parseInt(tmp[i]);
			}
			
			int stack[] = new int[n];
			int top=0;
			int answer[] = new int[n];
			for(int i=0; i<n-1; ++i) {
				stack[top++] = i; // 현재 원소 index 넣어주기
				int next = input[i+1];
				while(top-1 >= 0 && input[stack[top-1]] < next) {
					--top; // pop
					answer[stack[top]] = next;
				}
			}
			answer[n-1] = -1; // 마지막 원소
			// 스택에 남은 원소들 -1
			while(top-- > 0) {
				answer[stack[top]] = -1;
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<n-1; ++i) 
				// bw.write(answer[i]);은 ascii char형 int이기 때문에 깨져서 나온다. 
				sb.append(answer[i]).append(' ');
			sb.append(answer[n-1]);
			bw.write(sb.toString()); // bw.append(sb);보다 약간 빠름
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
