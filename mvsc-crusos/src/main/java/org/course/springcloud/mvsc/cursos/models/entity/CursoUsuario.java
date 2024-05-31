package org.course.springcloud.mvsc.cursos.models.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cursos_usuarios")
public class CursoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "usuario_id",unique = true)
    private Long usuarioId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public boolean equals(Object object){
        if(this == object){
            return true;
        }
        if(!(object instanceof CursoUsuario)){
            return false;
        }
        CursoUsuario o = (CursoUsuario) object;
        return this.usuarioId != null && this.usuarioId.equals(o.usuarioId);
    }
}
