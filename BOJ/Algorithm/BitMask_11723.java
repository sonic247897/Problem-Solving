package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// @ �ٲ��� ���� �غ���. 2��� ���� �����ϴ� �� ���� ������ �ٲ�°� �ֳ�?
//	-> �� ������ bitmask���� �迭�� index�� ���� �ʱ� ������ ��� ������, 
//	   ���࿡ �迭�� �ε����� ���� �ȴٸ� �迭�� ũ�Ⱑ 2�� �����ϰ� �ȴ�.

// {1,2,..,20} => {0,1,..,19}�� ���� (��ó�� ���ϸ� �ִ� ������ ũ�Ⱑ 2�谡 ��)
// 2^0+2^1+...+2^19 = 2^20-1 
//	-> int�� ������ ��Ÿ�� �� �����Ƿ� bitmask �̿�
public class BitMask_11723 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int S = 0; // ������
		
		try {
			int m = Integer.parseInt(br.readLine());
			String[] tmp;
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<m; ++i) {
				tmp = br.readLine().split(" ");
				String cmd = tmp[0];
				switch(cmd) {
					case "add":
						S |= (1 << Integer.parseInt(tmp[1]));
						break;
					case "remove":
						S &= ~(1 << Integer.parseInt(tmp[1]));
						break;
					case "check": // ���� S�� ���� ���ϸ� �ȵȴ�.
						int check = S & (1 << Integer.parseInt(tmp[1]));
						if(check > 0) sb.append('1').append('\n');
						else sb.append('0').append('\n');
						break;
					case "toggle":
						S ^= (1 << Integer.parseInt(tmp[1]));
						break;
					case "all":
						S = (1<<21)-1; // 2^0+2^1+..+2^20 = 2^21-1
						break;
					default: // empty
						S = 0;
				}
			}
			bw.write(sb.toString());
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
