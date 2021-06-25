package com.harashit.util;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class MongoConn {
	public static MongoClient mongoUtil() {
//		ConnectionString connectionString = new ConnectionString(
//				"mongodb+srv://admin:admin@cluster0.ovmps.mongodb.net/?serverSelectionTryOnce=false&serverSelectionTimeoutMS=15000&retryWrites=true&w=majority");
		CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
				fromProviders(PojoCodecProvider.builder().automatic(true).build()));

		MongoClientSettings settings = MongoClientSettings.builder().codecRegistry(pojoCodecRegistry).build();



		return MongoClients.create(settings);
	}
}

////mongodb+srv://admin:admin@cluster0.ovmps.mongodb.net/myFirstDatabase?retryWrites=true&w=majority
//mongodb+srv:// admin:admin@cluster0.ovmps.mongodb.net/?retryWrites=true&w=majority
//mongodb+srv:// admin:admin@cluster0.ovmps.mongodb.net/question?retryWrites=true&w=majority