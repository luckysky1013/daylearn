import java.io.File;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author liujian
 * @date 2018/9/21
 */
public class ThreadLearn {

	public synchronized void handleList(List<File> data, int threadNum) throws Exception {
		int length = data.size();
		int tl = length % threadNum == 0 ? length / threadNum : (length
				/ threadNum + 1);
	/*	*//**
		 * 打开加密机
		 *//*
		openHsm();
		CountDownLatch latch = new CountDownLatch(threadNum);
		for (int i = 0; i < threadNum; i++) {
			int end = (i + 1) * tl;
			HandleThread thread = new HandleThread("线程[" + (i + 1) + "] ", data, i * tl, end > length ? length : end,
					latch);
			thread.start();
		}

		class HandleThread extends Thread {
			private String threadName;
			private List<File> data;
			private int start;
			private int end;
			private CountDownLatch latch;

			public HandleThread(String threadName, List<File> data, int start, int end, CountDownLatch latch) {
				this.threadName = threadName;
				this.data = data;
				this.start = start;
				this.end = end;
				this.latch = latch;
			}

			public void run() {

				//TODO 将读取文件的操作在这里进行处理
				List<File> subList = data.subList(start, end)*//*.add("^&*")*//*;
				for (int i = 0; i < subList.size(); i++) {
					File file = subList.get(i);
					//EncOrDecFileWindow.addLog("开始处理第" + (i+1) + "个文件!");
					log.warn("开始处理第" + (i + 1) + "个文件!" + file.getName());
					try {
						operateAllFileCredit(file.getAbsolutePath(), encOrDec);
					} catch (Exception e) {

						e.printStackTrace();
					}
				}
				EncOrDecFileWindow.addLog(threadName + "处理完成，总共处理了" + subList.size() + "条！");
				latch.countDown();//任务完成，计数器减1
				long count = latch.getCount();
				//如果count==0 说明所有的线程处理完毕，开始关闭加密机，并且提示文件处理完毕；
				if (count == 0) {
					try {
						closeHsm();//关闭加密机
						log.debug("处理完成");
						EncOrDecFileWindow.addLog("所有文件处理完成！");
						long end = System.currentTimeMillis();
						log.debug("总共用时：" + (begin - end));
						EncOrDecFileWindow.addLog("总共用时：" + (begin - end));
					} catch (Exception e) {
						EncOrDecFileWindow.addErrorLog("关闭加密机连接失败!");
						log.error(e);
						try {
							throw new Exception(e.getMessage());
						} catch (Exception e1) {
							e1.printStackTrace();
						}

					} finally {
						*//**
						 * 设置空间状态
						 *//*
						setWidgetState(true);
					}

				}
			}

		}
*/
	}}