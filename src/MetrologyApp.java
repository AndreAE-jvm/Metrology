import java.util.ArrayList; //Используется для создания динамического массива (списка) для хранения значений измерений.
import java.util.List; //Это интерфейс, представляющий список.
import java.util.Scanner; //Используется для чтения ввода из консоли.

public class MetrologyApp {
    public static void main(String[] args) {
        List<Double> measurements = new ArrayList<>(); //Инициализирует пустой список для хранения значений типа double (измерений).
        Scanner scanner = new Scanner(System.in); //Создает объект Scanner для чтения ввода от пользователя.
        System.out.println("Введите измерения (введите 'exit' для завершения, после ввода нескольких значений и проведение вычислений):");

        while (true) { // непрерывно ждет ввода от пользователя, пока тот не введет "exit".
            String input = scanner.nextLine(); // Считывает строку ввода от пользователя.
            if (input.equalsIgnoreCase("exit")) { // проверяет, является ли ввод "exit".
                // Если это правда, он выходит из цикла.
                break;
            }
            try { // пытается разобрать ввод как число типа double.
                // Если успешно, добавляет измерение в список.
                // Если разбор не удается (NumberFormatException), информирует пользователя о недопустимом вводе.
                double measurement = Double.parseDouble(input);
                measurements.add(measurement);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Пожалуйста, введите число или 'exit'.");
            }
        }

        double average = measurements.stream().mapToDouble(Double::doubleValue).average().orElse(0); // Вычисляет среднее значение из списка.
        double max = measurements.stream().mapToDouble(Double::doubleValue).max().orElse(0); // Находит максимальное значение в списке.
        double min = measurements.stream().mapToDouble(Double::doubleValue).min().orElse(0); // Находит минимальное значение в списке.
        // - `orElse(0)`: Возвращает 0, если список пуст, предотвращая исключения.

        System.out.printf("Среднее: %.2f, Максимум: %.2f, Минимум: %.2f%n", average, max, min);
        scanner.close();
    }
}
        /* Потенциальные улучшения:
- Проверка ввода: Добавить дополнительную проверку диапазонов измерений или типов допустимых чисел.
- Обработка исключений: Обработать возможные исключения при закрытии сканера или выполнении вычислений.
- Пользовательский интерфейс: Улучшить интерфейс или предоставить варианты просмотра подробной статистики.

Этот код служит надежной основой для приложения по метрологии и может быть далее расширен или настроен в зависимости от требований. */
