package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BruteForce_15663 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] tmp = br.readLine().split(" ");
			int n = Integer.parseInt(tmp[0]);
			int m = Integer.parseInt(tmp[1]);
			
			// 사전순으로 증가하는 순서로 출력해야 하므로 입력된 순열을 정렬한다.
			tmp = br.readLine().split(" ");
			int[] input = new int[n];
			for(int i=0; i<n; ++i)
				input[i] = Integer.parseInt(tmp[i]);
			Arrays.sort(input);
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
