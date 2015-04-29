package org.revenge.search.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.revenge.search.RevengeSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RevengeSearch.class)
@IntegrationTest
public class EntityServiceTest {
    @Autowired
    private EntityService entityService;

    @Test
    public void testName() throws Exception {
        System.out.println("Some");
    }
}