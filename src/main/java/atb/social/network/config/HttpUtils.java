package atb.social.network.config;

import javax.servlet.http.HttpServletRequest;

public class HttpUtils {

    private static final String[] IP_HEADERS = {
            "HTTP-X-Real-IP"

            // you can add more matching headers here ...
    };

    private HttpUtils() {
        // nothing here ...
    }

    public static String getRequestIP(HttpServletRequest request) {
        for (String header : IP_HEADERS){
            String values = request.getHeader(header);
        if (values == null || values.isEmpty()) {
            continue;
        }
        String[] parts = values.split("\\s*,\\s*");
        return parts[0];
          }
        return request.getRemoteAddr();

}

}
