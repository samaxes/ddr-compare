# DDR Compare

Companion code to go along with the blog post at http://www.samaxes.com/2012/10/comparing-device-description-repositories/.

## Building DDR Compare

DDR Compare uses the [Apache Maven](http://maven.apache.org/) build system. Building DDR Compare requires you to have it installed.

Install [OpenDDR](https://github.com/OpenDDRdotORG/OpenDDR-Java) Maven dependencies into your local repository by executing the following script from inside the `lib` folder:

* `install-libs.sh` for Linux
* `install-libs.bat` for Windows

Build the project:

```shell
mvn clean package
```

## Deploying and running DDR Compare

DDR Compare needs a Java EE application server to run. Follow these steps to deploy it to JBoss AS:

1. Deploy the exploded WAR file to your application server.
1. Open the file `WAR/WEB-INF/classes/openddr/oddr.properties` and replace `<BASEDIR>` with the complete system path to the `openddr` directory.
1. Start your application server and point your browser to [http://localhost:8080/ddr](http://localhost:8080/ddr). 
