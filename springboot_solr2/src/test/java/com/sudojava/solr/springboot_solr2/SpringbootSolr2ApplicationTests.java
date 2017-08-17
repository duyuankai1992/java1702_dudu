package com.sudojava.solr.springboot_solr2;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.solr.core.SolrOperations;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.function.Consumer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootSolr2ApplicationTests {

	@Autowired
	SolrClient client;

	@Test
	public void contextLoads() throws Exception {
		SolrQuery query = new SolrQuery("*:*");
		SolrDocumentList list = client.query(query).getResults();
		list.forEach(new Consumer<SolrDocument>() {
			@Override
			public void accept(SolrDocument entries) {
				System.out.println(entries.get("pic_url"));
			}
		});
	}

}
