package co.edu.sena.projectAppApex.Service;

import co.edu.sena.projectAppApex.Model.Usuario;

public interface UsuarioService {
    public Usuario save(Usuario u);
    public String login(String user, String ctr);
}

