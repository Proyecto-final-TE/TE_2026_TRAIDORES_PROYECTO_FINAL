package unam.fesa.ico.te.proyectofinalfront.dashboard;

import java.util.List;

public class DashboardProfesor {

    private long totalAlumnos;
    private long horasTotales;
    private long alumnosCumplidos;

    private List<AlumnoResumen> alumnos;
    private List<HistorialHoras> historial;
    private List<ReportePrograma> reportes;

    public static class AlumnoResumen {
        private String nombre;
        private String programa;
        private long horas;
        private boolean cumplido;

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getPrograma() {
            return programa;
        }

        public void setPrograma(String programa) {
            this.programa = programa;
        }

        public long getHoras() {
            return horas;
        }

        public void setHoras(long horas) {
            this.horas = horas;
        }

        public boolean isCumplido() {
            return cumplido;
        }

        public void setCumplido(boolean cumplido) {
            this.cumplido = cumplido;
        }
    }

    public static class HistorialHoras {
        private String alumno;
        private String fecha;
        private String entrada;
        private String salida;
        private String actividades;
        private long horas;

        public String getAlumno() {
            return alumno;
        }

        public void setAlumno(String alumno) {
            this.alumno = alumno;
        }

        public String getFecha() {
            return fecha;
        }

        public void setFecha(String fecha) {
            this.fecha = fecha;
        }

        public String getEntrada() {
            return entrada;
        }

        public void setEntrada(String entrada) {
            this.entrada = entrada;
        }

        public String getSalida() {
            return salida;
        }

        public void setSalida(String salida) {
            this.salida = salida;
        }

        public String getActividades() {
            return actividades;
        }

        public void setActividades(String actividades) {
            this.actividades = actividades;
        }

        public long getHoras() {
            return horas;
        }

        public void setHoras(long horas) {
            this.horas = horas;
        }
    }

    public static class ReportePrograma {
        private String programa;
        private long totalAlumnos;
        private long horasAcumuladas;

        public String getPrograma() {
            return programa;
        }

        public void setPrograma(String programa) {
            this.programa = programa;
        }

        public long getTotalAlumnos() {
            return totalAlumnos;
        }

        public void setTotalAlumnos(long totalAlumnos) {
            this.totalAlumnos = totalAlumnos;
        }

        public long getHorasAcumuladas() {
            return horasAcumuladas;
        }

        public void setHorasAcumuladas(long horasAcumuladas) {
            this.horasAcumuladas = horasAcumuladas;
        }
    }

    public long getTotalAlumnos() {
        return totalAlumnos;
    }

    public void setTotalAlumnos(long totalAlumnos) {
        this.totalAlumnos = totalAlumnos;
    }

    public long getHorasTotales() {
        return horasTotales;
    }

    public void setHorasTotales(long horasTotales) {
        this.horasTotales = horasTotales;
    }

    public long getAlumnosCumplidos() {
        return alumnosCumplidos;
    }

    public void setAlumnosCumplidos(long alumnosCumplidos) {
        this.alumnosCumplidos = alumnosCumplidos;
    }

    public List<AlumnoResumen> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<AlumnoResumen> alumnos) {
        this.alumnos = alumnos;
    }

    public List<HistorialHoras> getHistorial() {
        return historial;
    }

    public void setHistorial(List<HistorialHoras> historial) {
        this.historial = historial;
    }

    public List<ReportePrograma> getReportes() {
        return reportes;
    }

    public void setReportes(List<ReportePrograma> reportes) {
        this.reportes = reportes;
    }
}

