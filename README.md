Складской учет
=======================
Описание страниц
-----------------------
Целевой пользователь - администратор или менеджер склада

На каждой странице будет раскрывающееся меню:
- Ссылка на главную страницу
- Ссылка на страницу с каталогом поставщиков
- Ссылка на страницу с каталогом заказчиков
- Ссылка на страницу с каталогом имеющихся товаров
- Ссылка на страницу истории поставок и выдач
- Ссылка на страницу состояния склада
- Ссылка на страницу формирования поставки или заказа

### Главная страница

Представляет собой несколько дашбордов, все заголовки которых являются ссылками на соответствующие страницы:
- Ближайшие выдачи (ссылка на страницу поставок и выдач) - список из пяти ближайших выдач (каждый пункт - ссылка на страницу конкретной выдачи).
- Ближайшие поставки (ссылка на страницу поставок и выдач) - список из пяти ближайших поставок (каждый пункт - ссылка на страницу конкретной поставки).
- Количество свободных ячеек разных типов (ссылка на страницу состояния склада)

Также есть две кнопки: "Сформировать заказ" и "Сформировать поставку", которые переводят на страницу формирования поставки или заказа соответственно.

### Каталог имеющихся товаров
Поиск товара с возможностью фильтрации и сортировки по различным параметрам (как на сайтах интернет-магазинов). Список найденных товаров - их карточки с быстрой информацией, по нажатию на которые происходит переход на страницу конкретного товара.
Фильтрация возможна по следующим признакам: наличие товара, тип товара, размер товара, поставщик и т. д. 
Сортировка возможна по следующим принакам: количество товара в наличии, срок годности товара, размер товара, название товара (в алфавитном порядке).

### Страница товара
Поставщики, количество в наличии, ближайшие поставки, сроки хранения, габариты, место на складе и т. д.
Все данные, кроме поставок, можно редактировать, нажав кнопку "Редактировать". Далее необходимо внести изменения и нажать кнопку "Подтвердить изменения".
Имя поставщика - ссылка на страницу поставщика. Карточки ближайших поставок - ссылки на страницы поставок.

### Каталог поставщиков
Поиск поставщика с возможностью сортировки по различным параметрам. Список найденных поставщиков - их карточки с быстрой информацией, по нажатию на которые происходит переход на страницу поставщика.
Сортировка возможна по следующим принакам: имя поставщика (в алфавитном порядке), количество запланированных поставок, общее количество поставок за последний год.

### Страница поставщика
Контактная информация, ближайшие запланированные поставки, динамика поставок за последний год (в виде графика по месяцам), поставляемые товары и т. д.
Контактную информацию и имя можно редактировать, нажав кнопку "Редактировать". Далее необходимо внести изменения и нажать кнопку "Подтвердить изменения".
Все карточки ближайших поставок - ссылки на конкретную поставку. Все карточки товаров - ссылки на страницу товара.

### Каталог заказчиков
Поиск заказчика с возможностью сортировки по различным параметрам. Список найденных заказчиков - их карточки с быстрой информацией, по нажатию на которые происходит переход на страницу заказчика.
Сортировка возможна по следующим принакам: имя заказчика (в алфавитном порядке), количество запланированных заказов, общее количество заказов за последний год.

### Страница заказчика
Контактная информация, ближайшие запланированные заказы, динамика заказов за последний год (в виде графика по месяцам) и т. д. 
Контактную информацию и имя можно редактировать, нажав кнопку "Редактировать". Далее необходимо внести изменения и нажать кнопку "Подтвердить изменения".
Все карточки ближайших заказов - ссылки на конкретный заказ.

### История поставок и выдач
Список карточек - быстрая информация о поставке или выдаче. Возможен поиск, фильтрация и сортировка.
Фильтрация и сортировка возможны по следующим признакам: дата, количество товаров, имя поставщика/заказчика и т. д. 

### Страница поставки
Дата и время поставки, оформления, список товаров, поставщик, и т. д. 
Все данные можно редактировать, нажав кнопку "Редактировать". Далее необходимо внести изменения и нажать кнопку "Подтвердить изменения".
Имя поставщика - ссылка на его страницу. Товары в списке - ссылки на страницы самих товаров.

### Страница заказа
Дата и время выдачи, оформления, список товаров, заказчик и т. д.
Все данные можно редактировать, нажав кнопку "Редактировать". Далее необходимо внести изменения и нажать кнопку "Подтвердить изменения".
Имя заказчика - ссылка на его страницу. Товары в списке - ссылки на страницы самих товаров.

### Страница формирования и оформления заказа или поставки
Форма с полями даты и времени выдачи или поставки, заказчике или постащике, товарах и т. д. Некоторые поля обязательные. Встроенная проверка наличия товаров или свободного места на складе. Кнопка подтверждения формирования заказа/поставки.

### Страница состояния склада
Перечисление свободных ячеек разных типов. Форма для проверки наличия свободного места.

Схема навигации между страницами
-----------------
Дополнительно на каждой странице есть доступ к вышеописанному меню.
![Alt text](schemes/map.jpg)

Схема базы данных
-----------------
![Alt text](schemes/bd.jpg)

Сценарии использования
----------------------
- Получение списка имеющихся товаров по видам, сроку хранения, поставщику и пр.
  - Перейти на страницу каталога товаров, нажав на заголовок дашборда или из главного меню.
  - Выбрать нужные фильтры и способ сортировки.
  - Нажать кнопку "Поиск".

- Получение данных о поставках и выдачах за заданный период времени
  - Перейти на страницу истории поставок и выдач, нажав на заголовок дашборда или из главного меню.
  - Выбрать нужные фильтры и способ сортировки.
  - Нажать кнопку "Поиск".

- Оформление поставки или выдачи
  - Перейти на страницу оформления поставок и выдач из главного меню.
  - Заполнить все обязательные поля и необязательные поля по необходимости. 
  - Нажать кнопку "Подтвердить оформление поставки или выдачи".

- Проверка наличия свободного места для поставки
  - Перейти на страницу состояния склада, нажав на заголовок дашборда или из главного меню.
  - Заполнить форму.
  - Нажать кнопку "Проверить наличие места".

- Добавление и удаление товара, чтение и редактирование данных о нем
  - Перейти на страницу каталога товаров из главного меню.
  - Найти необходимый товар.
  - Перейти на страницу товара, нажав на его карточку.
  - Нажать кнопку "Изменить".
  - Внести изменения.
  - Нажать кнопку "Сохранить изменения" или "Удалить товар".

- Добавление и удаление поставщиков и потребителей, чтение и редактирование данных о них
  - Перейти на страницу каталога поставщиков или потребителей из главного меню.
  - Найти необходимого поставщика или потребителя.
  - Перейти на страницу поставщика или потребителя, нажав на его карточку.
  - Нажать кнопку "Изменить".
  - Внести изменения.
  - Нажать кнопку "Сохранить изменения" или "Удалить поставщика/потребителя".
