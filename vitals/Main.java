package vitals;

import java.util.logging.Logger;

import vitals.utils.LanguageReader;

public class Main {

	private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {
		LanguageReader.getUserInput();
		assert (BatteryChecker.batteryIsOk(25, 70, 0.7f) == true);
		assert (BatteryChecker.batteryIsOk(50, 85, 0.0f) == false);
		assert (BatteryChecker.batteryIsOk(2.25f, 24, 0.7f) == true);
		assert (BatteryChecker.batteryIsOk(43, 24, 0.76f) == true);
		System.out.println(BatteryChecker.batteryIsOk(43, 24, 0.76f) == true);
		LOGGER.info("All tests done !");
	}

}