package study.leet.other;

import java.util.concurrent.ConcurrentHashMap;

public class Test {

	public static void main(String[] args) {
		ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(new Runnable() {
				public void add(String key) {
					Integer value = map.get(key);
					if (value == null) {
						map.put(key, 1);
					}
					else {
						map.put(key, value + 1);
					}
				}
				@Override
				public void run() {
					// TODO Auto-generated method stub
					add("qt");
				}
			});
			thread.start();
		}
		System.out.println(map.get("qt"));
	}
}
