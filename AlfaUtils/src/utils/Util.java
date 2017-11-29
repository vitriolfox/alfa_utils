package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Util {
    public static <K,V> Map<K,Collection<V>> putMapSet(Map<K,Collection<V>> map, K key, V value){
        if (map.containsKey(key)){
            Collection<V> values = map.get(key);
            values.add(value);
            map.put(key, values);

        } else {
            Set<V> values = new HashSet<V>();
            values.add(value);
            map.put(key, values);
        }
        return map;
    }


    public static String[] fileSplitReader(String inputFilePath, String splitterCharacter) throws IOException {

        BufferedReader br;
        String[] splittedLine = null;

        try {
            br = new BufferedReader(new FileReader(inputFilePath));
            String line;

            if ((line = br.readLine()) != null) {
                splittedLine = line.split(splitterCharacter);
            } else {
                throw new IOException("No line to split!");
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
        return splittedLine;
    }

}
