package apidiaslaborales.apidiaslaborales.core.service;

import java.util.List;

import apidiaslaborales.apidiaslaborales.core.Dto.CalendarioDto;

public interface ICalendarioService {

    public List<CalendarioDto> buscar(int año);

    public List<CalendarioDto> obtenerFestivos(int año);

    public CalendarioDto addCalendario(CalendarioDto calendarioDto);

    // public calendario agregarCalendario(Date fecha, tipo tipo, String
    // descripcion);

}
