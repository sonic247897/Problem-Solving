package hash.exam;

import java.util.Arrays;
import java.lang.Comparable;
// �ؽô� key�� value�� �����ϴ� ��� �������� ����
// �� ������ equals�� ����ϴ� ������ �ƴϹǷ� 
// ����� ���� ��ü�� ���� compareTo ����� ���°� ���� �ʳ�?

// ���� ������ ����
//	=> TreeMap

public class Hash04 {
	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		solution(genres, plays);
	}
	
	public static int[] solution(String[] genres, int[] plays) {
		// genres�� plays �� �ߺ��Ǵ°� �־ Treemap���� ���� ����
		class Music implements Comparable<Music>{
			int num;
			String genre;
			int play;
			public Music(int num, String genre, int play) {
				this.num = num;
				this.genre = genre;
				this.play = play;
			}
			@Override
			public int compareTo(Music that) {
				//1��: �帣 - ���� �帣����
				int result = (this.genre).compareTo(that.genre);
				//2��: play - �帣�� ������ ���ȸ�� ���� ������ ����
				if(result == 0) {
					result = that.play-this.play;
				}
				System.out.println(result);
				return result;
			}
			@Override
			public String toString() {
				return "Music [num=" + num + ", genre=" + genre + ", play=" + play + "]";
			}
			
		}

		
		Music[] music = new Music[10000];
		int size = genres.length;
		for(int i=0; i<size; ++i) {
			music[i] = new Music(i, genres[i], plays[i]);
			System.out.println(music[i].toString());
		}
		// ������ array�� sort�̹Ƿ� shuffle�� �ʿ�x
		Arrays.sort(music); 
		
		
		for(int i=0; i<size; ++i) {
			System.out.print(music[i].toString()+" ");
		}
		
		
		int[] answer = {0};
	    return answer;
		
    }
}
