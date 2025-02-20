package ListenerDemo;

public class SendMailSSL {
    public static void main(String[] args) {
        // Replace "from@gmail.com", "password", and "to@gmail.com" with real credentials
        String fromEmail = "maliniansut@gmail.com";
        String password = "your-app-password";  // Replace this with your generated app password
        String toEmail = "to@gmail.com";
        String subject = "Hello Java";
        String message = "How are you?";

        // Send the email
        Mailer.send(fromEmail, password, toEmail, subject, message);
    }
}
