package unam.fesa.ico.te.proyectofinalfront.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/profesor")
public class ControladorProfesor {

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/dashboard")
    public String mostrarDashboardProfesor(Model model) {

        String backendUrl = "http://localhost:8080/api/dashboard/profesor";

        try {
            Object datosProfesor =
                    restTemplate.getForObject(backendUrl, Object.class);

            model.addAttribute("datos", datosProfesor);

        } catch (Exception e) {

            model.addAttribute("error",
                    "No se pudieron cargar los datos del dashboard.");

            model.addAttribute("datos", null);
        }

        return "profesor/dashboard";
    }
}