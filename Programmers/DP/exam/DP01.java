package DP.exam;

import java.util.Stack;

public class DP01 {
	public static void main(String[] args) {

	}
	
	// ��ȣ ó���� �����.
	// => ��ȣ ó���� �ʿ� ���� ���� ǥ��� �̿�
	// => ������, �� ����->������ �ٲٴ� ��ȯ������ ���ľ� �ϹǷ�(�� ����ǥ����� �־�� ��)
	// 	�׳� ���� ��Ģ�����ڸ� �������� �ְ� ��ȿ�� �� ������ void return
	// <DP+����(���)>
	public static int solution(int N, int number) {
        // d[i] = N�� �̿��� i�� ���� �� �ִ� N�� �ּ� ����
        // d[i] > 8�̸� -1�� ����
        int[] d = new int[43046722]; // 43046721 = 9^8 
        Stack<Integer> stack = new Stack<Integer>();
        go(N, number, d, 0, 0, stack);
        
        int answer = 0;
        return answer;
    }
	
	public static void go(int N, int number, int[] d, int result, int cnt,
										Stack<Integer> stack) {
		// �̰� ����Ž�� �ƴѰ�?? ��� ��� �� �غ��� �ּ����� �ƴµ�.. �Ź� ����� d���� ���ؾ���
		
		// ����ǥ��� 2���� ���
		// 1. �ǿ����� ���� - ���ÿ� �ִ´�.
		for(int i=1; i<=8; ++i) {
			if(i+cnt > 8) break;
			int tmp = N;
			for(int j=1; j<i; ++j)
				tmp = tmp*10 + N;
			stack.push(tmp);
			
		}
		// 2. ������ ����
		
	}
	
}
