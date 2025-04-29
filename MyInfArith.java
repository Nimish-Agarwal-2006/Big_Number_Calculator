
import arbitraryarithmetic.AFloat;
import arbitraryarithmetic.AInteger;

public class MyInfArith {
    public static void main(String[] args) {
        String type = args[0];
        String operation = args[1];
        String operand1 = args[2];
        String operand2 = args[3];
        String operation_lower =operation.toLowerCase();
        System.out.println(operation_lower);
        if (type.equals("int")) {
            AInteger a1 = new AInteger(operand1);
            AInteger a2 = new AInteger(operand2);
            AInteger result = new AInteger();
            switch (operation_lower) {
                case "add":
                    result = a1.add(a2);
                    break;
                case "sub":
                    result = a1.sub(a2);
                    break;
                case "mul":
                    result = a1.multi(a2);
                    break;
                case "div":
                    result = a1.div(a2);
                    break;
                default:
                    System.out.println("Invalid operation.");
                    return;
            }
            System.out.println("Result: " + result);
        } else if (type.equals("float")) {
            AFloat f1 = new AFloat(operand1);
            AFloat f2 = new AFloat(operand2);
            AFloat result = new AFloat();

            switch (operation) {
                case "add":
                    result = f1.add(f2);
                    break;
                case "sub":
                    result = f1.sub(f2);
                    break;
                case "mul":
                    result = f1.multi(f2);
                    break;
                case "div":
                    result = f1.div(f2);
                    break;
                default:
                    System.out.println("Invalid operation.");
                    return;
            }

            System.out.println("Result: " + result);
        }
    }
}

