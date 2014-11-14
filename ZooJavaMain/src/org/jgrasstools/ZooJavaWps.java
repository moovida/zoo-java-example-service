package org.jgrasstools;

import java.util.HashMap;

import org.jgrasstools.utils.Utilities;

public class ZooJavaWps {
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static int ZooJavaBuilder( HashMap conf, HashMap inputs, HashMap outputs ) {
        try {
            String inPath = (String) inputs.get("inPath");
            String outPath = (String) inputs.get("outPath");

            Utilities.workOnData(inPath, outPath);

//            HashMap<String, Object> outputMap = new HashMap<String, Object>();
//            HashMap hm1 = new HashMap();
//            hm1.put("dataType","string");
//            HashMap tmp=(HashMap)(inputs.get("S"));
//            java.lang.String v=tmp.get("value").toString();
//            hm1.put("value","Hello "+v+" from JAVA WOrld !");

            outputs.put("outPath", outPath);
//            outputs.put("Result", outputMap);
        } catch (Exception e) {
            e.printStackTrace();
            outputs.clear();
            outputs.put("Result", "ERROR: " + e.getLocalizedMessage());
            return 4;
        }
        return 3;
    }

    public static void main( String[] args ) {
        HashMap inputs = new HashMap();
        inputs.put("inPath", "C:/Users/andre_000/workspace_jgrasstools/ZooJavaMain/dtm.asc");
        inputs.put("outPath", "C:/Users/andre_000/workspace_jgrasstools/ZooJavaMain/outdtm.asc");
        
        HashMap outputs = new HashMap();
        outputs.put("outPath", "C:/Users/andre_000/workspace_jgrasstools/ZooJavaMain/outdtm.asc");

        int zooJavaBuilder = ZooJavaBuilder(null, inputs, outputs);
        System.out.println(zooJavaBuilder);

    }
}
