package slawomirlech.przepisnawino;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private Przepisy przepis = new Przepisy();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // metoda setContentView informuje system z jakiego układu korzysta dana aktywność w tym przypadku jest to activity_main
    }

    /*
musimy pobrac referencje dwóch komponentów GUI:
spinnera i textview. dzieki temu będziemy mogli zarówno pobrać wartość
wybraną przezużytkownika na rozwijanej liście jak i wyświetlić tekst w widoku tekstowym
str.  55
*/

public class Przepisy { 
    List<String> getPrzepisy (String spinner){ // musi być import java.util.List; // getPrzepisy odnajduje pasujące przepisy na wino odpowiadające przekazanej nazwie owocu.
        List<String> tekstview = new ArrayList<>();
        if (spinner.equals("[1]Agrest")){
            tekstview.add("Agrest:\nIlość owoców: 11,6 kg\nIlość soku: 8 l\nIlość cukru na wino 12% : 3,6 kg\nIlość wody: 9,6 l\nIlość reg. kwasowości w na 20 l wody: 0 g");

        } else if (spinner.equals("[2]Aronia")) {
            tekstview.add("Aronia:\nIlość owoców: 9,8 kg\nIlość soku: 7 l\nIlość cukru na wino 12% : 3,4 kg\nIlość wody: 9,6 l\nIlość reg. kwasowości w na 20 l wody: 8-12 g");

        } else if (spinner.equals("[3]Głóg i dzika róża")){
            tekstview.add("Głóg i dzika róża:\nIlość owoców: 10 kg\nIlość soku: 5 l\nIlość cukru na wino 12% : 3,6 kg\nIlość wody: 12,4 l\nIlość reg. kwasowości w na 20 l wody: 28-36 g");

        } else if (spinner.equals("[4]Jabłka")){
            tekstview.add("Jabłka:\nIlość owoców: 21,6 kg\nIlość soku: 13 l\nIlość cukru na wino 12% : 2,8 kg\nIlość wody: 5 l\nIlość reg. kwasowości w na 20 l wody: 8-10 g");

        } else if (spinner.equals("[5]Wiśnie")){
            tekstview.add("Wiśnie:\nIlość owoców: 20 kg\nIlość soku: 11 l\nIlość cukru na wino 12% : 3 kg\nIlość wody: 6,6 l\nIlość reg. kwasowości w na 20 l wody: 0 g");

        } else if (spinner.equals("[6]Porzeczki")){
            tekstview.add("Porzeczki:\nIlość owoców: 10 kg\nIlość soku: 7 l\nIlość cukru na wino 12% : 3,8 kg\nIlość wody: 10,4 l\nIlość reg. kwasowości w na 20 l wody: 0 g");

        } else if (spinner.equals("[7]Winogrona")){
            tekstview.add("Winogrona czarne:\nIlość owoców: 18 kg\nIlość soku: 12,6 l\nIlość cukru na wino 12% : 2,4 kg\nIlość wody: 5 l\nIlość reg. kwasowości w na 20 l wody: 0 g");

        } else if (spinner.equals("[8]Rodzynki")){
            tekstview.add("Rodzynki:\nIlość owoców: 3 kg\nIlość soku: - \nIlość cukru na wino 12% : 3,4 kg\nIlość wody: 15,6 l\nIlość reg. kwasowości w na 20 l wody: 30 g");

        } else if (spinner.equals("[9]Jeżyny")){
            tekstview.add("Jeżyny:\nIlość owoców: 17 kg\nIlość soku: 12 l\nIlość cukru na wino 12% : 3,4 kg\nIlość wody: 5,6 l\nIlość reg. kwasowości w na 20l wody: 10 g");

        } else if (spinner.equals("[10]Czarny bez")){
            tekstview.add("Czarny bez:\nIlość owoców: 11,2 kg\nIlość soku: 7 l\nIlość cukru na wino 12% : 4 kg\nIlość wody: 7,2 l\nIlość reg. kwasowości w na 20l wody: 16 g");
        } else {
            tekstview.add("error: poza zakresem");
        }
        return tekstview;
    }
}

//  Ilość owoców [kg]:  Ilość soku [l]: Ilość cukru w [kg] potrzebna do uzyskania wina o zawartości alkochololu 12%
    // Ilość wody [litry]:    Ilość regulatora kwasowości w [g] na 20l wody:

// metoda wywoływana gdy użytkownik kliknie przycisk
public void onClickPokazPrzepis(View view){ // metoda wywolywana gdy uzytkownik kliknie przycisk // parametr "Viev" odwołuje się do komponentu GUI który soprowadził do wywołania tej metody
    TextView tekstview = (TextView) findViewById(R.id.tekstview); // wywołanie tego kodu powoduje utworzenie obiektu TextView o nazwie tekstview jednocześnie zyskujemu mozliwość wywoływania metod tego obiektu ( s. 60) pobiera referencje do komponentu TextView o id "tekstview"   dzieki pobraniu referencji do id przepis będziemy mogli póxniej wyświetlić zawartość tej referencji w widoku tekstowym
    Spinner spinner = (Spinner) findViewById(R.id.spinner); // / pobiera referencje do komponentu Spinner
    String wybranyOwoc = String.valueOf(spinner.getSelectedItem()); // pobieramy z rozwijanej listy aktualnie wybraną wartośc i konwersyjemy na łańcuch znaków// wybranyOwoc to bedzie nazwa zmiennej wybranego owocu po kliknięciu
    // pobieranie listy przepisów z klasy Przepisy:
    List<String> listaPrzepisow = przepis.getPrzepisy(wybranyOwoc);
    StringBuilder przepisyFormatted = new StringBuilder(); // konstruułuje łańcuch znaków w którym zostaną zapisane wartości znaków
    for (String lista : listaPrzepisow){
        przepisyFormatted.append(lista); // wyświetla przepisy  https://javastart.pl/static/klasy/string-stringbuffer-i-stringbuilder/
    }
// wyświetlenie wyników
    tekstview.setText(przepisyFormatted); // wyświetla wynik w widoku tekstowym
}

}


/* android:entries="@array/wybierz_wino" ten zapis w activity_main
 oznacza, że elementy listyw komponencie spinner pochodzą z tablicy wybierz_wino. Zapis @string odwołuje się do tablicy*/
