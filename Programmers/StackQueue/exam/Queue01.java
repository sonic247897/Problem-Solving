package StackQueue.exam;

import java.util.LinkedList;
import java.util.Queue;

public class Queue01 {

	public static void main(String[] args) {
		int[] truck_weights = {7, 4, 5, 6};
		solution(2, 10, truck_weights);
	}
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        // �ʸ��� ����
		int sec =1;
		int cap = weight - truck_weights[0];
		int truck_num = 1;
		// ť
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1); //����1 ������
		
		while(true) {
			sec++; //�ð���� - �� ����
			for (Integer truck_moved : q) {
				truck_moved++;  // @@�̰� �� 1���ϱ� �ȵ�? ���ϴ� �ڵ��?
			}
			// Ʈ�� ����
			System.out.println(q.peek());
			if(q.peek() == bridge_length) {
				cap += q.poll();
				System.out.println("����: "+cap);
			}
			
			// Ʈ�� �����ְ� cap ���������� ����
			if((truck_num < truck_weights.length) && (cap - truck_weights[truck_num] >=0)) {
				q.offer(1);
				cap -= truck_weights[truck_num];
				truck_num++;
				System.out.println("����: "+cap);
			}
			
			// 0�� ���� �ٽ� cap�� �����·� ���ƿ��� ��� ����
			if(cap == weight) {
				break;
			}
		}
		
		int answer = sec;
        return answer;
    }

}
