1. Форматування фігурних дужок (K&R стиль)
   Проблема (по всьому коду): У коді не дотримано стилю K&R для фігурних дужок.
   Фігурна дужка { повинна йти на тій самій лінії, що й конструкція, яка її відкриває, а не на новій лінії.
2. Зайві операції над рядками
    Повторно виконується replaceAll і змінюється рядок після того, як вже проситалийого змінну в content.
    Перетворення тексту можна зробити одним рядком під час його читання.
3. Читання файлу
   Проблема : Код читання файлу і обробки тексту дублюється в методі main і в методі cleanText. 
   Потрібно об'єднати ці операції, щоб уникнути дублювання.
    Використання методу cleanText для очищення тексту і спрощення коду.
4. Необхідність локальних змінних
    Ми використовуємо масив distincts і одразу ж починаємо з ним працювати без оптимізації.
   Можна розбити код на менші частини, зберігаючи результат у проміжних змінних для кращої читаємості.
5. Необхідність використання Stream API
   Для підрахунку частоти слів можна використовувати Stream API, що спрощує код та робить його більш зрозумілим.
6. Підрахунок частоти слів
   Використано Map<String, Integer> для підрахунку частоти, що дозволяє додавати кожне слово лише один раз, без повторних проходів по списку.
7. Сортування та виведення результатів
   Застосовано Java Streams для більш чистого та ефективного сортування й обмеження виведення топ-N слів
8. Винесення коду у методи
    Логіку розбито на кілька методів для покращення структури:
    cleanText – метод для очищення тексту.
9. Винесення коду у методи
   Логіку розбито на кілька методів для покращення структури:
    countWordFrequency – метод для підрахунку частоти слів.
    printTopWords – метод для виведення топ-N слів.
10.  Винесення коду у методи
     Логіку розбито на кілька методів для покращення структури:
     printTopWords – метод для виведення топ-N слів.
11. Обробка винятків
    Додана обробка винятків за допомогою конструкції try-catch, щоб програма не завершувалася у разі помилок під час читання файлу