package co.edu.sena.projectAppApex.Controller;

import co.edu.sena.projectAppApex.Model.Usuario;
import co.edu.sena.projectAppApex.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public Usuario guardar (@RequestBody Usuario u){
        System.out.println("Usuario recibido: " + u);
        return usuarioService.save(u);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario){
        String mensaje = usuarioService.login(usuario.getUsername(), usuario.getPassword());
        return ResponseEntity.ok(mensaje);
    }
}
