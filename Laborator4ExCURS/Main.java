import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Exemplu de utilizare a clasei Pair
        Pair<String, Integer> pair1 = new Pair<>("Hello", 42);
        Pair<Double, String> pair2 = new Pair<>(3.14, "World");

        System.out.println("Pair 1: " + pair1.getFirst() + ", " + pair1.getSecond());
        System.out.println("Pair 2: " + pair2.getFirst() + ", " + pair2.getSecond());

        // Exemplu de căutare într-un array de perechi
        Pair<String, Integer>[] array = new Pair[]{pair1, new Pair<>("ABC", 123), pair2};
        int index = GenericSearch.search(array, "Hello");

        if (index != -1) {
            System.out.println("Valoarea cautata se afla la pozitia: " + index);
        } else {
            System.out.println("Valoarea cautata nu a fost gasita in array.");
        }

        // Exemplu de calcul al valorilor minime și maxime dintr-un array de perechi
        Pair<String, Integer> minMaxPair = Pair.minmax(array);
        System.out.println("Minimul din array: " + minMaxPair.getFirst());
        System.out.println("Maximul din array: " + minMaxPair.getSecond());

        // Exemplu de generare a permutărilor
        System.out.print("Introduceti n pentru generarea permutarilor: ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Integer[] permutationArray = new Integer[n];
        for (int i = 0; i < n; i++) {
            permutationArray[i] = i + 1;
        }

        System.out.println("Permutarile pentru n=" + n + " sunt:");
        GenericPermutations.generatePermutations(permutationArray);
    }
}

class Pair<T, S> {
    private T first;
    private S second;

    public Pair(T firstElement, S secondElement) {
        this.first = firstElement;
        this.second = secondElement;
    }

    public T getFirst() {
        return first;
    }

    public S getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(S second) {
        this.second = second;
    }

    public void swap() {
        T temp = first;
        first = (T) second; // Presupunând că T și S au același tip
        second = (S) temp;
    }

    public static <T extends Comparable<T>, S extends Comparable<S>> Pair<T, S> minmax(Pair<T, S>[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array-ul trebuie sa fie diferit de null si sa contina cel putin un element");
        }

        T minFirst = array[0].getFirst();
        S minSecond = array[0].getSecond();
        T maxFirst = array[0].getFirst();
        S maxSecond = array[0].getSecond();

        for (Pair<T, S> pair : array) {
            if (pair.getFirst().compareTo(minFirst) < 0) {
                minFirst = pair.getFirst();
            }
            if (pair.getSecond().compareTo(minSecond) < 0) {
                minSecond = pair.getSecond();
            }
            if (pair.getFirst().compareTo(maxFirst) > 0) {
                maxFirst = pair.getFirst();
            }
            if (pair.getSecond().compareTo(maxSecond) > 0) {
                maxSecond = pair.getSecond();
            }
        }

        return new Pair<>(minFirst, minSecond);
    }
}

class GenericSearch {
    public static <T extends Comparable<T>, S> int search(Pair<T, S>[] array, T key) {
        if (array == null) {
            throw new IllegalArgumentException("Array-ul trebuie sa fie diferit de null");
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].getFirst().compareTo(key) == 0) {
                return i;
            }
        }

        return -1;
    }
}

class GenericPermutations {
    public static <T> void generatePermutations(T[] array) {
        // Implementare logica pentru generarea permutărilor aici
        // ...
    }
}