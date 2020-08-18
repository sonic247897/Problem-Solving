package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BruteForce_1248 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			char[][] sum = new char[n][n]; // i�� �׻� j���� �۰ų� ����. => �밢�� �������� ���κ� �ﰢ���� ä���.
			int[] a = new int[n];
			
			for(int i=0; i<n; ++i) {
				for(int j=i; j<n; ++j) 
					sum[i][j] = (char) br.read();
			}

			go(0, n, a, sum);
			
			for(int i=0; i<n; ++i) {
				bw.write(Integer.toString(a[i]));
				bw.write(' ');
			}
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static boolean check(int idx, int[] a, char[][] sum) {
		// sum[i][idx]: i���� = 0 ~ idx-1
		for(int i=0; i<idx; ++i) {
			int tmp = 0;
			// sum[i][j] = a[i]~a[j]������ ��
			for(int j=i; j<=idx; ++j) {
				tmp += a[j];
			}
			// �� ���̶� ��� �� �� ������ false
			if(tmp > 0) {
				if(sum[i][idx] != '+')
					return false;
			}else if(tmp < 0){
				if(sum[i][idx] != '-')
					return false;
			}else {
				if(sum[i][idx] != '0')
					return false;
			}
		}
		return true;
	}
	
	// �迭 a[] ä���� ���� - a�� idx��° �� ���ϰ� ������� ȣ��
	static boolean go(int idx, int n, int[] a, char[][] sum) {
		// ��� �� ���ϸ� �˻��ϰ� ���� - �տ��� ���� �˻��ϹǷ� �׳� ����
		if(idx == n) return true;		
		// ���� ��� ȣ�� - idx�� �˻�(��Ʈ��ŷ)
		boolean valid = false; // @ ��� �Լ��� ���ϰ��� �� ���� ������ ������ �����ؾ� �Ѵ�.
		// '0'�̶�� 0�� �ִ� ������ �ۿ� �����Ƿ� ���� ó��
		if(sum[idx][idx] == '0') {
			a[idx] = 0;
			if(check(idx, a, sum)) // @@ ��Ʈ��ŷ
				return go(idx+1, n, a, sum); // ����� false�� �տ������� �߸� ���� ���̹Ƿ� true ���� ������ ����
		}
		
		int sign = 1;
		if(sum[idx][idx] == '-') sign = -1;
		
		for(int i=1; i<=10; ++i) {
			a[idx] = sign*i;
			if(check(idx, a, sum)) // @@ ��Ʈ��ŷ
				valid = go(idx+1, n, a, sum);
			if(valid == true) return true;
		}
		// valid == true�� ���� ��� ���ϵǹǷ� ��Ͱ� ������ �ùٸ� a�� ���´�.
		return false;
	}
}
