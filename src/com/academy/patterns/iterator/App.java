package com.academy.patterns.iterator;

/**
 * Created by keos on 18.06.15.
 */
public class App {

    public static void main(String[] args) {
        Database database = new Database();
        database.add(new Table("TABLE 1"));
        database.add(new Table("TABLE 2"));
        database.add(new Table("TABLE 3"));
        database.add(new Table("TABLE 4"));
        database.add(new Table("TABLE 5"));
        database.add(new Table("TABLE 6"));
        database.add(new Table("TABLE 7"));
        database.add(new Table("TABLE 8"));
        database.add(new Table("TABLE 9"));
        database.add(new Table("TABLE 10"));

        for(Table table : database) {
            System.out.println(table.getName());
        }
    }
}
