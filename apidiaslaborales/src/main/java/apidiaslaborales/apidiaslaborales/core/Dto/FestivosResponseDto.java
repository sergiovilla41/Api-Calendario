package apidiaslaborales.apidiaslaborales.core.Dto;

import java.util.*;

public class FestivosResponseDto {
    private List<FestivoDto> Festivos;

    public List<FestivoDto> getFestivos() {
        return Festivos;
    }

    public void setFestivos(List<FestivoDto> festivos) {
        Festivos = festivos;
    }
}
