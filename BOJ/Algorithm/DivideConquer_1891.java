package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// ���� �迭 ������� �ʳ�?
//	-> �̵��ؾ� �ϴ� ��ġ�� ���Ŀ� ����ϴ� ���ұ����̸� ��ǥ�� �ٽ� �����ؼ� if�� �״�� ���� ������
//	=> �̹� �������� ��ǥ�� �������������� �ٽ� ���ư��� ��������� �ʱ� ����
//	=> �ٵ� d=50�� �� �迭�� ũ�Ⱑ 4^50�̶� �޸� �ʰ��̴�.

// �������� -> lg4(4^50) = 50�� Ž�� [���Ž��]
// 50���� Ž���ϹǷ� �� �� ã���� �ȴ�. (�迭 ���� ���� ���ڳ� ���ڿ��� ����)
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
			int d = Integer.parseInt(tmp[0]); // �ڸ���
			String piece = tmp[1];
			
			tmp = br.readLine().split(" ");
			// y��ǥ�� �Ʒ��� ������ �� ����� �ǵ��� ��ȯ
			long x = Long.parseLong(tmp[0]);
			long y = Long.parseLong(tmp[1])*-1;
			
			// 1. piece�� ����Ű�� ��ǥ �޾ƿ���
			long length = 1 << d;
			Pair piece_pair = go(0, 0, 0, piece, length);
			// 2. ��ǥ�� �ٽ� ��ġ ã��
			//  - ���� �˻��ϰ� solve, ���� ������ -1
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
			// ��и� ��ǥ ��
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
