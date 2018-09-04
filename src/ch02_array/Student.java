package ch02_array;

/**
 * The Student class for testing the self-defined class.
 *
 * @author  StrongXGP
 */
public class Student {
    private String  id;
    private String  name;
    private float   score;

    public Student(String id, String name, float score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s, id: %s, score: %.1f)", name, id, score);
    }
}
