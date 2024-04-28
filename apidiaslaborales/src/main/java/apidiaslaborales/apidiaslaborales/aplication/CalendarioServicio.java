package apidiaslaborales.apidiaslaborales.aplication;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import apidiaslaborales.apidiaslaborales.core.Dto.CalendarioDto;
import apidiaslaborales.apidiaslaborales.core.Dto.FestivosDto;
import apidiaslaborales.apidiaslaborales.core.entities.Calendario;
import apidiaslaborales.apidiaslaborales.core.repository.ICalendarioRepository;
import apidiaslaborales.apidiaslaborales.core.service.ICalendarioService;

@Service
public class CalendarioServicio implements ICalendarioService {
    private CalendarioCliente calendarioCliente;
    private ICalendarioRepository repository;

    public CalendarioServicio(CalendarioCliente calendarioCliente, ICalendarioRepository repository) {
        this.calendarioCliente = calendarioCliente;
        this.repository = repository;

    }

    @Override
    public List<FestivosDto> obtenerFestivos(int año) {

        return calendarioCliente.obtenerFestivo(año);
    }

    // List<FestivosDto> festivosDto = new ArrayList<>();
    // for (int month = 1; month <= 12; month++) {
    // FestivosDto festivosyear = calendarioCliente.obtenerFestivos(año);
    // if (festivosDto != null) {
    // festivosDto.add(festivosyear);
    // }
    // }
    // return festivosDto;
    @Override
    public Calendario agregar(Calendario calendario) {
        calendario.setId(0);
        return repository.save(calendario);
    }

    @Override
    public boolean eliminar(Long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    @Override
    public List<CalendarioDto> listar() {
        throw new UnsupportedOperationException("Unimplemented method 'listar'");
    }

}
