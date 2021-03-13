package org.indigoproject.webapp_dtomapper.service;

import org.indigoproject.webapp_dtomapper.domain.dto.TaskDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskService {

    Page<TaskDto> findAll(Pageable pageable);

    TaskDto findById(Long id);

}
