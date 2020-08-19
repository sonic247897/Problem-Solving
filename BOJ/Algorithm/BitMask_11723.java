package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// @ 바꾸지 말고 해보자. 2배로 수가 증가하는 거 말고 연산이 바뀌는게 있나?
//	-> 이 문제는 bitmask수를 배열의 index로 쓰지 않기 때문에 상관 없지만, 
//	   만약에 배열의 인덱스로 쓰게 된다면 배열의 크기가 2배 증가하게 된다.

// {1,2,..,20} => {0,1,..,19}로 변경 (전처리 안하면 최대 정수의 크기가 2배가 됨)
// 2^0+2^1+...+2^19 = 2^20-1 
//	-> int형 정수로 나타낼 수 있으므로 bitmask 이용
public class BitMask_11723 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int S = 0; // 공집합
		
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
					case "check": // 집합 S의 값은 변하면 안된다.
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
