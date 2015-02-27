package mailReport;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;


import java.util.*;

public class SendMail
{

    //reportFileName = TestExecutionResultFileName
    public static void execute(String reportFileName) throws Exception

    {
        String path ="D:\\AgorafyGit\\AgrofyAutomation\\AgorafyAutomation\\test-output\\emailable-report.html";
        //Report file = path&gt;

        String[] to={"ashishpatil227@gmail.com"};
        String[] cc={};
        String[] bcc={};

        SendMail.sendMail("ashish.patil@cuelogic.co.in",
                            "1qaz!QAZ@WSX",
                            "smtp.gmail.com",
                            "465",
                            "true",
                            "true",
                             true,
                            "javax.net.ssl.SSLSocketFactory",
                            "false",
                             to,
                             cc,
                             bcc,
                            "Test Report",
                            "Greetings, This Auto-generated report please do not reply",
                            path,
                            reportFileName);
      }

      public  static boolean sendMail(String userName,
                String passWord,
                String host,
                String port,
                String starttls,
                String auth,
                boolean debug,
                String socketFactoryClass,
                String fallback,
                String[] to,
                String[] cc,
                String[] bcc,
                String subject,
                String text,
                String attachmentPath,
                String attachmentName){

        //Object Instantiation of a properties file.
        Properties props = new Properties();

        props.put("mail.smtp.user", userName);

        props.put("mail.smtp.host", host);

        if(!"".equals(port)){
        props.put("mail.smtp.port", port);
        }

        if(!"".equals(starttls)){
            props.put("mail.smtp.starttls.enable",starttls);
            props.put("mail.smtp.auth", auth);
        }

        if(debug){

        props.put("mail.smtp.debug", "true");

        }else{

        props.put("mail.smtp.debug", "false");

        }

        if(!"".equals(port)){
            props.put("mail.smtp.socketFactory.port", port);
        }
        if(!"".equals(socketFactoryClass)){
            props.put("mail.smtp.socketFactory.class",socketFactoryClass);
        }
        if(!"".equals(fallback)){
            props.put("mail.smtp.socketFactory.fallback", fallback);
        }

        try{

            Session session = Session.getDefaultInstance(props, null);

            session.setDebug(debug);

            MimeMessage msg = new MimeMessage(session);
            
            msg.setText(text);

            msg.setSubject(subject);

            Multipart multipart = new MimeMultipart();
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            
            DataSource source = new FileDataSource(attachmentPath);
            
            String htmlFile = source.toString();
            
            System.out.println("html file.........................." + htmlFile);
            
            DataSource CSSsource = new FileDataSource("D:\\AgorafyGit\\AgrofyAutomation\\AgorafyAutomation\\test-output\\testng-reports.css");
            
            String cssFile = CSSsource.toString();
            
            System.out.println("css file......................." +cssFile);
            
            //htmlFile.concat("<style>");
            
            String totalData = htmlFile; 
            		
            
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(attachmentName);
            multipart.addBodyPart(messageBodyPart);

            System.out.println("messageBodyPart............." +messageBodyPart);
            
            msg.setContent(multipart);
            
            System.out.println("multipart..................."+multipart);
            
            msg.setFrom(new InternetAddress(userName));

            for(int i=0;i<to.length;i++){
                msg.addRecipient(Message.RecipientType.TO, new
InternetAddress(to[i]));
            }

            for(int i=0;i<cc.length;i++){
                msg.addRecipient(Message.RecipientType.CC, new
InternetAddress(cc[i]));
            }

            for(int i=0;i<bcc.length;i++){
                msg.addRecipient(Message.RecipientType.BCC, new
InternetAddress(bcc[i]));
            }

            msg.saveChanges();

            System.out.println("msg...................."+msg);
            
            Transport transport = session.getTransport("smtp");

            transport.connect(host, userName, passWord);

            transport.sendMessage(msg, msg.getAllRecipients());

            transport.close();

            return true;

        } catch (Exception mex){
            mex.printStackTrace();
            return false;
        }
    }
}
