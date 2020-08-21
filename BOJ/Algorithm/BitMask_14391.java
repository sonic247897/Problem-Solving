package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 각각의 칸에 대해서 가로인지 세로인지 정하면 된다.
// 2차원 배열 -> 1차원 배열 (비트마스크 수)
// 최대 원소 개수 = 16개 이므로 bitmask수로 나타낼 수 있다.
public class BitMask_14391 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] tmp = br.readLine().split(" ");
			int n = Integer.parseInt(tmp[0]);
			int m = Integer.parseInt(tmp[1]);
			// 2차원 배열 -> 1차원 배열 (비트마스크 수)
			int[] a = new int[n*m];
			for(int i=0; i<n; ++i) {
				String str = br.readLine();
				for(int j=0; j<m; ++j) {
					a[i*m+j] = str.charAt(j)-'0';
				}
			}
			
			int ans = 0;
			// 비트마스크 수 (0: 가로, 1: 세로)
			int total = (1<< (n*m));
			for(int i=0; i< total; ++i) {
				// 가로면 한 행으로 검사, 세로면 한 열로 검사
				// 	=> 중복으로 수 세는거 막으려면? check배열 필요 
				// 	-> check배열은 보통 검사하는 배열과 차원이 같으므로 똑같이 비트마스크 수로 바꾸자
				int sum = 0;
				int check = 0; // 0: 아직 검사 안 함, 1: 이미 검사함 
				for(int k=0; k< n*m; ++k) {
					if((check & (1<<k)) != 0) continue;
					if((i & (1<<k)) == 0) { // 가로 조각 - 같은 행까지만 검사해야 함
						int _tmp = a[k];
						int cur_row = k/m; // 현재 행
						check |= (1<<k);
						int next = k+1;
						while((i & (1<<next)) == 0 && next/m == cur_row) {
							_tmp = _tmp*10 + a[next];
							check |= (1<<next);
							++next;
						}
						sum += _tmp;
					// 다음k가 오는데 그냥 if문을 쓰지 않는 이유는 k<n*m조건을 for문에서 다시 체크해주려고 이다.
					}else { // 세로 조각 - 같은 열까지만 검사
						int _tmp = a[k];
						check |= (1<<k);
						int next = k + m; // 현재 열
						while((i & (1<<next)) != 0 && next < n*m) {
							_tmp = _tmp*10 + a[next];
							check |= (1<<next);
							next += m;
						}
						sum += _tmp;
					}
				}
				if(ans < sum) ans = sum;
			}
			
			bw.write(Integer.toString(ans));
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
