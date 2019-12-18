package laba1.model;

public class Room extends Entity{
    private String name;
    private Integer size;
    private Integer freePlaces;

    public Room(Integer id, String name, Integer size, Integer freePlaces) {
        this.size = size;
        this.freePlaces = freePlaces;
        this.id = id;
        this.name = name;
    }

    public Room() {
    }

    public Integer getFreePlaces() {
        return freePlaces;
    }

    public void setFreePlaces(Integer freePlaces) {
        this.freePlaces = freePlaces;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", freePlaces=" + freePlaces +
                '}';
    }
}
