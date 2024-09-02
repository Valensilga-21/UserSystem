package com.sena.User_system.interfaces;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sena.User_system.models.usuario;

@Repository
public interface IUsuario extends CrudRepository<usuario,String>{
	
	@Query("SELECT u FROM usuario u WHERE u.correo = ?1")
	Optional<usuario> findBycorreoElectronico(String correo);

	@Query ("SELECT u FROM usuario u WHERE TIMESTAMPDIFF(YEAR, u.fecha_nac, CURDATE())>=18 AND u.tipo_doc = 'TI'")
    List<usuario> cambiarTipoDocumento();

	@Query("SELECT u FROM usuario u WHERE  DATEDIFF(NOW(), u.fecha_actualizacion) >= 90")
    List<usuario> enviarCorreoCambiarContra(String enviarCorreoCambiarContra);
	
	@Query("SELECT u FROM usuario u WHERE  DATEDIFF(NOW(), u.fecha_inicio_sesion) >= 30")
    List<usuario> iniciosesionNotificar(String iniciosesionNotificar);
}
