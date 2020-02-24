# Advertisement Application

## Introduction

The advertisement application allows users to add (publish) new advertisements(Advertisement object includes 4 fields - 3 String type: title, description, topic + one LocalDate type field(timestamp)) and find existing ones by two ways:
1. Using a topic name
2. Using words that advertisement title or description are consisted of.

## settings.properties

```
spring.data.mongodb.uri=mongodb://user:qwerty123456@ds057857.mlab.com:57857/advertisements?retryWrites=false
```

## API
Publish(POST)

http://localhost:8080/publish

During publishing the JSON in the body should be sent, see example below:

```
{
	"title": "7",
	"description": "newAdvertisement",
	"topic": "new",
	"timestamp": "2020-02-24T14:45:15"
}
```

In case of successful publication the next reply will be received:

```
"ADVERTISEMENT_ADDED_SUCCESSFULLY"
```
Otherwise, if the advertisement with the same title has already existed:

```
"ADVERTISEMENT_EXISTS"
```
Or, if the advertisement format is invalid (for example, it includes empty fields value/s):

```
"INVALID_ADVERTISEMENT_FORMAT"
```

findByTopic(GET)

http://localhost:8080/topic/{topicName}

findByTopic(GET)

http://localhost:8080/titleOrDescriptionPart/{word}
* word - the part of the title or the description 

If some advertisements are found the next reply will be received:

```
[
    {
        "title": "3",
        "description": "advertisement1",
        "topic": "test",
        "timestamp": "2020-02-24"
    },
    {
        "title": "2",
        "description": "advertisement1",
        "topic": "test",
        "timestamp": "2020-02-24"
    },
    {
        "title": "1",
        "description": "advertisement1",
        "topic": "test",
        "timestamp": "2020-02-24"
    }
]
```
Otherwise, the empty list returns:

```
"[]"
```


## Tests
This project is tested with JUnit5 and Postman.

## Scalability

1.The additional field "version" with @Version annotation is added to AdvertisementDAO class. Now we can use try-catch block for OptimisticLockingFailureException that is thrown if some servers try to alter the document concurrently. So invalid operations will be rolled back and repeated. This approach is not actual for current API but just if we add some updating documents methods and increase servers number.

2. The text indexes is added to such fields as "topic" and "title"+"description"(compound) for perfomance increasing in the case of adding new requests using the commands(DO IT BEFORE THE FIRST SEARCH QUERY LAUNCH TO AVOID ERRORS):

```
db.advertisements.createIndex({"topic": "text"})
db.advertisements.createIndex({"title": "text", "description": "text"})
```

3. The next step is sharding using.

## Possible improvements

1. It is possible to add optional long type parameter for GET statistics requests restricting the number of returned documents. If the parameter is not passed it should be use the default value from settings.properties.
2. Limit-offset approach



