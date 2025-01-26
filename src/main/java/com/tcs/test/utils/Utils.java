package com.tcs.test.utils;

import com.tcs.test.exceptions.NotFoundTextException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static Long evaluateExpression(String expression) {
        // Eliminar los caracteres de espacio, '=', y '?' antes de evaluar la expresión
        expression = expression.replaceAll("[\\s=\\?]", "");

        // Pila para los números
        Stack<Long> numbers = new Stack<>();
        // Pila para los operadores
        Stack<Character> operators = new Stack<>();

        // Convertir la expresión a un arreglo de caracteres
        char[] chars = expression.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];

            // Si es un número, se puede tener más de una cifra
            if (Character.isDigit(ch)) {
                long num = 0;
                while (i < chars.length && Character.isDigit(chars[i])) {
                    num = num * 10 + (chars[i] - '0');
                    i++;
                }
                i--; // Volver al último carácter del número
                numbers.push(num);
            }
            // Si es un operador
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
                    performOperation(numbers, operators.pop());
                }
                operators.push(ch);
            }
        }

        // Realizar las operaciones restantes en la pila de operadores
        while (!operators.isEmpty()) {
            performOperation(numbers, operators.pop());
        }

        // El resultado final estará en la pila de números
        return numbers.pop();
    }

    // Método para obtener la precedencia de un operador
    private static int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return 0;
    }

    // Método para realizar una operación matemática
    private static void performOperation(Stack<Long> numbers, char operator) {
        long b = numbers.pop();
        long a = numbers.pop();
        long result = 0;

        switch (operator) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = a / b;
                break;
        }
        numbers.push(result);
    }


    public static String extractTextUsing(String inputText, String regExp) throws NotFoundTextException {
        // Use for regExp with only 1 group
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(inputText);
        if (matcher.find()) {
            return matcher.group(1);
        }
        throw new NotFoundTextException("Texto no encontrado.");
    }

    public static String extractTextUsing(Actor actor, Target target, String regExp) throws NotFoundTextException {
        String text = extractTextUsing(target.resolveFor(actor).getText(), regExp);
        System.out.println(text);
        return text;
    }

    public static Integer countItemIn(String inputText, String textToCount) {
        int count = 0;
        int index = 0;
        while ((index = inputText.indexOf(textToCount, index)) != -1) {
            count++;
            index++;
        }
        return count;
    }

    public static String repeatItem(String itemToRepeat, Integer countItem) {
        StringBuilder tempString = new StringBuilder();
        for (int i = 0; i < countItem; i++) {
            tempString.append(itemToRepeat);
        }
        return tempString.toString();
    }


}
