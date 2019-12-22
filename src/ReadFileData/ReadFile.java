package ReadFileData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    private final String nameFile;
    private int size;

    public ReadFile(String nameFile, int size) {

        this.nameFile = nameFile;
        this.size = size;
    }

    public int[] read() throws IOException {
        String st;
        File file = new File(nameFile);
        int[] set;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            set = new int[size];
            for (int i = 0; i < size; i++) {
                if ((st = br.readLine()) == null) {
                    break;
                }
                set[i] = Integer.parseInt(st);
            }
        }
        
        if (set == null) {
            System.out.println("read fail");
            System.exit(-1);
        }
        
        return set;
    }

    public void setSize(int size) {
        this.size = size;

    }

}
