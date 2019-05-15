package word_gussing_game;

public class point extends login {

    private int point;


    public point(String userName, String password, int point) {
        super(userName, password);
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
