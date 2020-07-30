package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 검색 - 이분탐색이 가장 빠름
// (값이 정수 + 그냥 존재여부 탐색이므로 boolean배열을 쓰면 O(1)로 찾을 수도 있지만
//	주어진 정수의 범위가 너무 커서 메모리가 초과될 수 있다.)
public class BinarySearch_10815 {
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
				int left = 0; 
				int right = n-1;
				boolean isFound = false;
				while(left <= right) {
					int mid = (left+right)/2;
					if(card[mid] == num) {
						ans[i] = 1;
						isFound = true;
						break;
					}else if(card[mid] > num) {
						right = mid-1;
					}else {
						left = mid+1;
					}
				}
				if(isFound == false) ans[i] = 0;
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
