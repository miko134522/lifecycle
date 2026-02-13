Pobierz plik lifecycle.zip, rozpakuj, zaimportuj i przetestuj w środowisku Android Studio przykładową  aplikację LifeCycle,
a następnie spróbuj wykonać własną wersję takiej aplikacji, która będzie sygnalizować zmiany wewnętrznego stanu Aktywności, poprzez wyświetlanie powiadomień za pomocą obiektów klasy Toast:.
      Toast.makeText(this, "onCreate", 1).show();
zaimplementuj w ten sposób działanie metod obsługujących wybrane podstawowe wydarzenia:  onCreate, onStart, onResume, onSaveInstanceState, onPause, onStop, onDestroy, onRestart.

Podpowiedź:
To zadanie będzie łatwiejsze gdy wykorzystasz opcję menu
    Code > Override Methods…      (skrót Ctrl+O)
dostępną w środowisku Android Studio.

Zaobserwuj i zanotuj sekwencje komunikatów Toast wyświetlanych po::

Kliknięciu programowego przycisku EXIT (w oknie aplikacji)
wyświetli się onPause
a po powrocie onCreate i onStart

Kliknięciu sprzętowego przycisku BACK (na telefonie)
wyświetli się onPause
a na powrocie onRestart onStart onResume

Kliknięciu sprzętowego przycisku HOME (na telefonie)
wyświetli onPause


Kliknięciu przycisku połączenia telefonicznego (CALL - zielona słuchawka)
(uwaga: w starszych telefonach/emulatorach były dodatkowe przyciski Call / Hang-up)
wyświetli po odebraniu onPause i onStop


Przytrzymaniu przycisku odłożenia słuchawki (HANG-UP -  czerwona słuchawka)
po odrzuceniu nic się nie wyświetliOtrzymaniu tekstowej wiadomości SMS (z innego emulatora lub telefonu)
Po otrzymaniu połączenia głosowego (z innego emulatora lub telefonu).

Za każdym razem wróć do tego samego podstawowego stanu "running",
poprzez otwarcie okna z listą zainstalowanych aplikacji (launch pad),
i przywrócenie/uruchomienie aplikacji, klikając na jej ikonie.


Zaobserowane wyniki udokumentuj do pliku Sprawozdanie.pdf. 
Plik prześlij na maila w odpowiedniej formie.
