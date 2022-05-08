package o0pavel0o.buycars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@RestController
public class EmailService {
	


	@Autowired
	private MailSender mailSender;

    @PostMapping(
    		value = "/email",
    		produces = MediaType.APPLICATION_JSON_VALUE)
    public String enviar(@RequestBody Email email) {
    	SimpleMailMessage msg = new SimpleMailMessage();
        msg.setText(email.getComentario());
        msg.setSubject(email.getAsunto());
        msg.setTo(email.getPara());
        msg.setFrom("compraenbuycars@gmail.com");
        mailSender.send(msg);
           
           return "email_enviado.html";
    }
    
    
	}

