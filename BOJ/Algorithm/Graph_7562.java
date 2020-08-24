package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*class Pair{
	int y,x;
	Pair(int y, int x){
		this.y = y;
		this.x = x;
	}
}*/

// 최소 이동 거리 - BFS
// 300^2 = 90000. 모든 칸 한 번씩 탐색해본다.
public class Graph_7562 {
	static int[] dy = {-1,-2,-2,-1, 1,2,2,1};
	static int[] dx = {-2,-1,1,2, 2,1,-1,-2};
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc;
		try {
			tc = Integer.parseInt(br.readLine());
			while(tc-- > 0) {
				int len = Integer.parseInt(br.readLine());
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
