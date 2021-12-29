import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

/**
 * ID сборки 63248173
 */
public class Calc {

    private final Deque<Integer> operands = new LinkedList<>();
    private final Map<String, BiFunction<Integer, Integer, Integer>> operations;

    public Calc() {
        operations = new HashMap(4);
        operations.put("+", (BinaryOperator<Integer>) (a, b) -> a + b);
        operations.put("-", (BinaryOperator<Integer>) (a, b) -> a - b);
        operations.put("*", (BinaryOperator<Integer>) (a, b) -> a * b);
        operations.put("/", (BinaryOperator<Integer>) (a, b) -> Math.floorDiv(a, b));
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            List<String> arguments = new LinkedList<>();
            while (tokenizer.hasMoreTokens()) {
                arguments.add(tokenizer.nextToken());
            }
            Calc calc = new Calc();
            calc.calc(arguments);
        }
    }

    private void calc(List<String> args) {
        for (String arg : args) {
            if (isOperand(arg)) {
                operands.push(Integer.parseInt(arg));
            } else {
                Integer b = operands.poll();
                Integer a = operands.poll();
                Integer result = operations.get(arg).apply(a, b);
                operands.push(result);
            }
        }
        System.out.println(operands.peek());
    }

    private boolean isOperand(String x) {
        return !(x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/"));
    }
}
