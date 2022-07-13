package vitals;

import java.util.logging.Logger;

import vitals.utils.LanguageReader;

public class ChargeRateChecker {

	private static final Logger LOGGER = Logger.getLogger(ChargeRateChecker.class.getName());
	static float maxChargeRate = 0.8f;
	
	static boolean checkChargeRate(float chargeRate) {
		if (chargeRate > maxChargeRate) {
			LanguageReader.printLanguageString("cr_out_of_range");
			return false;
		}
		if(chargeRate >= maxChargeRate - getChargeRateTolerenceValue()) {
			LanguageReader.printLanguageString("cr_high_warning");
		}else {
			LanguageReader.printLanguageString("cr_normal");
		}
		return true;
	}

	static float getChargeRateTolerenceValue() {	
		return ((5 * maxChargeRate)/100 );
	}
}
