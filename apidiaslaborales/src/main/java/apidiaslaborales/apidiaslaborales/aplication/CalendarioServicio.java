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
    public List<Calendario> listar() {
        return repository.findAll();
    }

    @Override
    public List<Calendario> listarPorAño(int año) {
        List<Calendario> calendarios = repository.findAll();
        List<Calendario> calendariosPorAño = new ArrayList<>();

        for (Calendario calendario : calendarios) {
            if (calendario.getYear() == año) {
                calendariosPorAño.add(calendario);
            }
        }

        return calendariosPorAño;
    }

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
    public List<CalendarioDto> obtenerFestivos(int year) {
        List<CalendarioDto> festivosDto = new ArrayList<>();
        for (int month = 1; month <= 12; month++) {
            CalendarioDto festivosyear = calendarioCliente.obtenerFestivosold(year);
            if (festivosDto != null) {
                festivosDto.add(festivosyear);
            }
        }
        return festivosDto;
    }

}
