package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DivideConquer_1517 {
	static int[] a = new int[500000];
	static int[] b = new int[500000];
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			String[] tmp = br.readLine().split(" ");
			for(int i=0; i<n; ++i)
				a[i] = Integer.parseInt(tmp[i]);
			// ���� ��Ʈ
			// - ���� ū ��: ���� ������ �� 499999+499998+...+1 = (500000*499999)/2 = 124999750000
			//	=> int�� �ƴ϶� long���� ���
			long ans = solve(0, n-1);
			bw.write(Long.toString(ans));
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// inversion ���� ����
	static long solve(int start, int end) {
		if(start == end)
			return 0;
		int mid = (start+end)/2;
		// ����
		long ans = solve(start, mid) + solve(mid+1, end);
		// ����(���� ����)
		int i = start;
		int j = mid+1;
		int k = 0;
	    // �� ���� ���� ���� ������ while�� -> �� �� ��� ���� ������ while�� (inversion ������ ����ϱ� ���� ������ �迭 ������ ���ƾ� ��)
		while(i <= mid || j <= end) {
	        // j>end ������ ������ �迭�� �� ������ �� a[i] <= a[j] ������ �ʿ� �������Ƿ� �ǳ� �ٱ� ���ؼ� ���
			if(i <= mid && (j > end || a[i] <= a[j])) {
				b[k++] = a[i++];
			}else {
				ans += (long) (mid-i+1); //���ʿ� ���� ���ҵ� ���� ������
				b[k++] = a[j++];
			}
		}
		for(int l=start; l<=end; ++l) {
			a[l] = b[l-start];
	    }
		return ans;	
	}

}
