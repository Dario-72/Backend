
package com.CavalieriDario.portfolio.Controler;

import com.CavalieriDario.portfolio.Entity.Persona;
import com.CavalieriDario.portfolio.Interface.InPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin (origins = "http://localhost:4200")
public class PersonaController {
    @Autowired InPersonaService inpersonaService; 
    
    @GetMapping("personas/traer")
    public List<Persona> getPersona(){
        return inpersonaService.getPersona();    
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/personas/crear")
    public String createPersona(@RequestBody Persona persona){
        inpersonaService.savePersona(persona);
        return "La persona se creo correctamente";
    } 
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        inpersonaService.deletePersona(id);
        return "La persona fue borrada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id, @RequestParam("nombre") String nuevoNombre, 
            @RequestParam("apellido") String nuevoApellido, @RequestParam("img") String nuevoImg){
        Persona persona = inpersonaService.findPersona(id);
        
        persona.setNombre(nuevoNombre);
        persona.setApellido(nuevoApellido);
        persona.setImg(nuevoImg);
        
        inpersonaService.savePersona(persona);
        return persona;
    }
                                            
    @GetMapping("/personas/traer/perfil")
      public Persona findPersona(){
          return inpersonaService.findPersona((long)1);
      }
}

