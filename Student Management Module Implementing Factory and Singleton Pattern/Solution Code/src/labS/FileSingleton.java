package labS;



import java.io.File;
import java.io.IOException;

public class FileSingleton {
	private static FileSingleton studentFile = new FileSingleton();
	private File file;
	
	private FileSingleton() {}
	
	public File getFileObject() {
		file = new File("studentDatabase.json");
		
		try {
			if(file.createNewFile()) {
				return file;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return file;
	}
	
	public static File getFile() {
		return studentFile.getFileObject();
	}
}