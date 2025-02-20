package ListenerDemo;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class Mailer {

    public static void send(String from, String password, String to, String sub, String msg) {
        // Get properties object
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        // Get Session
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                // No need to convert password to char array here, just use string
                return new PasswordAuthentication(from, password);  // Password as string
            }
        });

        // Compose message
        try {
            // Make sure the MimeMessage constructor gets the correct Session object
            MimeMessage message = new MimeMessage(session);

            // Add the recipient and the message content
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(sub);
            message.setText(msg);

            // Send the email
            Transport.send(message);
            System.out.println("Message sent successfully");
        } catch (MessagingException e) {
            // Handle any messaging exceptions that may occur
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        // Replace these with actual values
        String fromEmail = "maliniansut@gmail.com";  // Your email
        String password = "123@Malini";  // Use your Gmail App Password if 2FA is enabled
        String toEmail = "maliniansu@gmail.com";  // Recipient's email
        String subject = "Hello Java";
        String message = "How are you?";

        // Send the email using the send() method
        send(fromEmail, password, toEmail, subject, message);
    }
}


