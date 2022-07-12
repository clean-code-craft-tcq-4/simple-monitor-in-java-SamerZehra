package vitals;

import java.util.logging.Logger;
public class Main {
	private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
	static float minTemperature = 0.0f;
	static float maxTemperature = 45.0f;
	static float minSoc = 20.0f;
	static float maxSoc = 80.0f;
	static float maxChargeRate = 0.8f;

	static boolean batteryIsOk(float temperature, float soc, float chargeRate) {
		return checkTemperature(temperature) && checkSoc(soc) && checkChargeRate(chargeRate);
	}

	static boolean checkTemperature(float temperature) {
		if (temperature < minTemperature || temperature > maxTemperature) {
			LOGGER.info("Temperature is out of range!");
			return false;
		}
		if(temperature <= minTemperature + getTempTolerenceValue()) {
			LOGGER.warning("Warning: Approaching minTemperature");
			LOGGER.warning("Warnung: MinTemperatur nähert sich");
		}else if(temperature >= maxTemperature - getTempTolerenceValue()) {
			LOGGER.warning("Warning: Approaching maxTemperature");
			LOGGER.warning("Warnung: Annäherung an maxTemperature");
		}
		return true;
	}

	static boolean checkSoc(float soc) {
		if (soc < minSoc || soc > maxSoc) {
			LOGGER.info("State of Charge is out of range!");
			return false;
		}
		
		if(soc <= minSoc + getSocTolerenceValue()) {
			LOGGER.warning("Warning: Approaching discharge");
			LOGGER.warning("Warnung: Naht Entladung");
		}else if(soc >= maxSoc - getSocTolerenceValue()) {
			LOGGER.warning("Warning: Approaching charge-peak");
			LOGGER.warning("Warnung: Ladespitze nähert sich");
		}
		return true;
	}

	static boolean checkChargeRate(float chargeRate) {
		if (chargeRate > maxChargeRate) {
			LOGGER.info("Charge Rate is out of range!");
			return false;
		}
		if(chargeRate >= maxChargeRate - getChargeRateTolerenceValue()) {
			LOGGER.warning("Warnung: Annäherung an maxChargeRate");
		}
		return true;
	}

	static float getSocTolerenceValue() {	
		return ((5 * maxSoc)/100 );
	}
	
	static float getTempTolerenceValue() {	
		return ((5 * maxTemperature)/100 );
	}
	
	static float getChargeRateTolerenceValue() {	
		return ((5 * maxChargeRate)/100 );
	}
	public static void main(String[] args) {
		assert(batteryIsOk(25, 70, 0.7f) == true);
		assert(batteryIsOk(50, 85, 0.0f) == false);
		assert(batteryIsOk(2.25f, 24, 0.7f) == true);
		assert(batteryIsOk(43 , 24, 0.76f) == true);
		LOGGER.info("All tests done !");
	}
}
