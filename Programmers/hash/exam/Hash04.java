package hash.exam;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;
// 해시는 key나 value로 정렬하는 기능 제공하지 않음
// 이 문제는 equals를 사용하는 문제가 아니므로 
// 사용자 정의 객체를 만들어서 compareTo 만들어 쓰는게 낫지 않나?

// 정렬 가능한 구조 (근데 3개 값은 저장 못함, key-value)
//   => TreeMap

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
            return result;
         }
		@Override
		public String toString() {
			return "Music [num=" + num + ", genre=" + genre + ", play=" + play + "]";
		}
         
      }

      int size = genres.length;
      Music[] music = new Music[size];
      for(int i=0; i<size; ++i) {
         music[i] = new Music(i, genres[i], plays[i]);
      }
      // 참조형 array의 sort이므로 shuffle할 필요x
      Arrays.sort(music);
      
      for(int i=0; i<size ; ++i) {
    	  System.out.println(music[i].toString());
    	  
      }
      // ========이 상태에서 classic1, classic2, pop1, pop2를 map에 넣으면 되잖아
      
      
      
      // key순 정렬 - key를 sum으로 해야함
      TreeMap<Integer, String> Tmap = new TreeMap<Integer, String>();
      int sum = music[0].play;
      for(int i=0; i<size-1; ++i) {
         if(!music[i].genre.equals(music[i+1].genre)) {
            Tmap.put(sum, music[i].genre);
            sum = music[i+1].play;
         }else {
        	sum += music[i+1].play;
         }
      }
      Tmap.put(sum, music[size-1].genre); // 마지막 장르
      
      // 내림차순
      Iterator iter = Tmap.descendingKeySet().iterator();
      // 배열 사이즈 = 장르*2? 장르에 속한 곡 한 개일때  처리
      while(iter.hasNext()) {
    	  int key = (int)(iter.next());
    	  
      }
      
      int[] answer = {0};
      return answer;
      
    }
}