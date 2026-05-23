package unam.fesa.ico.te.proyectofinalfront.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/serviciosocial")
public class LoginProfesorController {

    @GetMapping("/login-profesor")
    public String mostrarLoginProfesor(){
        return "login-profesor";
    }

    @GetMapping("/dashboard-profesor")
    public String dashboardProfesor() {
        return "dashboard-profesor";
    }

    @PostMapping("/login-profesor")
    public String procesarLoginProfesor(@RequestParam String correo,
                                        @RequestParam String password,
                                        Model model) {

        if(correo.equals("profesor@unam.mx") && password.equals("1234")) {
            //  Si las credenciales son correctas, mostrar el dashboard
            return "dashboard-profesor";
        } else {
            //  Si son incorrectas, regresar al login con mensaje de error
            model.addAttribute("error", "Credenciales inválidas");
            return "login-profesor";
        }
    }
}
