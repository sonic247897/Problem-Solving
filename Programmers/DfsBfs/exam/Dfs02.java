package DfsBfs.exam;

public class Dfs02 {
	public static void main(String[] args) {
		int n = 3;
		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		System.out.println(solution(n, computers));
	}
	
	static boolean[] check = new boolean[200];
	
	// ������ ����- dfs, bfs �Ѵ� ����
    public static int solution(int n, int[][] computers) {
        // �־��� �׷��� ��: ������� ����
    	int answer = 0;
    	int size = computers.length;
        for(int i=0; i<size; ++i) {
        	if(!check[i]) {
        		dfs(computers, i);
        		answer++; //dfs�� ���� �����ϸ� ��Ʈ��ũ ���� ����
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
