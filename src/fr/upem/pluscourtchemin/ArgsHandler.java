package fr.upem.pluscourtchemin;

import java.util.Arrays;

public class ArgsHandler {
	private final String[] argLine;
	
	public ArgsHandler(String[] args){
		if(args.length < 4 ){
			throw new IllegalArgumentException("Usage : java ProjetAlgo -i input.xml -o output.png");
		}
		
		this.argLine = Arrays.copyOf(args, args.length);
	}
	
	/**
	 * Function to retrieve the xml filename for the parsing.
	 * 
	 * @return corresponding filename if in the line or null if 
	 * 			no one was found.
	 */
	public String getXmlFileName() {
		String[] args = argLine;

		for (int i = 0 ; i < args.length; i++) {
			if(args[i].equals("-i")){
				return new String(args[i+1]) ;
			}
		}
		
		return null;
	}
	
	/**
	 * Function to retrieve the png filename that will be generated
	 * 	on output.
	 * 
	 * @return corresponding filename if in the line or null if 
	 * 			no one was found.
	 */
	public String getPngOutputName() {
		String[] args = argLine;

		for (int i = 0 ; i < args.length; i++) {
			if(args[i].equals("-o")){
				return new String(args[i+1]) ;
			}
		}
		
		return null;
	}
}