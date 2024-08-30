package com.sena.User_system.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sena.User_system.models.usuario;

@Repository
public interface IUsuario extends CrudRepository<usuario,String>{
	
	@Query("SELECT u FROM usuario u WHERE u.correo = ?1")
	Optional<usuario> findBycorreoElectronico(String correo);
}
