import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author liujian
 * @date 2018/9/20
 */
public class ListThread {




	public void testStr(List<String>  list) {
		long start = System.currentTimeMillis();
		ExecutorService executor = Executors.newFixedThreadPool(15);
		int size = list.size();
		if (size > 100000) {
			int batch = size % 100000 == 0 ? size / 100000 : size / 100000 + 1;
			for (int j=0; j<batch; j++) {
				int end = (j+1)*100000;
				if (end > size) {
					end = size;
				}
				List<String> subList = list.subList(j*100000, end);
				TestCallable callable = new TestCallable();
				callable.setData(subList);
				executor.execute(callable);
			}
		}
		executor.shutdown();

		while (true) {
			if (executor.isTerminated()) {
				break;
			}
		}
		long date = System.currentTimeMillis() - start;
		System.out.println("======" + date + "======");
	}


	public static void main(String [] args){
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 10000000; i++) {
			list.add(i + ",");
		}
		ListThread listThread=new ListThread();
		listThread.testStr(list);
	}

}

