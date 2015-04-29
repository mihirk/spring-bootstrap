package org.revenge.search.web;

import org.revenge.search.model.Entity;
import org.revenge.search.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class EntityController {
    @Autowired
    private EntityService entityService;

    @RequestMapping(value = "/entity/search/{term}", method = RequestMethod.GET)
    public List<Entity> search(@PathVariable String term) throws IOException {
        return entityService.search(term);
    }
}
