class Solution {
	public static int[] solution(int brown, int yellow) {
		int[] answer = new int[2];

		int all = brown + yellow;

		for (int i = 1; i <= Math.sqrt(all); i++) {
			if (all % i != 0) continue;
			
			int total_sero = i;
			int total_garo = all / i;

			if (yellow == (total_sero - 2) * (total_garo - 2)) {
				answer[0] = total_garo;
				answer[1] = total_sero;
				break;
			}
		}

		return answer;
	}
}
