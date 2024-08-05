package com.domicilios.bugsbunny_api.service;

import com.domicilios.bugsbunny_api.model.entity.Usuario;
import com.domicilios.bugsbunny_api.repository.UsuarioRepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
@Transactional
public class UsuarioService implements IUsuarioService {

    @Autowired
    public UsuarioRepository usuarioRepository;

    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        List<Usuario> usuarios = usuarioRepository.findByEmail(usuario.getEmail());
        if (usuarios.size() > 0) {
            return null;
        }
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario completarRegistro(Usuario usuario) {

        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario obtenerUsuarioPorCredenciales(Usuario usuario) {
        List<Usuario> lista = usuarioRepository.findByEmail(usuario.getEmail());
        try{
            if (lista.isEmpty()) {
                return null;
            }
        }catch (Exception e){
            throw new IllegalArgumentException("no se existe el correo "+e.getMessage());
        }
        String password = lista.get(0).getPassword();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if (argon2.verify(password, usuario.getPassword())) {
            return lista.get(0);
        }
        return null;
    }
}
