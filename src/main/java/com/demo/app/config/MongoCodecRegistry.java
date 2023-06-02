package com.demo.app.config;

import lombok.Data;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.context.annotation.Configuration;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

/**
 * This config is required to enable serializing POJOs to and from BSON objects
 */
@Configuration
@Data
public class    MongoCodecRegistry {
    private CodecProvider codecProvider = PojoCodecProvider.builder().automatic(true).build();
    private CodecRegistry codecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(codecProvider));
}
