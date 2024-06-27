package PROYECUPC;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Solicitud {
    private static int contador = 2024000;
    private int codigo;
    private String nombreCliente;
    private int tipoServicio;
    private int tipoDispositivo;
    private String descripcionProblema;
    private String dniTecnico;
    private int nivelPrioridad;
    private int tipoAsistencia;
    private String indicaciones;
    private String estado;
    private String fechaHoraSolicitud;

    public Solicitud(String nombreCliente, int tipoServicio, int tipoDispositivo, String descripcionProblema) {
        this.codigo = ++contador;
        this.nombreCliente = nombreCliente;
        this.tipoServicio = tipoServicio;
        this.tipoDispositivo = tipoDispositivo;
        this.descripcionProblema = descripcionProblema;
        this.estado = "Registrada";
        this.fechaHoraSolicitud = obtenerFechaHoraActual();
        Historial.agregarEntrada("Nueva solicitud " + this.codigo);
    }

    public void asignarTecnico(String dniTecnico, int nivelPrioridad, int tipoAsistencia, String indicaciones) {
        Historial.agregarEntrada("Tecnico asignado de " + dniTecnico + " al codigo " + this.codigo);
        this.dniTecnico = dniTecnico;
        this.nivelPrioridad = nivelPrioridad;
        this.tipoAsistencia = tipoAsistencia;
        this.indicaciones = indicaciones;
        this.estado = "Asignada";
    }

    public void setEstado(String estado) {
        this.estado = estado;
        Historial.agregarEntrada("Estado: " + estado + " del codigo " + this.codigo);
    }

    public void setDniTecnico(String dniTecnico) {
        this.dniTecnico = dniTecnico;
    }

    public String getDniTecnico() {
        return dniTecnico;
    }

    private String obtenerFechaHoraActual() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }

    public String getFechaHoraSolicitud() {
        return fechaHoraSolicitud;
    }
    public int getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Solicituda del Cliente: (" +
                "codigo=" + codigo +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", tipo Servicio=" + tipoServicio +
                ", tipo Dispositivo=" + tipoDispositivo +
                ", descripcion Problema='" + descripcionProblema + '\'' +
                ", fechaHoraSolicitud='" + fechaHoraSolicitud + '\'' +
                ")\nSoporte: (DNI Tecnico='" + dniTecnico + '\'' +
                ", nivelPrioridad=" + nivelPrioridad +
                ", tipo Asistencia=" + tipoAsistencia +
                ", indicaciones='" + indicaciones + '\'' +
                ", estado='" + estado + '\'' +
                ')';
    }

}
