# NYTimesArticles
* To run the app you should sync the build.gradle and download all required dependencies.
* This App build using MVVM architecture.
* There are 3 main packages: 
    - component: contains Views and ViewModel for each screen
    - data: contains data access layer and objects models 
    - util: contains utilities classes like constants and extensions.
* There is a unit test for APIs and ViewModel using (Mockito and Junit)
    - you can run it by select target component from "com.nytimesarticles(test)" and run target function 
* There is a UI test for Layout using (espresso)
    - you can run it by select target component from "com.nytimesarticles(androidTest)" and run target function 
