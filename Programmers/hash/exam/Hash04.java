package hash.exam;

import java.util.Arrays;
import java.lang.Comparable;
// 해시는 key나 value로 정렬하는 기능 제공하지 않음
// 이 문제는 equals를 사용하는 문제가 아니므로 
// 사용자 정의 객체를 만들어서 compareTo 만들어 쓰는게 낫지 않나?

// 정렬 가능한 구조
//	=> TreeMap

public class Hash04 {
	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		solution(genres, plays);
	}
	
	public static int[] solution(String[] genres, int[] plays) {
		// genres랑 plays 다 중복되는거 있어서 Treemap으로 정렬 못함
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
				//1차: 장르 - 같은 장르끼리
				int result = (this.genre).compareTo(that.genre);
				//2차: play - 장르가 같으면 재생회수 많은 순으로 정렬
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
		// 참조형 array의 sort이므로 shuffle할 필요x
		Arrays.sort(music); 
		
		
		for(int i=0; i<size; ++i) {
			System.out.print(music[i].toString()+" ");
		}
		
		
		int[] answer = {0};
	    return answer;
		
    }
}
