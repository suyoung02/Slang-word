import java.io.*;
import java.util.*;

public class FileControl {
    TreeMap<String, List<String>> map;
    public FileControl() {
        map = new TreeMap<String, List<String>>();
    }

    void loadData() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src\\data\\slang.txt"));
        String line = "";
        line = br.readLine();
        String word = null;
        List<String> defi = new ArrayList<String>();
        while((line = br.readLine()) != null){
            String[] buffer = line.split("`");
            if(buffer.length <= 1){
                defi.add(buffer[0]);
                map.put(word,defi);
            } else {
                word = buffer[0];
                List<String> definition = new ArrayList<String>();
                String[] buff = buffer[1].split("\\|");

                for(int i = 0; i < buff.length;i++){
                    definition.add(buff[i]);
                }
                this.map.put(word, definition);
                defi = definition;
            }

        }
    }
}
