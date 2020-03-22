package StackQueue.exam;

// ���� API ���°ͺ��� �迭 ���°� ����
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
        	// index���� ���ؼ� �����ϸ� ���������� �Ǻ��ؾ��ϱ� ������ index�� �ִ´�
        	if(arrangement.charAt(i) == '(') {
        		stack[top++] = i;
        	}else {
        		// ������ index�� ���� index�� �����ϸ� �������̹Ƿ�
        		// ���ÿ� ���� �ִ� index������ŭ ���븦 �ڸ���(������ ����)
        		if(stack[top-1] == i-1) {
        			answer += top-1;
        		} 
        		else { // �������� �ʴٸ� �踷��Ⱑ �������Ƿ� +1
        			answer += 1;
        		}
        		--top;
        	}
        }
        
        return answer;
    }
}
