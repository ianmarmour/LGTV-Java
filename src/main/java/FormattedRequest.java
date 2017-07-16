/**
 * Created by ian on 7/15/17.
 */
import java.io.IOException;
import java.util.*;
public class FormattedRequest {
    private String reqType;
    private String reqId;
    private String reqClientKey;
    private String reqPayload;
    private String reqUri;

    public static String FormatRequest(String type, String id, String client_key, String payload, String uri) {
        LinkedHashMap hm = new LinkedHashMap();
        hm.put("type", type);
        hm.put("id", id);
        hm.put("client_key", client_key);
        hm.put("uri", uri);
        hm.put("payload", payload);

        LinkedHashMap<String, String> varcheck = VaribleChecker(hm);
        String formattedstring = "{";

        for(Map.Entry<String, String> entry: varcheck.entrySet()) {
            if(entry.getKey() == "payload") {
                formattedstring += "\"" + entry.getKey() + "\" : {" + entry.getValue() + "}";
            }
            else {
                formattedstring += "\"" + entry.getKey() + "\" : \"" + entry.getValue() + "\",";
            }
        }

        if(formattedstring.substring(formattedstring.length() - 1).equals(",") == true)  {
            System.out.println("Fuck");
            formattedstring = formattedstring.substring(0, formattedstring.length() -1);
        }
        formattedstring += "}";

        return formattedstring;
    }

    private static LinkedHashMap VaribleChecker(LinkedHashMap<String, String> args) {
            LinkedHashMap<String, String> newhash = new LinkedHashMap<String, String>();
            for (Map.Entry<String, String> entry : args.entrySet()) {
                if (entry.getValue() != null) {
                    newhash.put(entry.getKey(), entry.getValue());
                }
            }
            return newhash;
    }
}
