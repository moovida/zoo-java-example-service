package org.jgrasstools;

import java.util.HashMap;

import org.jgrasstools.utils.Utilities;

public class ZooJavaWps {
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static int ZooJavaBuilder( HashMap conf, HashMap inputs, HashMap outputs ) {
        try {

            HashMap<String, Object> inputInPathMap = (HashMap<String, Object>) inputs.get("inPath");
            String inPath = (String) inputInPathMap.get("value");

            HashMap<String, Object> inputOutPathMap = (HashMap<String, Object>) inputs.get("outPath");
            String outPath = (String) inputOutPathMap.get("value");

            Utilities.workOnData(inPath, outPath);

            HashMap<String, Object> outputOutPathMap = new HashMap<String, Object>();
            outputOutPathMap.put("dataType", "string");
            outputOutPathMap.put("value", outPath);

            outputs.put("outPath", outputOutPathMap);
        } catch (Exception e) {
            e.printStackTrace();
            outputs.clear();
            outputs.put("Result", "ERROR: " + e.getLocalizedMessage());
            return 4;
        }
        return 3;
    }

}
