#UI Automated Tests

Currently this is just code base for starting test automation. It contains flexible stuff which can be easily extended with any additional functionality

##Quick start guide of how to run and start implement automated tests

###How To Run:
To run tests locally do the following:

1. Install Java into your local machine 
1. Install Maven into your local machine
1. Install Firefox
1. Download [Selenium Server Standalone 2.46.0 JAR file] (https://selenium-release.storage.googleapis.com/index.html?path=2.46/)
1. Start Selenium Server from console using the following command: `java -jar selenium-server-standalone-2.46.0.jar`
1. Clone this repo, navigate to test/uitest folder
1. Start the tests with the following command: `mvn clean test -Dtestsuite.xml.file=src/test/resources/testsuite/sample.xml`
1. One simple test should be run: open the application and click 'Events' link

Use `-Dmaven.surefire.debug` parameter for run in debug mode.

Use `-Dtestsuite.xml.file={path_to_your_suite_file}` to specify test suite file to run


###Where to find and how to deal with content API

Frontend application uses REST API to retrieve to data, which is displayed on the pages. Currently Apiary Mock service is used - hardcoded values are returned instead of real data. Later it will be switched to real data, but the structure of responses should not be changed. Some changes are possible, but it should be reflected in Apiary Mock Service as well.

API Documentation is here: [http://docs.concertapichillerstablecopy.apiary.io/#](http://docs.concertapichillerstablecopy.apiary.io/#)

###How to process API data programmatically

In order to verify that Chiller TV frontend application correctly displays data, we are comparing what we see in the browser with corresponding data coming from API.
Below is described which steps to perform to retrieve the data from Chiller TV API programmatically

1. Define the endpoint you want to request ot retrieve the data, e.g.: `http://private-4dee3-pubcentralapi.apiary-mock.com/videos/1`
1. Send request to this endpoint, save the response JSON
1. I order to generate JAVA classes with Jackson annotations, go to [http://www.jsonschema2pojo.org](http://www.jsonschema2pojo.org)
1. Insert the JSON data there. Specify all necessary settings: package, class name, whether you'd like to cave constructors or not, etc.
1. Press 'ZIP' button - archive with classes will be generated. Jackson-style annotation is used in these classes to describe the JSON object and provide marshaling/unmarshaling using [Jackson Library](https://github.com/FasterXML/jackson)
1. Put these classes to appropriate place into `com.nbc.testautomation.chillertv.support.api.pojo` package
1. Add endpoint path to `src/test/resources/api/endpoints.properties` file and to `com.nbc.testautomation.chillertv.support.api.ApiEndpoints` class
1. Implement corresponding method in corresponding API service class. See example in `com.nbc.testautomation.chillertv.service.video.VideoApiService`. To send GET HTTP-request use method _get()_ of interface `com.nbc.testautomation.http.HttpProvider`. Currently on implementation of this interface is available: `com.nbc.testautomation.http.RestTemplateHttpProvider`. Feel free to use your uwn if it's reasonable. In described case [RestTemplate] (https://spring.io/guides/gs/consuming-rest/) will take responsibility for mapping JSON to POJO classes, so the POJO object filled with API data will be returned.  
1. Classes like `com.nbc.testautomation.chillertv.support.ObjectConverter` are aimed to convert data form POJO to domain model business objects. Feel free to use some custom algorithms.
1. As a result, API service will return business object of application domain model. Then it can be compared with data which is comming from API

