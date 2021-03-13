package org.indigoproject.webapp_dtomapper.controller;

import lombok.RequiredArgsConstructor;
import org.indigoproject.webapp_dtomapper.domain.dto.TaskDto;
import org.indigoproject.webapp_dtomapper.service.TaskService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskApi {

    private final TaskService taskService;

    @GetMapping
    public Page<TaskDto> findAll(Pageable pageable) {
        return taskService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public TaskDto findById(@PathVariable Long id) {
        return taskService.findById(id);
    }

}
