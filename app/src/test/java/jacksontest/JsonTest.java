package jacksontest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.JsonNode;

import org.junit.jupiter.api.Test;

import jacksontest.testobjects.SimpleTestCaseJson;

public class JsonTest {

    private String exampleJsonSource = "{ \"title\": \"Coder from Scratch\", \"author\": \"Shogunato\" }";
    @Test
    void testParse() {

        JsonNode node = Json.parse(exampleJsonSource);
        assertEquals(node.get("title").asText(), "Coder from Scratch");

    }

    @Test
    void fromJson() {

        JsonNode node = Json.parse(exampleJsonSource);
        SimpleTestCaseJson pojo = Json.fromJson(node, SimpleTestCaseJson.class);

        assertEquals(pojo.getTitle(), "Coder from Scratch");

    }
}
