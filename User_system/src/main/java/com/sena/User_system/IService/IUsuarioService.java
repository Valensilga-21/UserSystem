package com.sena.User_system.IService;

import java.util.List;
import java.util.Optional;

import com.sena.User_system.models.usuario;

public interface IUsuarioService {
	
	public String save(usuario usuario);
	public List<usuario> findAll();
	public Optional<usuario> findOne(String id_usuario);
	public int delete(String id_usuario);
	public Optional<usuario> findBycorreo(String correo);
}
