package org.indigoproject.webapp_dtomapper.repository;

import org.indigoproject.webapp_dtomapper.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskDao extends JpaRepository<Task, Long> {
}
