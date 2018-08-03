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

###How to contribute:

The easiest way to start is to investigate sample test class `com.nbc.testautomation.chillertv.SampleChillerTvTest`

Short guide which will be updated soon:

1. Inherit your test class from: `com.nbc.testautomation.chillertv.BaseTest`
1. Use [Page Object Approach] (https://code.google.com/p/selenium/wiki/PageObjects)
1. Inherit your page objects from: `com.nbc.testautomation.chillertv.page.BasePage`
1. For describing page controls use classes from package `com.nbc.testautomation.webdriver.element`, like `Button`, `Radio`, `TextInput`, `Link`, etc. Follow the example in `com.nbc.testautomation.chillertv.page.HomePage`
1. Use block classes for describing page blocks, which possibly can appear not once in many pages. Read more about this approach [here](https://github.com/yandex-qatools/htmlelements). Inherit you page blocks from `com.nbc.testautomation.webdriver.element.HtmlElement`. Follow the example in `com.nbc.testautomation.chillertv.page.HeaderMenuNavigationBlock`
  
###How to start Chiller TV application locally

1. Clone repo `https://github.com/NBCUOTS/hydra-chillertv.git`, navigate to just cloned folder `hydra-chillertv`
1. If folder `node_modules` is present inside `hydra-chillertv` (if you already cloned and tried to run it before), delete this folder: `rm -rf node_modules/`
1. In `hydra-chillertv` folder run: `npm install`
1. In `hydra-chillertv` folder run: `npm run qa-local`

If you have some issues, find more details about how to run locally here: [https://github.com/NBCUOTS/hydra/wiki/Running](https://github.com/NBCUOTS/hydra/wiki/Running)

###Git Workflow

Please, note, it's possible that some extra commands/actions are necessary to complete some step. Commands are provided just as examples. If it's not clear what should be done to complete the step, please, ask.

1. Fork this repo
1. Clone forked repo: `git clone https://user@gihub.com/user/repo.git`
1. Add official repo as remote to be up-to-date with latest changes: `git remote add upstream https://github.com/repo`
1. Create new branch in your just cloned local repo: `git checkout -b some-feature`. Name the branch according to feature/test what you are going to implement. You can also create new branch in your IDE
1. Add necessary changes to code in your feature-branch
1. Commit changes to you local repo: `git commit -a -m "Add first draft of some feature"`. You can also use IDE interface for commit your changes
1. Access to new commits from upstream: `git pull upstream master`
1. Merge latest changes from upstream master to your branch: `git merge <branch>`. Note, this command will merge the specified branch into the current branch, so you need to switch to you branch first. Note, that merge conflicts are possible. Also note, it's much more convenient to merge using IDE interface
1. After all conflicts are resolved, push you changes to origin (your forked repo): `git push origin feature-branch`
1. Create pull-request using github interface
1. After your pull-request is merged, yo can delete you local feature-branch. Than update you fork from upstream and go to step 4 to continue developing
1. If your pull-request was not merged and you received some comments, just go to step 5: add necessary changes to code in your feature-branch and proceed with updating pull-request 

Please, read this article for more detailed description of some steps and actions: [Git Forking Workflow] (https://www.atlassian.com/git/tutorials/comparing-workflows/forking-workflow)

####How to merge code in IntelliJ IDEA IDE

In this guide it is supposed, that currently some code changes were implemented in local forked repo.

All actions described below are applicable to IntelliJ IDEA only. On other IDEs some differences are possible

1. Ensure, that you commited your current changes to you local fork using following actions: 
  1. Select root folder in project explorer, open context menu, go to _Git_ -> _Commit Directory_, type some meaningful message and press _Commit_ 
1. If you are not ready to commit your changes, it's possible to stash your changes: 
  1. Select root folder in project explorer, open context menu, go to _Git_ -> _Repository_ -> _Stash changes..._ and press _Create stash_
1. If upstream remote is not added to your local repo, add it by performing `git remote` command from command line in your repo folder: `git remote add upstream https://github.com/NBCUOTS/hydra-demo.git`. More details is [here](https://help.github.com/articles/adding-a-remote/)
1. Then in IDE go to root folder in project explorer, open context menu, go to _Git_ -> _Repository_ -> _Branches_, and in the list of remote branches find _upstream/master_. Click it and then choose _Clone as new local branch_
1. Type some meaningful name for local branch, and click _Ok_. New local branch will be created and automatically switched to it
1. Select root folder in project explorer, open context menu, go to _Git_ -> _Repository_ -> _Pull..._. Select _upstream/master_ from the branches list, and press _Pull_. Changes from the server will be pulled to you local repo
1. If you already have _upstream/master_ as local branch, just checkout it: _Git_ -> _Repository_ -> _Branches_, select _upstream/master_ from list of local branches, and choose _Checkout_, and then update it from server using _pull_, as described above
1. Switch back to your branch: _Git_ -> _Repository_ -> _Branches_, select your local fork from list of local branches, and choose _Checkout_
1. Now merge latest changes from server to you local branch: Go to _Git_ -> _Repository_ -> _Branches_, select _upstream/master_ from list of local branches, and choose _Merge_
1. If there are no any conflicts, changes will be successfully merged to your local repo, and now you can either push it lo your remote fork and create pull request, or first unstash your changes and then commit it and push to remote fork
1. If there are some conflicts, IDE will suggest you to merge conflicts manually. You will see the pop-up window with the list of files to merge. Do the following:
  1. Select first file from the list
  1. Click _Merge_ button
  1. You will see the window splitted into three sections: _Local changes_ - it's your code, _Changes from server_ - it's code which is currently in _upstream/master_ and _Merge result_ - it's the section where you should merge manually code from server and yours. 
  1. Now you should carefully merge the code. Find more details [here](https://www.jetbrains.com/idea/help/resolving-conflicts.html) how to use merge tool
  1. Perform the same actions for all files in the list
1. After all files are merged, ensure that code is not broken by running `mvn compile` and `mvn test-compile`
1. Now you can push you code to remote fork and create pull request, or unstash your changes, commit it and then push to remote fork


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

Feel free to suggest custom algorithm of processing API data

###Saucelabs

1. Account for automated tests: *nbcu_chiller/chiller*
1. [Supported platforms and browsers] (https://saucelabs.com/platforms/)
1. [Platform Configurator] (https://wiki.saucelabs.com/display/DOCS/Platform+Configurator#/)
1. For testing applications which are running on localhost, use [Saucelabs Connect] (https://wiki.saucelabs.com/display/DOCS/Setting+Up+Sauce+Connect). Starting Saucelabs Connect: `bin/sc -u YOUR_USERNAME -k YOUR_ACCESS_KEY`, e.g.: `bin/sc -u nbcu_chiller -k 22532cbe-929b-49ee-80ef-10787cc537dc`
1. For run automated tests using Saucelabs use 'saucelabs' profile: `mvn clean test -Dspring.profiles.active=saucelabs`

Ask questions if any. It's just skeleton which will be extended significantly soon

TODO: add description of how test/build names in Saucelabs are generated

###How to add locators (class names, etc.) to elements in frontend application
If component is in `node_modules` folder:

1. After adding locator navigate to `node_modules/hydra` folder and run `npm install` or `npm i`
1. Run: `npm run build`
1. After verification, push changes to [https://github.com/NBCUOTS/hydra.git](https://github.com/NBCUOTS/hydra.git)
