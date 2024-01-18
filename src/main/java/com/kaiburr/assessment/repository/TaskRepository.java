package com.kaiburr.assessment.repository;

import com.kaiburr.assessment.models.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TaskRepository extends MongoRepository<Task, String> {}
