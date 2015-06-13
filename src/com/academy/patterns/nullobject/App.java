package com.academy.patterns.nullobject;


public class App 
{
    public static void main( String[] args ) {

		// Нуль-объект заменяет null'ы нейтральными объектами, поэтому в таком случае не нужны доп. проверки
		// В этом примере мы видим проход по бинарному дереву, содержащему null-объекты, без изменения алгоритма прохода по дереву
    	Node root = new NodeImpl("1",
    			new NodeImpl("11",
    					new NodeImpl("111",
    							NullNode.getInstance(),
    							NullNode.getInstance()),
    					NullNode.getInstance()), 
    			new NodeImpl("12",
    					NullNode.getInstance(),
    					new NodeImpl("122",
    							NullNode.getInstance(),
    							NullNode.getInstance())));

    	root.walk();
    }
}

