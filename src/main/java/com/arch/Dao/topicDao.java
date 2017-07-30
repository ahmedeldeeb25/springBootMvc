package com.arch.Dao;


import java.util.List;

import com.arch.Entities.Topics;

/**
 * Created by ahmed on 7/22/2017.
 */
public interface topicDao {
    void Insert(Topics topics);

    List<Topics> GetAll();

    Topics GetSpecific(String id);

    void Update(Topics topics);

    void deleteTopic(String id);
}
