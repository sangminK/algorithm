class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        for(int h=citations.length; h >= 0; h--) {
        	int max = 0;
    		
        	for(int c : citations) {
        		if(c >= h) max++;
        	}
        		
        	if(h <= max) {
        		answer = h;        	
        		break;
        	}        	
        }
      
        return answer;
    }
}
