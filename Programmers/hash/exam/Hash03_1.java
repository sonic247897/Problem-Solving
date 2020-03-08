package hash.exam;

import java.util.HashMap;
import java.util.Set;


public class Hash03_1 {
	public static void main(String[] args) {
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		System.out.println(solution(clothes));
	}
	
	public static int solution(String[][] clothes) {
		// ������, ������ ���� ��
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0; i<clothes.length; ++i) {
			String key = clothes[i][1];
			if(map.get(key) == null) {
				map.put(key, 1);
			}
			else {
				map.put(key, map.get(key)+1);
			}
		}
		
		int[] category = new int[30]; int idx =0;
		Set<String> keylist = map.keySet();
		for (String key : keylist) {
			category[idx++] = map.get(key);
		}
		
		
		// ���� - �ּ� 1������ ���� ~ map������ ��ŭ �� �� ����
		 // ���� - �ּ� 1������ ����
        int answer = 0;
        for(int i=1; i<=idx; ++i) {
        	answer += go(category, 0, 0, idx, i);
        }
        
        return answer;
	}
	
	static int[] a = new int[30];
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