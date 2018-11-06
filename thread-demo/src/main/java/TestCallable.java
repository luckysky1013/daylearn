import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author liujian
 * @date 2018/9/21
 */
public class TestCallable implements Runnable{

	private List<String> data;

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}

	@Override
	public void run() {
		//TODO 将读取文件的操作在这里进行处理
		//TODO 将读取文件的操作在这里进行处理

	}
}
