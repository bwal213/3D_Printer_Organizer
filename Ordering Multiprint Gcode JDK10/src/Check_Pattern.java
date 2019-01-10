import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * 
 */

/**
 * @author Ben Walker
 *
 */
public class Check_Pattern {
	
	static String filePath;
	static float dist;
	static int space = 20;
	
	Check_Pattern(String path, int distance){
		
		filePath = path;
		dist = distance;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Charset charset = Charset.forName("UTF-8");
		FileReader file;
		FileWriter tempFile;
		
//		if(args.length > 0){
		
		try {
			file = new FileReader(filePath);
			BufferedReader br = new BufferedReader(file);
			tempFile = new FileWriter(filePath + ".TEMP");
			BufferedWriter bw = new BufferedWriter(tempFile);
			
			int[] num = new int[0];
			//float num = new float[0];
			
			System.out.println("Created br");
			
			String line = br.readLine();
			while(true) {
				if(line.length() == 0 || line.contains("intro line")) {
					line = br.readLine();
					System.out.println("Move to next line");
				}
				else {
					break;
				}
			}
			
			int yPointer = 4;
			int xPointer = 4;
			
			float xValue = 0;
			float yValue = 0;
			
			for(int i = xPointer; i < line.length(); i++) {
				if(line.charAt(i) == ' ') {
					System.out.println(line.substring(xPointer, i));
					xValue = Float.parseFloat(line.substring(xPointer, i+1));
					yPointer = i += 2;
					break;
				}
			}
			while(true) {
				try {
					for(int i = yPointer+1; i < line.length(); i++) {
						if(line.charAt(i) == ' ') {
							System.out.println(line.substring(yPointer, i));
							yValue = Float.parseFloat(line.substring(yPointer, i+1));
							break;
						}
					}
					break;
					
				}catch(Exception e){
					line = br.readLine();
				}
			}
			
			System.out.println("Set initial Values");
			
			float xValue2 = 0;
			float yValue2 = 0;
			float tmp,tmp2,tmp3,tmp4;
			boolean xCompare, xCompare2, yCompare, yCompare2, xyCompare;
			
			System.out.println("Entering While");
			
			while(line != null && !line.contains("home X axis")) {
				
				if(line.length() != 0) {
				
					for(int i = xPointer; i < line.length(); i++) {
						if(line.charAt(i) == ' ') {
							//System.out.println(line.substring(xPointer, i+1));
							xValue2 = Float.parseFloat(line.substring(xPointer, i+1));
							yPointer = i += 2;
							break;
						}
					}
					
					for(int i = yPointer+1; i < line.length(); i++) {
						if(line.charAt(i) == ' ') {
							//System.out.println(line.substring(yPointer, i+1));
							yValue2 = Float.parseFloat(line.substring(yPointer, i+1));
							break;
						}
					}
					
					//System.out.println(xValue + " " + yValue + "\n" + xValue2 + " " + yValue2);
					tmp = (xValue + dist);
					tmp2 = (xValue - dist);
					tmp3 =(yValue + dist);
					tmp4 = (yValue - dist);
					
					xCompare = !(Float.compare((xValue + dist), xValue2) > 0);
					xCompare2 = !(Float.compare((xValue - dist), xValue2) < 0);
					yCompare = !(Float.compare((yValue + dist), yValue2) > 0);
					yCompare2 = !(Float.compare((yValue - dist), yValue2) < 0);
					
					if((xCompare || xCompare2) && (yCompare || yCompare2)) {
						//System.out.println(line);
						bw.write(line + "\n" + xValue + " " + yValue + "\n" + xValue2 + " " + yValue2);
						bw.newLine();
						xValue = xValue2;
						yValue = yValue2;
						line = br.readLine();
					}else {
						line = br.readLine();
					}
					
				}else {
					line = br.readLine();
				}
			}
			System.out.println("Exited While");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("A Critical Error Has Occured");
			e.printStackTrace();
		}
			
//		}
//		else{
//		System.out.println("No Arguments Specified");
//		}
	}

}
