# Getting Started with Open weather forecast

### Reference Documentation

Please get you appId from [Open weather](https://openweathermap.org) and then replace with it the following placeholder: #your appId#.

Open the application with your favourite IDE and run it on [localhost:8080](http://localhost:8080).

The parameters to enter are the following:

* The city: the selection will be eased by the autocomplete functionality.
* The starting hour from a range allowed among 0-23.
* The ending hour from a range allowed among 0-23.

The result returns for the next four days:

* the list of aggregations by the hours from the start to the end;
* the list of aggregations for the remaining hours of the day.

### Docker

On the root of this project you can find the Dockerfile and possibly run buildAndRun.sh
in order to build the image and run it.

### TO DO

* Logging
* Integration test
* Unit test to be improved
