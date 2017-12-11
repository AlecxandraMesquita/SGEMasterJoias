package br.sgemasterjoias.util;


import br.sgemasterjoias.util.MailSender;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "mailgctr")
@SessionScoped
public class MainController implements Serializable {

	private static final long serialVersionUID = -7367495919466412488L;
	
	private String fromMail;
    private String username;
    private String password;
    private String toMail;
    private String subject;
    private String message;

    public String getFromMail() {
        return fromMail;
    }

    public void setFromMail(String fromMail) {
        this.fromMail = fromMail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToMail() {
        return toMail;
    }

    public void setToMail(String toMail) {
        this.toMail = toMail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void send() {
        try {
            MailSender mailSender=new MailSender();
            mailSender.sendMail(fromMail, username, password, toMail, subject, message);
        } catch (Exception e) {
        }
    }
}