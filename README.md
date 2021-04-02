# NaturalOrderComparator

Natural order comparator for java, maven project is for unit tests validation only.

Examples of sorting:

#### Example 1
Unsorted:
```sh
"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"
```
Sorted:

```sh
"eight", "five", "four", "nine", "one", "seven", "six", "ten", "three", "two"
```

#### Example 2
Unsorted:
```sh
"a1", "a10", "a2", "a01", "1", "a0"
```
Sorted:

```sh
"1", "a0", "a01", "a1", "a2", "a10"
```
#### Example 3
Unsorted:
```sh
"0.2", "0.10", "1.3", "4.5", "0.222", "0.873"
```
Sorted:

```sh
"0.10", "0.2", "0.222", "0.873", "1.3", "4.5"
```
#### Example 4
Unsorted:
```sh
"0.2.1", "0.20.0", "1.3.4", "3.5.5", "0.1.1", "0.1.4", "0.13.4"
```
Sorted:

```sh
"0.1.1", "0.1.4", "0.2.1", "0.13.4", "0.20.0", "1.3.4", "3.5.5"
```
#### Example 5
Unsorted:
```sh
"100", "1,000,000", "4,000,000", "4,000", "5,345,456", "1,000", "2,000.00"
```
Sorted:

```sh
"100", "1,000","2,000.00", "4,000", "1,000,000", "4,000,000", "5,345,456"
```
#### Example 6
Unsorted:
```sh
"00b","0000", "000a", "003", "002", "001", "000A", "000"
```
Sorted:

```sh
"000", "0000", "000a", "000A", "00b", "001", "002", "003"
```
#### Example 7
Unsorted:
```sh
"apple", "Apple","Orange","orange", "Pear","pear"
```
Sorted:

```sh
"apple", "Apple", "orange", "Orange", "pear", "Pear"
```
#### Example 8
Unsorted:
```sh
"£apple","Orange","orange", "0Pear","01pear", "$apple001", "$apple002", "$apple010"
```
Sorted:

```sh
"0Pear", "01pear", "$apple001", "$apple002", "$apple010", "£apple", "orange", "Orange"
```

