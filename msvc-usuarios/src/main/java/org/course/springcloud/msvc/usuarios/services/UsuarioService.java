package org.course.springcloud.msvc.usuarios.services;

import org.course.springcloud.msvc.usuarios.models.entity.Usuario;
import org.hibernate.dialect.function.ListaggStringAggEmulation;

import java.util.List;
import java.util.Optional;

public interface  UsuarioService {
    List<Usuario> listar();
    Optional<Usuario> obtenerPorId(Long id);
    Usuario guardar(Usuario usuario);
    void eliminar(Long id);
    List<Usuario> listarPorIds(Iterable<Long> ids);

    Optional<Usuario> findByEmail(String email);
}
