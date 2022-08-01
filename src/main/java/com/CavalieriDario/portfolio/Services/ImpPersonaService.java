
package com.CavalieriDario.portfolio.Services;

import com.CavalieriDario.portfolio.Entity.Persona;
import com.CavalieriDario.portfolio.Interface.InPersonaService;
import com.CavalieriDario.portfolio.Repository.InPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService implements InPersonaService{
    @Autowired InPersonaRepository inpersonaRepository;
    
    @Override
    public List<Persona> getPersona() {
        List<Persona> persona = inpersonaRepository.findAll();
        return persona;        
    }

    @Override
    public void savePersona(Persona persona) {
        inpersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
        inpersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona persona = inpersonaRepository.findById(id).orElse(null);
        return persona;
    }  

}
