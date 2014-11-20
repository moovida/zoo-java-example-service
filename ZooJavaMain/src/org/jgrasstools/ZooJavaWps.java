package org.jgrasstools;

import java.util.HashMap;

import org.jgrasstools.utils.Utilities;

public class ZooJavaWps {
    public static int ZooJavaBuilder( HashMap<String, HashMap<String, String>> conf,
            HashMap<String, HashMap<String, String>> inputs, HashMap<String, HashMap<String, String>> outputs ) {
        try {
            HashMap<String, String> inputInPathMap = inputs.get("inPath");
            String inPath = inputInPathMap.get("value");

            HashMap<String, String> inputInParameterMap = inputs.get("inParameter");
            String inParameter = inputInParameterMap.get("value");

            HashMap<String, String> inputOutPathMap = (HashMap<String, String>) inputs.get("outPath");
            String outPath = inputOutPathMap.get("value");

            Utilities.workOnData(inPath, outPath, Double.parseDouble(inParameter));

            HashMap<String, String> outputOutPathMap = outputs.get("outPath");
            outputOutPathMap.put("value", outPath);
        } catch (Exception e) {
            e.printStackTrace();
            HashMap<String, String> outputOutPathMap = outputs.get("outPath");
            outputOutPathMap.put("value", "ERROR: " + e.getLocalizedMessage());
            return 4;
        }
        return 3;
    }

}
