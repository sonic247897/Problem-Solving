package StackQueue.exam;

public class Queue03 {
	public static void main(String[] args) {
	
	}
	// �� ��� �� �� ó���� ���Ϸ��� �ϴ� ������ �켱���� ���ؼ� �� ���� ����,Ž�� ���ص� �ȴ�
	// ���1. 0 10 20 30.. �����༭ �����ڸ��� ���� ��ġ�� �����ڸ��� �켱���� ����
	// 1~9 ī��Ʈ�迭? ã���� �ϴ� �켱����(�����ڸ���)���� ū�Ŵ� �׳� �� �����ְ�
	// �������� ������ ���� ���� ��� - ���ϱ�, %���� �ʿ�
	// ���2. �ؽøʿ� (����, �켱����)�� �����ϰ� �켱����=9,8,7.. �̾Ƽ� ���ϰ� 
	// �������� ������ ���� ���� ��� - ���ĵ� ���·� �̰ų� ��ȸ ����? 
	// (������ �ٷ� ����Ҽ� �ִ°�) �����ؾ���: �ִ� O(nlgn) => ���1 ���!
	public static int solution(int[] priorities, int location) {
		int size = priorities.length;
		int limit = priorities[location];
		int[] count = new int[10]; //1~9 index�� ���
		
		System.out.println("limit: "+limit);
		for(int i=0; i<size; ++i) { // if������ limitüũ ���ִ°� �� ������
			priorities[i] += (i*10);
			count[priorities[i]]++;
		}
		// limit+1 �̻��� �켱���� ���� �͵� ���ϱ�(limit+1�� ���� ����?=>X)
		int answer = 0;
		for(int i=limit+1; i<=9; ++i) {
			answer += count[i];
		}
		// limit+1�� ���� ���� count�����δ� �� �� �ִ� ������ ����
		// ���� limit+1������ �׳� count�� �� ���ϰ� ��Ģ�� �̿��ؾ� ��
		// location�̿�? %�̿�?
		// ó���� for�� �� �� flag�� limit���� ū ���� üũ
		
		
		
        return answer;
    }

}
