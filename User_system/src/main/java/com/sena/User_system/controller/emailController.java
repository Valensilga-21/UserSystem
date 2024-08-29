package com.sena.User_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;


@RestController
public class emailController {

	@Autowired
    private JavaMailSender javaMailSender;
	
	@GetMapping("/enviar-correo-registro")
    public String enviarCorreoRegistro() {
       try{
            String destinatario="billgav.04@gmail.com";
            String asunto="¡Bienvenid@ a nuestra plataforma!";
            String cuerpo=""
            + "    <p>Nos complace darte la bienvenida a TuTurismo Neiva, la plataforma ideal para descubrir los encantos de Neiva.</p>"
            + "    <p>En TuTurismoNeiva encontrarás todo lo que necesitas para conocer la cultura Neivana, desde información sobre lugares de interés y su ubicación.</p>"
            + "    <p>¡Estamos seguros de que TuTurismo Neiva te ayudará a vivir una experiencia inolvidable en Neiva!</p>"
            + "    <p>¡No dudes en contactarnos si tienes alguna pregunta!</p>"
            + "    <p>Gracias por unirte a nosotros.No olvides seguirnos en nuestras redes sociales.</p>";
        
            var retorno=enviarCorreo(destinatario,asunto,cuerpo);
            if(retorno) {
                return "se envió correctamente";
            }else {
                    return "No se pudo envíar";
            }

        }catch (Exception e) {
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
            System.out.println(e);
			return false;
		}
		
	}
}
