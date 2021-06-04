package Services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;


public class ConvertFromJSON {
    public static long convertJsonToLong (String jsonString) throws JsonProcessingException {

        Map<String, String> map =
                new ObjectMapper().readValue(jsonString,
                        new TypeReference<Map<String, String>>() {
        });

            return Long.parseLong(map.get("accId"));

    }
   public static Map<String, String> convertJsonForReplenishment (String jsonString) throws JsonProcessingException {

        Map<String, String> map =
                new ObjectMapper().readValue(jsonString,
                        new TypeReference<Map<String, String>>() {});

        return map;


    }
}
