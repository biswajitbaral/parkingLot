package com.gojek;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class AppMain 
{
    public static void main( String[] args )
    {


		switch (args.length) {
		case 0:
			System.out.println("Please enter 'exit' to quit");
			System.out.println("Waiting for input...");

			while(true) {
				try {
					BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
					String inputString = bufferRead.readLine();
					if (inputString.equalsIgnoreCase("exit")) {
						break;
					} else if ((inputString == null) || (inputString.isEmpty())) {

					} else {
						parseTextInput(inputString.trim());
					}
				} catch (IOException e) {
					System.out.println("Oops! Error in reading the input from console.");
					e.printStackTrace();
				}
			}
			break;
			
		case 1:
			parseInputFile(args[0]);
			break;
		
		}

	
    }
    public static void parseTextInput(String params) {
		RequestHandler.handleRequest(params.split(" ")[0].toLowerCase(), params.split(" "));

	}
    
	public static void parseInputFile(String filePath) {

		File inputFile = new File(filePath);
		try {
			BufferedReader br = new BufferedReader(new FileReader(inputFile));
			String line;
			try {
				while ((line = br.readLine()) != null) {
					parseTextInput(line.trim());
				}
			} catch (IOException ex) {
				System.out.println("Error in reading the input file.");
				ex.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found in the path specified.");
			e.printStackTrace();
		}

	}
}
