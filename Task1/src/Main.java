public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Укажите два аргумента: n и m.");
            return;
        }

        int n = Integer.parseInt(args[0]);  // Размер массива
        int m = Integer.parseInt(args[1]);  // Шаг перемещения

        if (n <= 0) {
            System.out.println("Число n должно быть больше 0.");
            return;
        }

        int position = 0;  // Начальная позиция (индекс 0 = 1)
        StringBuilder result = new StringBuilder();  // Для формирования пути
        result.append(1);  // Добавляем первый элемент (1)

        boolean[] visited = new boolean[n];  // Массив для отслеживания посещенных позиций
        visited[position] = true;

        while (true) {
            position = (position + m) % n;  // Двигаемся по кругу с шагом m

            // Коррекция индекса для отрицательных значений
            if (position < 0) {
                position += n;
            }

            // Если возвращаемся к начальному элементу, заканчиваем цикл
            if (visited[position]) {
                break;
            }

            result.append(position + 1);  // Добавляем элемент к результату
            visited[position] = true;  // Отмечаем позицию как посещенную
        }

        // Выводим полученный путь
        System.out.println(result.toString());
    }
}
