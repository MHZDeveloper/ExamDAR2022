import java.io.Serializable;

public class Cannette implements Serializable {

    private int id;

    public Cannette(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
