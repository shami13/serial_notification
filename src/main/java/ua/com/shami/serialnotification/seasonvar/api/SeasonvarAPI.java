package ua.com.shami.serialnotification.seasonvar.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;
import ua.com.shami.serialnotification.seasonvar.dto.SeasonvarSerialJSON;

import java.util.Collections;
import java.util.List;

@Service
@Configurable
public class SeasonvarAPI {

    private static final String SEARCH_COMMAND = "search";
    @Value("${seasonvar.key}")
    private String key;

    @Value("${seasonvar.url}")
    private String seasonvarUrl;

    public List<SeasonvarSerialJSON> searchSerial(String searchName) {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        LinkedMultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("key", key);
        params.add("command", SEARCH_COMMAND);
        params.add("query", searchName);


        HttpEntity<LinkedMultiValueMap<String, Object>> requestEntity = new HttpEntity<>(params, headers);


        ResponseEntity<String> responseEntity = restTemplate.exchange(
                seasonvarUrl,
                HttpMethod.POST,
                requestEntity,
                String.class);

        List<SeasonvarSerialJSON> serials = new Gson().fromJson(responseEntity.getBody(),
                new TypeToken<List<SeasonvarSerialJSON>>() {
                }.getType());

        return serials;
    }
}
