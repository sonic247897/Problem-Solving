package Sort.exam;

import java.util.Arrays;

public class Array03 {

	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 1, 5};
		System.out.println(solution(citations));
	}
	
	public static int solution(int[] citations) {
		int answer=0;
        //�ð� �ʰ��ϸ� shuffle
		Arrays.sort(citations);
		//�ڿ������� ��ȸ
		int size = citations.length;
		int over = 0; boolean isEnd = true;
		// �� ���� ��ȸ�ϸ鼭 �ο�ȸ�� �ٲ�� �������� ��� 
		for(int i=size-1; i>=1; --i) {
			int prev = citations[i];
			if(citations[i-1] != prev) {
				over = size-i;
				// min(citations[i], over)
				int h = citations[i] <= over ?  citations[i]: over;
				answer = h > answer ? h: answer;
				// ������ ����� citations[i-1]��
				// ��� ���� ������ h���� �� ũ�� ������ �� ������ break
				if(h>= citations[i-1]) {
					isEnd = false;
					break;
				}
			}
		}
		// ������ h
		if(isEnd) {
			over = size;
			int h = citations[size-1] <=over ? citations[size-1] : over;
			answer = h > answer ? h: answer;
		}
		
		return answer;
    }

}
