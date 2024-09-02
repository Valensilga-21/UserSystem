package com.sena.User_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.sena.User_system.models.usuario;

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

    public String cambiarTipoDocumento(usuario usuario){
        try{
            String asunto = "¡Hola "+ usuario.getNombre_completo() + "!";
            String cuerpo = ""
            + "<!DOCTYPE html>\r\n"
            + "<html lang=\"en\">\r\n"
            + "<head>\r\n"
            + "    <meta charset=\"UTF-8\">\r\n"
            + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
            + "    <title>Actualizar Documento</title>\r\n"
            + "    <script src=\"https://unpkg.com/boxicons@2.1.4/dist/boxicons.js\"></script>\r\n"
            + "    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>\r\n"
            + "    <link rel=\"stylesheet\" href=\"../css/bootstrap.css\">\r\n"
            + "    <script src=\"../js/bootstrap.js\"></script>\r\n"
            + "</head>\r\n"
            + "<body>\r\n"
            + "  <div class=\"container-fluid py-4\" style=\"width: 80rem;\">\r\n"
            + "    <h1 class=\"display-5 fw-bold\">Es hora de actualizar tu tipo de documento</h1>\r\n"
            + "    <p class=\"col-md-8 fs-4\">Queremos recordarte que es momento de actualizar tu tipo de documento.</p>\r\n"
            + "    <p class=\"col-md-8 fs-4\">Accede a tu cuenta en nuestra plataforma y realiza el cambio de tarjeta de identidad a cédula.</p>\r\n"
            + "    <p class=\"col-md-8 fs-4\">Gracias por su colaboración.</p>\r\n"
            + "    <ul class=\"nav col-md-5 justify-content-start list-unstyled d-flex\">\r\n"
            + "      <li class=\"ms-3\"><box-icon name='facebook' type='logo'></box-icon></li>\r\n"
            + "      <li class=\"ms-3\"><box-icon name='instagram' type='logo'></box-icon></li>\r\n"
            + "      <li class=\"ms-3\"><box-icon name='twitter' type='logo'></box-icon></li>\r\n"
            + "    </ul>\r\n"
            + "  </div>\r\n"
            + "</div>\r\n"
            + "</body>\r\n"
            + "</html>";

            var retorno=enviarCorreo(usuario.getCorreo(),asunto,cuerpo);
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
    
    public String enviarCorreoCambiarContra(usuario usuario){
        try{
            String asunto = "¡Hola!";
            String cuerpo = ""
            + "<!DOCTYPE html>\r\n"
            + "<html lang=\"en\">\r\n"
            + "<head>\r\n"
            + "    <meta charset=\"UTF-8\">\r\n"
            + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
            + "    <title>Cambiar Contraseña</title>\r\n"
            + "    <script src=\"https://unpkg.com/boxicons@2.1.4/dist/boxicons.js\"></script>\r\n"
            + "    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>\r\n"
            + "    <link rel=\"stylesheet\" href=\"../css/bootstrap.css\">\r\n"
            + "    <script src=\"../js/bootstrap.js\"></script>\r\n"
            + "</head>\r\n"
            + "<body>\r\n"
            + "  <div class=\"container-fluid py-4\" style=\"width: 80rem;\">\r\n"
            + "    <h1 class=\"display-5 fw-bold\">Cambiar Contraseña</h1>\r\n"
            + "    <p class=\"col-md-8 fs-4\">Es hora de cambiar tu contraseña.</p>\r\n"
            + "    <p class=\"col-md-8 fs-4\">Por motivos de seguridad, te pedimos que cambies tu contraseña actual por una nueva.</p>\r\n"
            + "    <p class=\"col-md-8 fs-4\">Haz clic en el siguiente enlace para cambiar tu contraseña:</p>\r\n"
            + "    <a href=\"#\" class=\"btn btn-success\">Cambiar Contraseña</a>\r\n"
            + "    <ul class=\"nav col-md-5 justify-content-start list-unstyled d-flex\" style=\"padding-top: 2%;\">\r\n"
            + "        <li class=\"ms-3\"><box-icon name='facebook' type='logo'></box-icon></li>\r\n"
            + "        <li class=\"ms-3\"><box-icon name='instagram' type='logo'></box-icon></li>\r\n"
            + "        <li class=\"ms-3\"><box-icon name='twitter' type='logo'></box-icon></li>\r\n"
            + "      </ul>\r\n"
            + "  </div>\r\n"
            + "</body>\r\n"
            + "</html>";
            

            var retorno=enviarCorreo(usuario,asunto,cuerpo);
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
    
    public String iniciosesionNotificar(String destinatario){
        try{
            String asunto = "¡Hola!";
            String cuerpo = ""
            + "<!DOCTYPE html>\r\n"
            + "<html lang=\"en\">\r\n"
            + "<head>\r\n"
            + "    <meta charset=\"UTF-8\">\r\n"
            + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
            + "    <title>Activar Cueta</title>\r\n"
            + "    <script src=\"https://unpkg.com/boxicons@2.1.4/dist/boxicons.js\"></script>\r\n"
            + "    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>\r\n"
            + "    <link rel=\"stylesheet\" href=\"../css/bootstrap.css\">\r\n"
            + "    <script src=\"../js/bootstrap.js\"></script>\r\n"
            + "</head>\r\n"
            + "<body>\r\n"
            + "  <div class=\"container-fluid py-4\" style=\"width: 80rem;\">\r\n"
            + "    <h1 class=\"display-5 fw-bold\">Tu cuenta ha sido bloqueada</h1>\r\n"
            + "    <p class=\"col-md-8 fs-4\">Te informamos que tu cuenta ha sido bloqueada temporalmente.</p>\r\n"
            + "    <p class=\"col-md-8 fs-4\">Para volver a activar la cuenta, has clic en el siguiente botón:</p>\r\n"
            + "    <a href=\"#\" class=\"btn btn-success\">Activar</a>\r\n"
            + "    <ul class=\"nav col-md-5 justify-content-start list-unstyled d-flex\" style=\"padding-top: 2%;\">\r\n"
            + "        <li class=\"ms-3\"><box-icon name='facebook' type='logo'></box-icon></li>\r\n"
            + "        <li class=\"ms-3\"><box-icon name='instagram' type='logo'></box-icon></li>\r\n"
            + "        <li class=\"ms-3\"><box-icon name='twitter' type='logo'></box-icon></li>\r\n"
            + "      </ul>\r\n"
            + "  </div>\r\n"
            + "</body>\r\n"
            + "</html>";
            

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
	
    public boolean enviarCorreo(String destinatario, String asunto, String cuerpo) throws MessagingException {
		try {
			MimeMessage message=javaMailSender.createMimeMessage();
			MimeMessageHelper helper=new MimeMessageHelper(message,true);
			
			helper.setSubject("gonzalezcalderonmariana@gmail.com");
			helper.setSubject(asunto);
			helper.setText(cuerpo,true);
			
			javaMailSender.send(message);
			return true;
		}catch (Exception e) {

			return false;
		}
		
	}
}
