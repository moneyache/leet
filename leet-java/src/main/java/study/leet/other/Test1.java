package study.leet.other;

public class Test1 {

	public static void main(String[] args) {
		Object object1 = new Object();
		Object object2 = new Object();
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
			
				synchronized (object1) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized (object2) {
				System.out.println(Thread.currentThread().getName() + "..............running");	
				}	
				}
			}
		});
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				synchronized (object2) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					synchronized (object1) {
					System.out.println(Thread.currentThread().getName() + "...............running");	
					}
				}
			}
		});
		thread1.start();
		thread2.start();
	}
}
