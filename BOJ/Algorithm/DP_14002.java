package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// LIS
public class DP_14002 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] input = new int[1000];
		int[] dp = new int[1000]; // 최대 길이 저장
		int[] prev = new int[1000];// 역추적(나중에 스택이나 재귀로 출력)
		
		try {
			int n = Integer.parseInt(br.readLine());
			String[] tmp = br.readLine().split(" ");
			int size = tmp.length;
			for(int i=0; i< size; ++i) {
				input[i] = Integer.parseInt(tmp[i]);
				dp[i] = 1; // 자기 자신 포함하므로 최소길이=1
				prev[i] = -1; // 초기화
				// 뒤에서부터 계산하는 것이 확률적으로 최대길이일 가능성이 높으므로 if조건문 덜 실행하게 될 것
				for(int j= i-1; j >= 0; --j) { 
					if(input[j] < input[i]) { // 값이 증가해야 함
						int length = dp[j]+1;
						if(length > dp[i]) {
							dp[i] = length;
							prev[i] = j;
						}
					}
				}
			}
			// 최대 길이 구하고, 그 인덱스를 저장하여 실제 부분수열을 구한다.
			int max_len = 0; 
			int index = -1;
			for(int i=0; i<size; ++i) {
				if(dp[i] > max_len) {
					max_len = dp[i];
					index = i;
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append(max_len).append('\n');
			
			int[] stack = new int[1000];
			int top = 0;
			while(index != -1) {
				stack[top++] = input[index]; 
				index = prev[index];
			}
			while(top-- > 0) {
				sb.append(stack[top]).append(' ');
			}
			
			bw.write(sb.toString());
			bw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
