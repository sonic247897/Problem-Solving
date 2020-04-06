package DfsBfs.exam;

public class Bfs02 {
	public static void main(String[] args) {

	}

	// 같은 정점 두 번 방문하면 DFS, BFS 아님
	// -> 공항을 정점으로 하면 사이클이 생기고 두번 이상 방문하는 경우 생김
	// 1. 전부 다른 정점으로 모델링? -> DFS인데 트리 모양에 그리디 알고리즘(사전순 우선선택) 될듯
	// 2. 주어진 항공권은 다 써야함 : 항공권 = 정점? ->DFS
	// 	정점 - 출발공항, 도착공항을 정렬하고 출발공항 인접리스트에 넣고 사전순으로 정렬
	//		=> X. string배열 써서 공항 넣으면 다음 node를 탐색할때 배열로 바로 접근할 수 있는
	//		 index인 정수가 아니라 string이 결과로 나오므로, 배열 탐색할때마다 O(N) 걸린다.
	// 그래프로 모델링 하려면 배열로 O(1)만에 접근할 수 있게 순차 numbering 필요
	// (해시같은 심볼 테이블은 매핑되는 수가 랜덤이므로 불가능)
	public String[] solution(String[][] tickets) {
		String[] answer = {};
		return answer;
	}

}
