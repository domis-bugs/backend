package com.domicilios.bugsbunny_api.service;
import com.domicilios.bugsbunny_api.model.entity.Usuario;
public interface IUsuarioService {

    Usuario registrarUsuario(Usuario usuario);
    Usuario completarRegistro(Usuario usuario);
    Usuario obtenerUsuarioPorCredenciales(Usuario usuario);
}
