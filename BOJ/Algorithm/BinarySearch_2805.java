package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 절단기 높이 결정 -> 나무 길이 계산
public class BinarySearch_2805 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] tmp = br.readLine().split(" ");
			int N = Integer.parseInt(tmp[0]);
			int M = Integer.parseInt(tmp[1]);
			
			tmp = br.readLine().split(" ");
			int[] tree = new int[N];
			int max = 0;
			for(int i=0; i<N; ++i) {
				tree[i] = Integer.parseInt(tmp[i]);
				if(max < tree[i]) max = tree[i];
			}
			
			// 적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값 찾기
			int left = 0;
			int right = max;
			int ans = 0;
			while(left <= right) {
				int mid = (left+right)/2;
				// mid높이의 절단기가 자른 나무들의 길이 구하기
				long cut = 0; // @ 합을 구할 때 int가 넘어갈 수 있다.
				for(int i=0; i<N; ++i) {
					int diff = tree[i] - mid;
					if(diff > 0) cut += diff;
				}
				// M미터 이상 - 절단기 최대높이: 상한
				if(cut >= M) {
					ans = mid;
					left = mid+1;
				}else {
					right = mid-1;
				}
			}
			bw.write(Integer.toString(ans));
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
