import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FileControl fl = new FileControl();
        fl.loadData();
//        show(fl.map);
        fl.loadHistory();
        fl.searchSlangWord("AMA");
        fl.saveHistory();
        fl.duplicate("AMA", "A M A");
        fl.searchSlangWord("AMA");
    }
    public static void show(TreeMap<String, List<String>> map) {
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println(key + " - " + map.get(key));
        }
    }
}