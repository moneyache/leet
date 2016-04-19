package study.leet.other;


public class GasStation {

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int sum = 0, total = 0, index = -1;
		for (int i = 0; i < cost.length; i++) {
			sum += gas[i] - cost[i];
			total += gas[i] - cost[i];
			if (sum < 0) {
				index = i;
				sum = 0;
			}
		}
		return total >= 0 ? index + 1 : -1; 
    }
	public static void main(String[] args) {
		GasStation gasStation = new GasStation();
		int[] gas = {2, 1, 3, 4, 5};
		int[] cost = {1, 2, 4, 4, 5};
		System.out.println(gasStation.canCompleteCircuit(gas, cost));
	}
}
