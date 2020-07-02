package StackQueue.exam;

import java.util.LinkedList;
import java.util.Queue;

public class Queue01 {

	public static void main(String[] args) {
		//int[] truck_weights = {7, 4, 5, 6};
		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
		solution(100, 100, truck_weights);
	}
	
	// 1�ʸ��� �ùķ��̼�(��ȭ�� �Ͼ�� ����)

	// 1. �ٸ� ���̸�ŭ�� ť ���(0���� �ʱ�ȭ): 1�ʸ��� �� ĭ�� �̵� �ؾ� �ϹǷ� LinkedList ���!
	//	�� �ð����� total���� ������ �� ���ϰ� ������ �� ���� ����.
	//		=> �ִ� 10^4*10^4 = 10^8
	// 2. ������ ť(LinkedList ���� ���� -> �� Ʈ������ �ð��ʵ� �������� �ϹǷ� map�ʿ�)
	//	 => �����ϰ� ���������� �ʴ�.
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Integer> queue = new LinkedList<Integer>();
		// �ʱ�ȭ - bridge_length��ŭ 0 �־���
		int qsize = bridge_length;
		while(qsize-- > 0) {
			queue.add(0);
		}
		int truckNum = truck_weights.length;
		// 1�ʺ��� ���� => ���� case��(ex.Ʈ���� 1��) �ɸ� Ȯ���� ���� ���!
		/*int bridgeWeight = truck_weights[0];
		queue.add(truck_weights[0]); 
		queue.poll();
		int truck_idx = 1;
		int second = 1;*/
		
		// 0�ʺ��� ����(���ÿ� ����)
		int bridgeWeight = 0;
		int truck_idx = 0;
		int second = 0;
		// @@ ���� ����! ���ÿ� ���ϸ� Ʈ���� ���������� ����(�ݴ� ���� Ʋ��)
		// ���ÿ� 2�� �̻��� ó���� �ϴ� ����(������ ������)�� ���ó� ������ �����ؼ� �����Ѵ�.
		while(true) {
			bridgeWeight -= queue.poll();
			++second;
			if(truck_weights[truck_idx] <= weight-bridgeWeight) {
				bridgeWeight += truck_weights[truck_idx];
				queue.add(truck_weights[truck_idx]); // ť(�ٸ�)�� Ʈ�� �ֱ�
				++truck_idx;
				if(truck_idx == truckNum) { 
					// Ʈ�� �� ���������� ���� ������ �ʸ� ����
					second += bridge_length;
					break;
				}
			}else {
				queue.add(0);
			}
		}
		return second;
    }

}
