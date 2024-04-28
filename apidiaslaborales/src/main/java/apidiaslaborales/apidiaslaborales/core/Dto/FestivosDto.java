package apidiaslaborales.apidiaslaborales.core.Dto;

import java.util.Date;

public class FestivosDto {
    private Date Fecha;
    private String Nombre;

    public FestivosDto(Date fecha, String nombre) {
        Fecha = fecha;
        Nombre = nombre;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

}
