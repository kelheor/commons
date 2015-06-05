package com.academy.algorithms.search;

import java.util.Arrays;

/**
 * Created by Kelheor on 05.06.2015.
 */
public class App {

    // A1[N], A2[N-1], �������� ������� ����� �������, �� ������ �� ������������.
    public static int searchMissing(int[] a1, int[] a2) {
        int[] excluded = new int[a1.length];
        for(int i = 0; i < excluded.length; i++) {
            excluded[i] = -1;
        }

        // ����������� �� ���������������� ������, ��� �������� ���� �������
        for(int i = 0; i<a2.length; i++) {
            // ���� �� ������ ������ �������, �������� �������, � ��� ��� ��� ����?
            int index;
            if((index = Arrays.binarySearch(a1, a2[i])) >= 0) {
                // �������� ��� � ����������� ������ ����� �� �� �� �������, ��� � � ��������������� �������
                excluded[index] = a1[index];
            }
        }

        // ����������� �� ���������������� �������, ��������, ��� ������� �� �������� � ����������� �������
        for(int i = 0; i < a1.length; i++) {
            if(a1[i] != excluded[i]) {
                return a1[i];
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int[] a1 = {1,2,3,4};
        int[] a2 = {2,4,1};
        assert searchMissing(a1, a2) == 3;
        System.out.println(searchMissing(a1, a2) == 3);
    }
}
