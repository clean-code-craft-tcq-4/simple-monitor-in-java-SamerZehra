package vitals;

import java.util.logging.Logger;

import vitals.utils.LanguageReader;

public class SocChecker {

	private static final Logger LOGGER = Logger.getLogger(SocChecker.class.getName());
	static float minSoc = 20.0f;
	static float maxSoc = 80.0f;
	
	static boolean checkSoc(float soc) {
		if (soc < minSoc || soc > maxSoc) {
			LanguageReader.printLanguageString("soc_out_of_range");
			return false;
		}
		
		if(soc <= minSoc + getSocTolerenceValue()) {	
			LanguageReader.printLanguageString("soc_low_warning");		
		}else if(soc >= maxSoc - getSocTolerenceValue()) {
			LanguageReader.printLanguageString("soc_high_warning");
		}else {
			LanguageReader.printLanguageString("soc_normal");
		}
		return true;
	}
	
	static float getSocTolerenceValue() {	
		return ((5 * maxSoc)/100 );
	}
}
