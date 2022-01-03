package com.sibyl.es;

import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Classname ESTest
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/01/02 21:03
 */

public class ESTest {

    @Autowired
    @Qualifier("restHighLevelClient")
    private RestHighLevelClient client;

    @Test
    public void reTest() throws IOException {
        GetIndexRequest request = new GetIndexRequest("sibyl");
        boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
        System.err.println(exists);
    }
    @Test
    public void reTest2() throws IOException {
        System.err.println("test");
    }


    public static void main(String[] args) {

    }
}
