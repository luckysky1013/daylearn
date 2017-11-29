package com.rabbitmq.demo.workqueue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.util.concurrent.TimeoutException;

public class Work {
    // 队列名称
    private final static String QUEUE_NAME = "workqueue_persistence";

    public static void main(String[] argv) throws java.io.IOException,
            java.lang.InterruptedException, TimeoutException {
        // 区分不同工作进程的输出
        int hashCode = Work.class.hashCode();
        // 创建连接和频道
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        // 声明队列
        boolean durable = true;
        channel.queueDeclare(QUEUE_NAME, durable, false, false, null);
        System.out.println(hashCode
                + " [*] Waiting for messages. To exit press CTRL+C");
        //设置最大服务转发消息数量
        //这样告诉RabbitMQ不要在同一时间给一个消费者超过一条消息。
        int prefetchCount = 1;
        // 换句话说，只有在消费者空闲的时候会发送下一条信息。
        channel.basicQos(prefetchCount);
        QueueingConsumer consumer = new QueueingConsumer(channel);
        // 指定消费队列
        // 打开应答机制  手动应答
        boolean ack = false;
        channel.basicConsume(QUEUE_NAME, ack, consumer);
        while (true)
        {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());

            System.out.println(hashCode + " [x] Received '" + message + "'");
            doWork(message);
            System.out.println(hashCode + " [x] Done");
            //另外需要在每次处理完成一个消息后，手动发送一次应答。
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);

        }

    }

    /**
     * 每个点耗时1s
     *
     * @param task
     * @throws InterruptedException
     */
    private static void doWork(String task) throws InterruptedException
    {
        for (char ch : task.toCharArray())
        {
            if (ch == '.'){
                Thread.sleep(1000);
            }
        }
    }
}
