package DP.exam;

import java.util.Stack;

public class DP01 {
	public static void main(String[] args) {

	}
	
	// 괄호 처리가 힘들다.
	// => 괄호 처리할 필요 없는 후위 표기식 이용
	// => 하지만, 꼭 중위->후위로 바꾸는 변환과정을 거쳐야 하므로(원 중위표기식이 있어야 함)
	// 	그냥 수와 사칙연산자를 무작위로 넣고 유효성 안 맞으면 void return
	// <DP+스택(계산)>
	public static int solution(int N, int number) {
        // d[i] = N을 이용해 i를 만들 수 있는 N의 최소 개수
        // d[i] > 8이면 -1이 정답
        int[] d = new int[43046722]; // 43046721 = 9^8 
        Stack<Integer> stack = new Stack<Integer>();
        go(N, number, d, 0, 0, stack);
        
        int answer = 0;
        return answer;
    }
	
	public static void go(int N, int number, int[] d, int result, int cnt,
										Stack<Integer> stack) {
		// 이거 완전탐색 아닌가?? 모든 경우 다 해봐야 최소인지 아는데.. 매번 계산한 d끼리 비교해야함
		
		// 후위표기식 2가지 경우
		// 1. 피연산자 만남 - 스택에 넣는다.
		for(int i=1; i<=8; ++i) {
			if(i+cnt > 8) break;
			int tmp = N;
			for(int j=1; j<i; ++j)
				tmp = tmp*10 + N;
			stack.push(tmp);
			
		}
		// 2. 연산자 만남
		
	}
	
}
