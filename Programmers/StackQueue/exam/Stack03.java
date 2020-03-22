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
	// ž�̶� ���� ����
	public static int[] solution(int[] prices) {
        int size = prices.length;
		int[] answer = new int[size];
		// index ����
        int[] stack = new int[size]; 
        stack[0] = 0; int top=1;
		for(int i=1; i<size; ++i) {
			// ���� �������� index���� ����ؼ� answer�� ����
        	if(prices[i] < prices[stack[top-1]]) {
        		--top;
        		answer[stack[top]] = 1; // ó���� ������ 1����
        		// ���� ���ݰ� ��� ��(empty Ȯ��)
        		while(top-1>=0 && prices[i] < prices[stack[top-1]]) {
        			--top;
            		answer[stack[top]] = i-stack[top];
        		}
        	}
        	stack[top++] = i;
        }
		// �������� ���� �ֵ� pop�ϸ鼭 size-index�� answer�� �ֱ�
		while(top > 0) {
			--top;
			answer[stack[top]] = (size-1) -stack[top];
		}
        return answer;
    }

}
