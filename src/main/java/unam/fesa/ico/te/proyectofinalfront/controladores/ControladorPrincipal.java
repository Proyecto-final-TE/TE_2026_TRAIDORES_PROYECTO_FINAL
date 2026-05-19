package unam.fesa.ico.te.proyectofinalfront.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/serviciosocial/")
public class ControladorPrincipal {

    @GetMapping ("/pag_inicio/")
    public String muestraInicio(){
        return "pag_inicio";
    }


    @GetMapping("/login/admin")
    public String mostrarLoginAdmin() {
        return "login_admin"; // Llama al archivo HTML
    }

    // 3. Procesar los datos del formulario (Mocking)
    @PostMapping("/login/admin")
    public String procesarLoginAdmin(
            @RequestParam("usuario") String usuario,
            @RequestParam("password") String password,
            Model model) {

        // Simulamos la validación que en el futuro hará el Backend
        if ("admin".equals(usuario) && "12345".equals(password)) {
            // Si es correcto, simula llevarlo a su panel de control
            return "redirect:/serviciosocial/dashboard/admin";
        } else {
            // Si es incorrecto, inyectamos el mensaje de error y recargamos el form
            model.addAttribute("error", "Credenciales incorrectas. Verifica tu usuario y contraseña.");
            return "login_admin";
        }
    }

    @GetMapping("/dashboard/admin")
    public String dashboardTemporalAdmin() {
        return "pag_inicio"; // Por ahora lo regresamos al inicio simulando que entró
    }
}

