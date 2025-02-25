# shopping-cart-app
Поиск товаров с фильтрами и добавление в корзину


### Клонирование репозитория

bash
git clone https://github.com/Lokas548/shopping-cart-app.git

cd pastebin

### Сборка проекта

Для сборки проекта используйте Maven или Gradle:

#### Maven

bash
mvn clean install

#### Swagger

http://localhost:{ваш-порт}/swagger-ui/index.html



## Эндпоинты

### 1. Тестовый Эндпоинт

- **Метод**: GET
- **Эндпоинт**: /api/
- **Описание**: Тестовый эндпоинт для проверки работоспособности сервера.

#### Ответ
- **Код состояния**: 200 OK
- **Тело**:
json
{
  "message": "hello. server successfully boot"
}

### 2. Добавить Новый Продукт

- **Метод**: POST
- **Эндпоинт**: /api/add
- **Описание**: Добавляет новый продукт в инвентаризацию.
  
#### Тело Запроса
json
{
  "name": "Название продукта",
  "category": "Название категории",
  "price": 99.99
}

#### Ответ
- **Код состояния**: 201 Created (или соответствующий код в зависимости от логики сервиса)
- **Тело**:
json
{
  "name": "Название продукта",
  "category": "Название категории",
  "price": 99.99
}

### 3. Показать Все Продукты

- **Метод**: GET
- **Эндпоинт**: /api/products
- **Описание**: Получает список всех продуктов в инвентаризации.

#### Ответ
- **Код состояния**: 200 OK
- **Тело**:
json
[
  {
    "name": "Название продукта",
    "category": "Название категории",
    "price": 99.99
  },
  ...
]

### 4. Получить Продукты по Категории

- **Метод**: GET
- **Эндпоинт**: /api/products/{category}
- **Описание**: Получает список продуктов, отфильтрованных по указанной категории.

#### Параметры Пути
- category (строка): Категория продуктов для получения.

#### Ответ
- **Код состояния**: 200 OK
- **Тело**:
json
[
  {
    "name": "Другой продукт",
    "category": "Название категории",
    "price": 49.99
  },
  ...
]

### 5. Поиск Продуктов по Фильтрам

- **Метод**: GET
- **Эндпоинт**: /api/products/
- **Описание**: Ищет продукты на основе различных фильтров (например, диапазон цен, категория).

#### Параметры Запроса
- category (String, необязательный): Категория для фильтрации.
- minPrice (Double, необязательный): Минимальная цена для фильтрации.
- maxPrice (Double, необязательный): Максимальная цена для фильтрации.

#### Ответ
- **Код состояния**: 200 OK
- **Тело**:
json
[
  {
    "name": "Отфильтрованный продукт",
    "category": "Отфильтрованная категория",
    "price": 29.99
  },
  ...
]

## Обработка Ошибок
API возвращает стандартные коды состояния HTTP для ошибок:
- 400 Bad Request: Неверные параметры запроса.
- 404 Not Found: Ресурс не найден.
- 500 Internal Server Error: Неожиданная ошибка сервера.

## Примеры Использования

### Добавление Нового Продукта
bash
curl -X POST /api/add -H "Content-Type: application/json" -d '{
  "name": "Новый продукт",
  "category": "Электроника",
  "price": 199.99
}'

### Получение Всех Продуктов
bash
curl -X GET /api/products

### Фильтрация Продуктов по Категории
bash
curl -X GET /api/products/Электроника

### Поиск Продуктов с Фильтрами
bash
curl -X GET "/api/products?minPrice=50maxPrice=200category=Электроника"
