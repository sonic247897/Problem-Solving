package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// cnt[] 배열을 이용하면 좋겠지만 나올 수 있는 수의 범위가 너무 커서 불가능
// 정렬 후 순회하면서 세어주자
public class Sorting_11652 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			long[] a = new long[n];
			for(int i=0; i<n; ++i)
				a[i] = Long.parseLong(br.readLine());
			
			Arrays.sort(a);
			
			long max_num = a[0];
			int cnt = 1;
			int max_cnt = 1;
			for(int i=1; i<n; ++i) {
				if(a[i] != a[i-1]) {
					if(max_cnt < cnt) {
						max_cnt = cnt;
						max_num = a[i-1];
					}
					cnt=0;
				}
				++cnt;
			}
			// 마지막 수 체크
			if(max_cnt < cnt) max_num = a[n-1];
			
			bw.write(Long.toString(max_num));
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
