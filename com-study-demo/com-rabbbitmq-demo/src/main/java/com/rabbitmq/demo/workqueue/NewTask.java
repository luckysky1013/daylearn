package com.rabbitmq.demo.workqueue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class NewTask {
    //队列名称
    private final static String QUEUE_NAME = "workqueue";

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //配置工厂的主机地址、用户名、密码、端口号
        factory.setHost("localhost");
        factory.setUsername("demo");
        factory.setPassword("demo");
        factory.setPort(15672);
        //创建一个连接对象
        Connection connection = factory.newConnection();
        //创建频道
        Channel channel = connection.createChannel();
        // 声明队列
        // 1、设置队列持久化
        boolean durable = true;
        channel.queueDeclare(QUEUE_NAME, durable, false, false, null);
        //发送10条消息，依次在消息后面附加1-10个点
        for (int i = 0; i < 10; i++)
        {
            String dots = "";
            for (int j = 0; j <= i; j++)
            {
                dots += ".";
            }
            String message = "helloworld" + dots+dots.length();
            //通过频道发布消息到指定的队列
            // MessageProperties 2、设置消息持久化
            channel.basicPublish("", QUEUE_NAME,
                    MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
        //关闭频道和资源
        channel.close();
        connection.close();

    }
}
