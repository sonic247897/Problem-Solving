package hash.exam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

// ��ü������ �ؽð� �� ������ ����-Ž���� ���� case�� ����
public class Hash03 {
	public static void main(String[] args) {

	}
	
	public static void shuffle(String[][] a) {
		 Random random = new Random();
		 for (int i=a.length-1; i>0; i--) {
		 int index = random.nextInt(i+1);
		 String[] temp = a[index];
		 a[index] = a[i];
		 a[i] = temp;
		 }
	}
	
	public int solution(String[][] clothes) {
	    // ����->��Ž(����) - Nx2�迭
		// shuffle �ص� �ð��ʰ� ��
		shuffle(clothes);
		
        Arrays.sort(clothes, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				if(o1[1].compareTo(o2[1]) <0)
					return 1;
				else if(o1[1].compareTo(o2[1]) >0)
					return -1;
				else
					return 0;
			}
        });
        
        int[] category = new int[40]; int idx = 0;
        category[0] = 1; 
        for(int i=1; i<clothes.length; ++i) {
        	if(!clothes[i][1].equals(clothes[i-1][1])) 
        		category[++idx] =1;
        	else 
        		category[idx]++;
        }
        
        // ���� - �ּ� 1������ ����
        int answer = 0;
        for(int i=1; i<=idx+1; ++i) {
        	answer += go(category, 0, 0, idx, i);
        }
        
        return answer;
    }
	static int[] a = new int[40];
	public static int go(int[] category, int index, int selected, int n, int m) {
		if(selected == m) {
			// ���� �ϳ� �̱� ����
			int result = 1;
			for(int i=0; i< m; ++i) {
				result *= category[a[i]];
			}
			return result;
		}
		if (index > n) return 0; // ���� �̱� ����
		int ans = 0;
		a[selected] = index;
		ans += go(category, index+1, selected+1, n, m);
		a[selected] = 0;
		ans += go(category, index+1, selected, n, m);
		return ans;
	}
}