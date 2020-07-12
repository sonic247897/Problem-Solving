package DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// answer에 답을 저장할 때 각 원소의 index 접근 필요 
// - 스택은 index연산으로 접근할 수 없으므로 원소 대신 index 저장
public class Stack_17299 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] cnt = new int[1000001];
		
		try {
			int n = Integer.parseInt(br.readLine());
			String[] tmp = br.readLine().split(" ");
			int[] input = new int[n];
			for(int i=0; i<n; ++i) {
				input[i] = Integer.parseInt(tmp[i]);
				++cnt[input[i]];
			}
			int[] stack = new int[n];
			int top = 0;
			int[] answer = new int[n];
			for(int i=0; i<n-1; ++i) {
				// 현재 수 push
				stack[top++] = i; // index 저장
				int next = input[i+1];
				while(top-1 >= 0 && cnt[input[stack[top-1]]] < cnt[next]) {
					--top; // pop
					answer[stack[top]] = next;
				}
			}
			answer[n-1] = -1;
			// 스택에 남은 원소 위치에는 -1 저장
			while(top-- > 0) {
				answer[stack[top]] = -1;
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<n-1; ++i) {
				sb.append(answer[i]).append(' ');
			}
			sb.append(answer[n-1]);
			bw.write(sb.toString());
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
