
package com.CavalieriDario.portfolio.Repository;

import com.CavalieriDario.portfolio.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InPersonaRepository extends JpaRepository<Persona, Long>{
    
}
