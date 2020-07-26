package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Greedy_11047 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] tmp = br.readLine().split(" ");
			int n = Integer.parseInt(tmp[0]);
			int k = Integer.parseInt(tmp[1]);
			
			int[] coins = new int[n];
			for(int i=0; i<n; ++i) 
				coins[i] = Integer.parseInt(br.readLine());
			
			int cnt = 0;
			for(int i= n-1; i>=0; --i) {
				if(k == 0) break;
				cnt += k/coins[i];
				k %= coins[i];
			}
			
			bw.write(Integer.toString(cnt));
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
