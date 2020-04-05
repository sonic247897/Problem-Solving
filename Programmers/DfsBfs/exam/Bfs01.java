package DfsBfs.exam;

import java.util.LinkedList;
import java.util.Queue;

public class Bfs01 {
	// 백준 단지번호붙이기 문제는 순회가 쉬운 2차원 배열이라 모델링 안한거고
	// 이건 그냥 경우의 수가 적어서 모델링 안한거임
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		System.out.println(solution(begin, target, words));
	}
	// 예외처리 - 단어 list에 없으면 0을 return. O(N)
	// 	x => bfs, dfs가 O(N)에 가까움
	// 그래프 모델링? - 정렬로는 불가능. 계속 한바퀴씩 돌면서 연결리스트 만들어줘야 함.
	// 한 글자 차이 사이에만 간선있음 -> 경우의수가 적으므로 그래프 모델링 할 필요 없이
	// 매번 50개 words 찾으면서 가기. 최대 (50*길이10 = 500)
	// 최단거리 - BFS
	public static int solution(String begin, String target, String[] words) {
		// 번거로우니 그냥 while 안에 코드 밖에서 한 번 더돌림
		// String큐를 만들면 인덱스를 정수로 접근하는 check, dist배열을 사용하기가 힘드므로
		// words배열의 인덱스를 넣는 Integer큐를 생성 (보통의 BFS, DFS와 배열사용하는 자료구조들..)
        int size = words.length;
        Queue<Integer> q = new LinkedList<Integer>();
        boolean check[] = new boolean[size];
        int dist[] = new int[size];
        
        // begin이랑 비교
        int strLength = begin.length();
        for(int nxt=0; nxt < size; ++nxt) {
    		// 알파벳 한 개만 차이 나는지 확인
			int cnt = 0;
			for(int i=0; i<strLength; ++i) {
				if(cnt>1) break;
				if(words[nxt].charAt(i) != begin.charAt(i)) {
					++cnt;
				}
			}
			if(cnt == 1){
				q.add(nxt); 
				check[nxt] = true;
				dist[nxt] = 1;
				if(words[nxt].equals(target)) {
					return 1; // 정답 찾으면 바로 리턴
				}
			}
		
    	}
        // words배열에서 도는 while문
        while(!q.isEmpty()) {
        	int cur = q.remove();
        	for(int nxt=0; nxt < size; ++nxt) {
        		if(!check[nxt]) {
        			// 알파벳 한 개만 차이 나는지 확인
        			int cnt = 0;
        			for(int i=0; i<strLength; ++i) {
        				if(cnt>1) break;
        				if(words[cur].charAt(i) != words[nxt].charAt(i)) {
        					++cnt;
        				}
        			}
        			if(cnt == 1){
        				q.add(nxt); 
        				check[nxt] = true;
        				dist[nxt] = dist[cur]+1;
        				if(words[nxt].equals(target)) {
        					return dist[nxt]; // 정답 찾으면 바로 리턴
        				}
        			}
        		}
        	}
        }
        // 끝까지 못 찾으면 찾을 수 없으므로 0
        return 0;
    }
}
