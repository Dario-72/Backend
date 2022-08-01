
package com.CavalieriDario.portfolio.Security.Repository;

import com.CavalieriDario.portfolio.Security.Entity.Rol;
import com.CavalieriDario.portfolio.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
