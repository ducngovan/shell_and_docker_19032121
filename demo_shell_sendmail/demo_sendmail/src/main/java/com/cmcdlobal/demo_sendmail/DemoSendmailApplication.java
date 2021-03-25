package com.cmcdlobal.demo_sendmail;

import org.w3c.dom.ls.LSParserFilter;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;


public class DemoSendmailApplication {

    public static void main(String args[]) throws AddressException, MessagingException {
        sendText();
    }

    public static void sendText() throws AddressException, MessagingException {
        Properties mailServerProperties;
        Session getMailSession;
        MimeMessage mailMessage;

        // Step1: setup Mail Server
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");

        // Step2: get Mail Session
        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        mailMessage = new MimeMessage(getMailSession);

        mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("ngoducnk@gmail.com")); //địa chỉ người nhận

        // Bạn có thể chọn CC, BCC
//    generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("cc@gmail.com")); //Địa chỉ cc gmail

// get time
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String strDate = dateFormat.format(date);
//

		mailMessage.setSubject("Demo send gmail from Java " + strDate);


        // Tạo phần gửi message
        BodyPart messagePart = new MimeBodyPart();
        messagePart.setText("Demo send text by gmail from Java");

        // Tạo phần gửi file
        BodyPart filePart = new MimeBodyPart();
        File file = new File("/shell/itemjava.txt");
        DataSource source = new FileDataSource(file);
        filePart.setDataHandler(new DataHandler(source));
        filePart.setFileName(file.getName());

        // Gộp message và file vào để gửi đi
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messagePart);
        multipart.addBodyPart(filePart);
        mailMessage.setContent(multipart );


        // Step3: Send mail
        Transport transport = getMailSession.getTransport("smtp");

        // Thay your_gmail thành gmail của bạn, thay your_password thành mật khẩu gmail của bạn
        transport.connect("smtp.gmail.com", "nickname96bn@gmail.com", "0904955121aA@");
        transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
        transport.close();
    }

}
