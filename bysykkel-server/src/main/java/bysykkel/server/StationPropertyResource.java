package bysykkel.server;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

@RestController
public class StationPropertyResource {

    private StationPropertyService stationPropertyService =
            new StationPropertyService(System.getenv("CLIENT_IDENTIFIER"));

    @RequestMapping(value = "v1/stationproperties", produces=APPLICATION_JSON_UTF8_VALUE)
    public List<StationProperty> findStationProperties() {
        return stationPropertyService.findStationProperties();
    }

}
