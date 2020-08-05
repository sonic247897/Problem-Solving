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
			Pair piece_pair = go(0, 0, 0, d, piece, length);
			// 2. ��ǥ�� �ٽ� ��ġ ã��
			//  - ���� �˻��ϰ� go, ���� ������ -1
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	} 
	
	static Pair go(int idx, long y, long x, int d, String piece, long length) {
		if(length == 2) {
			// ��и� ��ǥ ��
			char num = piece.charAt(idx);
			switch(num) {
				case '1':
					return new Pair(y, x+1);
				case '2':
					return new Pair(y, x);
				case '3':
					return new Pair(y+1, x);
				case '4':
					
			}
		}
		long mid = length/2;
		char num = piece.charAt(idx);
		Pair pair;
		
		if(num == '1')
			pair = go(idx+1, y, x+mid  d, piece, mid);
		
		if(num == '2')
			pair = go(idx+1)
			
		return pair;
	}
	
}
