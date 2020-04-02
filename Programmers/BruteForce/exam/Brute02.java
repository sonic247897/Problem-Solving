package BruteForce.exam;

import java.util.Arrays;

public class Brute02 {
	public static void main(String[] args) {
		/*String a = "011";
		System.out.println(Integer.parseInt(a));*/
		
		String numbers = "011";
		System.out.println("답: "+solution(numbers));
		
	}
	
	// 최대 7p7+ 7p6 + ... +7p1 / 같은 수가 나오면 세면 안됨
	// 7654321
	// 에라토스테네스의 체(가장 큰 수에 대해 거의 상수시간에 비례) 쓰면 최악의 경우
	// 	=> 9999999: 하나의 케이스만 검사하면 되는데 9999999까지 다 계산함
	// 각자 수 만들어서 제곱근 수로 나누기 방법 사용(a*a=a^2)
	public static int solution(String numbers) {
        // "0000"-> 0은 소수 0개 return
		// 0이 맨 앞에 오는 경우 x
		int size = numbers.length();
		int[] a = new int[size];
		boolean allZero = true;
		
		// char로 저장해서 연결하면 재귀함수에서 int result 대신 char배열을 넘겨줘야 하고 
		// 나중에 char배열을 정수로 변환해서 소수검사 하는것도 어렵다.
		// @@ Integer.parseInt(numbers)를 먼저 쓰고 10으로 나눠주면서 정수 넣으면 X
		//		=> "011"일 경우 11로 바뀐다.
		for(int i=0; i<size; ++i) {
			a[i] = Character.getNumericValue(numbers.charAt(i));
			if(a[i] != 0) allZero = false;
		}
		if(allZero) return 0;
		
		// 7중 for문 말고 재귀
		// 중복x - 체크배열 필요, 이미 계산된 수 계산x - 크기는 최대값까지
		Arrays.sort(a); int limit=0;
		for(int i=size-1; i>=0; --i) {
			limit = limit*10 +a[i];
		}
		boolean[] calculated = new boolean[limit+1];
		boolean[] check = new boolean[size];
		return go(a, check, 0, 0, calculated);
    }
	
	public static int go(int[] a, boolean[] check, int cnt, int result, boolean[] calculated) {
		int answer = 0;
		if(!calculated[result]) {
			calculated[result] = true;
			boolean prime = true;
			// 소수 검사
			if(result==0 || result ==1)
				prime = false;
			for(int i=2; i*i <= result; ++i) {
				if(result % i == 0) { 
					prime = false;		
				}
			}
			if(prime) answer += 1;
			// 더이상 선택할 수 없으면 리턴
			if(cnt == a.length) return answer;
		}
		
		for(int i=0; i<a.length; ++i) {
			if(check[i]) continue;
			check[i] = true;
			answer += go(a, check, cnt+1, result*10 +a[i], calculated);
			check[i] = false;
		}
		return answer;
	}

}




