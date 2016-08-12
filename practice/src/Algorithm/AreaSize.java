package Algorithm;


import java.io.IOException;
import java.util.Scanner;

public class AreaSize {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String temp = scanner.nextLine().trim();
        int number = Integer.parseInt(temp);
        int[] result;
        int total;
        float[][] matrix;
        String[] data;

        if (number < 1 || number > 10)
            return;

        result = new int[number];
        for (int i = 0; i < number; ++i) {
            temp = scanner.nextLine().trim();
            total = Integer.parseInt(temp);

            if (total < 3 || total > 100)
                return;

            matrix = new float[total][2];
            for(int j = 0; j < total; ++j){
                temp = scanner.nextLine().trim();
                data = temp.split(" ");
                matrix[j][0] = Float.parseFloat(data[0]);
                matrix[j][1] = Float.parseFloat(data[1]);


            }


        }

        for(int i : result)
            System.out.println(i);

        scanner.close();
    }
}
