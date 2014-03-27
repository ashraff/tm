package com.github.markserrano.jsonquery.jpa.builder;

import junit.framework.Assert;
import net.ashraff.taskmanager.entities.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.github.markserrano.jsonquery.jpa.filter.JsonFilter;
import com.github.markserrano.jsonquery.jpa.mapper.JsonObjectMapper;
import com.github.markserrano.jsonquery.jpa.util.DateTimeZoneRule;
import com.mysema.query.BooleanBuilder;

public class JsonBooleanBuilderTest {

	private JsonBooleanBuilder jsonBooleanBuilder;
	private BooleanBuilder booleanBuilder;

	@Rule
	public DateTimeZoneRule dateTimeZoneRule = new DateTimeZoneRule(
			"Asia/Manila");

	private String filterMultiple = "{     \"groupOp\": \"OR\",     \"groups\": [         {             \"groupOp\": \"OR\",             \"groups\": [                 {                     \"groupOp\": \"AND\",                     \"groups\": [],                     \"rules\": [                         {                             \"data\": \"JAVA\",                             \"field\": \"primarySkill\",                             \"op\": \"eq\"                         }                     ]                 }, 		{ 		    \"groupOp\": \"AND\", 		    \"groups\": [], 		    \"rules\": [ 			{ 			    \"data\": \"UI\", 			    \"field\": \"tertiarySkill\", 			    \"op\": \"eq\" 			} 		    ] 		}             ],             \"rules\": [                 {                     \"data\": \"aw39997\",                     \"field\": \"soeId\",                     \"op\": \"eq\"                 },                 {                     \"data\": \"Ashraff Ali Wahab\",                     \"field\": \"resourceName\",                     \"op\": \"eq\"                 }             ]         },         {             \"groupOp\": \"AND\",             \"groups\": [],             \"rules\": [                 {                     \"data\": \"UI\",                     \"field\": \"secondarySkill\",                     \"op\": \"eq\"                 }             ]         }     ],     \"rules\": [         {             \"data\": \"bx40008\",             \"field\": \"soeId\",             \"op\": \"eq\"         }     ] }";

	@Before
	public void setUp() throws Exception {
		jsonBooleanBuilder = new JsonBooleanBuilder(Resource.class);
	}

	@After
	public void tearDown() throws Exception {
		jsonBooleanBuilder = null;
	}

	@Test
	public void testBuild() {

		booleanBuilder = jsonBooleanBuilder
				.build(new JsonFilter(filterMultiple));
		System.out.println(booleanBuilder.toString());

		Assert.assertNotNull(booleanBuilder);
	}
	
	@Test
	public void testBuildRecursively() {

		JsonFilter filter = JsonObjectMapper.map(filterMultiple);
		
		booleanBuilder = jsonBooleanBuilder
				.buildRecusively(filter,booleanBuilder);
		System.out.println(booleanBuilder.toString());

		Assert.assertNotNull(booleanBuilder);
	}

}
