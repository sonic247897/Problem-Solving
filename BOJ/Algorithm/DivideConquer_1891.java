package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 실제 배열 써야하지 않나?
//	-> 이동해야 하는 위치가 이후에 계산하는 분할구간이면 좌표를 다시 셋팅해서 if문 그대로 쓰면 되지만
//	=> 이미 지나버린 좌표는 분할정복에서는 다시 돌아가서 계산하지는 않기 때문
//	=> 근데 d=50일 때 배열의 크기가 4^50이라 메모리 초과이다.

// 분할정복 -> lg4(4^50) = 50번 탐색 [사분탐색]
// 50번씩 탐색하므로 두 번 찾으면 된다. (배열 쓰지 말고 숫자나 문자열로 구현)
class Pair{
	long y, x;
	Pair(long y, long x){
		this.y = y;
		this.x = x;
	}
}

public class DivideConquer_1891 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] tmp = br.readLine().split(" ");
			int d = Integer.parseInt(tmp[0]); // 자리수
			String piece = tmp[1];
			
			tmp = br.readLine().split(" ");
			// y좌표가 아래로 내려갈 때 양수가 되도록 변환
			long x = Long.parseLong(tmp[0]);
			long y = Long.parseLong(tmp[1])*-1;
			
			// 1. piece가 가리키는 좌표 받아오기
			long length = 1 << d;
			Pair piece_pair = go(0, 0, 0, piece, length);
			// 2. 좌표로 다시 위치 찾기
			//  - 범위 검사하고 solve, 범위 넘으면 -1
			long nextY = piece_pair.y + y;
			long nextX = piece_pair.x + x;
			if(nextY>=0 && nextY <length && nextX >=0 && nextX < length) {
				StringBuilder sb = new StringBuilder();
				solve(0, 0, nextY, nextX, sb, length);
				bw.write(sb.toString());
			}else {
				bw.write(Integer.toString(-1));
			}
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	} 
	
	private static void solve(long y, long x, long ny, long nx, StringBuilder sb, long length) {
		if(length == 1) return;
		long mid = length/2;
		if(x+mid <= nx && ny < y+mid) {
			sb.append('1');
			solve(y, x+mid, ny, nx, sb, mid);
		}
		if(nx < x+mid && ny < y+mid) {
			sb.append('2');
			solve(y, x, ny, nx, sb, mid);
		}
		if(nx < x+mid && ny >= y+mid) {
			sb.append('3');
			solve(y+mid, x, ny, nx, sb, mid);
		}
		if(x+mid <= nx && ny >= y+mid) {
			sb.append('4');
			solve(y+mid, x+mid, ny, nx, sb, mid);
		}
	}

	static Pair go(int idx, long y, long x, String piece, long length) {
		if(length == 1) {
			// 사분면 좌표 비교
			return new Pair(y, x);
		}
		long mid = length/2;
		char num = piece.charAt(idx);
		Pair pair = new Pair(-1, -1);
		
		if(num == '1')
			pair = go(idx+1, y, x+mid, piece, mid);
		if(num == '2')
			pair = go(idx+1, y, x, piece, mid);
		if(num == '3')
			pair = go(idx+1, y+mid, x, piece, mid);
		if(num == '4')
			pair = go(idx+1, y+mid, x+mid, piece, mid);
		
		return pair;
	}
	
}
