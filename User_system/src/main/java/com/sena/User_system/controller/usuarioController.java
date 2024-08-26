package com.sena.User_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.User_system.IService.IUsuarioService;
import com.sena.User_system.models.usuario;

@RequestMapping("/api/v1/usuario")
@RestController
@CrossOrigin
public class usuarioController {
	@Autowired
	private IUsuarioService usuarioService;
	
	@PostMapping("/")
    public ResponseEntity<Object> save(@RequestBody usuario usuario) {


        if (usuario.getNombre_completo().equals("")) {
            
            return new ResponseEntity<>("El nombre es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }

        if (usuario.getTipo_doc().equals("")) {
            
            return new ResponseEntity<>("El tipo de documento es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }

        if (usuario.getNumero_doc() == 0) {
            return new ResponseEntity<>("El número de documento es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }

        if (usuario.getFecha_nac().equals("")) {
            
            return new ResponseEntity<>("La fecha de nacimiento es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }
        
        if (usuario.getCorreo().equals("")) {
            
            return new ResponseEntity<>("El correo es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }
        
        if (usuario.getContraseña().equals("")) {
            
            return new ResponseEntity<>("La contraseña es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }
        
        if (usuario.getFecha_actualizacion().equals("")) {
            
            return new ResponseEntity<>("La fecha de actualizacion es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }
        
        if (usuario.getFecha_inicio_sesion().equals("")) {
            
            return new ResponseEntity<>("La fecha de actualizacion es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }
        
        if (!usuario.isCampo_notificacion()) {
            return new ResponseEntity<>("La notificacion es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }
        
        if (usuario.getEstado().equals("")) {
            
            return new ResponseEntity<>("La fecha de actualizacion es un campo obligatorio", HttpStatus.BAD_REQUEST);
        }
        
        usuarioService.save(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.OK);

    }
	
	@GetMapping("/")
	public ResponseEntity<Object> findAll(){
		var ListaUsuario=usuarioService.findAll();
		return new ResponseEntity<>(ListaUsuario,HttpStatus.OK);
	}
	
	@GetMapping("/{id_usuario}")
	public ResponseEntity<Object> findOne(@PathVariable String id_usuario){
		var usuario=usuarioService.findOne(id_usuario);
		return new ResponseEntity<>(usuario,HttpStatus.OK);
	}
	
	/*
	@GetMapping("/busqueda/{filtro}")
	public ResponseEntity<Object> findFiltro(@PathVariable String filtro){
	var ListaLibro=libroService.filtroLibro(filtro); 
	return new ResponseEntity<>(ListaLibro,HttpStatus.OK);
	}*/
	
	@DeleteMapping("/{id_usuario}")
	public ResponseEntity<Object> delete(@PathVariable String id_usuario){
		usuarioService.delete(id_usuario);
		return new ResponseEntity<>("Registro eliminado",HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable String id, @RequestBody usuario usuarioUpdate){
		var usuario=usuarioService.findOne(id).get();
		if (usuario != null) {
			usuario.setNombre_completo(usuarioUpdate.getNombre_completo());
			usuario.setTipo_doc(usuarioUpdate.getTipo_doc());
			usuario.setNumero_doc(usuarioUpdate.getNumero_doc());
			usuario.setFecha_nac(usuarioUpdate.getFecha_nac());
			usuario.setCorreo(usuarioUpdate.getCorreo());
			usuario.setContraseña(usuarioUpdate.getContraseña());
			usuario.setFecha_actualizacion(usuarioUpdate.getFecha_actualizacion());
			usuario.setFecha_inicio_sesion(usuarioUpdate.getFecha_inicio_sesion());
			usuario.setCampo_notificacion(usuarioUpdate.isCampo_notificacion());
			usuario.setEstado(usuarioUpdate.getEstado());

			usuarioService.save(usuario);
			return new ResponseEntity<>(usuario,HttpStatus.OK);
		}
		else {
		return new ResponseEntity<>("Error, usuario no encontrado",HttpStatus.BAD_REQUEST);
		}
	}
}
