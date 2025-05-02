FROM eclipse-temurin


RUN apt-get update && apt-get install -y ant

#  Set working directory
WORKDIR /app

COPY . .

RUN ant jar

# Compile your main class
RUN javac -cp .:/app/arbitraryarithmetic/aarithmetic.jar MyInfArith.java

ENTRYPOINT ["java", "-cp", ".:/app/arbitraryarithmetic/aarithmetic.jar", "MyInfArith", "int", "add", "1", "1"]

CMD ["int", "add","1","1"]
