package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BinarySearch_1790 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] tmp = br.readLine().split(" ");
			int n = Integer.parseInt(tmp[0]);
			int k = Integer.parseInt(tmp[1]);
			
			// 몇 번째 수까지 만들어야 할 지 확인해 본다.
			int left = 1; // 최소값
			int right = n; // 최대값
			int ans = -1;
			while(left <= right) {
				int mid = (left+right)/2;
				// 1~mid까지 합친 수의 길이 구하기
				// 1 ≤ N ≤ 100000000 (최대 9자리)
				int length = 0;
				int d = 1; // 10진수 기준으로 계산
				int cnt = 1; // 자리수
				while(mid-d >= 0) {
					// d*10-1 = 9, 99, 999, ..
					length += (Math.min(d*10-1, mid)-d+1)*cnt; 
					d *= 10;
					++cnt;
				}
				// mid를 쓰는 순간 생성되는 범위 안에 k가 속하는지 확인
				if(length-cnt+1 <= k && k <= length){
					int start = length-cnt+1;
					int end = length;
					// 모듈러 연산과 나눗셈 연산으로 차례대로 수를 구할 때는 뒷자리부터 구하는 것이 쉽다
					for(int i=end; i>=start ; --i) {
						int num = mid%10;
						mid /= 10;
						if(i == k) { 
							ans = num;
						}
					}
				}
				// 정답 찾았으면 끝
				if(ans != -1) break;
				// 정답 못 찾았으면 이분탐색 계속
				if(k < length-cnt+1) right = mid-1;
				if(k > length) left = mid+1;
			}
			
			bw.write(Integer.toString(ans));
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
