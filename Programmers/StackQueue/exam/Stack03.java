package StackQueue.exam;

public class Stack03 {
	public static void main(String[] args) {
		//int[] prices = {1,1,1,4,3,2,2}; // 6,5,4,1,1,1,0
		int[] prices = {2,1,2,3}; // 1,2,1,0
		int[] result = solution(prices);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]+" ");
		}
	}
	// 탑이랑 같은 유형
	public static int[] solution(int[] prices) {
        int size = prices.length;
		int[] answer = new int[size];
		// index 저장
        int[] stack = new int[size]; 
        stack[0] = 0; int top=1;
		for(int i=1; i<size; ++i) {
			// 가격 떨어지면 index차이 계산해서 answer에 저장
        	if(prices[i] < prices[stack[top-1]]) {
        		--top;
        		answer[stack[top]] = 1; // 처음에 만나는 1차이
        		// 이전 가격과 계속 비교(empty 확인)
        		while(top-1>=0 && prices[i] < prices[stack[top-1]]) {
        			--top;
            		answer[stack[top]] = i-stack[top];
        		}
        	}
        	stack[top++] = i;
        }
		// 마지막에 남은 애들 pop하면서 size-index를 answer에 넣기
		while(top > 0) {
			--top;
			answer[stack[top]] = (size-1) -stack[top];
		}
        return answer;
    }

}
