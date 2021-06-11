package DfsBfs.exam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

// ���⼺ �׷���
public class Dfs03 {
	public static void main(String[] args) {
		String[][] tickets = {{"ICN", "JFK"},{"HND", "IAD"}, {"JFK", "HND"}};
		String[] answer = solution(tickets);
	}
	
	// ���� ���� �� �� �湮�ϸ� DFS, BFS �ƴ�
	// -> ������ �������� �ϸ� ����Ŭ�� ����� �ι� �̻� �湮�ϴ� ��� ����
	// => ������ �������� �𵨸��� �׷��������� ����Ŭ ���ܵ� ok��. �ٸ�, DFS BFS�� �ƴϴ�!
	
	// 1. ���� �ٸ� �������� �𵨸�? -> �׸��� �˰���(������ �켱����) �ɵ�
	// 2. �־��� Ƽ���� �� ����� : Ƽ�� = ���� ->DFS
	//	=> ���� �Ŀ� DFS
	// ���� tc) Ƽ���� �ߺ��� �� ����
	static HashMap<String, List<String>> map = new HashMap<>();
	static HashMap<String, Boolean> check = new HashMap<>();
	
	public static String[] solution(String[][] tickets) {
		int size = tickets.length;
		// ��ȸ�ϸ鼭 ä���.
		String[] answer = new String[size+1]; 
		int idx = 0;
		
		// Ƽ�� ������ ���� 
		Arrays.sort(tickets, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				int res = o1[0].compareTo(o2[0]);
				if(res == 0) res = o1[1].compareTo(o2[1]);
				return res;
			}
		});
		// �׷��� �𵨸� - ���� ����Ʈ(����: ticket) => O(10,000)
		// �Է��� �׷����� �־����� �ʾҴٸ�, �׷��� �𵨸��� O(n)�� �Ϸ��� hash ��� ��.
		// => boolean check�ؾ� �ϹǷ� ����(���, ����) �ɰ��� ���� �״�� ����� -> ���ڿ� ���ľ� ��. 
		// -> ����) �ߺ� Ƽ��.. => �ؽ� collision ó�� ����� �ҵ�
		for(int i=0; i<size; ++i) {
			StringBuilder sb = new StringBuilder();
			sb.append(tickets[i][0]).append(tickets[i][1]);
			if(!map.containsKey(sb)) {
			}else {
				
			}
		}
		
		go(tickets);
		
		
		return answer;
	}
	
	public static void go(String[][] tickets) {
		
	}

}
