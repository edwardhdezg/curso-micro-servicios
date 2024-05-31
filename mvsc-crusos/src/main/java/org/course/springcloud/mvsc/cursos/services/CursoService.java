package org.course.springcloud.mvsc.cursos.services;

import org.course.springcloud.mvsc.cursos.models.Usuario;
import org.course.springcloud.mvsc.cursos.models.entity.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {

    List<Curso> listar();
    Optional<Curso> buscarPorId(Long id);
    Curso guardar(Curso curso);
    void eliminar(Long id);

    //Metodos que estaran en comunicacion  con el otro servicio :
    //Asignar usuarios a unn curso, crear un usuario en caso de que no eista, eliminar un usuario de unn curso(no de la bd de usuarios)
    //Simulando que desde el controlador se manda el primer parametro @Requestbody y el segundo @Pathvariable
    Optional<Usuario> asignarUsuario(Usuario usuario, Long cursoId);
    Optional<Usuario> crearUsuario(Usuario usuario, Long cursoId);
    Optional<Usuario> eliminarUsuario(Usuario usuario, Long cursoId);
    Optional<Curso> porIdConUsuarios(Long id);
    void eliminarCursoUsuarioPorId(Long id);


}
