# zuul-filtering-logging
filter and log requests during routing with Zuul

Its recommended to use `spring-cloud-gateway` instead of zuul which is supported by __recent springboot releases__. 
**Zuul is no longer supported in springboot**

## What does this do

This application demonstrates the use of Netflix Zuul to route requests

## How to use the service

Call any of
* http://localhost:8080/users/1
* http://localhost:8080/users/3
* http://localhost:8080/products/1
* http://localhost:8080/products/3

change port number using `server.port` setting in `application.yml`

## How to start the app

```bash
$ java -jar target/zuul_filter_logging-0.0.1-SNAPSHOT.jar
```


## Whats happening

* The file `src/main/java/resources/application.yml` contains routes mapping to paths `/products/**` `/users/**` which use the dummyjson endpoints
* The file `ZuulRequestLoggingFilter.java` adds an entry to request header for each request
* The file `ZuulResponseLoggingFilter.java` retrieves the added header, computes duration of the call and logs it



## Sample Invocation
invoke
```bash
$ curl -s "http://localhost:8080/users/1" |  jq
```
you get 
```json
{
  "id": 1,
  "firstName": "Terry",
  "lastName": "Medhurst",
  "maidenName": "Smitham",
  "age": 50,
  "gender": "male",
  "email": "atuny0@sohu.com",
  "phone": "+63 791 675 8914",
  "username": "atuny0",
  "password": "9uQFF1Lh",
  "birthDate": "2000-12-25",
  "image": "https://robohash.org/hicveldicta.png",
  "bloodGroup": "A−",
  "height": 189,
  "weight": 75.4,
  "eyeColor": "Green",
  "hair": {
    "color": "Black",
    "type": "Strands"
  },
  "domain": "slashdot.org",
  "ip": "117.29.86.254",
  "address": {
    "address": "1745 T Street Southeast",
    "city": "Washington",
    "coordinates": {
      "lat": 38.867033,
      "lng": -76.979235
    },
    "postalCode": "20020",
    "state": "DC"
  },
  "macAddress": "13:69:BA:56:A3:74",
  "university": "Capitol University",
  "bank": {
    "cardExpire": "06/22",
    "cardNumber": "50380955204220685",
    "cardType": "maestro",
    "currency": "Peso",
    "iban": "NO17 0695 2754 967"
  },
  "company": {
    "address": {
      "address": "629 Debbie Drive",
      "city": "Nashville",
      "coordinates": {
        "lat": 36.208114,
        "lng": -86.58621199999999
      },
      "postalCode": "37076",
      "state": "TN"
    },
    "department": "Marketing",
    "name": "Blanda-O'Keefe",
    "title": "Help Desk Operator"
  },
  "ein": "20-9487066",
  "ssn": "661-64-2976",
  "userAgent": "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/534.24 (KHTML, like Gecko) Chrome/12.0.702.0 Safari/534.24"
}


```
