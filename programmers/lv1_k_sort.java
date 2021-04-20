import java.util.Arrays;

class Solution {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {
			int start = commands[i][0];
			int end = commands[i][1];

			int[] newArr = new int[end - start + 1];
			
			int idx = 0;
			for (int j = start - 1; j <= end - 1; j++) {
				newArr[idx++] = array[j];
			}
			Arrays.sort(newArr);
			answer[i] = newArr[commands[i][2] - 1];
		}
		
		return answer;
	}
}
