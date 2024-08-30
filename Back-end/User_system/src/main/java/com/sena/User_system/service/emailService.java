package com.sena.User_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class emailService {

	@Autowired
    private JavaMailSender javaMailSender;

    public String enviarCorreoBienvenida(String destinatario){
        try{
            String asunto = "¡Hola!";
            String cuerpo = ""
            + "<body"
            + "<div class=\"container-fluid py-4\" style=\"width: 75rem;\">\r\n"
            + "  <h1 class=\"display-5 fw-bold\">Bienvenid@ a nuestra plataforma</h1>\r\n"
            + "  <p class=\"col-md-8 fs-4\">Nos alegra que estés aquí, nuestra plataforma está diseña para ofrecerte múltiples experiencias. \r\n"
            + "  Síguenos en nuestras redes sociales y disfruta de los servicios que tenemos para ti.</p>\r\n"
            + "  <ul class=\"nav col-md-5 justify-content-start list-unstyled d-flex\">\r\n"
            + "    <li class=\"ms-3\"><box-icon name='facebook' type='logo'></box-icon></li>\r\n"
            + "    <li class=\"ms-3\"><box-icon name='instagram' type='logo'></box-icon></li>\r\n"
            + "    <li class=\"ms-3\"><box-icon name='twitter' type='logo'></box-icon></li>\r\n"
            + "  </ul>\r\n"
            + "</div>\r\n"
            + "</div>\r\n"
            + "<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>"
            + "<script src=\"https://unpkg.com/boxicons@2.1.4/dist/boxicons.js\"></script>\r\n"
            + "</body>";
            

            var retorno=enviarCorreo(destinatario,asunto,cuerpo);
            if(retorno) {
                return "se envió correctamente";
            }else {
                return "No se pudo envíar";
            }

        }catch (Exception e) {
            // TODO: handle exception
            return "Error al envíar "+e.getMessage();
        }
    }
	
	public boolean enviarCorreo(String destinatario,String asunto,String cuerpo) throws MessagingException {
        try {
            MimeMessage message=javaMailSender.createMimeMessage();
            MimeMessageHelper helper=new MimeMessageHelper(message,true);
            
            helper.setTo(destinatario);
            helper.setSubject(asunto);
            helper.setText(cuerpo,true);
            
            javaMailSender.send(message);
            return true;
        }catch (Exception e) {

            return false;
        }
    }
}
