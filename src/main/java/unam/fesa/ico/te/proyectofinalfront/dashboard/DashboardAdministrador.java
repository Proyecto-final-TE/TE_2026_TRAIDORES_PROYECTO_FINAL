package unam.fesa.ico.te.proyectofinalfront.dashboard;

import java.util.List;

public class DashboardAdministrador {

    private ProgramasEstadistica programas;
    private UsuariosEstadistica usuarios;
    private List<AvanceProgramaEstadistica> avanceHorasPorPrograma;

    public static class ProgramasEstadistica {
        private long activos;
        private long inactivos;
        private long finalizados;

        public long getActivos() {
            return activos;
        }

        public void setActivos(long activos) {
            this.activos = activos;
        }

        public long getInactivos() {
            return inactivos;
        }

        public void setInactivos(long inactivos) {
            this.inactivos = inactivos;
        }

        public long getFinalizados() {
            return finalizados;
        }

        public void setFinalizados(long finalizados) {
            this.finalizados = finalizados;
        }
    }

    public static class UsuariosEstadistica {
        private long totalProfesores;
        private long totalAlumnos;

        public long getTotalProfesores() {
            return totalProfesores;
        }

        public void setTotalProfesores(long totalProfesores) {
            this.totalProfesores = totalProfesores;
        }

        public long getTotalAlumnos() {
            return totalAlumnos;
        }

        public void setTotalAlumnos(long totalAlumnos) {
            this.totalAlumnos = totalAlumnos;
        }
    }

    public static class AvanceProgramaEstadistica {
        private String nombrePrograma;
        private long horasAcumuladas;

        public String getNombrePrograma() {
            return nombrePrograma;
        }

        public void setNombrePrograma(String nombrePrograma) {
            this.nombrePrograma = nombrePrograma;
        }

        public long getHorasAcumuladas() {
            return horasAcumuladas;
        }

        public void setHorasAcumuladas(long horasAcumuladas) {
            this.horasAcumuladas = horasAcumuladas;
        }
    }

    public ProgramasEstadistica getProgramas() {
        return programas;
    }

    public void setProgramas(ProgramasEstadistica programas) {
        this.programas = programas;
    }

    public UsuariosEstadistica getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(UsuariosEstadistica usuarios) {
        this.usuarios = usuarios;
    }

    public List<AvanceProgramaEstadistica> getAvanceHorasPorPrograma() {
        return avanceHorasPorPrograma;
    }

    public void setAvanceHorasPorPrograma(List<AvanceProgramaEstadistica> avanceHorasPorPrograma) {
        this.avanceHorasPorPrograma = avanceHorasPorPrograma;
    }
}
