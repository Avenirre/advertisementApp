# Advertisement Application

## Introduction

The advertisement application allows the user to add (publish) new advertisements(Advertisement object includes 4 fields - 3 String type: title, description, topic + one filed LocalDate type(timestamp)) and find existing ones by two ways:
1. Using a topic name
2. Using words that advertisement title or description are consisted of.


## API
Publish
Method POST

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

Running `bin/phpa` on this file would yield the following output:

```
----------------------------------------------
| file        | line | message               |
==============================================
| example.php | 3    | if ($user !== null) { |
----------------------------------------------

1 out of 1 boolean expressions are assumptions (100%)
```

This is an example of an **assertion**:

```php
if ($user instanceof User) {
    $user->logout();
}
```

## Tests
This project is built with [PHPUnit](https://github.com/sebastianbergmann/phpunit) and [Prophecy](https://github.com/phpspec/prophecy-phpunit).
In order to run these tests make sure you have dev dependencies installed with composer.

Running PHPUnit:
```sh
$ ./vendor/bin/phpunit
```
