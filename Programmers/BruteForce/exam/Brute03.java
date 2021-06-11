package BruteForce.exam;

public class Brute03 {
	public static void main(String[] args) {
		
	}
	// 숫자야구 조건 3개 ㅡ 서로 영향줘서 어려움
	// 순열x,비트마스크x: 범위 123~987
	// 조건 복잡하지만 매번 3분기 ㅡ 재귀
	// (숫자길이3)^(명령개수3) *질문 100개 = 900
	public static int solution(int[][] baseball) {
		// 각 수가 명령어의 조건에 맞는지 확인
        // boolean[] correct = new boolean[988]; // 0~ 987
        int[] correct = new int[988]; // 0~ 987
        
        // 깊이=3 재귀
        int size_baseball = baseball.length;
        for(int i=0; i<size_baseball; ++i) {
        	// baseball배열을 통째로 넘겨주면 안에서 재귀함수 또 만들어야 함
        	int num = baseball[i][0];
        	int strike = baseball[i][1];
        	int ball = baseball[i][2];
        	if(strike == 0 && ball == 0) { // 아웃일 때는 재귀 할 필요 X
        		 correct[num] = 1;
        		 // @주의!! boolean배열로 true, false를 하면 
        		 // 이미 방문한 노드는 다시 방문해서 덮어쓰면 안되므로 최소 3가지 상태 필요
        		 // 	: 0(방문X), 1(방문했는데 false), 2(방문했는데 true)
        		 //	=> 안됨. 다음 조건에 따라 true->false로 덮어쓰여야 할 수도 있음/ false는 계속 false임
        		 // 문제가 어려운 이유: 계속 다음 명령어에 의해 true와 false를 덮어쓰기 때문
        		 
        	}
        	go(num, strike, ball, correct, 0);
        }
        
        int answer = 0;
        int size_correct = correct.length;
        for(int i=0; i<size_correct; ++i) {
        	if(correct[i] == 2)
        		++answer;
        }
        
        return answer;
    }
	
	public static void go(int num, int strike, int ball, int[] correct, int idx) {
		// base case - 1. 스트라이크, 볼 다 썼거나  2. 세자리 모두 검사했을 때
		if((strike==0 && ball==0) || idx == 3) {
			// correct배열 true처리
			// if(correct[i] == 0) 방문하지 않았다면
			return;
		}
		// 스트라이크
		if(strike >= 0) {
			// 쫌 복잡하노.. StringBuilder.append로 하자..
			// -> 안됨. 매 조건마다 correct배열 정의해야함..?
			//	=> base case인 마지막에 하면 안되나??
			int tmp = num;
			for(int i=0; i<2-idx; ++i) {
				tmp /= 10; 
			}
			tmp *= 10
			
			for(int i=0; i<988; ++i) {
				correct[idx]
			}
			go(num, strike-1, ball, correct, 1);
		}
		// 볼
		if(ball >= 0) {
			go(num,)
		}
		
		
	}
}
