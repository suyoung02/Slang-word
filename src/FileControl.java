import java.io.*;
import java.util.*;

public class FileControl {
    TreeMap<String, List<String>> map;
    List<String> history;
    Set<String> keySet;
    public FileControl() {
        map = new TreeMap<String, List<String>>();
        history = new ArrayList<String>();
    }

    void loadOriginalData() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src\\data\\originslang.txt"));
        String line = "";
        line = br.readLine(); // read the structure of the file in the first line
        String word = null;
        List<String> defi = new ArrayList<String>();
        //Read every line in file
        while((line = br.readLine()) != null){
            String[] buffer = line.split("`"); //split the line into Array list as slangword and definition
            if(buffer.length <= 1){ // if the line is no contains the char ' means no slangword
                defi.add(buffer[0]);
                map.put(word,defi); // change the value of the previous slangword
            } else {
                word = buffer[0]; //get the slangword
                List<String> definition = new ArrayList<String>();
                String[] buff = buffer[1].split("\\|"); //get the definition

                for(int i = 0; i < buff.length;i++){
                    definition.add(buff[i]); // split multiple definition
                }
                this.map.put(word, definition); // add slangword and definition in treemap
                defi = definition; // save the key to use next
            }
        }
        br.close();
    }
    void loadData() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src\\data\\originslang.txt"));
        String line = "";
        line = br.readLine(); // read the structure of the file in the first line
        String word = null;
        List<String> defi = new ArrayList<String>();
        //Read every line in file
        while((line = br.readLine()) != null){
            String[] buffer = line.split("`"); //split the line into Array list as slangword and definition
            if(buffer.length <= 1){ // if the line is no contains the char ' means no slangword
                defi.add(buffer[0]);
                map.put(word,defi); // change the value of the previous slangword
            } else {
                word = buffer[0]; //get the slangword
                List<String> definition = new ArrayList<String>();
                String[] buff = buffer[1].split("\\|"); //get the definition

                for(int i = 0; i < buff.length;i++){
                    definition.add(buff[i]); // split multiple definition
                }
                this.map.put(word, definition); // add slangword and definition in treemap
                defi = definition; // save the key to use next
            }
        }
        br.close();
    }
    void loadHistory() throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src\\data\\history.txt"));
            String line = "";
            while ((line = br.readLine()) != null){
                history.add(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    void searchSlangWord(String keyword){
        //Convert key from treemap to set
        ArrayList<String> slang = new ArrayList<String>();
        this.keySet = this.map.keySet();
        for(String key : keySet){
            if(key.contains(keyword)){
                System.out.println(key + " - " + this.map.get(key));
            }
        }
    }

    void addHistory(String keyword){
        this.history.add(keyword);
    }

    void saveHistory() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("src\\data\\history.txt"));
        for(String key : this.history){
            bw.write(key);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    void addSlangWord(String word,List<String> definition){
        if(this.map.get(word) != null){

        } else {
            this.map.put(word, definition);
        }
    }

    void overwrite(String slangword, String meaning){
        List<String> mean1 = List.of(meaning);
        map.put(slangword, mean1);
    }

    void duplicate(String slangword, String meaning){
        List<String> mean1 = map.get(slangword);
        mean1.add(meaning);
        map.put(slangword, mean1);
    }
}
