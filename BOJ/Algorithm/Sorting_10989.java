package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 시간복잡도 O(N+10000) N <= 10^7
// 이 수는 10,000보다 작거나 같은 자연수이다. 
//	=> 이 조건 때문에 cnt[] 배열을 쓸 수 있다.
public class Sorting_10989 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int[] cnt = new int[10001]; // 1~10000
			int n =Integer.parseInt(br.readLine());
			for(int i=0; i<n; ++i)
				++cnt[Integer.parseInt(br.readLine())];
			
			for(int i=0; i<10001; ++i) {
				for(int j=0; j<cnt[i]; ++j) {
					bw.write(Integer.toString(i));
					bw.write('\n');
				}
			}
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
