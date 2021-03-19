import java.util.Comparator;

class CompareCards implements Comparator<Card>
{
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(Card a, Card b)
    {
        return a.getType().compareTo(b.getType());
    }
} 