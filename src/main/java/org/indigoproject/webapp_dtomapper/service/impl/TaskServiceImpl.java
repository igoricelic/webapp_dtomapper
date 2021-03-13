package org.indigoproject.webapp_dtomapper.service.impl;

import lombok.RequiredArgsConstructor;
import org.indigo.dtomapper.providers.specification.Mapper;
import org.indigoproject.webapp_dtomapper.domain.Task;
import org.indigoproject.webapp_dtomapper.domain.dto.TaskDto;
import org.indigoproject.webapp_dtomapper.repository.TaskDao;
import org.indigoproject.webapp_dtomapper.service.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final Mapper mapper;

    private final TaskDao taskDao;

    @Override
    public Page<TaskDto> findAll(Pageable pageable) {
        // fetch results from database
        Page<Task> results = taskDao.findAll(pageable);
        // map results to desired type and return results as page
        return results.map(task -> mapper.map(task, TaskDto.class));
    }

    @Override
    public TaskDto findById(Long id) {
        // fetch task if exists, if doesn't exist -> throw exception
        Task result = taskDao.findById(id).orElseThrow(RuntimeException::new);
        // map result to desired type with depth
        TaskDto mappedResult = mapper.map(result,1, TaskDto.class);
        // return result
        return mappedResult;
    }

}
