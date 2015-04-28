package org.revenge.search.web;

import org.revenge.search.model.Entity;
import org.revenge.search.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EntityController {
    @Autowired
    private EntityService entityService;

    @RequestMapping(value = "/entity/{searchString}", method = RequestMethod.GET)
    public List<Entity> get(@PathVariable String searchString) throws IllegalAccessException {
        return entityService.get(searchString);
    }

    @RequestMapping(value = "/entity", method = RequestMethod.POST)
    public Entity create(@RequestBody Entity entity) throws IllegalAccessException {
        return entityService.create(entity);
    }

    @RequestMapping(value = "/entity", method = RequestMethod.DELETE)
    public void delete() {
        entityService.deleteAll();
    }
}
