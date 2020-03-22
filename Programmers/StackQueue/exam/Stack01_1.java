package StackQueue.exam;

public class Stack01_1 {
	public static void main(String[] args) {
		int[] heights = {6,9,5,7,4};
		int[] result = solution(heights);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
	
	// O(N) - �׷��� �ӵ� �����.. tc�� ������?
	// ���� �̿� - ��ū�� �����ε� �����ʿ��� ū���� �ƴ϶� ������ (�ݴ� ���� ��ȸ)
	public static int[] solution(int[] heights) {
        int size = heights.length;
        int[] answer = new int[size];
        // index�� ������? ���Ҹ� ������? 
        // => ���信 index+1��°�� answer�� �־�� �ϹǷ� index�� �ִ´�
        // ** ��ȣ�� �޴´ٰ� ������ ž�� �������(pop) �����ִ� ������ ž���� ���� ��ȣ�� ���� �� �ִ� ��츦
        // ����ĥ �� �ִ�. ���� ������ push�� �����ʿ������� �Ѵ�. ������ ž�� ���̻� ��ȣ�� �� ���Ƿ� pop���൵ �ȴ�.
        
        int[] stack = new int[size]; 
        stack[0] = size-1; // ������ ž�� index
        int top=1; 
        for(int i=size-2; i>=0 ;--i) {
        	// ��ȣ�� �޾��� ž�� ������ ����ž �����ϰ�  answer�� ǥ��
        	if(heights[stack[top-1]] < heights[i]) {
        		answer[stack[--top]] = i+1; // i+1��° ž
        		// ���ǿ� ������ ��� pop
        		// ���� ������ - �տ��� �����̸� �ٷ� pass
        		while(top-1 >= 0 && heights[stack[top-1]] < heights[i]) {
        			answer[stack[--top]] = i+1;
        		}
        	}
        	// ���� ž ���ÿ� �ֱ�
        	stack[top++] = i;
        }
        answer[0] = 0; // ������ ž
        
        return answer;
    }

}
