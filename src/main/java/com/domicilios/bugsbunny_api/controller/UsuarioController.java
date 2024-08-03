package com.domicilios.bugsbunny_api.controller;
import com.domicilios.bugsbunny_api.model.entity.Usuario;
import com.domicilios.bugsbunny_api.service.IUsuarioService;
import com.domicilios.bugsbunny_api.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    private IUsuarioService iusuarioService;

    @Autowired
    private JWTUtil jwtUtil;

    private boolean validarToken(String token){
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public Usuario registrarUsuario(@RequestBody Usuario usuario) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hasts = argon2.hash(1,1024,1, usuario.getPassword());
        usuario.setPassword(hasts);
        return iusuarioService.registrarUsuario(usuario);
    }

}
