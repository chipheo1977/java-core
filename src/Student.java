public class Student extends Person {

    private int id;
    private float score;

    public float getScore() {
        return score;
    }

    public int getId() {
        return this.id;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public Student(String name, int age, boolean isDied, float score, int id) {
        super(name, age, isDied);
        this.score = score;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student: " + getName() +
                ", " +
                "score: " + score +
                ", " +
                "age: " + getAge() +
                ", " +
                "status: " + (isDied() ? "died" : "alive") +
                ", " +
                "id: " + this.id;
    }
}
