package budget_app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import java.io.IOException;

public class ConverterMethods {

    public static byte[] convertObjectToJsonBytes(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsBytes(object);
    }

    public static String convertObjectToJsonString(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

    public static <T> T convertJsonBytesToObject(byte[] bytes, Class<T> clazz) throws IOException {
        ObjectReader reader = new ObjectMapper()
                .readerFor(clazz);
        return reader.readValue(bytes);
    }
}