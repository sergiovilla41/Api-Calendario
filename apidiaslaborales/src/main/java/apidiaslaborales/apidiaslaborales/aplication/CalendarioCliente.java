package apidiaslaborales.apidiaslaborales.aplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import apidiaslaborales.apidiaslaborales.core.Dto.CalendarioDto;

@Service
public class CalendarioCliente {

    @Autowired
    private RestTemplate restTemplate;

    public CalendarioDto obtenerFestivos(int año) {
        String url = "http://localhost:3030/listar-festivos/" + año;
        ResponseEntity<CalendarioDto> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<CalendarioDto>() {
                });
        return responseEntity.getBody();
    }

}
