package Algorithm;

import java.util.*;

// 왜 굳이 배열Integer[]로 바꿔서 연산? 그냥 ArrayList<Integer> 쓰면 안되나?
//	=> ArrayList도 어차피 내부적으로 배열로 구현된 리스트인데.. (LinkedList와 다름)
class Result implements Comparable<Result> {
    Integer[] a;
    Result(ArrayList<Integer> a) {
        this.a = a.toArray(new Integer[a.size()]);
    }
    // 출력시 StringBuilder에 append 할 때 사용
    int get(int index) {
        return (int)this.a[index];
    }
    // 순열이 같은지 비교할 때 사용(중복된 순열 제거)
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
    // 정렬 할 때 사용
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
        // 순열들을 정렬해서 앞뒤로 같은 순열이 있으면 제거한다.
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
        // 그냥 중복 없이 선택하는 수열 만들고, 수열 중에 같은 것이 있으면 제거해주는 자료형을 만듬
    	// => 이럴 바에는 HashSet을 쓰는게 낫지 않나? -> HashSet 쓰면 정렬을 못함..
    	if (index == m) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i=0; i<m; i++) {
            	// a[i]는 0 ~ n-1 수열
                temp.add(num[a[i]]);
            }
            d.add(new Result(temp));
            return;
        }
        // 중복 없이 선택하는 일반 수열을 만들어준다. (선택o/선택x)
        for (int i=0; i<n; i++) {
            if (c[i]) continue;
            c[i] = true;
            a[index] = i;
            go(index+1, n, m);
            c[i] = false;
        }
    }   
}