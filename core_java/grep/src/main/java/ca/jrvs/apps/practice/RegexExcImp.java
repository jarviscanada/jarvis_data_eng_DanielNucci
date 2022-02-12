package ca.jrvs.apps.practice;

import java.util.regex.Pattern;

public class RegexExcImp implements RegexExc {

	public RegexExcImp() {
		
	}

	@Override
	public boolean matchJpeg(String filename) {
		return Pattern.matches(".jpe?g$", filename);
	}

	@Override
	public boolean matchIp(String ip) {
		return Pattern.matches("^([0-9]{1,3}[\\.]){3}[0-9]{1,3}$", ip);
	}

	@Override
	public boolean isEmpty(String line) {
		return Pattern.matches("^\\s*$", line);
	}

}
