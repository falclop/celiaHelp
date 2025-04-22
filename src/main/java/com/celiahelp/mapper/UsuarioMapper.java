package com.celiahelp.mapper;

import com.celiahelp.dto.UsuarioDTO;
import com.celiahelp.model.Rol;
import com.celiahelp.model.Usuario;
import com.celiahelp.repository.RolRepository;

import java.util.Optional;

public class UsuarioMapper {

    public static UsuarioDTO toDTO(Usuario usuario) {
        if (usuario == null) return null;

        return new UsuarioDTO(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getPasswordHash(),
                usuario.getRol() != null ? usuario.getRol().getId() : null
        );
    }

    public static Usuario toEntity(UsuarioDTO dto, RolRepository rolRepository) {
        if (dto == null) return null;

        Usuario usuario = new Usuario();
        usuario.setId(dto.getId());
        usuario.setNombre(dto.getNombre());
        usuario.setEmail(dto.getEmail());

        if (dto.getRolId() != null) {
            Optional<Rol> rol = rolRepository.findById(dto.getRolId());
            rol.ifPresent(usuario::setRol);
        }

        return usuario;
    }
}
