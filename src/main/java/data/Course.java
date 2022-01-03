package data;

public enum Course {
    AI(0), // 0
    BWL(1), // 1
    SEG(2); // 2

    private int number;

    Course(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}