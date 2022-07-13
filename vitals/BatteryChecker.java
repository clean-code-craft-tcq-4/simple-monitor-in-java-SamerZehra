package vitals;

public class BatteryChecker {
	static boolean batteryIsOk(float temperature, float soc, float chargeRate) {
		return TemperatureChecker.checkTemperature(temperature) && SocChecker.checkSoc(soc) && ChargeRateChecker.checkChargeRate(chargeRate);
	}
}
