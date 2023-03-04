package homework_5.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.internal.platform.Platform;
import okhttp3.logging.HttpLoggingInterceptor;

public class PrettyLogger implements HttpLoggingInterceptor.Logger {

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public void log(String massage) {
        String trimMassage = massage.trim();
        if ((trimMassage.startsWith("{") && trimMassage.endsWith("}"))
                || (trimMassage.startsWith("[") && trimMassage.endsWith("]"))) {
            try {
                Object object = mapper.readValue(massage, Object.class);
                String prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
                Platform.get().log(prettyJson, Platform.INFO, null);
            } catch (JsonProcessingException e) {
                Platform.get().log(massage, Platform.WARN, e);
            }
        }
        else {
            Platform.get().log(massage, Platform.INFO, null);
        }
    }
}
