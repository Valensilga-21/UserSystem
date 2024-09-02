package com.sena.User_system.Task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.sena.User_system.models.usuario;
import com.sena.User_system.service.emailService;
import com.sena.User_system.service.usuarioService;

@Component
public class Task {
    
    @Autowired
    private usuarioService data;

    @Autowired
    private emailService email;
    
    
    @Scheduled(cron = "0 0 8 * * *")
    public void sendNotificationcron() {
        var ListaUsuario = data.cambiarTipoDocumento();
        for (usuario usuario : ListaUsuario) {
            System.out.println("usuario que requiere actualizar documento " + 
            usuario.getNombre_completo());
            email.enviarCorreoCambiarContra(usuario);
        }
    }
    
    @Scheduled(cron = "12 13 * * * *")
    public void sendPasswordExpirationNotifications() {
        var ListaUsuario = data.enviarCorreoCambiarContra();
        for (usuario usuario : ListaUsuario) {
            System.out.println("usuario que requiere actualizar documento " + 
            usuario.getNombre_completo());
            email.enviarCorreoCambiarContra(usuario);
        }
    }
    
    @Scheduled(cron = "0 0 0 * * 0")
    public void blockInactiveUsers() {
    List<usuario> inactiveUsers = data.iniciosesionNotificar();
    for (usuario usuario : inactiveUsers) {
        System.out.println("usuario inactivo: " + usuario.getNombre_completo());
        usuario.setEstado("INACTIVO");
        data.save(usuario);
        email.iniciosesionNotificar(usuario.getCorreo());
    	}
    }
}
