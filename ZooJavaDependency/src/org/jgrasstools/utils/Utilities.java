package org.jgrasstools.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple utis class to create a dependency for the main 
 * java wps module.
 * 
 * @author Andrea Antonello (www.hydrologis.com)
 */
public class Utilities {

    public static void workOnData( String inDataPath, String outDataPath ) throws Exception {
        List<String> header = new ArrayList<>();
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inDataPath))) {
            String line;
            int count = 0;
            while( (line = br.readLine()) != null ) {
                if (count++ < 6) {
                    header.add(line);
                } else {
                    lines.add(line);
                }
            }
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outDataPath))) {
            for( String line : header ) {
                bw.write(line + "\n");
            }
            int size = lines.size();
            // write inverted lines
            for( int i = 0; i < size; i++ ) {
                String line = lines.get(size - i - 1);
                bw.write(line + "\n");
            }
        }
    }
}
