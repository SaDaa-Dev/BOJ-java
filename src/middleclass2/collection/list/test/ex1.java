package middleclass2.collection.list.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ex1 {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> students = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0) {
                break;
            }

            students.add(input);
        }

        System.out.println(students.toString());
    }
}
