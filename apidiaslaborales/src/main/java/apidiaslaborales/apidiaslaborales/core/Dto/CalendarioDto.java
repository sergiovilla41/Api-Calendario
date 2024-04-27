package apidiaslaborales.apidiaslaborales.core.Dto;

import java.util.Date;

public class CalendarioDto {
    private Long id;
    private Date fecha;
    private int tipo;
    private String descripcion;

    public CalendarioDto(Long id, Date fecha, int tipo, String descripcion) {
        this.id = id;
        this.fecha = fecha;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "CalendarioDto [id=" + id + ", fecha=" + fecha + ", tipo=" + tipo + ", descripcion=" + descripcion + "]";
    }

}
