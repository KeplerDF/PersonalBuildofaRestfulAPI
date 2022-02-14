# PersonalBuildofaRestfulAPI

I have included comments above every method in order to explain my thought processes. I believe that I have built a Rest API to the best of my ability but it has become
more obvious that I need more experience in order to learn and refine some of the possible best practices when it comes to building a Rest API.

The program is built on top of a demo spring initialized program which allowed me to not only integrate Spring from the get go but also added a maven dependancy wrapper which
adds all the necessary dependancies for this project without myself having to do tedious version control. 

This program was set to use Java 11.

The program should be run from the DemoApplication after the pom.xml is initiated to allow for the download of all external libraries.




The following commands are what are required according to the requirements set forth. 

The first and second command do appear to work as intended according to rudamentory testing however I was having issues with the third as it seems I have made a mistake in the
logic which does not allow the for loop to access the secondary arraylist to which the first arraylist of matrixes is assigned. I currently expect this issue to be caused by
the fact that I have not made the object which stores this arraylist of metrics to be globaly accessable/present. I had thought I had achieved this by making the object in which
it is initiated and stored, a global decleration. The error produced is an indexOutOfBound exception and I have chosen not to wrap it in a try catch statment as I wanted to work 
on it further.


command to initiate a sensor      : "http://localhost:8080/sensor?country=ireland&city=dublin"

command to update the sensor      : "http://localhost:8080/update?sensorid=1&temperature=30&humidity30"

command to get the final response : "http://localhost:8080/infogetter?sensorid=1&timestart=2019-01-21T05:47:08.644&timeend=2023-01-10T05:47:08.644"
