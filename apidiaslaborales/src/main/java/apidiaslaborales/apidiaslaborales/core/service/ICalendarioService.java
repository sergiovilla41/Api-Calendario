package apidiaslaborales.apidiaslaborales.core.service;

import java.util.List;

import apidiaslaborales.apidiaslaborales.core.Dto.CalendarioDto;
import apidiaslaborales.apidiaslaborales.core.Dto.FestivosDto;
import apidiaslaborales.apidiaslaborales.core.entities.Calendario;

public interface ICalendarioService {

    public List<FestivosDto> obtenerFestivos(int year);

    public List<CalendarioDto> listar();

    public Calendario agregar(Calendario calendario);

    public boolean eliminar(Long id);

}
