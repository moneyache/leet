package study.leet.other;

public class MaxProfile {
    public int maxProfit(int[] prices) {
    	int len = prices.length;
    	if (len < 2) {
			return 0;
		}
        int[] profiles = new int[len];
        int min = prices[0];
        profiles[0] = 0;
        for (int i = 1; i < len; i++) {
			int curVal = prices[i];
			if (curVal < min) {
				min = curVal;
			}
			int curProfile = curVal - min;
			profiles[i] = Math.max(curProfile, profiles[i - 1]);
		}
        return profiles[len - 1];
    }
	public static void main(String[] args) {
		
	}
}
