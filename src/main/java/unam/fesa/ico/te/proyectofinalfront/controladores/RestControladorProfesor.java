package unam.fesa.ico.te.proyectofinalfront.controladores;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/dashboard")
public class RestControladorProfesor {

    private static final Map<String, Object> memoriaProfesor = new HashMap<>();

    static {

        memoriaProfesor.put("totalAlumnos", 3);
        memoriaProfesor.put("horasTotales", 350);
        memoriaProfesor.put("alumnosCumplidos", 2);

        List<Map<String, Object>> alumnos = new ArrayList<>();

        alumnos.add(new HashMap<>(Map.of(
                "nombre", "Juan Pérez",
                "programa", "Programa A",
                "horas", 80,
                "cumplido", false
        )));

        alumnos.add(new HashMap<>(Map.of(
                "nombre", "María López",
                "programa", "Programa B",
                "horas", 120,
                "cumplido", true
        )));

        alumnos.add(new HashMap<>(Map.of(
                "nombre", "Carlos Sánchez",
                "programa", "Programa A",
                "horas", 150,
                "cumplido", true
        )));

        memoriaProfesor.put("alumnos", alumnos);

        memoriaProfesor.put("historial", new ArrayList<>());

        recalcularReportes();
    }

    // ==========================
    // GET DASHBOARD
    // ==========================
    @GetMapping("/profesor")
    public Map<String, Object> obtenerDashboardProfesor() {

        recalcularReportes();
        return memoriaProfesor;
    }

    // ==========================
    // AGREGAR ALUMNO
    // ==========================
    @PostMapping("/alumnos")
    public Map<String, Object> agregarAlumno(@RequestBody Map<String, Object> alumno) {

        List<Map<String, Object>> alumnos =
                (List<Map<String, Object>>) memoriaProfesor.get("alumnos");

        // nuevo alumno seguro
        Map<String, Object> nuevo = new HashMap<>();
        nuevo.put("nombre", alumno.get("nombre"));
        nuevo.put("programa", alumno.get("programa"));
        nuevo.put("horas", alumno.get("horas"));
        nuevo.put("cumplido", false);

        alumnos.add(nuevo);

        recalcularMetricas();

        return Map.of("mensaje", "Alumno agregado correctamente");
    }

    // ==========================
    // MÉTRICAS BASE
    // ==========================
    private void recalcularMetricas() {

        List<Map<String, Object>> alumnos =
                (List<Map<String, Object>>) memoriaProfesor.get("alumnos");

        memoriaProfesor.put("totalAlumnos", alumnos.size());

        long cumplidos = alumnos.stream()
                .filter(a -> Boolean.TRUE.equals(a.get("cumplido")))
                .count();

        memoriaProfesor.put("alumnosCumplidos", cumplidos);

        long horas = alumnos.stream()
                .mapToLong(a -> ((Number) a.get("horas")).longValue())
                .sum();

        memoriaProfesor.put("horasTotales", horas);
    }

    // ==========================
    // RESUMEN POR PROGRAMA (DINÁMICO)
    // ==========================
    private static void recalcularReportes() {

        List<Map<String, Object>> alumnos =
                (List<Map<String, Object>>) memoriaProfesor.get("alumnos");

        Map<String, Map<String, Object>> resumen = new HashMap<>();

        for (Map<String, Object> a : alumnos) {

            String programa = (String) a.get("programa");
            int horas = ((Number) a.get("horas")).intValue();

            resumen.putIfAbsent(programa, new HashMap<>());

            Map<String, Object> r = resumen.get(programa);

            r.put("programa", programa);

            r.put("totalAlumnos",
                    ((int) r.getOrDefault("totalAlumnos", 0)) + 1);

            r.put("horasAcumuladas",
                    ((int) r.getOrDefault("horasAcumuladas", 0)) + horas);
        }

        memoriaProfesor.put("reportes", new ArrayList<>(resumen.values()));
    }
}


