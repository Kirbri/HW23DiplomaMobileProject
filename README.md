# <p align="center">Проект по мобильной автоматизации тестовых сценариев для android приложения компании [Авито](https://www.avito.ru/)</p>

> Ави́то — российский интернет-сервис для размещения объявлений о товарах, недвижимости, вакансиях и резюме на рынке труда, а также услугах, занимающий первое место в мире среди сайтов объявлений

 ____

<a id="table_of_contents"></a>
## Содержание

* <a href="#tools">Технологии и инструменты</a>
* <a href="#project_goal">Цель проекта</a>
* <a href="#cases">Реализованные автотесты</a>
* <a href="#jenkins">Сборка в Jenkins</a>
* <a href="#jenkins_parameters">Параметризированная сборка в Jenkins</a>
* <a href="#console">Запуск тестов</a>
* <a href="#allure">Allure отчет</a>
* <a href="#allure-testops">Интеграция с Allure TestOps</a>
* <a href="#jira">Интеграция с Jira</a>
* <a href="#notifications">Уведомления</a>
* <a href="#video">Примеры видео выполнения тестов</a>

___

<a id="tools"></a>
## <a name="Технологии и инструменты">Технологии и инструменты на проекте</a>

- Проект написан на **Java** с использованием фреймфворка **Selenide**
- Для модульного тестирования использовался **JUnit 5**
- На платформе **BrowserStack** были найдены локаторы и запущены удалённые тесты
- С помощью **Android Studio** создан эмулятор на котором найдены локаторы и запущены тесты, с помощью **Appium**
- <a href="#allure">Отчётность</a> представлена в **Allure Report**
- <a href="#jenkins">Непрерывная интеграция</a> и непрерывное развертывание реализовано через **Jenkins**
- **Telegram** и почтовый агент используются для получения <a href="#notifications">уведомлений</a>



| Логотип | Описание                                                                                                                                      |
| --- |-----------------------------------------------------------------------------------------------------------------------------------------------|
| <a href="https://www.jetbrains.com/idea/"><img align="center" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/intellij/intellij-original.svg" height="40" weight="40" alt="IntelliJ IDEA"/> | IntelliJ IDEA — интегрированная среда разработки программного обеспечения.                                                                    |
| <a href="https://www.java.com/ru/"><img align="center" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" height="40" weight="40" alt="Java"/> | Java — строго типизированный объектно-ориентированный язык программирования общего назначения.                                                |
| <a href="https://github.com/"><img align="center" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/github/github-original.svg" height="40" weight="40" alt="Github"/> | GitHub — крупнейший веб-сервис для хостинга IT-проектов и их совместной разработки.                                                           |
| <a href="https://junit.org/junit5/"><img align="center" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/junit/junit-original.svg" height="40" weight="40" alt="JUnit 5"/> | JUnit — фреймворк для модульного тестирования программного обеспечения на языке Java.                                                         |
| <a href="https://gradle.org/"><img align="center" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/gradle/gradle-original.svg" height="40" weight="40" alt="Gradle"/> | Gradle — система автоматической сборки.                                                                                                       |
| <a href="https://www.jenkins.io/"><img align="center" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/jenkins/jenkins-original.svg" height="40" weight="40" alt="Jenkins"/> | Jenkins — программная система предназначенная для обеспечения процесса непрерывной интеграции программного обеспечения.                       |
| <a href="https://www.atlassian.com/software/jira"><img align="center" src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/jira/jira-original.svg" height="40" weight="40" alt="Jira"/> | Jira — система отслеживания ошибок, предназначена для организации взаимодействия с пользователями и управления проектами.                     |
| <a href="https://github.com/allure-framework"><img align="center" src="https://avatars.githubusercontent.com/u/5879127?s=200&v=4" height="40" weight="40" alt="Allure"/> | Allure - фреймворк для создания простых и понятных отчётов автотестов.                                                                        |
| <a href="https://selenide.org/"><img align="center" src="https://avatars.githubusercontent.com/u/43955696?s=200&v=4" height="40" weight="40" alt="Selenide"/> | Selenide - это фреймворк для автоматизированного тестирования веб-приложений на основе Selenium WebDriver.                                    |
| <a href="https://appium.io/"><img align="center" src="https://appium.io/docs/en/latest/assets/images/appium-logo-white.png" height="40" weight="40" alt="Appium"/> | Appium — ПО, разработанное для упрощения автоматизации пользовательского интерфейса многих платформ приложений, включая мобильные устройства. |
| <a href="https://www.browserstack.com/"><img align="center" src="https://avatars.githubusercontent.com/u/1119453?s=200&v=4" height="40" weight="40" alt="BrowserStack"/> | BrowserStack — это облачная платформа для веб-тестирования и мобильного тестирования.                                                         |
| <a href="https://developer.android.com/studio"><img align="center" src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/Android_Studio_Logo_2024.svg/160px-Android_Studio_Logo_2024.svg.png" height="40" weight="40" alt="AndroidStudio"/> | Android Studio — интегрированная среда разработки (IDE) для работы с платформой Android.                                                      |
| <a href="https://qameta.io/"><img align="center" src="https://avatars.githubusercontent.com/u/19841150?s=200&v=4" height="40" weight="40" alt="TestOps"/> | Allure Testops - полноценное управление тестированием, ориентированное на автоматизацию, согласованное с DevOps.                              |
| <a href="https://telegram.org/"><img align="center" src="https://upload.wikimedia.org/wikipedia/commons/8/83/Telegram_2019_Logo.svg" height="40" weight="40" alt="Telegram"/>| Telegram — кроссплатформенный мессенджер.                                                                                                     |

<a href="#table_of_contents">Наверх</a>
____

<a id="project_goal"></a>
## <a name="Цель проекта">Цель проекта </a>

> <p>Проект является демонстрационным и включает в себя ряд мобильных автоматизированных тестов, охватывающих различные аспекты функциональности, обеспечивая качество, надежность и стабильность работы приложения.</p>

<a href="#table_of_contents">Наверх</a>

 ____

<a id="cases"></a>
## <a name="Реализованные автотесты"> Реализованные автотесты </a>
### 1. Поиск объявлений

- [x] Поиск по ключевому слову с нулевым результатом;
- [x] Поиск по ключевому слову с не нулевым результатом;
- [x] Поиск по ключевому слову и подписка на поиск.

### 2. Открытие первого объявления и взаимодействие с ним

- [x] Открыть первое объявление и проверить совпадение названий;
- [x] Открыть первое объявление и позвонить по нему;
- [x] Открыть первое объявление и написать по нему;
- [x] Открыть первое объявление и отправить базовый вопрос продавцу;
- [x] Открыть первое объявление и перейти к профилю продавца;
- [x] Открыть первое объявление и подписаться на продавца;
- [x] Открыть первое объявление и пожаловаться на него.

<a href="#table_of_contents">Наверх</a>

____

<a id="jenkins"></a>
## <a name="Сборка в Jenkins"> Сборка в [Jenkins](https://jenkins.autotests.cloud/job/010-Kornilova_Ann_qa_guru-java_23/) </a>

Для запуска сборки необходимо перейти в раздел Build with Parameters и нажать кнопку Build

<p align="center">  
<a href="https://jenkins.autotests.cloud/job/010-Kornilova_Ann_qa_guru-java_23/"><img src="src/test/resources/images/screenshot/Jenkins_1.png" alt="Jenkins" width="950"/></a>  
</p>

<a id="jenkins_parameters"></a>
### <a name="Параметры сборки в Jenkins"> Параметры сборки в Jenkins </a>

- **REPOSITORY** - репозиторий источник данных для запуска тестов
- **TASK** - выбор группы тестов
- **USER_NAME ACCESS_KEY** - учётные данные от платформы browserstack
- **DEVICE_NAME** - модель телефона

<p align="center">  
<a href="https://jenkins.autotests.cloud/job/010-Kornilova_Ann_qa_guru-java_23/build?delay=0sec"><img src="src/test/resources/images/screenshot/Jenkins_2.png" alt="Jenkins" width="950"/></a>  
</p>

<a href="#table_of_contents">Наверх</a>

_____

<a id="console"></a>
## Команды для запуска тестов

> [!NOTE]
> 
> **[Иструкция](https://autotest.how/appium-setup-for-local-android-tutorial-md) по настройке и запуску** 
> 
> Для локального запуска необходимо установить:
> - [Java](https://github.com/qa-guru/knowledge-base/wiki/%D0%98%D0%BD%D1%81%D1%82%D1%80%D1%83%D0%BC%D0%B5%D0%BD%D1%82%D1%8B:-Java), 
> - [Gradle](https://github.com/qa-guru/knowledge-base/wiki/%D0%98%D0%BD%D1%81%D1%82%D1%80%D1%83%D0%BC%D0%B5%D0%BD%D1%82%D1%8B:-Gradle), 
> - Cреда разработки, например, [IntelliJ IDEA](https://github.com/qa-guru/knowledge-base/wiki/%D0%98%D0%BD%D1%81%D1%82%D1%80%D1%83%D0%BC%D0%B5%D0%BD%D1%82%D1%8B:-IntelliJ-IDEA)
> - [Android studio](https://developer.android.com/studio)
> - [node.js](https://nodejs.org/en/download)
> - [npm](https://www.npmjs.com/)
> - [Appium Server](https://github.com/appium/appium)
> - Драйвер [UiAutomator2](https://appium.io/docs/en/2.1/quickstart/uiauto2-driver/)
> - [Appium Inspector](https://github.com/appium/appium-inspector)

### Допустимые комбинации

```mermaid 
flowchart LR
    A(gradle) --> B(clean)
    B --> C{Выбрать task}
    C --> D[android_all_test]
    C --> E[android_search_test]
    C --> F[android_announcement_test]
    D --> G[environment.properties]
    E --> G[environment.properties]
    F --> G[environment.properties]
    G --> H[-DdeviceHost=browserstack]
    G --> I[-DdeviceHost=emulation]
    H --> J[-DbrowserstackUser]
    H --> K[-DbrowserstackKey]
```

### Локально

**Локальный запуск с параметрами по умолчанию**

*Для теста возьмутся параметры из файла resources/properties/local.properties, для изменения параметров необходимо исправить файл*
```bash  
gradle clean {task}
```

**Пример локального запуска с указанием параметров в консоли**
```bash  
gradle clean web_login_test 
-Denvironment=local 
-DbrowserName=firefox 
-DbrowserVersion=135 
-DbrowserWindowSize=2560x1440 
-DbrowserIsRemote=false
```

### Удалённо

**Пример локального запуска с указанием среды выполнения**

*Тест можно запустить из терминала, а выполнение будет в Selenoid, параметры для запуска - resources/properties/remote.properties, для изменения параметров необходимо исправить файл*
```bash  
gradle clean web_search_test 
-Denvironment=remote
```

**Пример удалённого запуск через *Jenkins***
```bash
clean
${TASK} 
-Denvironment=remote 
-DbrowserName=${BROWSER} 
-DbrowserVersion=${BROWSER_VERSION} 
-DbrowserWindowSize=${SCREEN_RESOLUTION} 
-DbrowserIsRemote=true 
-DremoteUrl=${REMOTE_URL} 
-DremoteUser=${REMOTE_USER} 
-DremotePassword=${REMOTE_PASSWORD}
```

<a href="#table_of_contents">Наверх</a>

_____

<a id="allure"></a>
## <a name="Allure">Allure [отчет](https://jenkins.autotests.cloud/job/009-Kornilova_Ann_qa_guru-java_23/allure/)</a>

### Основная страница отчёта

<p align="center">  
<img title="Allure Overview Dashboard" src="src/test/resources/images/screenshot/Allure_1.png" width="850">  
</p>  

### Тест-кейсы

<details>

<summary>Раскройте, для просмотра</summary>
<p align="center">  
<img title="Allure Tests" src="src/test/resources/images/screenshot/Allure_2.png" width="850">  
</p>

</details>>

### Графики

<details>

<summary>Раскройте, для просмотра</summary>
  <p align="center">  
<img title="Allure Graphics" src="src/test/resources/images/screenshot/Allure_3.png" width="850">

<img title="Allure Graphics" src="src/test/resources/images/screenshot/Allure_4.png" width="850">  
</p>

</details>>

<a href="#table_of_contents">Наверх</a>

___

<a id="allure-testops"></a>
## <a name="Allure_TestOps">Интеграция с [Allure TestOps](https://allure.autotests.cloud/project/4645/dashboards)</a>

### Allure TestOps Dashboard

<p align="center">  
<img title="Allure TestOps Dashboard" src="src/test/resources/images/screenshot/Allure_TestOps_1.png" width="850">  
</p>  

### Авто тест-кейсы

<p align="center">  
<img title="Allure TestOps Tests" src="src/test/resources/images/screenshot/Allure_TestOps_2.png" width="850">  
</p>

<a href="#table_of_contents">Наверх</a>

___
<a id="jira"></a>
## <a name="Jira">Интеграция с [Jira](https://jira.autotests.cloud/browse/HOMEWORK-1415)</a>

<p align="center">  
<img title="Jira" src="src/test/resources/images/screenshot/Jira_1.png" width="850">  
</p>

<p align="center">  
<img title="Jira" src="src/test/resources/images/screenshot/Jira_2.png" width="850">  
</p>

<a href="#table_of_contents">Наверх</a>

____

<a id="notifications"></a>
## <a name="Notifications"> Уведомления </a>


###  <a name="Telegram"> Уведомление в Telegram </a>

<p align="center">  
<img title="Allure Overview Dashboard" src="src/test/resources/images/screenshot/Telegram.png" width="550">  
</p>

<a href="#table_of_contents">Наверх</a>


###  <a name="Mail"> Уведомление на почту </a>

<p align="center">  
<img title="Allure Overview Dashboard" src="src/test/resources/images/screenshot/Mail_1.png" width="550">  
</p>

<a href="#table_of_contents">Наверх</a>


____

<a id="video"></a>
##  <a name="Video"> Примеры выполнения тестов </a>

<p align="center">
<img title="Selenoid Video" src="src/test/resources/images/gif/FavoriteTests_2.gif" width="550" height="350"  alt="video">   
</p>

<details>
<summary>Раскройте, для просмотра</summary>
<p align="center">
<img title="Selenoid Video" src="src/test/resources/images/gif/FavoriteTests_2.gif" width="550" height="350"  alt="video">   
</p>

<p align="center">
<img title="Selenoid Video" src="src/test/resources/images/gif/FavoriteTests_3.gif" width="550" height="350"  alt="video">   
</p>

<p align="center">
<img title="Selenoid Video" src="src/test/resources/images/gif/LoginTest_1.gif" width="550" height="350"  alt="video">   
</p>

<p align="center">
<img title="Selenoid Video" src="src/test/resources/images/gif/LoginTest_1.gif" width="550" height="350"  alt="video">   
</p>

<p align="center">
<img title="Selenoid Video" src="src/test/resources/images/gif/SearchTests_1.gif" width="550" height="350"  alt="video">   
</p>

<p align="center">
<img title="Selenoid Video" src="src/test/resources/images/gif/SearchTests_2.gif" width="550" height="350"  alt="video">   
</p>

<p align="center">
<img title="Selenoid Video" src="src/test/resources/images/gif/SearchTests_3.gif" width="550" height="350"  alt="video">   
</p>

<p align="center">
<img title="Selenoid Video" src="src/test/resources/images/gif/SearchTests_4.gif" width="550" height="350"  alt="video">   
</p>

<p align="center">
<img title="Selenoid Video" src="src/test/resources/images/gif/SearchTests_5.gif" width="550" height="350"  alt="video">   
</p>
</details>

<a href="#table_of_contents">Наверх</a>