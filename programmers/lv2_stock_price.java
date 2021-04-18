class Solution {
    public int[] solution(int[] prices) {        
        int[] answer = {};
		int size = prices.length;
		answer = new int[size];
		
		for(int i=0 ; i < size; i++) {		
			answer[i] = 0;			
			for(int j=i+1; j<size; j++) {
				answer[i]++;
				if(prices[i] > prices[j]) break;							
			}			
		}
        
		return answer;
    }
}
