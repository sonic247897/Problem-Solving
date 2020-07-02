package StackQueue.exam;

import java.util.LinkedList;
import java.util.Queue;

/*
 * �ʿ��� ����: ���� ������ ������ ��ġ(�̵��� ������ ����), 
 * 			���� ����Ʈ���� �켱���� ���� ����Ʈ �ִ��� ���� 
 */

public class Queue03 {
	public static void main(String[] args) {
		int[] priorities = {1, 1, 9, 1, 1, 1};
		int location = 0;
		solution(priorities, location);
	}
	// ť�� �̿��� �ùķ��̼�(�׳� �غ���)
	// �ִ� 100+99+98+...+2+1 = 5050
	// location ������ ���� �̵��ؾ� �ϹǷ� ť 2�� ��� 
	// �Ź� �̵��ϹǷ� LinkedList�� ������ ť ��� (ArrayList����)
	public static int solution(int[] priorities, int location) {
		Queue<Integer> priorities_Queue = new LinkedList<Integer>();
		Queue<Boolean> location_Queue = new LinkedList<Boolean>();
		// ���� ���Һ��� ū �켱���� ����Ʈ �� �� ���Ҵ��� ���� �ʿ�
		int[] leftPriority = new int[10]; // 1~9 ���
		int currentMaxNum = 0;
		
		int size = priorities.length;
		for(int i=0; i<size; ++i) {
			// �ڹٴ� �ڵ����� wrapperŸ������ �������ش�
			priorities_Queue.add(priorities[i]);
			if(i == location) 
				location_Queue.add(true);
			else
				location_Queue.add(false);
			
			++leftPriority[priorities[i]];
		}
		for(int i=9; i>=0; --i) {
			if(leftPriority[i] != 0) {
				currentMaxNum = i;
				break;
			}
		}
		// �ùķ��̼� ����
		int order = 0;
		while(true) {
			// ����: poll -> add
			int print = priorities_Queue.poll();
			boolean isFound = location_Queue.poll();
			// ���� �ְ� �켱���� ����Ʈ�̸�
			if(print == currentMaxNum) {
				++order; // �ϳ� �����
				if(isFound == true)  // ���� ã�� ����Ʈ�̸� ���� ����
					return order;
				// �ְ� �켱���� ���� �� ������ �� ���� �켱���� ã��
				if(--leftPriority[print] == 0) {
					for(int i=currentMaxNum-1; i>=0; --i) {
						if(leftPriority[i] != 0) {
							currentMaxNum = i;
							break;
						}
					}
				}
			// �ְ� �켱������ �ƴ϶�� �ٽ� ť �ڿ� �߰�
			}else {
				priorities_Queue.add(print);
				location_Queue.add(isFound);
			}
		}
    }

}
