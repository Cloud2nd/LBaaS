package com.exactsix.mibaas.lecture.service.search;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.springframework.stereotype.Service;

@Service
public class LectureElasticSearchService {

	private Client client;

	@SuppressWarnings("resource")
	@PostConstruct
	private void init() {

		Settings settings = ImmutableSettings.settingsBuilder()
				.put("cluster.name", "exactsix").build();
		client = new TransportClient()
				.addTransportAddress(new InetSocketTransportAddress(
						"elk01.xwmooc.net", 9300));
	}

	public List<String> test() {

		SearchResponse response = client
				.prepareSearch()
				.setQuery(
						QueryBuilders
								.matchQuery("couchbaseDocument.doc._class",
										"com.exactsix.mibaas.lecture.repository.dto.LectureRepositoryDto"))
				.execute().actionGet();

		List<String> keys = new ArrayList<String>();

		for (SearchHit hit : response.getHits()) {
			keys.add(hit.getId());
		}

		return keys;

	}

	public List<String> getProgressCourse() {

		SearchResponse response = client
				.prepareSearch()
				.setQuery(
						QueryBuilders
								.matchQuery("couchbaseDocument.doc._class",
										"com.exactsix.mibaas.lecture.repository.dto.LectureRepositoryDto"))
				.setQuery(
						QueryBuilders.matchQuery(
								"couchbaseDocument.doc.status", "approve"))
				.setQuery(
						QueryBuilders.matchQuery(
								"couchbaseDocument.doc.userCode", "dave"))
				.execute().actionGet();

		List<String> keys = new ArrayList<String>();

		for (SearchHit hit : response.getHits()) {
			keys.add(hit.getId());
			System.out.println(hit.getId());
		}

		return keys;

	}

	public List<String> getChapters(String lectureCode) {

		QueryBuilder queryBuilder = QueryBuilders
				.boolQuery()
				.must(QueryBuilders
						.matchQuery("couchbaseDocument.doc._class",
								"com.exactsix.mibaas.lecture.repository.dto.LectureChapterRepositoryDto"))
				.must(QueryBuilders.matchQuery(
						"couchbaseDocument.doc.lectureCode", lectureCode));

		SearchResponse response = client.prepareSearch().setQuery(queryBuilder)
				.execute().actionGet();

		List<String> keys = new ArrayList<String>();

		for (SearchHit hit : response.getHits()) {
			keys.add(hit.getId());
		}

		return keys;

	}

}