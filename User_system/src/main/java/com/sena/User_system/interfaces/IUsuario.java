package com.sena.User_system.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sena.User_system.models.usuario;

@Repository
public interface IUsuario extends CrudRepository<usuario,String>{

}
