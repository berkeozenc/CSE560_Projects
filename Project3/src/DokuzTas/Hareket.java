package DokuzTas;

/**
 *
 * @author haltay
 */
public class Hareket {
    private int from;
    private int to;

    public Hareket(int from, int to) throws Exception{
        if(from<0 || from >23)
            throw new Exception("from not in valid region");
        if(to<0 || to >23)
            throw new Exception("to not in valid region");
        if(from == to)
            throw new Exception("from an to must not be equal");
         
        this.from = from;
        this.to = to;
    }

    public String toString(){
        return "from: " + from + ", to: " + to;
    }
    
    public static void main(String[] args) throws Exception {
        Hareket hareket = new Hareket(0, 1);
        
        System.out.println(hareket);
    }
}