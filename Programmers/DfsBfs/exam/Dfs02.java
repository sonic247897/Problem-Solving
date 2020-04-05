package DfsBfs.exam;

public class Dfs02 {
	public static void main(String[] args) {
		int n = 3;
		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		System.out.println(solution(n, computers));
	}
	
	static boolean[] check = new boolean[200];
	
	// 연결요소 문제- dfs, bfs 둘다 가능
    public static int solution(int n, int[][] computers) {
        // 주어진 그래프 모델: 인접행렬 형식
    	int answer = 0;
    	int size = computers.length;
        for(int i=0; i<size; ++i) {
        	if(!check[i]) {
        		dfs(computers, i);
        		answer++; //dfs가 새로 시작하면 네트워크 새로 시작
        	}
        }
        return answer;
    }
    
    public static void dfs(int[][] computers, int node) {
    	check[node] = true;
    	for(int i=0; i<computers.length; ++i) {
    		if(computers[node][i] ==1 && !check[i]) {
    			dfs(computers, i);
    		}
    	}
    }
}
