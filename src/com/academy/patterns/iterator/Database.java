package com.academy.patterns.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by keos on 18.06.15.
 */
public class Database implements Iterable<Table> {

    private Table[] tables;
    private int N = 0;
    private int maxSize = 10;

    public Database(int size) {
        this.tables = new Table[size];
        maxSize = size;
    }

    public Database() {
        this(10);
    }

    public void add(Table table) {
        if(N<maxSize) {
            tables[N++] = table;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public Table[] getTables() {
        return tables;
    }

    @Override
    public Iterator<Table> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Table> {

        private Table[] copy;
        private int i = 0;

        public ListIterator() {
            copy = new Table[tables.length];
            System.arraycopy(tables, 0, copy, 0, tables.length);
        }

        @Override
        public boolean hasNext() {
            return i < tables.length;
        }

        @Override
        public Table next() {
            if(!hasNext()) { throw new NoSuchElementException(); }
            return copy[i++];
        }

    }
}
