package org.openchs.search.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Entity {
    private String name;
    private String uuid;

    public Entity(String name, String uuid) {
        this.name = name;
        this.uuid = uuid;
    }

    public Entity(String json) throws IOException {
        Entity entity = new ObjectMapper().readValue(json, this.getClass());
        this.name = entity.getName();
        this.uuid = entity.getUuid();
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

    public byte[] json() throws JsonProcessingException {
        return new ObjectMapper().writeValueAsBytes(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entity entity = (Entity) o;

        if (name != null ? !name.equals(entity.name) : entity.name != null) return false;
        return !(uuid != null ? !uuid.equals(entity.uuid) : entity.uuid != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        return result;
    }
}
