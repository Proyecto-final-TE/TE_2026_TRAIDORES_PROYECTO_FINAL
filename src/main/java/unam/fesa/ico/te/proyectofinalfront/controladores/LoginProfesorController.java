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

    // 1. Muestra la pantalla del login al darle clic en la página de inicio
    @GetMapping("/login/profesor")
    public String mostrarLoginProfesor(){
        return "login-profesor";
    }

    // 2. Procesa los datos cuando le das al botón de "Ingresar al Sistema"
    @PostMapping("/login/profesor")
    public String procesarLoginProfesor(@RequestParam String correo,
                                        @RequestParam String password,
                                        Model model) {

        // Validamos las credenciales (ahorita están quemadas, luego las ligan a la BD)
        if(correo.equals("profesor@unam.mx") && password.equals("1234")) {
            // ¡AQUÍ ESTÁ LA MAGIA! Si es correcto, lo pateamos a la ruta del dashboard
            return "redirect:/serviciosocial/dashboard/profesor";
        } else {
            // Si se equivoca, le regresamos el error en la misma pantalla
            model.addAttribute("error", "Credenciales inválidas. Verifica tu correo o contraseña.");
            return "login-profesor";
        }
    }

    // 3. NUEVO MÉTODO: La llave que abre el dashboard
    @GetMapping("/dashboard/profesor")
    public String mostrarDashboardProfesor() {
        // Esto le dice a Spring Boot que pinte tu archivo "dashboard-profesor.html"
        return "dashboard-profesor";
    }
}