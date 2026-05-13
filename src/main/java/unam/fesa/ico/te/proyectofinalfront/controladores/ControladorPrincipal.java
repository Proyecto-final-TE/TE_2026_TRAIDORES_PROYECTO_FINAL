package unam.fesa.ico.te.proyectofinalfront.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/serviciosocial/")
public class ControladorPrincipal {

    @GetMapping ("/pag_inicio/")
    public String muestraInicio(){
        return "pag_inicio";
    }
}
