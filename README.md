# Pet-проект: Тестирование the-internet.herokuapp.com

**Цель:** Продемонстрировать навыки функционального тестирования, составления баг-репортов и тестовой документации.

## Что протестировано
- https://the-internet.herokuapp.com/inputs
- https://the-internet.herokuapp.com/checkboxes
- https://the-internet.herokuapp.com/add_remove_elements/

## Найденные баги (3 шт)
| ID | Описание |
|----|----------|
| BUG-001 | В числовое поле можно вставить букву «e» через Ctrl+V |
| BUG-002 | Первый чекбокс теряет состояние после перезагрузки |
| BUG-003 | Второй чекбокс самовольно возвращается в `checked` |

## Тестовая документация
- [Баг-репорты](BUGS.md)
- [Тест-кейсы](TEST_CASES.md)
- [Чек-лист](CHECKLIST.md)

## Инструменты
- Ручное тестирование
- Google Таблицы (баг-трекинг)
- GitHub Pages (портфолио)

## Как посмотреть
Страница для тестирования: https://the-internet.herokuapp.com/
## Автотест для BUG-003

Автотест на Java + Selenium, который воспроизводит баг с возвращением галочки.

### Запуск автотеста
```bash
cd autotests/PETAUTOTESTS
mvn test

Ожидаемый результат
Expected [false] but was [true]
BUG-003: Второй чекбокс должен оставаться НЕотмеченным после перезагрузки!
✅ Тест падает, потому что баг существует.

Инструменты:
Ручное тестирование
Java 17 + Selenium + JUnit 5
Maven
GitHub
