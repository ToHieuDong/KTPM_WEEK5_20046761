package com.example.mq;

import com.example.mq.entity.Student;
import jakarta.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;

import java.util.List;


public class Receiver {
    public static void main(String[] args) throws Exception {
//        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");



        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        Connection connection = factory.createConnection();



        Session sesion = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        connection.start();

        Destination destination = sesion.createQueue("dynamic/Gnoodd");
        MessageConsumer consumer = sesion.createConsumer(destination);

        factory.setTrustedPackages(List.of("com.example.mq.entity"));
        System.out.println("Waiting....");

        consumer.setMessageListener(message -> {
            try {
                if (message instanceof TextMessage) {
                    String mess = ((TextMessage) message).getText();
                    System.out.println(mess);
                } else if (message instanceof ObjectMessage) {
                    Student st = message.getBody(Student.class);
                    System.out.println(st);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


    }
}
