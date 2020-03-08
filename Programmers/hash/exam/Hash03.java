package hash.exam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

// 대체적으로 해시가 더 빠른데 정렬-탐색이 빠른 case도 있음
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
	    // 정렬->완탐(조합) - Nx2배열
		// shuffle 해도 시간초과 남
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
        
        // 조합 - 최소 1개부터 시작
        int answer = 0;
        for(int i=1; i<=idx+1; ++i) {
        	answer += go(category, 0, 0, idx, i);
        }
        
        return answer;
    }
	static int[] a = new int[40];
	public static int go(int[] category, int index, int selected, int n, int m) {
		if(selected == m) {
			// 조합 하나 뽑기 성공
			int result = 1;
			for(int i=0; i< m; ++i) {
				result *= category[a[i]];
			}
			return result;
		}
		if (index > n) return 0; // 조합 뽑기 실패
		int ans = 0;
		a[selected] = index;
		ans += go(category, index+1, selected+1, n, m);
		a[selected] = 0;
		ans += go(category, index+1, selected, n, m);
		return ans;
	}
}