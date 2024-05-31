package org.course.springcloud.mvsc.cursos.repository;

import org.course.springcloud.mvsc.cursos.models.entity.Curso;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CursoRepository extends CrudRepository<Curso, Long> {
    @Modifying
    @Query("DELETE FROM CursoUsuario cu WHERE cu.usuarioId = ?1")
    void eliminarCursoUsuarioPorId(Long id);

}
