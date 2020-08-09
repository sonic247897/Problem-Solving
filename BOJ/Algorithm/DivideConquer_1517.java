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
			// 머지 소트
			// - 가장 큰 답: 전부 역순일 때 499999+499998+...+1 = (500000*499999)/2 = 124999750000
			//	=> int가 아니라 long으로 출력
			long ans = solve(0, n-1);
			bw.write(Long.toString(ans));
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	// inversion 개수 리턴
	static long solve(int start, int end) {
		if(start == end)
			return 0;
		int mid = (start+end)/2;
		// 분할
		long ans = solve(start, mid) + solve(mid+1, end);
		// 병합(실제 정렬)
		int i = start;
		int j = mid+1;
		int k = 0;
	    // 한 쪽이 먼저 끝날 때까지 while문 -> 양 쪽 모두 끝날 때까지 while문 (inversion 개수를 계산하기 위해 오른쪽 배열 끝까지 돌아야 함)
		while(i <= mid || j <= end) {
	        // j>end 조건은 오른쪽 배열이 다 끝났을 때 a[i] <= a[j] 조건이 필요 없어지므로 건너 뛰기 위해서 사용
			if(i <= mid && (j > end || a[i] <= a[j])) {
				b[k++] = a[i++];
			}else {
				ans += (long) (mid-i+1); //왼쪽에 남은 원소들 개수 더해줌
				b[k++] = a[j++];
			}
		}
		for(int l=start; l<=end; ++l) {
			a[l] = b[l-start];
	    }
		return ans;	
	}

}
