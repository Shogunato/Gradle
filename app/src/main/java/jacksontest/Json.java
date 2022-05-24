package jacksontest;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Json {
    
    private static ObjectMapper om = getObjectMapper();
    private static ObjectMapper getObjectMapper() {
        return new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static JsonNode parse(String src) {

        try{
            return om.readTree(src);
        }catch(IOException e) {
            System.out.println("Congrats you cant even process JSON...");
            return null;
        }
        
    }

    public static <T> T fromJson(JsonNode node, Class<T> clazz) {

        try {
            return om.treeToValue(node, clazz);
        } catch (JsonProcessingException e) {
            System.out.println("Error passing JSON to Object");
        }
        return null;
        
    }

    public static JsonNode toJson(Object objToJason) {
        return om.valueToTree(objToJason);
    }

    public static String stringify(JsonNode node, boolean pretty) {

        try {
            
            if(pretty == false) {
                return om.writer().writeValueAsString(node);
            }else{
                return om.writer().with(SerializationFeature.INDENT_OUTPUT).writeValueAsString(node);
            }

        } catch (IOException e) {
            System.out.println("Error when returning from JsonNode to String");
        }
        return null;

    }

}
