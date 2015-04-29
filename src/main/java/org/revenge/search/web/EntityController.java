package org.revenge.search.web;

import org.revenge.search.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EntityController {
    @Autowired
    private EntityService entityService;
}
