package com.example.mq;

import com.example.mq.entity.Student;
import jakarta.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;

import java.util.List;

public class Sender {
    public static void main(String[] args) throws JMSException {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();

        Connection connection = factory.createConnection();



        Session sesion = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        connection.start();

        Destination destination = sesion.createQueue("dynamic/Gnoodd");
        MessageProducer producer = sesion.createProducer(destination);


        factory.setTrustedPackages(List.of("com.example.mq.entity"));
        System.out.println("Waiting....");

        for (int i = 0; i < 10; i++) {
            TextMessage message = sesion.createTextMessage("Mess" + i);
            producer.send(message);
        }

        Student st = new Student("20046761", "ToHieuDong");
        ObjectMessage message = sesion.createObjectMessage(st);
        producer.send(message);

        System.out.println("sending....");
    }
}
