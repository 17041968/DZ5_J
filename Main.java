package org.example;

import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Main {
    public void sort(int arr[]) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    void heapify(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && arr[l] > arr[largest])
            largest = l;
        if (r < n && arr[r] > arr[largest])
            largest = r;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, n, largest);
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public class ListOfEmplooyes {
        private static HashMap<String, ArrayList<String>> people = new HashMap<>();

        public void add(String firstName, String lastName) {
            if (people.containsKey(firstName)) {
                people.get(firstName).add(lastName);
            } else {
                ArrayList<String> values = new ArrayList<>();
                values.add(lastName);
                people.put(firstName, values);
            }
        }

        public static void getListOfEmplooyes() {
            String[] arrayNames = new String[people.size()];
            people.keySet().toArray(arrayNames);
            int[] arraySizeNames = new int[people.size()];
            for (int i = 0; i < arrayNames.length; i++) {
                int sizeName = people.get(arrayNames[i]).size();
                arraySizeNames[i] = sizeName;
            }
            boolean isSorted = false;
            int valueNumber;
            String valueName;
            while (!isSorted) {
                isSorted = true;
                for (int i = 0; i < arraySizeNames.length - 1; i++) {
                    if (arraySizeNames[i] < arraySizeNames[i + 1]) {
                        isSorted = false;

                        valueNumber = arraySizeNames[i];
                        arraySizeNames[i] = arraySizeNames[i + 1];
                        arraySizeNames[i + 1] = valueNumber;
                        valueName = arrayNames[i];
                        arrayNames[i] = arrayNames[i + 1];
                        arrayNames[i + 1] = valueName;
                    }
                }
            }
            for (int i = 0; i < arrayNames.length; i++) {
                System.out.println("Имя " + arrayNames[i] + " повторяется " + arraySizeNames[i] + " раз(а)");
                for (int j = 0; j < arraySizeNames[i]; j++) {
                    System.out.print(arrayNames[i] + " ");
                    String[] arrayLastName = new String[arraySizeNames[i]];
                    people.get(arrayNames[i]).toArray(arrayLastName);
                    System.out.println(arrayLastName[j]);
                }
            }
        }

        public class PhoneBook {
            private static HashMap<String, ArrayList<String>> phoneNumbers = new HashMap<>();

            public void add(String name, String number) {
                if (phoneNumbers.containsKey(name)) {
                    phoneNumbers.get(name).add(number);
                } else {
                    ArrayList<String> values = new ArrayList<>();
                    values.add(number);
                    phoneNumbers.put(name, values);
                }
            }

            public ArrayList<String> find(String name) {
                if (phoneNumbers.containsKey(name)) {
                    return phoneNumbers.get(name);
                }
                return new ArrayList<String>();
            }

				public static HashMap<String, ArrayList<String>> getPhoneNumbers() {
					return phoneNumbers;
				}

				public static void setPhoneNumbers(HashMap<String, ArrayList<String>> phoneNumbers) {
					PhoneBook.phoneNumbers = phoneNumbers;
				}
}


