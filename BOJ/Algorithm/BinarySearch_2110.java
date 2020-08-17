package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 가장 인접한 두 공유기 사이의 거리 계산
public class BinarySearch_2110 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] tmp = br.readLine().split(" ");
			int N = Integer.parseInt(tmp[0]);
			int C = Integer.parseInt(tmp[1]);
			int[] home = new int[N];
			for(int i=0; i<N; ++i) 
				home[i] = Integer.parseInt(br.readLine());
		
			// 좌표가 순서대로 주어지지 않으므로 정렬 필요
			Arrays.sort(home);
			
			// 공유기 개수 만큼 전부 사용해야 한다.
			// 가장 인접한 두 공유기 사이의 거리 -> 최대로: 모든 공유기 설치 가능한 상황 중 상한
			int left = 1; // (조건)집 여러개가 같은 좌표를 가지는 일은 없다.
			int right = home[N-1]-home[0];
			while(left <= right) {
				int mid = (left+right)/2;
				int router = C; // 남은 공유기 개수
				// @ 브루트 포스? 그리디? => 그리디로 풀던데.. 왜 가능한지는 모르겠음
				// @ 투 포인터(브루트 포스)로 바꿀 수 있는 부분?
				for(int i=0; i<N; ++i) {
					int l = 
					int dist = home[i]-home[]
				}
				if(router < 0) 
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
