package unam.fesa.ico.te.proyectofinalfront.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/serviciosocial")
public class LoginProfesorController {

    // 1. Muestra la pantalla del login
    @GetMapping("/login/profesor")
    public String mostrarLoginProfesor(){
        return "login-profesor";
    }

    // 2. Procesa los datos del login
    @PostMapping("/login/profesor")
    public String procesarLoginProfesor(@RequestParam String correo,
                                        @RequestParam String password,
                                        Model model) {

        // Validamos las credenciales (dummy, luego se conecta a BD)
        if(correo.equals("profesor@unam.mx") && password.equals("1234")) {
            // Si es correcto, redirige al dashboard
            return "redirect:/serviciosocial/dashboard/profesor";
        } else {
            // Si es incorrecto, regresa error en la misma pantalla
            model.addAttribute("error", "Credenciales inválidas. Verifica tu correo o contraseña.");
            return "login-profesor";
        }
    }

    // 3. Método para mostrar el dashboard
    @GetMapping("/dashboard/profesor")
    public String mostrarDashboardProfesor() {
        return "dashboard-profesor";
    }
}
