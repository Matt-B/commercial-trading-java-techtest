# Anagram Finder
A simple command line utility for finding anagrams in a specified file

## Software required to run this
* Java 17

## Building and Running the tests
```
./gradlew clean build
```

## Running the program
```
./gradlew bootRun --args="example2.txt" 
```
where example2.txt is the text file that we want to search for anagrams

## Notes

### Description

This solution uses the `AnagramFileParser` class to parse the file line by line into a `List<String>` until it encounters a word of a different length, at which point it passes the group of words of  the same length to the `AnagramAggregator` class, which uses the Java streams API to group all the words by their constituent characters, sorted alphabetically. This gives us a `Map` where the values are the grouped anagrams. This is then returned to be printed to `stdout`, again using the streams API to join them with a comma delimiter. 

### Assumptions

As well as the assumptions listed in the PDF:
- The words in the input file are ordered by size
- The files may not fit into memory all at once (but all the words of the same size would)
- The words are not necessarily actual English words. For example, "ABC" and "CBA" are both considered words for the sake of this exercise.

I have also made the following additional assumption:
- Anagrams are case-sensitive

### Big O Analysis

As my solution uses `Arrays.sort()` to sort each word alphabetically as part of  the `sortedAlphabetically` method in the `AnagramAggregator` class, the Big O complexity of the algorithm is `O(n⋅m log m)`, where `n` is the number of words in the input and `m` is the maximum length of a word in the input. This is due to the sorting algorithm used by this method, which is the principal component of complexity in the solution.

### Potential Improvements

Given more time I would implement a more comprehensive set of integration tests to ensure better test coverage around the file parsing and printing code. The provided input did not have any uppercase letters however the program could be easily adjusted to handle them should it be required. Performance improvements would also be possible - such as investigating more efficient sorting algorithms or using a parallel stream but these may need to be driven by a requirement to handle bigger datasets.


