import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 
 */

/**
 * @author Ben Walker
 *
 */
public class Organize_Gcode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		GetFile gf = new GetFile();
		System.out.println("gf created");
		//gf.main(args);
		gf.main(args);
		
		System.out.println("gf.main ran");
		
		FileReader ogFile;
		FileWriter tmpFile;
		FileWriter newFile;
			
//			if(args.length > 0){
			
		try {
			/**
			 * sets up a buffered reader and writer to work in tandem, so that a new file can be created with only the lines of moves.
			 */
			System.out.println("Entered try{");
			ogFile = new FileReader(gf.getPath());
			BufferedReader br = new BufferedReader(ogFile);
			tmpFile = new FileWriter(gf.getPath() + ".tmp");
			BufferedWriter bwTmp = new BufferedWriter(tmpFile);
			
			int numOfObjects = gf.getNumObjects();
			
			int[] num = new int[numOfObjects];
			
			/*
			 * Needs clarity
			 */
			float[][] locations = new float[0][];
			
			String allLines = "";
			
			/**
			 * reads in a line and sees if eof has been reached. Every line that has X and Y coordinates is added to new file.
			 */
			String line = br.readLine();
			
			System.out.println("Entering While");
			
			while(line != null){
				
				if(line.length() > 3 && line.charAt(3) == 'X'){
					//allLines += allLines + line + " ";
					bwTmp.write(line);
					bwTmp.newLine();
				}
				line = br.readLine();
			}
			System.out.println("Exited While");
			
			br.close();
			bwTmp.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("A Critical Error Has Occured");
			e.printStackTrace();
		}
		
		Check_Pattern cp = new Check_Pattern(gf.getPath() + ".tmp", 35);
		
		cp.main(args);
				
//		}
//		else{
//		System.out.println("No Arguments Specified");
//		}

	}
	
	

}
