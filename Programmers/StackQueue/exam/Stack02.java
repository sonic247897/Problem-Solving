package StackQueue.exam;

// 스택 API 쓰는것보다 배열 쓰는게 빠름
public class Stack02 {
	public static void main(String[] args) {
		String arrangement = "()(((()())(())()))(())";
		System.out.println(solution(arrangement));
	}
	
	public static int solution(String arrangement) {
        int answer = 0;
        int size = arrangement.length();
        int[] stack = new int[size]; int top=0;
        for(int i=0; i<size; ++i) {
        	// index끼리 비교해서 인접하면 레이저임을 판별해야하기 때문에 index를 넣는다
        	if(arrangement.charAt(i) == '(') {
        		stack[top++] = i;
        	}else {
        		// 스택의 index가 현재 index와 인접하면 레이저이므로
        		// 스택에 남아 있는 index개수만큼 막대를 자른다(스택의 길이)
        		if(stack[top-1] == i-1) {
        			answer += top-1;
        		} 
        		else { // 인접하지 않다면 쇠막대기가 끝났으므로 +1
        			answer += 1;
        		}
        		--top;
        	}
        }
        
        return answer;
    }
}
