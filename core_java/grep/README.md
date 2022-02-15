# Java Grep Implementation
## Introduction
The Java Grep implementation is a grep-like application programmed using Java. The application has also been containerized for the convenience of the user. All that is needed to execute is a regex, a file path to the files you wish to search, and a path for the output file to be created in. The technologies used to achieve this are the Java programming language, Maven, and JUnit for testing.

## Quick Start
To get started using this application please first pull this application from either GitHub or DockerHub located [here](https://hub.docker.com/repository/docker/djnucci73/grep)

The usage for the java project from GitHub is: 

`mvn clean package`

`java -cp target/grep-1.0-SNAPSHOT.jar ca.jrvs.apps.grep.JavaGrepImp "Regex" inputPath outputFile`, this will run the for-loop based implementation of the grep app

`java -cp target/grep-1.0-SNAPSHOT.jar ca.jrvs.apps.grep.JavaGrepLambdaImp "Regex" inputPath outputFile`, this will run the stream based implementation of the grep app

---
For the docker image:

`docker pull djnucci73/grep`

```docker run --rm -v `pwd`/data:/data -v `pwd`/log:/log djnucci73/grep "Regex" inputPath outputFile```


## Implementation
### Pseudoscope
The program first finds the list of files it needs to check based off of the filepath passed in the command-line arguments. After the files have been added to a list, they are then looped through to read all lines they contain. Each line is checked for the regex given in the command-line arguments. All matching lines are printed to the output file, named by the command-line argument.

### Performance Issue
Because the Java grep implementation must loop all lines in all files and check them after storing them in a List, the memory consumption of the program is large. To fix this, a switch to lambda functions and streams can be implemented. Streams take up less memory than a List object would in this implementation. 

## Test
The scope of this project is fairly limited. This being the case, JUnit was only used to unit test the methods needed for this project. The final output file of the Java grep implementation was asserted manually to be the correct values. If this project was for production, additional testing would need to be implemented to increase coverage.

## Deployment
The application was dockerized for the convenience of the user. The package was first assembled by use of Maven. By use of the `Dockerfile` ([link](./Dockerfile)) and the docker build command, the docker image was created to encapsulate the Java grep app. After the docker image was verified to be functional, the image was pushed to DockerHub located [here](https://hub.docker.com/repository/docker/djnucci73/grep).

## Improvements
### Depth and Breadth First Search Flags
Currently the Java Grep implementation searches the first layer of the directory that was passed in the arguments. In future, the addition of flags for depth first and breadth first searches allows greater versatility in the usage of this app. These flags would take in an integer for the number of layers maximum they wish to search, defaulting to maximum depth. The implementation of these flags would require modification of the listFiles method to be recursive.

### General Efficiency Improvements
The implementation has room for some decent efficiency gains. As already mentioned in this README, most of this project runs utilizing List objects and for loops. By using Streams the memory usage should reduce. Other than this though is multi-threading. As this project currently stands it implements one thread searching through all files to then search each of those files. The program could search for all files, separate reading the lines into multiple threads to increase performance. 

### Greater Flexibility
As mentioned in the first improvement, the project is created for a couple of tight-knit use cases. By adding more flags to the application more use cases could be accommodated. The addition of a flag to change the output location to stdout would make this application more friendly to command line users. A flag that allows a regex to be read from a file could be implemented such that users will not have to rewrite long expressions into the command. Many more of these flags exist and would likely be implemented dependent on use case.

### Multiple Regex Matching
To expand upon the previous improvement, the ability to enter multiple regular expressions would increase the useability of the grep implementation. This could be done with the regex file flag outlined or take the shape of additional expressions in the arguments. This would reduce the amount of time needed to search through the file system for multiple grep uses therefore increasing the efficiency of the application.

