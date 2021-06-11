package DfsBfs.exam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

// 방향성 그래프
public class Dfs03 {
	public static void main(String[] args) {
		String[][] tickets = {{"ICN", "JFK"},{"HND", "IAD"}, {"JFK", "HND"}};
		String[] answer = solution(tickets);
	}
	
	// 같은 정점 두 번 방문하면 DFS, BFS 아님
	// -> 공항을 정점으로 하면 사이클이 생기고 두번 이상 방문하는 경우 생김
	// => 공항을 정점으로 모델링한 그래프에서는 사이클 생겨도 ok임. 다만, DFS BFS가 아니다!
	
	// 1. 전부 다른 정점으로 모델링? -> 그리디 알고리즘(사전순 우선선택) 될듯
	// 2. 주어진 티켓은 다 써야함 : 티켓 = 정점 ->DFS
	//	=> 정렬 후에 DFS
	// 히든 tc) 티켓은 중복될 수 있음
	static HashMap<String, List<String>> map = new HashMap<>();
	static HashMap<String, Boolean> check = new HashMap<>();
	
	public static String[] solution(String[][] tickets) {
		int size = tickets.length;
		// 순회하면서 채운다.
		String[] answer = new String[size+1]; 
		int idx = 0;
		
		// 티켓 사전순 정렬 
		Arrays.sort(tickets, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				int res = o1[0].compareTo(o2[0]);
				if(res == 0) res = o1[1].compareTo(o2[1]);
				return res;
			}
		});
		// 그래프 모델링 - 연결 리스트(정점: ticket) => O(10,000)
		// 입력이 그래프로 주어지지 않았다면, 그래프 모델링을 O(n)에 하려면 hash 써야 함.
		// => boolean check해야 하므로 정점(출발, 도착) 쪼개지 말고 그대로 써야함 -> 문자열 합쳐야 함. 
		// -> 예외) 중복 티켓.. => 해시 collision 처리 해줘야 할듯
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
