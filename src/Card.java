public class Card implements Comparable<Card> {

    private String name;
    private String type;
    private int count = 1;

    public Card(String n, String t){
        name =n; type=t;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count += count;
    }

    @Override
    public int compareTo(Card c) {

        String compare = c.getName();

        return name.compareTo(compare);
    }

    public String toString(){
        return "\nNombre: " + name + "\nTipo: " + type + "\nCount: " + count;
    }
}
