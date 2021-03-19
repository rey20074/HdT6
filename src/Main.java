import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MapFactory<String, Card> factory = new MapFactory<>();
        GeneralMap<String, Card> cards;
        GeneralMap<String, Card> userCards;
        String ans;

        System.out.println("Bienvenido, por favor ingrese el tipo de Map que desea utilizar:");
        System.out.println("1) HashMap = HM\n2) LinkedHashMap = LM\n3) TreeMap = TM");

        ans = sc.nextLine();
        userCards = factory.getMap(ans.toUpperCase());
        cards = factory.getMap(ans.toUpperCase());

        try {
            File myObj = new File("C:\\Users\\juanc\\OneDrive\\Escritorio\\UVG\\Tareas\\Algoritmos y estructura de Datos\\Hoja de Trabajo 6\\src\\cards.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String name = data.split("\\|")[0];
                String type = data.split("\\|")[1];
                Card card = new Card(name, type);
                cards.Put(name, card);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        boolean body = true;
        while (body) {

            System.out.println("\nIngrese la opcion que desee:" +
                    "\n1) Agregar carta a su coleccion." +
                    "\n2) Ver tipo de una carta en su coleccion." +
                    "\n3) Mostrar la informacion de cada carta en su coleccion." +
                    "\n4) Mostrar la informacion de cada carta en su coleccion ordenada por tipo." +
                    "\n5) Mostrar la informacion de cada carta existente." +
                    "\n6) Mostrar la informacion de cada carta existente ordenada por tipo."+
                    "\n7) Salir.");

            int choice = 0;

            boolean ask = true;
            while (ask) {
                try {
                    choice = sc.nextInt();
                    sc.nextLine();
                    if (choice > 6 || choice < 1) {
                        System.out.println("\nPor favor ingrese un valor correcto.");
                    } else {
                        ask = false;
                    }
                } catch (Exception e) {
                    System.out.println("\nPor favor ingrese un valor correcto.");
                }
            }

            String name;

            switch (choice) {


                case 1:
                    System.out.println("\nPor favor ingrese el nombre de la carta que desea ingresar.");
                    name = sc.nextLine();
                    if (cards.ContainsKey(name)) {
                        if (!userCards.ContainsKey(name)) {
                            userCards.Put(name, cards.Get(name));
                        } else {
                            userCards.Get(name).setCount(1);
                        }
                    } else {
                        System.out.println("\nEl nombre de la carta que ha ingresado no se encuentra en la base de datos.");
                    }
                    break;


                case 2:
                    System.out.println("\nPor favor ingrese el nombre de la carta en su coleccion que desea ver.");
                    name = sc.nextLine();
                    if (userCards.ContainsKey(name)) {
                        System.out.println("\nTipo: " + userCards.Get(name).getType());
                    } else {
                        System.out.println("\nLa carta que busca no se ha encontrado en su coleccion.");
                    }
                    break;


                case 3:
                    for(String s: userCards.KeySet()){
                        System.out.println("\nNombre: " + s + "\nTipo: " + userCards.Get(s).getType() + "\nCantidad: " + userCards.Get(s).getCount());
                    }
                    break;

                case 4:

                    if(userCards.IsEmpty()){
                        System.out.println("\nNo hay cartas en su coleccion.");
                    } else {
                        ArrayList<Card> c = new ArrayList<>(userCards.Values());
                        c.sort(new CompareCards());
                        for (Card ca : c) {
                            System.out.println(ca.toString());
                        }
                    }

                case 7:
                    body = false;
                    break;

            }

        }

    }

}
