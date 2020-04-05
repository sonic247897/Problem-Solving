package DfsBfs.exam;

import java.util.LinkedList;
import java.util.Queue;

public class Bfs01 {
	// ���� ������ȣ���̱� ������ ��ȸ�� ���� 2���� �迭�̶� �𵨸� ���ѰŰ�
	// �̰� �׳� ����� ���� ��� �𵨸� ���Ѱ���
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		System.out.println(solution(begin, target, words));
	}
	// ����ó�� - �ܾ� list�� ������ 0�� return. O(N)
	// 	x => bfs, dfs�� O(N)�� �����
	// �׷��� �𵨸�? - ���ķδ� �Ұ���. ��� �ѹ����� ���鼭 ���Ḯ��Ʈ �������� ��.
	// �� ���� ���� ���̿��� �������� -> ����Ǽ��� �����Ƿ� �׷��� �𵨸� �� �ʿ� ����
	// �Ź� 50�� words ã���鼭 ����. �ִ� (50*����10 = 500)
	// �ִܰŸ� - BFS
	public static int solution(String begin, String target, String[] words) {
		// ���ŷο�� �׳� while �ȿ� �ڵ� �ۿ��� �� �� ������
		// Stringť�� ����� �ε����� ������ �����ϴ� check, dist�迭�� ����ϱⰡ ����Ƿ�
		// words�迭�� �ε����� �ִ� Integerť�� ���� (������ BFS, DFS�� �迭����ϴ� �ڷᱸ����..)
        int size = words.length;
        Queue<Integer> q = new LinkedList<Integer>();
        boolean check[] = new boolean[size];
        int dist[] = new int[size];
        
        // begin�̶� ��
        int strLength = begin.length();
        for(int nxt=0; nxt < size; ++nxt) {
    		// ���ĺ� �� ���� ���� ������ Ȯ��
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
					return 1; // ���� ã���� �ٷ� ����
				}
			}
		
    	}
        // words�迭���� ���� while��
        while(!q.isEmpty()) {
        	int cur = q.remove();
        	for(int nxt=0; nxt < size; ++nxt) {
        		if(!check[nxt]) {
        			// ���ĺ� �� ���� ���� ������ Ȯ��
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
        					return dist[nxt]; // ���� ã���� �ٷ� ����
        				}
        			}
        		}
        	}
        }
        // ������ �� ã���� ã�� �� �����Ƿ� 0
        return 0;
    }
}
