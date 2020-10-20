package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 1 1 1 ... 1 1 5 이런 케이스도 있기 때문에 모든 집합을 다 검사해봐야 한다
// boolean[] check 배열에서 이분탐색 가능?
// 	=> x. false가 한 개가 아니라 여러 개 있음. 그냥 선형검색으로 찾기
public class Recursion_14225 {
	// 합으로 나온 수를 int형 linked list에 저장하면 정렬도 해야되고 중복된 수도 처리해야 하므로 복잡하다.
	// 무조건 1부터 끝까지 모든 자연수 확인해봐야 하는데
	// 배열은 '자연수 = index'이므로 중복도 해결되고 확인이 더 쉬움.
	static boolean[] check = new boolean[2000001]; // 최대 합 = 20*100,000
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			String[] tmp = br.readLine().split(" ");
			int[] num = new int[n];
			for(int i=0; i<n; ++i)
				num[i] = Integer.parseInt(tmp[i]);
			
			go(0, 0, n, num);
			
			for(int i=1; ; ++i) {
				if(!check[i]) {
					bw.write(Integer.toString(i));
					break;
				}
			}
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void go(int idx, int sum, int n, int[] num) {
		if(idx == n) {
			check[sum] = true;
			return;
		}
		// 현재 idx가 가리키는 수를 포함하는 경우
		go(idx+1, sum+num[idx], n, num);
		// 포함하지 않는 경우
		go(idx+1, sum, n, num);
	}
}
