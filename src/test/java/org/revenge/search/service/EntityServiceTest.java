package org.revenge.search.service;

import com.aerospike.client.Bin;
import com.aerospike.client.Key;
import org.junit.Test;

public class EntityServiceTest {
    @Test
    public void testName() throws Exception {
        Key key = new Key("test", "demo", "putgetkey");
        Bin bin1 = new Bin("bin1", "value1");
        Bin bin2 = new Bin("bin2", "value2");

// Write a record
//        dbClient.put(null, key, bin1, bin2);
//
//// Read a record
//        Record record = dbClient.get(null, key);
//
//        System.out.println(record);
//
//        dbClient.close();

    }
}