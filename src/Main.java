import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        FileControl fl = new FileControl();
        fl.loadData();
        show(fl.map);
    }
    public static void show(TreeMap<String, List<String>> map) {
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.println(key + " - " + map.get(key));
        }
    }
}