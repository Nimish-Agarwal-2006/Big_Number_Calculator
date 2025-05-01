# CUSTOM BIG_NUMBER CALCULATOR

## INTRODUCTION
- The main objective of this library is the implementation of an **Infinite/Arbitrary-Precision Calculator**.
- It allows for handling large numbers with arbitrary precision, which are beyond the capabilities of standard data types.
- The library includes support for basic arithmetic operations such as addition, subtraction, multiplication, and division, with accurate results even for very large or small numbers.

## IMPLEMENTATION
- **Language**: Java 23
- **Build Tool**: Ant

### FILE STRUCTURE
- The library contains a package called `arbitraryarithmetic` with the following files:
  - **`AInteger.java`**: Contains the implementation for arbitrary-precision integer arithmetic.
  - **`Afloat.java`**: Contains the implementation for arbitrary-precision floating-point arithmetic.
  - **`MyInfArith.java`**: The main class that integrates and provides the interface for performing arbitrary-precision arithmetic operations.



### FEATURES
- Handles arbitrary-precision integers.
- Supports addition, subtraction, multiplication, and division.
- Can handle negative numbers.
- String-based implementation, ensuring large numbers are accurately represented.
- Provides basic utility methods for comparison, copying, and parsing.

## COMPONENTS

### AINTEGER.JAVA (INTEGER CLASS)
- The `Ainteger` class handles operations for arbitrarily large integers, including support for negative values. It supports basic arithmetic operations such as addition, subtraction, multiplication, and division, using string-based representations for the numbers. This class ensures no precision is lost, even with very large numbers.
- This class file belongs to the `arbitraryarithmetic` package.

#### MEMBER VARIABLES
- It has a protected member `num` of type `String`.

#### CONSTRUCTORS
1. **DEFAULT CONSTRUCTOR**:
   - **`public Ainteger()`**: Initializes the `num` member variable to the string `"0"`, representing the integer value 0.
   
2. **PARAMETERIZED CONSTRUCTOR**:
   - **`public Ainteger(String s)`**: Initializes the `num` member variable with the value provided in the string `s`.

#### KEY METHODS
- `copy()`: Returns a new Ainteger object initialized with the current `num` value.
- **`addition(Ainteger a)`**:  
  Calls the `add(Ainteger a)` method to add the current `Ainteger` with another `Ainteger`. It then trims the output of the `add` method to ensure the result is correctly formatted.
- **`subtract(Ainteger a)`**:  
  Calls the `sub(Ainteger a)` method to subtract another `Ainteger` from the current `Ainteger`. It then trims the output of the `sub` method.
- **`multiply(Ainteger a)`**:  
  Calls the `mult(Ainteger a)` method to multiply the current `Ainteger` with another `Ainteger`. It then trims the output of the `mult` method.
- **`divide(Ainteger a)`**:  
  Calls the `division(Ainteger)` method where it divides the current `Ainteger` by another `Ainteger` and returns the list of quotient and remainder. It returns the quotient from the output of the `division` method.
- `compareTo(Ainteger a)`: Compares two `Ainteger` objects.
- `remove_zeroes(String s)`: Removes leading or trailing zeros from a string representation of a number.
- `parse(String s)`: Parses a string into an `Ainteger` object.
- `valid_check(String s)`: Checks if a string is a valid integer.

### AFLOAT.JAVA (FLOAT CLASS)
- This class file belongs to the `arbitraryarithmetic` package.
- The `Afloat` class handles arbitrary-precision floating-point numbers, offering support for both integer and decimal parts. Like the `Ainteger` class, `Afloat` uses string-based representations to store numbers and ensures no precision loss for large numbers. This class supports operations like addition, subtraction, multiplication, and division on floating-point numbers.

#### MEMBER VARIABLES
- `num`: Stores the number as a string.
- `intpart`: Stores the integer part of the number.
- `decimalpart`: Stores the decimal part of the number.
- `no_decimal_num`: Stores the number string without the decimal.

#### CONSTRUCTORS
- **`Afloat()`**: Initializes an `Afloat` object with a default value of `0.0`.
- **`Afloat(String inp)`**: Initializes an `Afloat` object with a given string input representing a floating-point number.
  - If the input does not contain a decimal point, it appends `.0` to treat it as a floating-point number.
  - Splits the input into two parts:
    - `intpart`: The part before the decimal.
    - `decimalpart`: The part after the decimal.
  - Concatenates `intpart` and `decimalpart` to get `no_decimal_num`, which is used for internal arithmetic operations.

#### KEY METHODS
- `copy()`: Returns a new Afloat object initialized with the current `num` value.
- **`addition(Afloat a)`**:  
  Calls the `add(Afloat a)` method to add the current `Afloat` with another `Afloat`. It then trims the output of the `add` method to ensure the result is correctly formatted.
- **`subtract(Afloat a)`**:  
  Calls the `sub(Afloat a)` method to subtract another `Afloat` from the current `Afloat`. It then trims the output of the `sub` method.
- **`multiply(Afloat a)`**:  
  Calls the `mult(Afloat a)` method to multiply the current `Afloat` with another `Afloat`. It then trims the output of the `mult` method.
- **`divide(Afloat a)`**:  
  Calls the `division(Afloat a)` method where it divides the current `Afloat` by another `Afloat`. It then trims the output of the `division` method.
- `compareTo(Afloat a)`: Compares two `Afloat` objects.
- `remove_zeroes(String s)`: Removes leading or trailing zeros from a string representation of a number.
- `parse(String s)`: Parses a string into an `Afloat` object.
- `valid_check(String s)`: Checks if a string is a valid float.

### MYINFARITH.JAVA
- It is a Java file which imports the package and runs test cases.
- It takes command-line arguments and performs arithmetic operations.

### EXECUTING USING MYINFARITH
To perform addition, subtraction, multiplication, and division, run the following commands:

```bash
java MyInfArith int add 49485475 9897557
Result: 59383032
java MyInfArith float sub 0.0099 0009
Result: -8.9901
java MyInfArith int mul 6 7
Result: 42
java MyInfArith int div 20 4
Result: 5
```
## Runner.py
- It is a python script which run the program with command lines arguments using MyInfarith.java
---
## Executing using runner.py
To perform addition, subtraction, multiplication, and division, run the following commands:

```bash
python3 runner.py int add 2402726 -200000
Result: 2202726
 python3 runner.py int sub 58757 -8877
Result: 67634
python3 runner.py float mul 9.009 -07 
Result: -63.063
python3 runner.py float div 9 7 
Result: 1.285714285714285714285714285714
```
## Installation

Simply download or clone this repository and add the `Ainteger` and `Afloat` classes to your Java project. There's no additional installation required.

## Conclusion
### Key Learning
- Arbitrary Precision Arithmetic: Implementing custom data types for handling large numbers, which standard Java data types can't manage due to their fixed size and precision limits.
- String-based Representation: Using strings to represent large integers and floating-point numbers ensures that precision is maintained across arithmetic operations.
- Learned How to use ant build tool and using Python to run commands in command line.
###
- Each arithmetic operation (addition, subtraction, multiplication, division) was tested with both small and large numbers to ensure the results are accurate.
- Special attention was given to operations with negative numbers, zero, and very large numbers.
- The results from the library were compared against the built-in Java BigInteger and BigDecimal classes to verify correctness.
###
- The string-based arithmetic operations may be slower compared to built-in data types, especially for very large numbers.
- Handling large numbers using strings can consume a significant amount of memory, which may be a concern for extremely large values.
