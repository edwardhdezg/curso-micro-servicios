package org.course.springcloud.mvsc.cursos.services;

import org.course.springcloud.mvsc.cursos.clients.UsuarioClientRest;
import org.course.springcloud.mvsc.cursos.models.Usuario;
import org.course.springcloud.mvsc.cursos.models.entity.Curso;
import org.course.springcloud.mvsc.cursos.models.entity.CursoUsuario;
import org.course.springcloud.mvsc.cursos.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CursoServiceImpl implements  CursoService{

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioClientRest usuarioClientRest;

    @Override
    @Transactional(readOnly = true)
    public List<Curso> listar() {
        return (List<Curso>) cursoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Curso> buscarPorId(Long id) {
        return cursoRepository.findById(id);
    }

    @Override
    @Transactional
    public Curso guardar(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        cursoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<Usuario> asignarUsuario(Usuario usuario, Long cursoId) {
        Optional<Curso> cursoDb= cursoRepository.findById(cursoId);
        if (cursoDb.isPresent()){
            Usuario usuarioMvsc = usuarioClientRest.detalle(usuario.getId());

            Curso curso= cursoDb.get();
            CursoUsuario cursoUsuario= new CursoUsuario();
            cursoUsuario.setUsuarioId(usuarioMvsc.getId());

            curso.addCursoUsuario(cursoUsuario);
            cursoRepository.save(curso);
            return Optional.of(usuarioMvsc);
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<Usuario> crearUsuario(Usuario usuario, Long cursoId) {
        Optional<Curso> cursoDb= cursoRepository.findById(cursoId);
        if (cursoDb.isPresent()){
            Usuario usuarioNuevoMvsc = usuarioClientRest.crear(usuario);

            Curso curso= cursoDb.get();
            CursoUsuario cursoUsuario= new CursoUsuario();
            cursoUsuario.setUsuarioId(usuarioNuevoMvsc.getId());

            curso.addCursoUsuario(cursoUsuario); //Agregamos el usuario al curso
            cursoRepository.save(curso);
            return Optional.of(usuarioNuevoMvsc);
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<Usuario> eliminarUsuario(Usuario usuario, Long cursoId) {
        Optional<Curso> cursoDb= cursoRepository.findById(cursoId);
        if (cursoDb.isPresent()){
            Usuario usuarioMvsc = usuarioClientRest.detalle(usuario.getId());

            Curso curso= cursoDb.get();
            CursoUsuario cursoUsuario= new CursoUsuario();
            cursoUsuario.setUsuarioId(usuarioMvsc.getId());

            curso.removeCursoUsuario(cursoUsuario); //Eliminamos el usuario del curso
            cursoRepository.save(curso);
            return Optional.of(usuarioMvsc);
        }
        return Optional.empty();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Curso> porIdConUsuarios(Long id) {
        Optional<Curso> o= cursoRepository.findById(id);
        if (o.isPresent()){
            Curso curso= o.get();
            if(!curso.getCursoUsuarios().isEmpty()){
                List<Long> ids= curso.getCursoUsuarios().stream().map(cu -> cu.getUsuarioId()).collect(Collectors.toList());
                List<Usuario> usuarios= usuarioClientRest.obtenerUsuariosPorCurso(ids);
                curso.setUsuarios(usuarios);
            }
            return Optional.of(curso);
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public void eliminarCursoUsuarioPorId(Long id) {
        cursoRepository.eliminarCursoUsuarioPorId(id);
    }
}
