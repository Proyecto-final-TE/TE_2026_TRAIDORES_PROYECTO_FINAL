package unam.fesa.ico.te.proyectofinalfront.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/serviciosocial")
public class LoginProfesorController {

    @GetMapping("/login/profesor")
    public String mostrarLoginProfesor() {
        return "login-profesor";
    }

    @PostMapping("/login/profesor")
    public String procesarLoginProfesor(@RequestParam String correo,
                                        @RequestParam String password,
                                        Model model) {

        if (correo.equals("profesor@unam.mx") && password.equals("1234")) {

            // 👇 ahora SÍ manda al controlador real del dashboard
            return "redirect:/profesor/dashboard";

        } else {
            model.addAttribute("error", "Credenciales inválidas.");
            return "login-profesor";
        }
    }

    @GetMapping("/dashboard/profesor")
    public String mostrarDashboardProfesor() {

        return "profesor/dashboard";
    }
}
