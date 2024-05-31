package org.course.springcloud.msvc.usuarios.controllers;

import jakarta.validation.Valid;
import org.course.springcloud.msvc.usuarios.models.entity.Usuario;
import org.course.springcloud.msvc.usuarios.repositories.UsuarioRepository;
import org.course.springcloud.msvc.usuarios.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalle(@PathVariable Long id) {
        Optional<Usuario> o = usuarioService.obtenerPorId(id);
        if (o.isPresent()) {
            return ResponseEntity.ok(o.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Usuario usuario, BindingResult result) {
        if(usuarioService.findByEmail(usuario.getEmail()).isPresent()){
            return ResponseEntity.badRequest().body(Collections.singletonMap("Mensaje","El email ya existe en la base de datos"));
        }
        if(result.hasErrors()){
            return validar(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.guardar(usuario));
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@Valid @RequestBody Usuario usuario,BindingResult result, @PathVariable Long id) {
        if(result.hasErrors()){
            return validar(result);
        }
        Optional<Usuario> o = usuarioService.obtenerPorId(id);
        if (o.isPresent()) {
            Usuario usuarioDb = o.get();
            if(!usuario.getEmail().equalsIgnoreCase(usuarioDb.getEmail()) && usuarioService.findByEmail(usuario.getEmail()).isPresent()){
                return ResponseEntity.badRequest().body(Collections.singletonMap("Mensaje","Ya existe un usuario con ese email"));

            }
            usuarioDb.setNombre(usuario.getNombre());
            usuarioDb.setEmail(usuario.getEmail());
            usuarioDb.setPassword(usuario.getPassword());
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.guardar(usuarioDb));
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        Optional<Usuario> o = usuarioService.obtenerPorId(id);
        if (o.isPresent()) {
            usuarioService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/usuarios-por-curso")
    public ResponseEntity<?> obtenerUsuariosPorCurso(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(usuarioService.listarPorIds(ids));
    }



    private  ResponseEntity<Map<String, String>> validar(BindingResult result) {
        Map<String,String> errores = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errores.put(err.getField(), "El campo "+err.getField()+" "+err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errores);
    }


}
