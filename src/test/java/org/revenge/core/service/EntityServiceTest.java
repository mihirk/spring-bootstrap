package org.revenge.core.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.revenge.core.RevengeCore;
import org.revenge.core.model.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RevengeCore.class)
@IntegrationTest
public class EntityServiceTest {
    @Autowired
    private EntityService entityService;

    @Test
    public void testName() throws Exception {
        entityService.create(new Entity("Ramesh Kumar"));
        entityService.create(new Entity("Suresh Kumar"));
        entityService.create(new Entity("Mahesh Kumar"));
        entityService.create(new Entity("Dinesh Kumar"));
        entityService.create(new Entity("Kalpesh Kumar"));
        entityService.create(new Entity("Ramesh Singh"));
        List<Entity> searchResults = entityService.get("esh");
        assertEquals(6, searchResults.size());
        entityService.deleteAll();
    }
}