import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        
        int[][] supo = {{1, 2, 3, 4, 5}, 
        				{2, 1, 2, 3, 2, 4, 2, 5},
        				{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int supoCnt = supo.length;
        List<Integer> point = new ArrayList<Integer>();
        for(int i=0; i < supoCnt; i++) point.add(0);  // 점수 초기화        	
        
        int idx=0;
        for(int a : answers) {        	
        	for(int i=0; i < supoCnt; i++) { // 0 1 2        	
        		if(a == supo[i][idx % supo[i].length]) {
        			point.set(i, point.get(i) + 1);        			
        		}        		           		
        	}        	
        	idx++;
        }
        
        
        int max = point.stream().mapToInt(Integer::intValue).max().orElse(0);
        List<Integer> answerArr = new ArrayList<Integer>();
        for(int i=0; i < point.size(); i++) {
        	if(max == point.get(i)) {
        		answerArr.add(i+1);        	
        	}
        }
        answer = answerArr.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}
