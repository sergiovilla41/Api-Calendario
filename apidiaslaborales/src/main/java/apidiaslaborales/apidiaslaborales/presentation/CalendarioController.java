package apidiaslaborales.apidiaslaborales.presentation;

import java.util.List;
import java.time.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import apidiaslaborales.apidiaslaborales.core.Dto.FestivoDto;
import apidiaslaborales.apidiaslaborales.core.entities.Calendario;
import apidiaslaborales.apidiaslaborales.core.service.ICalendarioService;

@RestController
@RequestMapping("/api/calendario")
public class CalendarioController {
    private ICalendarioService service;

    public CalendarioController(ICalendarioService service) {
        this.service = service;
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Calendario> listar() {
        return service.listar();
    }

    @GetMapping("/listar/{year}")
    public List<Calendario> listar(@PathVariable("year") Integer año) {

        return service.listarPorAño(año);

    }

    @RequestMapping(value = "/agregar/{year}", method = RequestMethod.POST)
    public List<Calendario> agregar(@PathVariable int year) {
        service.poblarCalendario(year);
        return service.listar();
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public boolean eliminar(@PathVariable long id) {
        return service.eliminar(id);
    }

    @GetMapping("/festivos/{year}")
    public List<FestivoDto> obtenerDiaFestivos(@PathVariable("year") Integer year) {
        // Year anio = Year.of(year); // Represent an entire year.

        // anio
        // .atDay(1) // Determine the first day of the year. Returns a `LocalDate`
        // object.
        // .datesUntil( // Generates a `Stream<LocalDate>`.
        // anio
        // .plusYears(1) // Returns a new `Year` object, leaving the original unaltered.
        // .atDay(1) // Returns a `LocalDate`.
        // ) // Returns a `Stream<LocalDate>`.
        // .forEach( // Like a `for` loop, running through each object in the stream.
        // System.out::println // Each `LocalDate` object in stream is passed to a call
        // of
        // // `System.out.println`.
        // );
        return service.obtenerDiaFestivos(year);
    }

}
