package laba1.model;

public class Doctor extends Entity{
    private String name;

    public Doctor(String name, Integer id) {
        this.id = id;
        this.name = name;
    }

    public Doctor() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
