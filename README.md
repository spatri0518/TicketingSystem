# TicketingSystem
Ticketing Service Application is built using the Java technologies like Spring Framework with Jersey Rest Web Service.
Application Scope:
1)	Find the number of seats available with optional parameter venue level.
2)	Find and hold seats based on the input parameters like number of seats and the preferred level.
3)	Reserve seats which were hold earlier.
4)	Process which releases the holds after preconfigured time period.
#Software Prerequisites:
Pls. install the below listed software’s if not present.
1)	Gradle 1.12
2)	JDK 1.8
#Build Process: 
1)	Download the project from GIT using the below link

2)	Extract the TicketingService.zip file to a folder.
3)	Update the application log file path variable “logPath” in the below file 
TicketingSystem\src\main\resources\TicketingService-log4j2.xml
4)	Open command prompt and cd to the project folder.
5)	Use the below command to build and run the project
     Gradle jettyRunWar

6)	Should have downloaded the dependencies and executed the junit tests cases, generated war file, 
deployed and started jetty server with the APP running .
 

Also pls. note that the test cases status can be found in the below location
%PROJECT_FOLDER%//build/reports/tests/index.html as shown in the below screen shot.
 
Execution Steps:
1)	Service can be tested using rest client or directly from the browser using the below links 

API 1 – to find Seats Available
http://localhost:8080/ticketingSystem/rest/ticketing/numSeatsAvailable?venueLevel=2

API 2 – to find and hold Seats based on the availability and the level parameters
http://localhost:8080/ticketingSystem/rest/ticketing/findAndHoldSeats?numSeats=2&customerEmail=spatri@gmail.com&minLevel=2&maxLevel=2

API 3 – to reserve the tickets which are already hold.
http://localhost:8080/ticketingSystem/rest/ticketing/reserveSeats?seatHoldId=1636145645&customerEmail=spatri@gmail.com

 


 

