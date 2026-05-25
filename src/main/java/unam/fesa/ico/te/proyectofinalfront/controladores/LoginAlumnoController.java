package unam.fesa.ico.te.proyectofinalfront.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/serviciosocial")
public class LoginAlumnoController {

    @GetMapping("/login/alumno")
    public String mostrarLoginAlumno() {
        return "login-alumno";
    }

    @PostMapping("/login/alumno")
    public String procesarLoginAlumno(
            @RequestParam String identificador,
            @RequestParam String password,
            RedirectAttributes redirectAttributes) {

        if (identificador.equals("312345678") && password.equals("1234")) {
            redirectAttributes.addFlashAttribute("exito", "Login exitoso. Bienvenido alumno.");
            return "pag_inicio";
        } else {
            redirectAttributes.addFlashAttribute("error", "Credenciales inválidas. Verifica tu número de cuenta o contraseña.");
            return "redirect:/serviciosocial/login/alumno";
        }
    }
}