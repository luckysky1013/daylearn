package com.demo.multithread;

public class MultiThreadLong {
	//定义静态变量
	public static long t = 0;
	//定义赋值的类
	public static class ChangeT implements Runnable {
		private long to;

		public ChangeT(long to) {
			this.to = to;
		}

		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				MultiThreadLong.t = to;
				Thread.yield();
			}
		}

	}

	public static class ReadT implements Runnable {

		public void run() {
			// TODO Auto-generated method stub
			while (true) {
				long tmp = MultiThreadLong.t;
				if (tmp != 111L && tmp != -999L && tmp != 333L && tmp != -444L) {
					System.out.println(tmp);
					Thread.yield();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		//4个线程堆long行数据t进行赋值
		new Thread(new ChangeT(111L)).start();
		new Thread(new ChangeT(-999L)).start();
		new Thread(new ChangeT(333L)).start();
		new Thread(new ChangeT(-444L)).start();
		
		new Thread(new ReadT()).start();
	}
}
