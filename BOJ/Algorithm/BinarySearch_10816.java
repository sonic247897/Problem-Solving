package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 배열 안에서 같은 원소의 개수 = 상한index - 하한index
//	=> 상한, 하한 찾기: 이분탐색
// 시간복잡도: O(M*lgN)
public class BinarySearch_10816 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			int[] card = new int[n];
			String[] tmp = br.readLine().split(" ");
			for(int i=0; i<n; ++i)
				card[i] = Integer.parseInt(tmp[i]);
			// 이분 탐색을 위해 정렬 먼저
			Arrays.sort(card);
			
			int m = Integer.parseInt(br.readLine());
			int[] ans = new int[m];
			tmp = br.readLine().split(" ");
			for(int i=0; i<m; ++i) {
				int num = Integer.parseInt(tmp[i]);
				// 이분 탐색 - @ left와 right는 매번 초기화 해줘야 한다!
				// upper bound
				int left = 0; 
				int right = n-1;
				int upperBound = -1;
				while(left <= right) {
					int mid = (left+right)/2;
					if(card[mid] == num) {
						upperBound = mid+1;
						left = mid+1;
					}else if(card[mid] > num) {
						right = mid-1;
					}else {
						left = mid+1;
					}
				}
				// lower bound
				left = 0; 
				right = n-1;
				int lowerBound = -1;
				while(left <= right) {
					int mid = (left+right)/2;
					if(card[mid] == num) {
						lowerBound = mid;
						right = mid-1;
					}else if(card[mid] > num) {
						right = mid-1;
					}else {
						left = mid+1;
					}
				}
				ans[i] = upperBound - lowerBound;
			}
			
			for(int i=0; i<m; ++i) {
				bw.write(Integer.toString(ans[i]));
				bw.write(' ');
			}
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
