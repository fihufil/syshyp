# SYShyp
Program monitorujący zasoby i zagrożenia w systemie Linux

budowanie:
```bash
javac syshyp.java
```
uruchomienie:
```bash
java syshyp
```

Klasy:

 syshyp.java
Analyzer.java
CPU.java
Disk.java
RAM.java
Threat.java|
SSHFailed.java
SudoFailed.java

syshyp:

Używana do utworzenia obiektów z klas, otworzenia i zamknięcia pliku, a także za faktyczny zapis do pliku.

Analyzer:

Zawiera dziedziczoną metodę która potrafi pozyskać linijkę z pliku.

CPU:

Odczytuje z /proc/stat zużycie CPU i zwraca je jako liczbę zmiennoprzecinkową.

Disk:

Parsuje output z polecenia df i odczytuje zajętość głównego systemu plików /

RAM:

Zawiera metodę która umie podać ilość pamięci w zależności od przekazanego parametru

0 for MemTotal
1 for MemFree
2 for Buffers
3 for Cached

Threat:

potrafi podać ostatnią linijkę z pliku /var/log/auth.log

SSHFailed i SudoFailed:

Bliźniacze klasy które poszukują odpowiednich eventów w pliku auth.log

Jak złapać % użycia CPU w Linuxie z /proc/stat?:

```bash
$cat /proc/stat | head -n 1

cpu 16333 284 92133 346134 38206 0 1125
```

Należy spojrzeć na 1. linię i zsumować wszystkie wartości oraz 3 pierwsze oddzielnie.

Następnie należy odczekać np. 5 sek. i znów zsumować wszystkie wartości i 3 pierwsze oddzielnie.

(3pierwszeWartości2-3pierwszeWartości1) / (WszystkieWartości2 – WszystkieWartości1) * 100

i Viola mamy użycie CPU w procentach.

Jak złapać % użycia RAM w Linuxie z /proc/meminfo

```bash
$ cat /proc/meminfo | head -n 4

MemTotal: 8081628 kB

MemFree: 1780420 kB

Buffers: 142384 kB

Cached: 4102472 kB
```
(MemTotal – MemBuffers – Cached – MemFree)/MemTotal
