<h2>Проект "Библиотека"</h2>

Программа для использования библиотекарями с следующими возможностями:
* Регистрация новых читателей с последующей возможностью их изменения и удаления
* Добавление новых книг с последующей возможностью их изменения и удаления
* Выдача книг читателям, используя выпадающий список
* Освобождение книг (после того, как читатель возвращает книгу обратно в библиотеку)
* Страница с списком всех пользователей библиотеки с возможностью перехода на страницу отдельного пользователя
* Страница с списком всех книг библиотеки с возможностью перехода на страницу отдельной книги
* Страница читателя с указанием значения его полей и списка книг, которые он взял, в виде выпадающего списка
* Страница книги с указанием значения его полей и имени человека, который взял эту книгу
* Пагинация страницы с списокм всех книг библиотеки с возможностью выбора количества отображаемых книг и запрашиваемой страницы
* Сортировка книг по году издания
* Страница поиска книг
* Автоматическая проверка на то, что читатель просрочил возврат книги.

#### Стек технологий: 
Java 17, PostgreSQL, Hibernate, Spring Data JPA, Spring MVC, Thymeleaf, Spring Validator, Maven, Git

---

<h3>Работа с приложением</h3>

Для регистрации нового читателя необходимо выполнить POST запрос на адрес: /people/new

<img src=https://user-images.githubusercontent.com/69649934/231165631-9da59966-6d4c-45c1-9e57-ebfc1f61b7f6.png width="400" height="200" />

Для редактирования данных о читателе необходимо выполнить POST запрос на адрес: /people/{id читателя}/edit

<img src=https://user-images.githubusercontent.com/69649934/231167435-b305dd64-1186-47df-bc54-81ffc7323ace.png width="400" height="200" />

Для просмотра всех зарегистрированных читателей библиотеки необходимо выполнить GET запрос на адрес: /people

<img src=https://user-images.githubusercontent.com/69649934/231168060-2bfc4de3-ba9f-4a21-872d-40adcf2ce34c.png width="420" height="220" />

Для добавления книги в библиотеку необходимо выполнить POST запрос на адрес: /books/new

<img src=https://user-images.githubusercontent.com/69649934/231181816-b1bbb9d7-f454-4beb-8a8f-45451eb26607.png width="400" height="200" />

Для редактирования данных о книге необходимо выполнить POST запрос на адрес: /books/{id книги}/edit

<img src=https://user-images.githubusercontent.com/69649934/231183071-a654d8f3-e64a-41ca-8e1d-e40a2417427c.png width="400" height="200" />

Для просмотра всех книг библиотеки необходимо выполнить GET запрос на адрес: /books

<img src=https://user-images.githubusercontent.com/69649934/231180859-9544e2f5-a267-4011-8c7e-e833f171ff49.png width="430" height="260" />

---

<h3>Примеры рабочих страниц программы</h3>

<img src=https://user-images.githubusercontent.com/69649934/231183883-89d2ebe1-8ffd-4845-8778-047993d6acd3.png width="450" height="300" />

<img src=https://user-images.githubusercontent.com/69649934/231191715-b200b9c4-a30f-4973-bb8c-8b9f4a210599.png width="430" height="300" />

<img src=https://user-images.githubusercontent.com/69649934/231190923-e0402617-7984-4258-8bf3-a409a428f291.png width="440" height="300" />

<img src=https://user-images.githubusercontent.com/69649934/231190419-84b8bb34-0890-406d-8a54-137f438aac86.png width="420" height="300" />

<img src=https://user-images.githubusercontent.com/69649934/231188325-13e486b5-c7b7-4251-8196-073843a98350.png width="500" height="310" />

<img src=https://user-images.githubusercontent.com/69649934/231189771-b983820c-6ef3-41a9-bd84-f648182270d8.png width="500" height="310" />

<img src=https://user-images.githubusercontent.com/69649934/231192750-0ba75580-dd62-4b3d-a722-fb35e8494f2d.png width="520" height="370" />

<img src=https://user-images.githubusercontent.com/69649934/231194291-8d314c9c-07b1-4aba-a2da-c6f1e1c571bd.png width="400" height="300" />
