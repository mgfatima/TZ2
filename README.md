# Описание проекта:
Этот проект реализует простейшую программу на языке Java, которая считывает числа из файла и выполняет следующие операции:

 • Находит минимальное число.
 
 • Находит максимальное число.
 
 • Считает сумму всех чисел.
 
 • Считает произведение всех чисел.
 
## Структура проекта:

 1 Main.java: Основной класс, который считывает числа из файла и вызывает функции для поиска минимального и максимального числа, а также для вычисления суммы и произведения всех чисел.

 2 numbers.txt: Текстовый файл, содержащий числа, разделенные пробелами.

 3 MainTest.java: Класс с тестами для проверки корректности работы основных функций (_min, _max, _sum, _mult).
 
## Настройка CI/CD:

Для автоматического тестирования и сборки проекта используется GitHub Actions.

 1 Создание файла workflow:

 ◦ В корне репозитория создается файл .github/workflows/ci.yml, который содержит конфигурацию для сборки и тестирования проекта при каждом новом коммите в ветку main, а также при создании pull request.

 2 Добавление бейджа статуса:

 ◦ В файл README.md добавляется бейдж, отображающий текущий статус сборки проекта. Бейдж автоматически обновляется в зависимости от результатов последней сборки.

 3 Интеграция с мессенджером:

 ◦ Настраивается интеграция с Telegram для отправки уведомлений о результатах сборки. При успешном прохождении тестов отправляется сообщение "все ок". При неуспешном прохождении тестов отправляется информация о том, какие именно тесты не пройдены.
 
## Пример уведомлений в Telegram:

 • Успешное прохождение тестов: Сообщение "все ок".

 • Неуспешное прохождение тестов: Подробная информация о том, какие тесты не прошли.

Проект настроен для автоматического тестирования и сборки с использованием GitHub Actions. Уведомления о результатах тестирования отправляются в Telegram. Система автоматически запускает тесты при каждом новом коммите в репозиторий, обеспечивая надежность и стабильность кода.
