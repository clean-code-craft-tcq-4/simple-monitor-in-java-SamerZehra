package vitals;

import java.util.logging.Logger;

import vitals.utils.LanguageReader;

public class TemperatureChecker {
	private static final Logger LOGGER = Logger.getLogger(TemperatureChecker.class.getName());
	static float minTemperature = 0.0f;
	static float maxTemperature = 45.0f;
	
	static boolean checkTemperature(float temperature) {
		if (temperature < minTemperature || temperature > maxTemperature) {
			LanguageReader.printLanguageString("temp_out_of_range");
			return false;
		}
		if(temperature <= minTemperature + getTempTolerenceValue()) {
			LanguageReader.printLanguageString("temp_low_warning");
		}else if(temperature >= maxTemperature - getTempTolerenceValue()) {
			LanguageReader.printLanguageString("temp_high_warning");
		}else {
			LanguageReader.printLanguageString("temp_normal");
		}
		return true;
	}
	
	static float getTempTolerenceValue() {	
		return ((5 * maxTemperature)/100 );
	}
	
}
