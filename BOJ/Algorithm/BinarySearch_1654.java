package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 이분 탐색 문제인가? => 어느 기준으로 YES/NO가 정해진다
// N개보다 많이 만드는 것도 N개를 만드는 것에 포함된다. 이때 만들 수 있는 최대 랜선의 길이를 구하라
// 	=> (기준 - N개 케이블이 만들어지는가?)
public class BinarySearch_1654 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] tmp = br.readLine().split(" ");
			int k = Integer.parseInt(tmp[0]);
			int n = Integer.parseInt(tmp[1]);
			int[] cable = new int[k];
			for(int i=0; i<k; ++i)
				cable[i] = Integer.parseInt(br.readLine());
			// 먼저 계산해야 하는 값을 이분탐색으로 찾는다.
			// 계산 순서: 자를 랜선의 길이 정하기 -> 랜선 개수 계산 
			// N개 이상~ => 최대길이 : 상한 찾기
			
			// @ left와 right는 long으로 바꿔줘야 한다. 이분탐색 logic상 맨 끝 범위에서 +1 되어서 종료되는 경우도 있기 때문
			// 	예) 모든 막대 길이가 2^31-1이고 정답도 2^31-1이면 맨 끝에서 left와 right이 겹치게 되고, left = mid+1;이
			//		실행되어 int범위를 초과하게 된다.
			long left = 0; 
			long right = (1<<31)-1;
			long ans = 0;
			while(left <= right) {
				long mid = (left+right)/2;
				// mid 길이로 잘라서 나온 랜선 개수 계산
				int cnt = 0;
				for(int i=0; i<k; ++i)
					cnt += cable[i]/mid;
				
				if(cnt >= n) { // 조건 만족하는 더 큰 길이가 있는지 찾기
					ans = mid;
					left = mid+1;
				}else {
					right = mid-1;
				}
			}
			
			bw.write(Long.toString(ans));
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
