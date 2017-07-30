package com.arch.mongoEntities;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by ahmed on 7/26/2017.
 */

public interface userRepository extends MongoRepository<user, String> {

    public user findById(String Id);
}
