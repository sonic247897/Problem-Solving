package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Student implements Comparable<Student>{
	String name;
	int korean, english, math;
	Student(String name, int korean, int english, int math) {
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
	@Override
	public int compareTo(Student o) {
		int korComp = o.korean - this.korean; // 내림차순
		if(korComp == 0) {
			int engComp = this.english - o.english; // 오름차순
			if(engComp == 0) {
				int mathComp = o.math - this.math; // 내림차순
				if(mathComp == 0) {
					int nameComp = this.name.compareTo(o.name); // 오름차순
					return nameComp;
				}
				return mathComp;
			}
			return engComp;
		}
		return korComp;
	}
}

public class Sorting_10825 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			String[] tmp;
			Student[] student = new Student[n];
			for(int i=0; i<n; ++i) {
				tmp = br.readLine().split(" ");
				student[i] = new Student(tmp[0], Integer.parseInt(tmp[1]), 
						Integer.parseInt(tmp[2]), Integer.parseInt(tmp[3]));
			}
			
			Arrays.sort(student);
			
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<n; ++i) {
				sb.append(student[i].name).append('\n');
			}
			bw.write(sb.toString());
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
