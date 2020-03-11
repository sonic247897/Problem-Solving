package hash.exam;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;
// �ؽô� key�� value�� �����ϴ� ��� �������� ����
// �� ������ equals�� ����ϴ� ������ �ƴϹǷ� 
// ����� ���� ��ü�� ���� compareTo ����� ���°� ���� �ʳ�?

// ���� ������ ���� (�ٵ� 3�� ���� ���� ����, key-value)
//   => TreeMap

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
      // ������ array�� sort�̹Ƿ� shuffle�� �ʿ�x
      Arrays.sort(music);
      
      for(int i=0; i<size ; ++i) {
    	  System.out.println(music[i].toString());
    	  
      }
      // ========�� ���¿��� classic1, classic2, pop1, pop2�� map�� ������ ���ݾ�
      
      
      
      // key�� ���� - key�� sum���� �ؾ���
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
      Tmap.put(sum, music[size-1].genre); // ������ �帣
      
      // ��������
      Iterator iter = Tmap.descendingKeySet().iterator();
      // �迭 ������ = �帣*2? �帣�� ���� �� �� ���϶�  ó��
      while(iter.hasNext()) {
    	  int key = (int)(iter.next());
    	  
      }
      
      int[] answer = {0};
      return answer;
      
    }
}