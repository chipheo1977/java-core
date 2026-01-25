package entity;

public class CourseSecondary extends Course{
    public CourseSecondary(int id, String name, int lesson, double retail) {
        super(id, name, lesson, retail);
    }

    @Override
    public double calculatePrice() {
        return this.retail * 2;
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
