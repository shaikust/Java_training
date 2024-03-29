package demo.javaFiles;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
		String inputFilePath = "src/main/resources/static/input.json";
		String outputFilePath = "src/main/resources/static/output.json";

		try {
			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonData = readJSON(objectMapper, inputFilePath);
			editJSON(objectMapper, (ObjectNode) jsonData);
			saveJSON(objectMapper, jsonData, outputFilePath);
			System.out.println("JSON file has been modified and saved to: " + outputFilePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static JsonNode readJSON(ObjectMapper objectMapper, String filePath) throws IOException {
		return objectMapper.readTree(new File(filePath));
	}

	private static void editJSON(ObjectMapper objectMapper, ObjectNode jsonData) {
		jsonData.put("name", "Samuel");
		jsonData.put("age", 29);


		jsonData.put("Hobbies", "Travelling");
		jsonData.put("Experience", 2);
	}

	private static void saveJSON(ObjectMapper objectMapper, JsonNode jsonData, String filePath) throws IOException {
		objectMapper.writeValue(new File(filePath), jsonData);
	}

}
