package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// N-Queen ������ ũ�Ⱑ N �� N�� ü���� ���� �� N���� ���� ������ �� ���� ���� ����
// O(2^(15*15)) => ��Ʈ��ŷ ���� ���Ʈ�����ϸ� �ð��ʰ�
// ��, ��, �밢���� check�� ǥ���صθ� ���� �� �ִ��� �˻縦 O(1)���� �� �� �ִ�.
//	=> ��ü�ð����⵵�� O(N^2)�� �ȴ�.
public class Recursion_9663 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			// 2���� �迭�� 1���� �迭�� check�ϱ�
			//	=> �ѹ��� ������ ĭ�� ä��� + ��Ģ�� �ִٸ�, 1���� �迭�� �� ���� ä�� �� �ִ�.
			boolean[] col_check = new boolean[n];
			int size = 2*n; // ����: 0~2*(n-1) =>ũ��: 2*n-1
			boolean[] diag1_check = new boolean[size];
			boolean[] diag2_check = new boolean[size];
			int ans = go(0, n, col_check, diag1_check, diag2_check); // 0����� ����
			bw.write(Integer.toString(ans));
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int go(int row, int n, boolean[] col_check, boolean[] diag1_check, boolean[] diag2_check) {
		if(row == n) return 1; // ��� ���� �˻������Ƿ� ����� �� 1 �߰�
		
		// �̹� row���� ���� col�� ��ġ
		int ans = 0;
		for(int i=0; i<n; ++i) {
			if(col_check[i] || diag1_check[row+i] || diag2_check[row-i+(n-1)]) continue; 
			col_check[i] = true;
			diag1_check[row+i] = true;
			diag2_check[row-i+(n-1)] = true;
			ans += go(row+1, n, col_check, diag1_check, diag2_check);
			col_check[i] = false;
			diag1_check[row+i] = false;
			diag2_check[row-i+(n-1)] = false;
		}
		return ans;
	}
}
