import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Укажите файл с числами в качестве аргумента.");
            return;
        }

        String fileName = args[0];
        ArrayList<Integer> nums = readNumbersFromFile(fileName);
        if (nums.isEmpty()) {
            System.out.println("Файл пуст или не содержит корректных чисел.");
            return;
        }

        int minMoves = calculateMinMoves(nums);
        System.out.println(minMoves);
    }

    private static ArrayList<Integer> readNumbersFromFile(String fileName) {
        ArrayList<Integer> nums = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    nums.add(Integer.parseInt(line.trim()));
                } catch (NumberFormatException e) {
                    System.out.println("Пропущена строка с некорректным числом: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }

        return nums;
    }

    private static int calculateMinMoves(ArrayList<Integer> nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int average = sum / nums.size();
        int moves = 0;

        for (int num : nums) {
            moves += Math.abs(num - average);
        }

        return moves;
    }
}

