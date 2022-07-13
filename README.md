# RandomSetBuilder
RandomSetBuilder - is a class that builds you set of random numbers from the range

## How to
## Creating object
To create an object of RandomSetBuilder use parameters `min`, `max` and `seed`. The range will be from `min` to `max` - 1.  
Parameters `min` and `seed` are optional. By default `min = 0` and `seed = System.currentTimeMillis()`.

Code example:
```java
RandomSetBuilder randomSetBuilder = new RandomSetBuilder(0, 10);
```

## Adding numbers to the set (building)
### append(int count)
To add some numbers to the set use `append(int count)` method. If `count` is more than number of integers that can be added, 
than only available number of integers will be added.

Code example:
```java
RandomSetBuilder randomSetBuilder = new RandomSetBuilder(0, 10);

randomSetBuilder.append(3);   // add 3 unique integers from the range [0, 9], 7 left unused
randomSetBuilder.append(2);   // add 2 unique integers from the range [0, 9], 5 left unused
randomSetBuilder.append(100); // add 5 unique integers from the range [0, 9], 0 left unused
randomSetBuilder.append(100); // add 0 unique integers from the range [0, 9], 0 left unused
```

### appendAll()
If you want to add all the rest unused integers use `appendAll()` method.

Code example:
```java
RandomSetBuilder randomSetBuilder = new RandomSetBuilder(0, 10);

randomSetBuilder.append(3);    // add 3 unique integers from the range [0, 9], 7 left unused
randomSetBuilder.append(2);    // add 2 unique integers from the range [0, 9], 5 left unused
randomSetBuilder.appendAll();  // add 5 unique integers from the range [0, 9], 0 left unused
```

## Getting building result
As the result you can get `List`, `Set`, `Queue`, `Deque` or integer array

Code example:
```java
Set<Integer> randomSet = randomSetBuilder.toSet();
List<Integer> randomList = randomSetBuilder.toList();
Queue<Integer> randomQueue = randomSetBuilder.toQueue();
Deque<Integer> randomDeque = randomSetBuilder.toDeque();
int[] randomArray = randomSetBuilder.toArray();
```
