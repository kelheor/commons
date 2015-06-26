package com.academy.patterns.interpreter;

import java.util.Stack;

/**
 * Created by keos on 26.06.15.
 */
public class App {
    public static void main(String[] args) {
        // Выражение может быть представено в префиксной, инфиксной, постфиксной нотации. Ниже используется постфиксная.
        // Интерпретатор разбивает предложение на выражения, которые могут быть вычеслены
        // Следует использовать на простых выражениях и в некритичных к скорости приложениях
        // В противном случае лучше взять нормальный парсер
        // В данном случае мы еще и строим абстрактное синтаксисное дерево

        String tokenString = "4 3 2 - 1 + *";
        Stack<Expression> stack = new Stack<>();
        String[] tokenList = tokenString.split(" ");

        for(String s: tokenList) {
            if(isOperator(s)) {
                Expression left = stack.pop();
                Expression right = stack.pop();
                System.out.println("LEFT: " + left.interpret() + " RIGHT: " + right.interpret());
                Expression operator = getOperatorExpression(s, left, right);
                System.out.println("OPERATOR: " + operator);
                int result = operator.interpret();
                NumberExpression resultExpression = new NumberExpression(result);
                stack.push(resultExpression);
                System.out.println("PUSHED RESULT: " + resultExpression.interpret());
            } else {
                Expression i = new NumberExpression(s);
                stack.push(i);
                System.out.println("PUSHED NUMBER: " + i.interpret());
            }
        }
        System.out.println("RESULT: " + stack.pop().interpret());
    }

    public static boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*");
    }

    public static Expression getOperatorExpression(String s, Expression left, Expression right) {
        switch (s) {
            case "+":
                return new PlusExpression(left, right);
            case "-":
                return new MinusExpression(left, right);
            case "*":
                return new MultiplyExpression(left, right);
        }
        return null;
    }
}
