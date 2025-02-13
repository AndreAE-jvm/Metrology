import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MetrologyApp {
    public static void main(String[] args) {
        List<Double> measurements = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите измерения (введите 'exit' для завершения):");

        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            try {
                double measurement = Double.parseDouble(input);
                measurements.add(measurement);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Пожалуйста, введите число или 'exit'.");
            }
        }

        double average = measurements.stream().mapToDouble(Double::doubleValue).average().orElse(0);
        double max = measurements.stream().mapToDouble(Double::doubleValue).max().orElse(0);
        double min = measurements.stream().mapToDouble(Double::doubleValue).min().orElse(0);

        System.out.printf("Среднее: %.2f, Максимум: %.2f, Минимум: %.2f%n", average, max, min);
        scanner.close();
    }
}