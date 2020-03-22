package StackQueue.exam;

public class Stack01_1 {
	public static void main(String[] args) {
		int[] heights = {6,9,5,7,4};
		int[] result = solution(heights);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
	
	// O(N) - 그런데 속도 비슷함.. tc가 작은가?
	// 스택 이용 - 오큰수 문제인데 오른쪽에서 큰수가 아니라 작은수 (반대 방향 순회)
	public static int[] solution(int[] heights) {
        int size = heights.length;
        int[] answer = new int[size];
        // index를 넣을까? 원소를 넣을까? 
        // => 정답에 index+1번째를 answer에 넣어야 하므로 index를 넣는다
        // ** 신호를 받는다고 왼쪽의 탑이 사라지면(pop) 남아있는 오른쪽 탑에서 보낸 신호를 받을 수 있는 경우를
        // 지나칠 수 있다. 따라서 스택의 push를 오른쪽에서부터 한다. 오른쪽 탑은 더이상 신호가 안 오므로 pop해줘도 된다.
        
        int[] stack = new int[size]; 
        stack[0] = size-1; // 마지막 탑의 index
        int top=1; 
        for(int i=size-2; i>=0 ;--i) {
        	// 신호를 받아줄 탑이 있으면 보낸탑 삭제하고  answer에 표시
        	if(heights[stack[top-1]] < heights[i]) {
        		answer[stack[--top]] = i+1; // i+1번째 탑
        		// 조건에 맞으면 계속 pop
        		// 숏컷 연산자 - 앞에가 거짓이면 바로 pass
        		while(top-1 >= 0 && heights[stack[top-1]] < heights[i]) {
        			answer[stack[--top]] = i+1;
        		}
        	}
        	// 현재 탑 스택에 넣기
        	stack[top++] = i;
        }
        answer[0] = 0; // 마지막 탑
        
        return answer;
    }

}
