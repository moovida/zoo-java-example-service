zoo-java-example-service
========================

A zoo-project java wps service example with dependencies jar

Important files and folders
-------------------------------

Raster
++++++++

* dtm.asc
* dtm.prj
* dtm.sld

which is a very small raster file. It is small but works well. This
has to be used as input map.

WPS stuff
++++++++++++

* ZooJavaMain: contains the service class ZooJavaWps.
* ZooJavaDependency: the dependency project, from which a jar should be created. It contains a single utility class called by the main project
* ZooJavaBuilder.zcfg: the zoo configuration file.
