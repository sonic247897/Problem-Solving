package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 모을 수 있는 에너지 양의 최댓값을 구하는 프로그램
public class Recursion_16198 {
	static int[] num;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			// N<=10이므로 그냥 리스트에서 순차탐색해도 될듯
			String[] tmp = br.readLine().split(" ");
			num = new int[n];
			for(int i=0; i<n; ++i)
				num[i] = Integer.parseInt(tmp[i]);
			
			boolean[] check = new boolean[n];
			int ans = go(0, 0, n, check);
			bw.write(Integer.toString(ans));
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int go(int cnt, int energy, int n, boolean[] check) {
		if(cnt == n-2) return energy;
		
		// 처음 구슬과 마지막 구슬은 선택할 수 없음
		int max = 0;
		for(int i=1; i<n-1; ++i) {
			if(check[i]) continue;
			check[i] = true;
			// 없어진 구슬은 num[i-1]*num[i+1]에 포함되지 않게 해야함
			// => 삽입, 삭제가 필요하므로 linked list가 적합해보이지만 삭제하고 다시 삽입할 때  
			// index(순서)까지 맞춰서 해야하므로 삽입, 삭제가 O(1)이 아니라 O(n)이 걸린다. 
			int left=i-1, right=i+1;
			while(true) {
				// 둘다 방문 안되어있으면 가능
				if(!check[left] && !check[right]) break;
				// 이미 방문한 점이면 그 다음을 찾는다.
				if(check[left]) --left;
				if(check[right]) ++right;
			}
			int res = go(cnt+1, energy+num[left]*num[right], n, check);
			if(res > max) max = res;
			check[i] = false;
		}
		return max;
	}
}
