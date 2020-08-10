package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Member implements Comparable<Member>{
	int age;
	String name;
	int join;
	Member(int age, String name, int join){
		this.age = age;
		this.name = name;
		this.join = join;
	}
	@Override
	public int compareTo(Member o) {
		int result = this.age - o.age;
		if(result == 0)
			return this.join - o.join;
		return result;
	}
}

public class Sorting_10814 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			String[] tmp;
			Member[] member = new Member[n];
			for(int i=0; i<n; ++i) {
				tmp = br.readLine().split(" ");
				member[i] = new Member(Integer.parseInt(tmp[0]), tmp[1], i);
			}
			
			Arrays.sort(member);
			
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<n; ++i) {
				sb.append(member[i].age).append(' ').append(member[i].name).append('\n');
			}
			bw.write(sb.toString());
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
