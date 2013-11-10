package projetAlgo;

public class ArgsHandler {
	
	private String inputName;
	private String outputName;
	
	public ArgsHandler(String[] args){
		if(args.length != 4 ){
			throw new IllegalArgumentException("Kaboom");
		}
		for(int i=0;i<args.length;i++){
			if(args[i].equals("-i")){
				inputName = new String(args[i+1]) ;
			}
			if(args[i].equals("-o")){
				outputName = new String(args[i+1]);
			}
		}
		
	}
	
	public String getInputName(){
		return inputName;
	}
	
	public String getOutputName(){
		return outputName;
	}
	
	

}
