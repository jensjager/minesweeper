# Minesweeper
Autorid: Taavi Eistre, Jens Jäger

Tegime oma objektorienteeritud programmeerimise rühmatööks
klassikalise mängu "Minesweeper".

Mängijale on ette antud varjatud väli, kus osad ruudud on "miinid".
Mängija ülesandeks on nähtavaks muuta kõik tühjad ruudud.
Abiks tuleb fakt, et tühjad ruudud näitavad, mitut miini nad puudutavad.
Juhul, kui mängija valib miini, osutub mäng kaotatuks.

Klassid:
- Minesweeper - Main meetodiga klass, kus paikneb jooksev mäng.
- Kasutaja - Klass, mille peamiseks eesmärgiks on kasutaja suhtlemine ning mängija elutõeväärtuse hoidmine.
- Ruudud - Ülemklass Miinile ja TühiRuudule, kus on defineeritud vajalikud
isendiväljad ning isendimeetodid.
- Miin - Ruudud alamklass, kus on defineeritud konstruktor ning ülekattega toString(),
mis on vajalik väljal esineva isendi näitamiseks.
- TühiRuut - Sarnane klassile Miin.
- Väli - Klass, mille sees hoitakse Ruudud[][] massiivi ning mis sisaldab väljaga tegutsemiseks
vajalikke meetodeid. Näiteks välja jaoks loomise meetod ning tühjade ruutude
väärtustamise (näitab mitut miini tühi ruut puutub) meetod.

Tegemise protsess:
1) Algne koosistumine, mille käigus mõtlesime välja üldise struktuuri ning kuidas peaksid klassid väli,
miin ja tühimiin töötama.
2) Mainitud klasside kirjutamine ning testimine
3) Taavi täiustas struktuurselt neid ning muutis mängu juba mängitavaks.
4) Jens täiustas väli klassi paari kasuliku meetodiga (näiteks avaldaTühjad()).
5) Taavi töötlesid struktuuri natuke ümber loenguvideotest õpitu alusel.

Ajakulu:
- Taavi ~ 5h
- Jens ~ 3h

Puuduste poole pealt tooks välja võibolla selle, et enne ülem- ja alamklasside loenguvideoid oli meie
kood üpriski segane. Kui oleksime nendest omadustest varem teadnud, oleksime saanud juba algusest peale puhtamat
koodi kirjutada.

Arvame, et rühmatöö on senimaani päris edukalt välja tulnud. Järgmiseks oleks plaan viia mäng üle
graafilisele kasutajaliidesele, kus oleks võimalik mängu palju mugavamalt mängida.

Testimiseks ja katsetamiseks kasutasime peamiselt main meetodis väikseid näiteid
(näiteks tekitasime välja ja kasutasime selle peal kõikNähtav() meetodit ning väljastasime selle).