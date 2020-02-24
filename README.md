# Advertisement Application

## Introduction

The advertisement application allows the user to add (publish) new advertisements(Advertisement object includes 4 fields - 3 String type: title, description, topic + one filed LocalDate type(timestamp)) and find existing ones by two ways:
1. Using a topic name
2. Using words that advertisement title or description are consisted of.


## Introduction
PHP Assumptions is the result of a proof of concept inspired by the "[From assumptions to assertions](http://rskuipers.com/entry/from-assumptions-to-assertions)" blog post.
It's a static code analysis tool doing checks for weak assumptions.

This is an example of an **assumption**:

```php
if ($user !== null) {
    $user->logout();
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
