package com.sena.User_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.User_system.IService.IUsuarioService;
import com.sena.User_system.interfaces.IUsuario;
import com.sena.User_system.models.usuario;

@Service
public class usuarioService implements IUsuarioService{
	
	@Autowired
	private IUsuario data;
	
	@Override
	public String save(usuario usuario) {
		data.save(usuario);
		return usuario.getId_usuario();
	}


	@Override
	public List<usuario> findAll() {
		List<usuario> ListaUsuario=
		(List<usuario>) data.findAll();
		return ListaUsuario;
	}

	@Override
	public Optional<usuario> findOne(String id) {
		Optional<usuario> usuario=data.findById(id);
		return usuario;
	}


	@Override
	public int delete(String id_usuario) {
	    try {
	        data.deleteById(id_usuario);
	        return 1;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return 0;
	    }
	}
	
	@Override
    public Optional<usuario> findBycorreo(String correo) {
        return data.findBycorreo(correo);
    }
}
