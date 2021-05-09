import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
// 참고한 순열 소스 : https://bcp0109.tistory.com/14
class Solution {    	
    static List<Integer> primeNumList = new ArrayList<Integer>();
    
    public int solution(String numbers) {
        int answer = 0;
        primeNumList.clear();     // 초기화
        
        // 문자열 -> 숫자 배열
        int len = numbers.length();
        int[] numArr = new int[len];
        for(int i=0; i < len; i++) {
        	numArr[i] = Integer.parseInt(numbers.substring(i, i+1));        	
        }
        
        // 순열(i개 뽑기)
        for(int i=1; i <= len; i++) {         
        	permutation(numArr, 0, len, i);        	
        }
        
		// 배열리스트 중복제거
		HashSet<Integer> numSet = new HashSet<Integer>(primeNumList);
		answer = numSet.size();        
        
        return answer;
    }

    // 순열
    static void permutation(int[] arr, int depth, int n, int r) {
    	if(depth == r) {
    		String numStr = "";
    		for(int i=0; i<r; i++) {
    			numStr += arr[i];    			
    		}    		
    		int permNum = Integer.parseInt(numStr);
    		if(isPrimeNumber(permNum)) {	// 소수 확인
    			primeNumList.add(permNum);
    		}    		
    		return;
    	}
    	
    	for(int i=depth; i < n; i++) {
    		swap(arr, depth, i);
    		permutation(arr, depth+1, n, r);
    		swap(arr, depth, i);
    	}
    }
    
    static void swap(int[] arr, int depth, int i) {
    	int temp = arr[depth];
    	arr[depth] = arr[i];
    	arr[i] = temp;
    }
    
    // 소수
    static boolean isPrimeNumber(int n) {    	
    	if(n < 2) { // 0,1
    		return false;
    	}

    	int cnt = 0;
    	for(int i=1; i <= n; i++) { // 1과 자기자신으로만 나눠저야함
    		if(n%i == 0) cnt++;
    		if(cnt > 2) return false;    		
    	}
    	
    	return cnt == 2 ? true : false;
    }    
    
    
}
