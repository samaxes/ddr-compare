rem Install maven artifacts
call mvn install:install-file -DgroupId=org.w3c.ddr.simple -DartifactId=DDR-Simple-API -Dversion=2008-03-30 -Dpackaging=jar -Dfile=DDR-Simple-API.jar -DgeneratePom=true -DcreateChecksum=true
call mvn install:install-file -DgroupId=org.openddr.simpleapi.oddr -DartifactId=OpenDDR-Simple-API -Dversion=1.0.0.24 -Dpackaging=jar -Dfile=OpenDDR-Simple-API-1.0.0.24.jar -DgeneratePom=true -DcreateChecksum=true
