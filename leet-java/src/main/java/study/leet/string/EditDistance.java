package study.leet.string;

public class EditDistance {
    public int minDistance(String word1, String word2) {
    	if (word1 == null || word2 == null) {
			return -1;
		}
    	if (word1.isEmpty()) {
			return word2.length();
		}
    	if (word2.isEmpty()) {
			return word1.length();
		}
    	int len1 = word1.length();
    	int len2 = word2.length();
    	char[] arr1 = word1.toCharArray();
    	char[] arr2 = word2.toCharArray();
    	int[][] record = new int[len2 + 1][len1 + 1];
    	for (int i = 0; i < len1 + 1; i++) {
			record[0][i] = i;
		}
    	for (int i = 0; i < len2 + 1; i++) {
			record[i][0] = i;
		}
    	for (int i = 1; i < len2 + 1; i++) {
    		char ic = arr2[i - 1];
			for (int j = 1; j < len1 + 1; j++) {
				char jc = arr1[j - 1];
				if (ic == jc) {
					record[i][j] = record[i - 1][j - 1];
					continue;
				}
				record[i][j] = Math.min(Math.min(record[i - 1][j] + 1, record[i][j - 1] + 1), record[i - 1][j - 1] + 1);
			}
		}
        return record[len2][len1];
    }
    public static void main(String[] args) {
		EditDistance editDistance = new EditDistance();
		String word1 = "abed";
		String word2 = "aedfb";
		System.out.println(editDistance.minDistance(word1, word2));
	}
}
