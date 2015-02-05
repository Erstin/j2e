package supsms.reader;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author ___Cid___
 */
public class SupSMSReader {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
            throws NamingException, JMSException {

        Connection connection = null;
        try {
            Context context = new InitialContext();
            ConnectionFactory connectionFactory
                    = (ConnectionFactory) context.lookup("Connection-factory");
            Destination destination = (Destination) context.lookup("queue/supsms");
            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageConsumer messageConsumer = session.createConsumer(destination);

            connection.start();

            while (true) {
                Message message = messageConsumer.receive();
                if (message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) message;
                    System.out.println(textMessage.getText());
                }
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            if(connection != null) {
                connection.close();
            }
        }
    }

}
