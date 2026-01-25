package entity;

public class CoursePrimary extends Course{

    public CoursePrimary(int id, String name, int lesson, double retail) {
        super(id, name, lesson, retail);
    }

    @Override
    public double calculatePrice() {
        return this.retail * 1;
    }

    @Override
    public String toString() {
        return "id: " + this.getId() +
                ", " +
                "name: " + this.getName() +
                ", " +
                "lesson: " + this.lesson +
                ", " +
                "price: " + this.calculatePrice();
    }
}
