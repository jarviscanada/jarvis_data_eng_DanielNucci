package ca.jrvs.apps.practice;

public interface RegexExc {
	
	
	/**
	 * return true if filename extension is jpg or jpeg (case sensitive)
	 *  
	 * @param filename
	 * @return boolean 
	 */
	public boolean matchJpeg(String filename);
	
	/**
	 * return true if ip is valid (range is between 0.0.0.0 - 999.999.999.999)
	 * 
	 * @param ip
	 * @return boolean
	 */
	public boolean matchIp (String ip);
	
	/**
	 * return true if line is empty (empty or with whitespace)
	 * 
	 * @param line
	 * @return boolean
	 */
	public boolean isEmpty(String line);
}
