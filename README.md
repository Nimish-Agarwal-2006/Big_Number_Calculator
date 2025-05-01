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
  - **`AFloat.java`**: Contains the implementation for arbitrary-precision floating-point arithmetic.
  - **`MyInfArith.java`**: The main class that integrates and provides the interface for performing arbitrary-precision arithmetic operations.



### FEATURES
- Handles arbitrary-precision integers.
- Supports addition, subtraction, multiplication, and division.
- Can handle negative numbers.
- String-based implementation, ensuring large numbers are accurately represented.
- Provides basic utility methods for comparison, copying, and parsing.

## COMPONENTS

### AINTEGER.JAVA (INTEGER CLASS)
- The `AInteger` class handles operations for arbitrarily large integers, including support for negative values. It supports basic arithmetic operations such as addition, subtraction, multiplication, and division, using string-based representations for the numbers. This class ensures no precision is lost, even with very large numbers.
- This class file belongs to the `arbitraryarithmetic` package.

#### MEMBER VARIABLES
- It has a protected member `num` of type `String`.

#### CONSTRUCTORS
1. **DEFAULT CONSTRUCTOR**:
   - **`public AInteger
  ()`**: Initializes the `num` member variable to the string `"0"`, representing the integer value 0.
   
2. **PARAMETERIZED CONSTRUCTOR**:
   - **`public AInteger
  (String s)`**: Initializes the `num` member variable with the value provided in the string `s`.

#### KEY METHODS
- `copy()`: Returns a new AInteger object initialized with the current `num` value.
- **`addition(AInteger a)`**:  
  Calls the `add(AInteger
 a)` method to add the current `AInteger
` with another `AInteger
`. It then trims the output of the `add` method to ensure the result is correctly formatted.
- **`subtract(AInteger a)`**:  
  Calls the `sub(AInteger
 a)` method to subtract another `AInteger
` from the current `AInteger
`. It then trims the output of the `sub` method.
- **`multiply(AInteger a)`**:  
  Calls the `mult(AInteger
 a)` method to multiply the current `AInteger
` with another `AInteger
`. It then trims the output of the `mult` method.
- **`divide(AInteger a)`**:  
  Calls the `division(AInteger
)` method where it divides the current `AInteger
` by another `AInteger
` and returns the list of quotient and remainder. It returns the quotient from the output of the `division` method.
- `compareTo(AInteger a)`: Compares two `AInteger` objects.
- `remove_zeroes(String s)`: Removes leading or trailing zeros from a string representation of a number.
- `parse(String s)`: Parses a string into an `AInteger` object.
- `valid_check(String s)`: Checks if a string is a valid integer.

### AFLOAT.JAVA (FLOAT CLASS)
- This class file belongs to the `arbitraryarithmetic` package.
- The `AFloat` class handles arbitrary-precision floating-point numbers, offering support for both integer and decimal parts. Like the `AInteger` class, `AFloat` uses string-based representations to store numbers and ensures no precision loss for large numbers. This class supports operations like addition, subtraction, multiplication, and division on floating-point numbers.

#### MEMBER VARIABLES
- `num`: Stores the number as a string.
- `intpart`: Stores the integer part of the number.
- `decimalpart`: Stores the decimal part of the number.
- `no_decimal_num`: Stores the number string without the decimal.

#### CONSTRUCTORS
- **`AFloat()`**: Initializes an `AFloat` object with a default value of `0.0`.
- **`AFloat(String inp)`**: Initializes an `AFloat` object with a given string input representing a floating-point number.
  - If the input does not contain a decimal point, it appends `.0` to treat it as a floating-point number.
  - Splits the input into two parts:
    - `intpart`: The part before the decimal.
    - `decimalpart`: The part after the decimal.
  - Concatenates `intpart` and `decimalpart` to get `no_decimal_num`, which is used for internal arithmetic operations.

#### KEY METHODS
- `copy()`: Returns a new AFloat object initialized with the current `num` value.
- **`addition(AFloat a)`**:  
  Calls the `add(AFloat a)` method to add the current `AFloat` with another `AFloat`. It then trims the output of the `add` method to ensure the result is correctly formatted.
- **`subtract(AFloat a)`**:  
  Calls the `sub(AFloat a)` method to subtract another `AFloat` from the current `AFloat`. It then trims the output of the `sub` method.
- **`multiply(AFloat a)`**:  
  Calls the `mult(AFloat a)` method to multiply the current `AFloat` with another `AFloat`. It then trims the output of the `mult` method.
- **`divide(AFloat a)`**:  
  Calls the `division(AFloat a)` method where it divides the current `AFloat` by another `AFloat`. It then trims the output of the `division` method.
- `compareTo(AFloat a)`: Compares two `AFloat` objects.
- `remove_zeroes(String s)`: Removes leading or trailing zeros from a string representation of a number.
- `parse(String s)`: Parses a string into an `AFloat` object.
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

Simply download or clone this repository and add the `AInteger` and `AFloat` classes to your Java project. There's no additional installation required.

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
