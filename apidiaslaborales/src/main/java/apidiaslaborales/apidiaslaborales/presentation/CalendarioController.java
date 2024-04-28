package apidiaslaborales.apidiaslaborales.presentation;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import apidiaslaborales.apidiaslaborales.core.Dto.CalendarioDto;
import apidiaslaborales.apidiaslaborales.core.Dto.FestivosDto;
import apidiaslaborales.apidiaslaborales.core.entities.Calendario;
import apidiaslaborales.apidiaslaborales.core.service.ICalendarioService;

@RestController
@RequestMapping("/api/calendario")
public class CalendarioController {
    private ICalendarioService service;

    public CalendarioController(ICalendarioService service) {
        this.service = service;
    }

    @RequestMapping(value = "/listar/{year}", method = RequestMethod.GET)
    public List<FestivosDto> buscar(@PathVariable int year) {
        var festivosano = service.obtenerFestivos(year);
        return festivosano;
        // return service.listar();

    }

    // @RequestMapping(value = "/listar", method = RequestMethod.GET)
    // public List<Calendario> listar() {
    // return service.listar();
    // }

    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Calendario crear(@RequestBody Calendario calendario) {
        return service.agregar(calendario);
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public boolean eliminar(@PathVariable long id) {
        return service.eliminar(id);
    }

}
