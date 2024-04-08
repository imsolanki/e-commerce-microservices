package com.codemagic.notificationservice.service;

import com.codemagic.orderservice.dto.OrderEvent;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {
    public static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    private KafkaTemplate<String,OrderEvent> kafkaTemplate;
    @Autowired
    public OrderConsumer(KafkaTemplate<String, OrderEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(OrderEvent orderEvent){
        LOGGER.info(String.format("OrderDto Event Received in email-service - > %s ", ToStringBuilder
                .reflectionToString(orderEvent)));
        //send email to the customer --> To be implemented later

    }

//    private void sendEmailToCustomer(OrderEvent orderEvent) {
//        // Configure mail server properties
//        Properties properties = new Properties();
//        properties.put("mail.smtp.host", "your-smtp-host");
//        properties.put("mail.smtp.port", "587"); // Port may vary based on your SMTP provider
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls.enable", "true");
//
//        // Set username and password for authentication
//        String username = "your-email@example.com";
//        String password = "your-email-password";
//
//        // Create a session with authentication
//        Session session = Session.getInstance(properties, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(username, password);
//            }
//        });
//
//        try {
//            // Create a MIME message
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(username));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(orderEvent.getCustomerEmail()));
//            message.setSubject("Your Order Details");
//            message.setText("Dear Customer,\n\nYour order details: " + orderEvent.toString());
//
//            // Send the message
//            Transport.send(message);
//
//            LOGGER.info("Email sent successfully to customer: {}", orderEvent.getCustomerEmail());
//        } catch (MessagingException e) {
//            LOGGER.error("Error sending email to customer: {}", e.getMessage());
//        }
//    }

}
