<h1>1. Követelményanalízis</h1>
<h3>1.1. Célkitűzés, projektindító dokumentum</h3>
A program legfőbb célja jól átláthatóan, és érthetően nyilvántartani egy fejvadász cég projektjeit. Mindezt egy webes alkalmazás segítségével, hogy bárhol el lehessen érni. A projekteket lehessen kategorizálni megrendelő szerint, mint pl. banki szektor.  A projektekhez lehessen hozzárendelni jelölteket, és lehessen új jelölteket létrehozni az alapadatok megadásával. A biztonság miatt, legyen lehetőség bejelentkezésre, és regisztrálni új felhasználót, csak az admin szerepkörrel rendelkező felhasználó tudjon.
<h6>Funkcionális követelmények:</h6>
*	Regisztráció
*	Bejelentkezés
*	Csak bejelentkezett felhasználók által elérhető funkciók
  *	új jelölt készítése és felvétele egy projekthez
  *	a meglévő jelöltek és projektek szerkesztése
  *	a meglévő jelöltek törlésére
  *	projektek létrehozása
  
<h6>Nem funkcionális követelmények:</h6>
*	**Könnyű áttekinthetőség:** egyértelmű legyen, hogy milyen adatot kell beírni, melyik helyre, és könnyen lehessen navigálni az oldalon. 
*	**Használhatóság:** ésszerű elrendezés, könnyen kezelhetőség
*	**Megbízhatóság:** Hibásan bevitt adatok esetén a program jól láthatóan jelezzen a felhasználónak, és emelje ki a hibás beviteli mezőket. A jól bevitt adatok maradjanak az űrlapban.
*	**Karbantarthatóság:** könnyen lehessen bővíteni, a különböző típusú fájlok külön csoportosítva, ésszerűen legyenek felbontva, a könnyebb fejleszthetőség miatt
 
<h3>1.2. Használatieset-modell, funkcionális követelmények</h3>

**Vendég:** Csak a login formot éri el
 *	Bejelentkezés

**Beosztott:** A következő funckióhoz is hozzáfér. 
  *	Beosztotthoz tartozó projektek megtekintése, szerkesztése
  *	Meglévő projekthez hozzárendelt jelöltek listájának megtekintése
  *	Meglévő projekthez hozzárendelt jelöltek listájának szerkesztése
  *	Meglévő projekthez új jelölt hozzáadása
  
**Cégvezető:** A beosztott funkciókon kívül még hozzáférhet a következőkhöz is.
  *	Minden projekt megteknitése
  *	Beosztottakat projektekhez rendelni
  *	Új projekt létrehozása
  *Projekt törlése
  *	Projektek kategóriákba sorolása
  *	Új beosztott regisztrálása
  
![alt text](/imgs/hasznalat_eset.png "")
  
  
Bejelentkezés

 ![alt text](/imgs/bejelentkezes.png "")
 
Kijelentkezés

 ![alt text](/imgs/kijelentkezes.png "")
 
Jelöltek megtekintése, szerkesztése, törlése
 ![alt text](/imgs/jeloltek.png "")
 
Projektek létrehozása, kategóriába sorolása, megtekintése, szerkesztése, törlése
 ![alt text](/imgs/projektek.png "")
Új beosztott regisztrálása
![alt text](/imgs/beosztott.png "")
 
Oldaltérkép
*	Publikus
  *	Belépés
*	Beosztott
  *	Kijelentkezés
  *	Egyes projektek megtekintése, szerkesztése
  *	Jelöltek megtekintése, szerkesztése, hozzáadása
*	Cégvezető
  *	Kijelentkezés
  *	Minden projekt megtekintése
  *	Beosztottak projekthez rendelése
  *	Új projekt létrehozása, kategóriába sorolása, törlése
  *	Új beosztott regisztrálása
  
 
Végpontok
*	GET /login : Bejelentkező oldal
*	POST /login : Autentikáció
*	GET /candidates: Projekt jelöltjei és projektek adminisztrációja
*	POST /candidates : Jelöltek,projektek szerkesztése
*	GET /users : Felhasználók listája
*	POST /users: Felhasználók listájának szerkesztése
<h6>1.3. Osztálymodell</h6>
**Adatmodell**

![alt text](/imgs/adatmodell.png "")

Tesztelés:

Enterprise Java Bean tests:

Results :

Tests run: 2, Failures: 0, Errors: 0, Skipped: 0

------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time: 24.003s
Finished at: Sat Jan 21 11:58:25 CET 2017
Final Memory: 11M/165M
------------------------------------------------------------------------

Két tesztmetódus fut le, az első azt ellenőrzi, hogy helyesen be tud-e lépni a felhasználó.
```
@Test
    public void testLogin() throws Exception {
        LoginBean loginBean = (LoginBean) container.getContext().lookup("java:global/classes/LoginBean");
        User loggedInUser = loginBean.getLoggedInUser();
        Assert.assertEquals("admin", loggedInUser.getUsername());
    }
```
A második teszt metódus teszteli, hogy lehet-e új felhasználót létrehozni, majd ellenőrzi, hogy megkapja-e a szerepköröket, majd hogy lehet-e neki projektet felvenni.
```
@Test
    public void testRegistration() throws Exception {
        UsersBean usersBean = (UsersBean) container.getContext().lookup("java:global/classes/UsersBean");
        String testerString = "teszt6";
        User newUser = usersBean.registerNewUser(testerString, testerString, testerString);
        //teszt sikeres regisztrációt
        Assert.assertEquals(testerString, usersBean.getRegisteredUsers().get(usersBean.getRegisteredUsers().size()-1).getUsername());   
        
        //teszt user szerepkör
        Assert.assertEquals("commonuser", usersBean.getRegisteredUsers().get(usersBean.getRegisteredUsers().size()-1).getRoles().get(0).getName());
        //teszt projektek
        Assert.assertEquals("Projektnev", usersBean.getAvailableProjects(newUser).get(0).getProjectName());
}
```
    
A tesztelés a JUnit(4.1) és a Glassfish alkalmazás szerver embedded apijával történik.

![alt text](/imgs/unittest.png "")
 
