package Algorithm;

import java.util.*;

// �� ���� �迭Integer[]�� �ٲ㼭 ����? �׳� ArrayList<Integer> ���� �ȵǳ�?
//	=> ArrayList�� ������ ���������� �迭�� ������ ����Ʈ�ε�.. (LinkedList�� �ٸ�)
class Result implements Comparable<Result> {
    Integer[] a;
    Result(ArrayList<Integer> a) {
        this.a = a.toArray(new Integer[a.size()]);
    }
    // ��½� StringBuilder�� append �� �� ���
    int get(int index) {
        return (int)this.a[index];
    }
    // ������ ������ ���� �� ���(�ߺ��� ���� ����)
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Result) {
            Result that = (Result)obj;
            int n = this.a.length;
            for (int i=0; i<n; i++) {
                if (this.a[i] != that.a[i]) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }
    // ���� �� �� ���
    public int compareTo(Result that) {
        int n = this.a.length;
        for (int i=0; i<n; i++) {
            if (this.a[i] == that.a[i]) continue;
            if (this.a[i] < that.a[i]) return -1;
            if (this.a[i] > that.a[i]) return 1;
        }
        return 0;
    }
}
public class BruteForce_15663 {
    static boolean[] c = new boolean[10];
    static int[] a = new int[10];
    static int[] num = new int[10];
    static ArrayList<Result> d = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        for (int i=0; i<n; i++) {
            num[i] = sc.nextInt();
        }
        Arrays.sort(num, 0, n);
        go(0, n, m);
        // �������� �����ؼ� �յڷ� ���� ������ ������ �����Ѵ�.
        Collections.sort(d);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<d.size(); i++) {
            if (i == 0 || !d.get(i).equals(d.get(i-1))) {
                for (int j=0; j<m; j++) {
                    sb.append(d.get(i).get(j));
                    if (j != m-1) sb.append(' ');
                }
                sb.append('\n');
            }
        }
        System.out.print(sb);
    }
    
    static void go(int index, int n, int m) {
        // �׳� �ߺ� ���� �����ϴ� ���� �����, ���� �߿� ���� ���� ������ �������ִ� �ڷ����� ����
    	// => �̷� �ٿ��� HashSet�� ���°� ���� �ʳ�? -> HashSet ���� ������ ����..
    	if (index == m) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i=0; i<m; i++) {
            	// a[i]�� 0 ~ n-1 ����
                temp.add(num[a[i]]);
            }
            d.add(new Result(temp));
            return;
        }
        // �ߺ� ���� �����ϴ� �Ϲ� ������ ������ش�. (����o/����x)
        for (int i=0; i<n; i++) {
            if (c[i]) continue;
            c[i] = true;
            a[index] = i;
            go(index+1, n, m);
            c[i] = false;
        }
    }   
}