// Разработка программы для подсчета калорий может быть полезной в фитнес-клубе,
// чтобы помочь клиентам следить за своим питанием и достижением фитнес-целей.
// Рассмотрим пример простой программы на Java, которая может служить калькулятором калорий.
// Программа будет учитывать базовые параметры, такие как возраст, пол, вес, рост и уровень физической активности,
// для расчета суточной нормы калорий по формуле Харриса-Бенедикта.

import java.util.Scanner;

public class CalorieCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод данных пользователя
        System.out.println("Введите ваш пол (M/F): ");
        char gender = scanner.next().charAt(0);

        System.out.println("Введите ваш возраст: ");
        int age = scanner.nextInt();

        System.out.println("Введите ваш вес в килограммах: ");
        double weight = scanner.nextDouble();

        System.out.println("Введите ваш рост в сантиметрах: ");
        double height = scanner.nextDouble();

        System.out.println("Введите ваш уровень физической активности (от 1 до 5): ");
        System.out.println("1 - Минимальная активность");
        System.out.println("2 - Низкая активность");
        System.out.println("3 - Средняя активность");
        System.out.println("4 - Высокая активность");
        System.out.println("5 - Очень высокая активность");
        int activityLevel = scanner.nextInt();

        // Рассчет BMR (Basal Metabolic Rate) по формуле Харриса-Бенедикта
        double bmr;
        if (gender == 'M' || gender == 'm') {
            bmr = 88.36 + (13.4 * weight) + (4.8 * height) - (5.7 * age);
        } else {
            bmr = 447.6 + (9.2 * weight) + (3.1 * height) - (4.3 * age);
        }

        // Факторы физической активности
        double[] activityFactors = {1.2, 1.375, 1.55, 1.725, 1.9};

        // Рассчет суточной нормы калорий
        double dailyCalories = bmr * activityFactors[activityLevel - 1];

        // Вывод результатов
        System.out.printf("Ваша суточная норма калорий: %.2f калорий.\n", dailyCalories);

        scanner.close();
    }
}

// ### Объяснение работы кода
//1. Программа запрашивает у пользователя параметры пол, возраст, вес, рост и уровень физической активности.
//2. Рассчитывает базальный обмен веществ (BMR) с использованием формулы Харриса-Бенедикта.
//3. Учитывает уровень физической активности для корректировки расчетов калорий.
//4. Выводит итоговое количество калорий, которое пользователю необходимо употреблять в сутки.
//
//### Дополнения и изменения
//- Добавьте больше проверок ввода для повышения надежности.
//- Можете расширить программу, добавив функции для хранения данных пользователи или рекомендаций по питанию.
//- Включите графический интерфейс для более удобного использования.
