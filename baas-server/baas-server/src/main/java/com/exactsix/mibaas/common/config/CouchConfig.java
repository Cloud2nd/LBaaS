package com.exactsix.mibaas.common.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@Configuration
@EnableCouchbaseRepositories(basePackages = {"com.exactsix.mibaas"})
public class CouchConfig extends AbstractCouchbaseConfiguration{

	@Override
	protected List<String> bootstrapHosts() {
		return Arrays.asList("couch01.xwmooc.net");
	}

	@Override
	protected String getBucketName() {
		return "default";
	}

	@Override
	protected String getBucketPassword() {
		return "";
	}
}
