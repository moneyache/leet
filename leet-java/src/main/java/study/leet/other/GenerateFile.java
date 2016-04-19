package study.leet.other;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class GenerateFile {

	public static void generateFile(String filePath) throws IOException, FileNotFoundException, NoSuchAlgorithmException {
		BufferedWriter writer  = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath),"utf-8"));
		Random random = new Random();
		for (int i = 0; i < 100000000; i++) {
			
			writer.write("key" + System.currentTimeMillis()*random.nextInt(100) + "\t" + random.nextInt(1000000000) + "\n");
		}
		writer.close();
	}
	public static void main(String[] args) {
		try {
			generateFile("E:\\test1.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
