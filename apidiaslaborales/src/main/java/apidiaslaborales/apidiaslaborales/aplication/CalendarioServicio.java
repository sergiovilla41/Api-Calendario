package apidiaslaborales.apidiaslaborales.aplication;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;
import apidiaslaborales.apidiaslaborales.core.Dto.CalendarioDto;
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
    public List<CalendarioDto> obtenerFestivos(int año) {
        List<CalendarioDto> calendarioDtos = new ArrayList<>();
        for (int month = 1; month <= 12; month++) {
            CalendarioDto calendarioDto = calendarioCliente.obtenerFestivos(año);
            if (calendarioDto != null) {
                calendarioDtos.add(calendarioDto);
            }
        }
        return calendarioDtos;
    }

    @Override
    public List<CalendarioDto> buscar(int año) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscar'");
    }

    @Override
    public CalendarioDto addCalendario(CalendarioDto calendarioDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addCalendario'");
    }

}
