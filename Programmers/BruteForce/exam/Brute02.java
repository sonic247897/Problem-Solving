package BruteForce.exam;

import java.util.Arrays;

public class Brute02 {
	public static void main(String[] args) {
		/*String a = "011";
		System.out.println(Integer.parseInt(a));*/
		
		String numbers = "011";
		System.out.println("��: "+solution(numbers));
		
	}
	
	// �ִ� 7p7+ 7p6 + ... +7p1 / ���� ���� ������ ���� �ȵ�
	// 7654321
	// �����佺�׳׽��� ü(���� ū ���� ���� ���� ����ð��� ���) ���� �־��� ���
	// 	=> 9999999: �ϳ��� ���̽��� �˻��ϸ� �Ǵµ� 9999999���� �� �����
	// ���� �� ���� ������ ���� ������ ��� ���(a*a=a^2)
	public static int solution(String numbers) {
        // "0000"-> 0�� �Ҽ� 0�� return
		// 0�� �� �տ� ���� ��� x
		int size = numbers.length();
		int[] a = new int[size];
		boolean allZero = true;
		
		// char�� �����ؼ� �����ϸ� ����Լ����� int result ��� char�迭�� �Ѱ���� �ϰ� 
		// ���߿� char�迭�� ������ ��ȯ�ؼ� �Ҽ��˻� �ϴ°͵� ��ƴ�.
		// @@ Integer.parseInt(numbers)�� ���� ���� 10���� �����ָ鼭 ���� ������ X
		//		=> "011"�� ��� 11�� �ٲ��.
		for(int i=0; i<size; ++i) {
			a[i] = Character.getNumericValue(numbers.charAt(i));
			if(a[i] != 0) allZero = false;
		}
		if(allZero) return 0;
		
		// 7�� for�� ���� ���
		// �ߺ�x - üũ�迭 �ʿ�, �̹� ���� �� ���x - ũ��� �ִ밪����
		Arrays.sort(a); int limit=0;
		for(int i=size-1; i>=0; --i) {
			limit = limit*10 +a[i];
		}
		boolean[] calculated = new boolean[limit+1];
		boolean[] check = new boolean[size];
		return go(a, check, 0, 0, calculated);
    }
	
	public static int go(int[] a, boolean[] check, int cnt, int result, boolean[] calculated) {
		int answer = 0;
		if(!calculated[result]) {
			calculated[result] = true;
			boolean prime = true;
			// �Ҽ� �˻�
			if(result==0 || result ==1)
				prime = false;
			for(int i=2; i*i <= result; ++i) {
				if(result % i == 0) { 
					prime = false;		
				}
			}
			if(prime) answer += 1;
			// ���̻� ������ �� ������ ����
			if(cnt == a.length) return answer;
		}
		
		for(int i=0; i<a.length; ++i) {
			if(check[i]) continue;
			check[i] = true;
			answer += go(a, check, cnt+1, result*10 +a[i], calculated);
			check[i] = false;
		}
		return answer;
	}

}




