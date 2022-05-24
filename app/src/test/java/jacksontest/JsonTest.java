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

        assertEquals("Coder from Scratch", pojo.getTitle());

    }

    @Test
    void toJson() {

        SimpleTestCaseJson pojo = new SimpleTestCaseJson();
        pojo.setTitle("Testing 123");

        JsonNode node = Json.toJson(pojo);
        assertEquals("Testing 123", node.get("title").asText());

    }

    @Test
    void stringify() {

        SimpleTestCaseJson pojo = new SimpleTestCaseJson();
        pojo.setTitle("Testing 123");

        JsonNode node = Json.toJson(pojo);
        System.out.println(Json.stringify(node, false)+"\n");
        System.out.println(Json.stringify(node, true));

    }
}
