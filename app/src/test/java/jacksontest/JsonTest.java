package jacksontest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.DateConversion;

import com.fasterxml.jackson.databind.JsonNode;

import jacksontest.testobjects.*;

public class JsonTest {

    private String exampleJsonSource = "{\n    \"title\": \"Coder from Scratch\",\n    \"author\": \"Shogunato\"\n}";
    private String dayExampleJsonSource = "{\n    \"date\": \"2019-12-25\",\n    \"name\": \"Christmas Day\"\n}";

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
        pojo.setAutor("Shogunato");

        JsonNode node = Json.toJson(pojo);
        System.out.println(Json.stringify(node, false)+"\n");
        System.out.println(Json.stringify(node, true));

    }

    @Test
    void dayTest() {

        JsonNode node = Json.parse(dayExampleJsonSource);
        DayTestCaseJson pojo = Json.fromJson(node, DayTestCaseJson.class);

        assertEquals("2019-12-25", pojo.getDate().toString());

    }
}
