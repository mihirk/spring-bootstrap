package org.revenge.core.model;

public class Entity {
    private String name;
    private String uuid;

    public Entity(String name) {
        this.name = name;
    }

    public Entity(String name, String uuid) {
        this.name = name;
        this.uuid = uuid;
    }

    public Entity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "name='" + name + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
