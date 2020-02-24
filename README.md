# Advertisement Application

## Introduction

The advertisement application allows users to add (publish) new advertisements(Advertisement object includes 4 fields - 3 String type: title, description, topic + one LocalDate type field(timestamp)) and find existing ones by two ways:
1. Using a topic name
2. Using words that advertisement title or description are consisted of.


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
Or if the advertisement format is invalid (fir example it includes empty fields value/s):

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
This project is built with [PHPUnit](https://github.com/sebastianbergmann/phpunit) and [Prophecy](https://github.com/phpspec/prophecy-phpunit).
In order to run these tests make sure you have dev dependencies installed with composer.

Running PHPUnit:
```sh
$ ./vendor/bin/phpunit
```
