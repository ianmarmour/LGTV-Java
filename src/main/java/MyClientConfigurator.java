/**
 * Created by ian on 7/12/17.
 */
import javax.websocket.ClientEndpointConfig;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class MyClientConfigurator extends ClientEndpointConfig.Configurator {
    static volatile boolean called = false;

    @Override
    public void beforeRequest(Map<String, List<String>> headers) {
        called = true;
        headers.put("origin", Arrays.asList("null"));
        headers.put("type", Arrays.asList("register"));
        headers.put("id", Arrays.asList("register_0"));
    }
}
