Intro
========================

A zoo-project java wps service example with dependencies jar.

**This is a work in progress.**

Files and Folders in the eclipse projects
=============================================

WPS stuff
-----------

* ZooJavaMain: contains the service class ```org.jgrasstools.ZooJavaWps```.
* ZooJavaDependency: the dependency project, from which a jar should be created. It contains a single utility class (```org.jgrasstools.utils.Utilities```) called by the main project
* ZooJavaBuilder.zcfg: the zoo configuration file.


Raster
---------

* dtm.asc
* dtm.prj
* dtm.sld

which is a very small raster file. It is small but works well. This
has to be used as input map.

Files and Folders in the ZOO environment
============================================

The structure of the data in the cgi-bin folder is:
```
.
├── libZOO.so                        -> from the zoo-api/java
├── ZOO.class                        -> from the zoo-api/java
├── zoojavatest                      -> folder cfg and jars from this project
│   ├── main.cfg
│   ├── zoo_java_dependency.jar
│   └── zoo_java_mainwps.jar
└── zoo_loader.cgi                   -> the main zoo cgi file
```

How to create the jars
--------------------------
The jars can be exported from eclipse by right-clicking on the project and using the ```export->Java->Jar file``` option.

* ZooJavaMain -> is exported to -> zoo_java_mainwps.jar
* ZooJavaDependency -> is exported to -> zoo_java_dependency.jar

Testing GetCapabilities
---------------------------------

To check if the service is available:
```
http://127.0.0.1/cgi-bin/zoo_loader.cgi?ServiceProvider=&metapath=zoojavatest&Service=WPS&Request=GetCapabilities&Version=1.0.0
```
which should supply some xml containing also:
```
  <wps:ProcessOfferings>
    <wps:Process wps:processVersion="1">
      <ows:Identifier>ZooJavaBuilder</ows:Identifier>
      <ows:Title>ZooJavaTest</ows:Title>
      <ows:Abstract>It tests for java stuff.</ows:Abstract>
      <ows:Metadata xlink:title="It tests for java stuff 2."/>
    </wps:Process>
  </wps:ProcessOfferings>
  ```

Testing Execution
------------------------

Execution of the service can be triggered through:
```
http://127.0.0.1/cgi-bin/zoo_loader.cgi?ServiceProvider=&metapath=zoojavatest&Service=WPS&Request=Execute&Version=1.0.0&Identifier=ZooJavaBuilder&DataInputs=inPath=/mypath/dtm.asc
```

This should ideally run the module and launch and exception complaining about the path to the input file **/mypath/dtm.asc** not existing.




