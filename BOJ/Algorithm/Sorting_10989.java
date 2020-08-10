package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// �ð����⵵ O(N+10000) N <= 10^7
// �� ���� 10,000���� �۰ų� ���� �ڿ����̴�. 
//	=> �� ���� ������ cnt[] �迭�� �� �� �ִ�.
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
