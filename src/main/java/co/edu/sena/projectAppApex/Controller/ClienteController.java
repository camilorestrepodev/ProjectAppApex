package co.edu.sena.projectAppApex.Controller;

import co.edu.sena.projectAppApex.Model.Cliente;
import co.edu.sena.projectAppApex.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private ClienteService clienteService;
    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.crearUsuario(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCliente);
    }

    @GetMapping("/{guia}")
    public ResponseEntity<Cliente> obtenerUsuarioPorGuia(@PathVariable Integer guia) {
        Cliente usuario = clienteService.obtenerUsuarioPorGuia(guia);
        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> obtenerTodosLosClientes() {
        List<Cliente> usuarios = clienteService.obtenerTodosLosClientes();
        return ResponseEntity.ok(usuarios);
    }

    @PutMapping("/{guia}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Integer guia, @RequestBody Cliente cliente) {
        Cliente usuarioExistente = clienteService.obtenerUsuarioPorGuia(guia);
        if (usuarioExistente != null) {
            cliente.setGuia(guia);
            Cliente clienteActualizado = clienteService.actualizarCliente(cliente);
            return ResponseEntity.ok(clienteActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{guia}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Integer guia) {
        Cliente usuarioExistente = clienteService.obtenerUsuarioPorGuia(guia);
        if (usuarioExistente != null) {
            clienteService.eliminarClientePorGuia(guia);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
