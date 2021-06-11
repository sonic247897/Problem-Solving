package hash.exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class genre_best{
	int total_play;
	int[] best_play = {-1, -1}; //�帣�� ���� ���� �ϳ����, �ϳ��� � �����մϴ�.
	int[] best_num = {-1, -1};
	
	public genre_best(int total_play) {
		this.total_play = total_play;
	}
}

// O(n)
public class Hash04 {
   public static void main(String[] args) {
      String[] genres = {"classic", "pop", "classic", "classic", "pop"};
      int[] plays = {500, 600, 150, 800, 2500};
      int[] answer = solution(genres, plays);
      for(int i=0; i<answer.length; ++i)
    	  System.out.println(answer[i]);
   }
   
   public static int[] solution(String[] genres, int[] plays) {
	   int size = genres.length;
	   HashMap<String, genre_best> map = new HashMap<>();
	   
	   genre_best tmp;
	   for(int i=0; i<size; ++i) {
		   if(map.containsKey(genres[i])) {
			   tmp = map.get(genres[i]);
			   tmp.total_play += plays[i];
		   }else {
			   tmp = new genre_best(plays[i]);
			   map.put(genres[i], tmp);
		   }
		   // �帣���� 2�� �ȿ� ��� ������ Ȯ��
		   // ������ȣ�� ���� �����ϹǷ� ���� ��� ����� �ʿ� x
		   int first = tmp.best_play[0]; int second = tmp.best_play[1];
		   // �������� ���� - 3�� �� ��
		   if(second < plays[i]) {
			   tmp.best_play[1] = plays[i];
			   tmp.best_num[1] = i;
			   if(first < plays[i]) { // ù��° �� 2���� ������
				   tmp.best_play[0] = plays[i];
				   tmp.best_play[1] = first;
				   tmp.best_num[1] = tmp.best_num[0];
				   tmp.best_num[0] = i;
			   }
		   }
	   }
	   
	   // ����
	   Iterator it = sortByValue(map).iterator();
       int idx = 0;
       int[] array = new int[size];
	   while(it.hasNext()) {
    	   String genre = (String) it.next();
    	   tmp = map.get(genre);
    	   array[idx++] = tmp.best_num[0];
    	   if(tmp.best_num[1] != -1)
    		   array[idx++] = tmp.best_num[1];
       }
	   int[] answer = new int[idx];
	   for(int i=0; i<idx; ++i)
		   answer[i] = array[i];
	   return answer;
   }
   
   public static List sortByValue(final HashMap<String, genre_best> map) {
	   List<String> list = new ArrayList();
	   list.addAll(map.keySet());
	   
	   // ��������
	   Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				genre_best v1 = map.get(o1);
				genre_best v2 = map.get(o2);
				return v2.total_play - v1.total_play;
			}
	   });
	   return list;
   }
}