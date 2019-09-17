# Word-Anagram

This is a code challenge for DiDi to fulfil a function output all the words according to the dictionary and the set of characters.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

This project should be run by Java version greater than Java 8. So you need to have a java 8 at least to run this project.

```
This is my Java version:
1. java version "1.8.0_221"
2. Java(TM) SE Runtime Environment (build 1.8.0_221-b11)
3. Java HotSpot(TM) 64-Bit Server VM (build 25.221-b11, mixed mode)
```

### Testing

A step by step series of examples that tell you how to get a development env running

Say what the step will be: 

```
git clone https://github.com/Shan6633/Word-Anagram.git
cd  Word-Anagram && ./runme.sh
```

## Test Case

For this project I use words on https://raw.githubusercontent.com/lad/words/master/words as my dictionary. And a char array char arr[] = {'a', 'b','d', 'e', 'f', 'g', 'h', 'i', 'j', 'k','m'}  as the input characters. You can change this char array within range from 'a' to 'z' in the main function in SearchWord.java

## Basic Idea

For this question, since the dictionary can have a large amount of data. So it will be both time and space consuming by just storing all data in to a Set and check character one by one. So I decided to build a Trie tree to store the dictionary.


