package com.celiahelp.repository;

import com.celiahelp.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    /**
     * Busca un usuario por su email (único).
     */
    Optional<Usuario> findByEmail(String email);
}