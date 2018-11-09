package fr.EasyGameMotor.GameConfig;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class FPSConfig {

	@SuppressWarnings("unchecked")
	public static int getFPSConfig() {
		Yaml yaml = new Yaml();
        Reader yamlFile = null;
        
		try {
			
			yamlFile = new FileReader("config.yml");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}

        Map<String , Object> yamlMaps = (Map<String, Object>) yaml.load(yamlFile);
		
		return (int) yamlMaps.get("FPS");
	}
}
