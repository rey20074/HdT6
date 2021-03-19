import java.util.HashMap;

public class MapFactory<K,E> {

    //selecciona la implementacion a utilizar para un stack
    //se utiliza el patron Factory
    public GeneralMap<K,E> getMap(String entry) {
        // seleccion de la implementacion a utilizar:

        if (entry.equals("HM"))
            return new NewHashMap<K,E>();
        else if(entry.equals("LM"))
            return new NewLinkedHashMap<K,E>();
        else if(entry.equals("TM"))
            return new NewTreeMap<K,E>();
        else {
            System.out.println("\nHa ingresado un valor incorrecto por lo que se le ha asignado un HashMap por defecto\n");
            return new NewHashMap<K,E>();
        }

    }

}
