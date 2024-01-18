package com.kaiburr.assessment.repository;

import com.kaiburr.assessment.models.Task;

import java.util.List;

public interface SearchRepository {
    List<Task> findByName(String query);
    List<Task> findByAssignee(String query);
}
