package apidiaslaborales.apidiaslaborales.aplication;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import apidiaslaborales.apidiaslaborales.core.Dto.FestivosDto;

@Service
public class CalendarioCliente {

    @Autowired
    private RestTemplate restTemplate;

    public List<FestivosDto> obtenerFestivosold(int año) {
        String url = "http://localhost:3030/listar-festivos/" + año;
        ResponseEntity<List<FestivosDto>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<FestivosDto>>() {
                });
        System.out.println(responseEntity.getBody());
        return responseEntity.getBody();
    }

    public List<FestivosDto> obtenerFestivo(int año) {
        String BASE_URL = "http://localhost:3030/listar-festivos/" + año;
        ResponseEntity<List<FestivosDto>> responseEntity = restTemplate.exchange(
                BASE_URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<FestivosDto>>() {
                });
        List<FestivosDto> festivosDto = responseEntity.getBody();
        return festivosDto.stream()
                // .map(festivosDto::get())
                .collect(Collectors.toList());
    }
}
