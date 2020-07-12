package DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class String_11656 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String str = br.readLine();
			int size = str.length();
			String[] suffix = new String[size];
			for(int i=0; i<size; ++i) {
				suffix[i] = str.substring(i);
			}
			Arrays.sort(suffix);
			for(int i=0; i<size-1; ++i) {
				bw.write(suffix[i]);
				bw.write('\n');
			}
			bw.write(suffix[size-1]);
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
