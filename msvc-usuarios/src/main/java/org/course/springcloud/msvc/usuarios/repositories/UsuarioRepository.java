package org.course.springcloud.msvc.usuarios.repositories;

import org.course.springcloud.msvc.usuarios.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario,Long> {
    Optional<Usuario> findByEmail(String email);


}
