
package com.CavalieriDario.portfolio.Interface;

import com.CavalieriDario.portfolio.Entity.Persona;
import java.util.List;


public interface InPersonaService {
    //traer lista de personas
    public List<Persona> getPersona();
    
    //guardar un objeto del tipo Persona
    public void savePersona(Persona persona);
    
    //eliminar objeto por id
    public void deletePersona(Long id);
    
    //buscar persona por id
    public Persona findPersona(Long id);

    
}
