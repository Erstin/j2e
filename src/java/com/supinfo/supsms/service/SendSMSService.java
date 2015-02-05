package com.supinfo.supsms.service;

import com.supinfo.supsms.entity.SMS;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 *
 * @author ___Cid___
 */
@Stateless
public class SendSMSService {
    
    @Resource(mappedName = "Connection-factory")
    private ConnectionFactory connectionFactory;
    
    @Resource(mappedName = "queue/supsms")
    private Destination destination;
    
    private final String separatorMessage = System.lineSeparator();
    
    public void send(SMS sms)
    throws JMSException {
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        TextMessage textMessage = session.createTextMessage(buildMessage(sms));
                        
        MessageProducer messageProducer = session.createProducer(destination);
        messageProducer.send(textMessage);
    }

    private String buildMessage(SMS sms) {
        StringBuilder builder = new StringBuilder();
        
        builder.append(sms.getSender().getPhoneNumber());
        builder.append(separatorMessage);
        builder.append(sms.getMessage());
        builder.append(separatorMessage);
        builder.append(sms.getReceiver().getPhoneNumber());
        
        return builder.toString();
    }
}
