package org.revenge.search.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.revenge.search.RevengeSearch;
import org.revenge.search.model.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RevengeSearch.class)
@IntegrationTest
public class EntityServiceTest {
    @Autowired
    private EntityService entityService;

    @Test
    public void saveEntity() throws Exception {
        String uuid = UUID.randomUUID().toString();
        Entity testEntity = new Entity("TestName", uuid);
        Entity createdEntity = entityService.create(testEntity);
        assertEquals(testEntity, createdEntity);
    }

    @Test
    public void searchEntity() throws Exception {
        String uuid1 = UUID.randomUUID().toString();
        String uuid2 = UUID.randomUUID().toString();
        String uuid3 = UUID.randomUUID().toString();
        String uuid4 = UUID.randomUUID().toString();
        Entity entity1 = new Entity("Ramesh Singh", uuid1);
        Entity entity2 = new Entity("Ramesh Kumar", uuid2);
        Entity entity3 = new Entity("Ramesh Suresh", uuid3);
        Entity entity4 = new Entity("Suresh Ramalingam", uuid4);
        entityService.create(entity1);
        entityService.create(entity2);
        entityService.create(entity3);
        entityService.create(entity4);
        List<Entity> results = entityService.search("Ram");
        assertEquals(4, results.size());
    }


    @Test
    public void testName() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/usr/share/dict/words"));
        String currentLine = null;
        while ((currentLine = bufferedReader.readLine()) != null) {
            entityService.create(new Entity(currentLine, UUID.randomUUID().toString()));
        }
        bufferedReader.close();
    }
}