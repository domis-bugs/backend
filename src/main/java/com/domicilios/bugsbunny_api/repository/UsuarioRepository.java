package com.domicilios.bugsbunny_api.repository;
import com.domicilios.bugsbunny_api.model.entity.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Transactional
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    @Query("FROM Usuario u WHERE u.email = :email")
    List<Usuario> findByEmail(@Param("email") String email);
}
