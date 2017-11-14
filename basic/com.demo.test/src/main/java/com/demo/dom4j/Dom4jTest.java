package com.demo.dom4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Dom4jTest {
	private static Document document = null;

	/**
	 * dom4j读取xml文件 使用SAXReader 对象
	 * 
	 * @param fileName
	 *            xml文件名字
	 * @return 返回document对象
	 */
	public static Document load(String fileName) {
		SAXReader saxReader = new SAXReader();
		try {
			document = saxReader.read(new File(fileName));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return document;
	}

	/**
	 * dom4j 读取xml文件 使用SAXReader 对象
	 * 
	 * @param url
	 * @return
	 */
	public static Document load(URL url) {
		SAXReader saxReader = new SAXReader();
		try {
			document = saxReader.read(url);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return document;
	}

	public void parseXml01() {
		try {
			// 将src下面的xml转换为输入流
			InputStream inputStream = new FileInputStream(new File("D:/project/dynamicWeb/src/resource/module01.xml"));
			// InputStream inputStream =
			// this.getClass().getResourceAsStream("/module01.xml");//也可以根据类的编译文件相对路径去找xml
			// 创建SAXReader读取器，专门用于读取xml
			SAXReader saxReader = new SAXReader();
			// 根据saxReader的read重写方法可知，既可以通过inputStream输入流来读取，也可以通过file对象来读取
			// Document document = saxReader.read(inputStream);
			Document document = saxReader.read(new File("D:/project/dynamicWeb/src/resource/module01.xml"));// 必须指定文件的绝对路径
			// 另外还可以使用DocumentHelper提供的xml转换器也是可以的。
			// Document document = DocumentHelper.parseText("<?xml
			// version=\"1.0\" encoding=\"UTF-8\"?><modules id=\"123\"><module>
			// 这个是module标签的文本信息</module></modules>");

			// 获取根节点对象
			Element rootElement = document.getRootElement();
			System.out.println("根节点名称：" + rootElement.getName());// 获取节点的名称
			System.out.println("根节点有多少属性：" + rootElement.attributeCount());// 获取节点属性数目
			System.out.println("根节点id属性的值：" + rootElement.attributeValue("id"));// 获取节点的属性id的值
			System.out.println("根节点内文本：" + rootElement.getText());// 如果元素有子节点则返回空字符串，否则返回节点内的文本
			// rootElement.getText() 之所以会换行是因为
			// 标签与标签之间使用了tab键和换行符布局，这个也算是文本所以显示出来换行的效果。
			System.out.println("根节点内文本(1)：" + rootElement.getTextTrim());// 去掉的是标签与标签之间的tab键和换行符等等，不是内容前后的空格
			System.out.println("根节点子节点文本内容：" + rootElement.getStringValue()); // 返回当前节点递归所有子节点的文本信息。

			// 获取子节点
			Element element = rootElement.element("module");
			if (element != null) {
				System.out.println("子节点的文本：" + element.getText());// 因为子节点和根节点都是Element对象所以它们的操作方式都是相同的
			}
			// 但是有些情况xml比较复杂，规范不统一，某个节点不存在直接java.lang.NullPointerException，所以获取到element对象之后要先判断一下是否为空

			rootElement.setName("root");// 支持修改节点名称
			System.out.println("根节点修改之后的名称：" + rootElement.getName());
			rootElement.setText("text"); // 同样修改标签内的文本也一样
			System.out.println("根节点修改之后的文本：" + rootElement.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	     
}
