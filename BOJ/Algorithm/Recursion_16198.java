package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// ���� �� �ִ� ������ ���� �ִ��� ���ϴ� ���α׷�
public class Recursion_16198 {
	static int[] num;
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			// N<=10�̹Ƿ� �׳� ����Ʈ���� ����Ž���ص� �ɵ�
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
		
		// ó�� ������ ������ ������ ������ �� ����
		int max = 0;
		for(int i=1; i<n-1; ++i) {
			if(check[i]) continue;
			check[i] = true;
			// ������ ������ num[i-1]*num[i+1]�� ���Ե��� �ʰ� �ؾ���
			// => ����, ������ �ʿ��ϹǷ� linked list�� �����غ������� �����ϰ� �ٽ� ������ ��  
			// index(����)���� ���缭 �ؾ��ϹǷ� ����, ������ O(1)�� �ƴ϶� O(n)�� �ɸ���. 
			int left=i-1, right=i+1;
			while(true) {
				// �Ѵ� �湮 �ȵǾ������� ����
				if(!check[left] && !check[right]) break;
				// �̹� �湮�� ���̸� �� ������ ã�´�.
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
