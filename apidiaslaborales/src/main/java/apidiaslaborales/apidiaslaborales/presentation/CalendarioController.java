package apidiaslaborales.apidiaslaborales.presentation;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import apidiaslaborales.apidiaslaborales.core.Dto.CalendarioDto;
import apidiaslaborales.apidiaslaborales.core.entities.Calendario;
import apidiaslaborales.apidiaslaborales.core.service.ICalendarioService;

@RestController
@RequestMapping("/api/calendario")
public class CalendarioController {
    private ICalendarioService service;

    public CalendarioController(ICalendarioService service) {
        this.service = service;
    }

    @RequestMapping(value = "/listar/{año}", method = RequestMethod.GET)
    public List<CalendarioDto> buscar(@PathVariable int año) {
        return service.obtenerFestivos(año);
    }

    @PostMapping("/calendario")
    public ResponseEntity<?> addCalendario(@RequestBody CalendarioDto calendarioDto) {
        CalendarioDto nuevoCalendario = service.addCalendario(calendarioDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCalendario);
    }

}
