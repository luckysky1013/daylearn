package com.demo.rabbitmq.helloworld;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class ReceiveDemo {
	private static final String QUEUE_NAME="hello";
	
	public static void main(String[] args) throws Exception, TimeoutException {
		//创建连接工厂
		ConnectionFactory factory=new ConnectionFactory();
		factory.setHost("localhost");
		//获取连接对象
		Connection connection=factory.newConnection();
		//获取频道对象
		Channel channel=connection.createChannel();
		//声明指定队列
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		//创建消费者对象
		QueueingConsumer consumer=new QueueingConsumer(channel);
		//绑定队列和消费者
		channel.basicConsume(QUEUE_NAME, consumer);
		
		while(true){
			//消费获取消息内容
			//nextDelivery是一个阻塞方法（内部实现其实是阻塞队列的take方法） 
			QueueingConsumer.Delivery delivery=consumer.nextDelivery();
			String message=new String(delivery.getBody());
			System.out.println("[x] received "+message+"  success");
			
		}
	}
}
