package co.edu.sena.projectAppApex.Service;

import co.edu.sena.projectAppApex.Model.Cliente;
import co.edu.sena.projectAppApex.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente crearUsuario(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente obtenerUsuarioPorGuia(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepository.findAll();
    }

    public Cliente actualizarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void eliminarClientePorGuia(Integer id) {
        clienteRepository.deleteById(id);
    }
}
