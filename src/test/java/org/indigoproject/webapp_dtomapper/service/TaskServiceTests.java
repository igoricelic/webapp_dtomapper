package org.indigoproject.webapp_dtomapper.service;

import org.indigoproject.webapp_dtomapper.domain.dto.TaskDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TaskServiceTests {

    @Autowired
    private TaskService taskService;

    @Test
    void findAllTest() {
        Page<TaskDto> results = taskService.findAll(Pageable.unpaged());
        for (TaskDto taskDto : results) {
            assertNotNull(taskDto.getTitle());
            assertNotNull(taskDto.getDescription());
            assertNotNull(taskDto.getDeadline());
            assertNotNull(taskDto.getManager());
            assertNull(taskDto.getEmployees());
        }
    }

    @Test
    @Transactional
    void findByIdTest() {
        assertThrows(RuntimeException.class, () -> taskService.findById(11L));
        TaskDto taskDto = taskService.findById(1L);
        assertEquals(1L, taskDto.getId());
        assertEquals("task 1", taskDto.getTitle());
        assertNotNull(taskDto.getDescription());
        assertNotNull(taskDto.getDeadline());
        assertEquals("Carey Baccus", taskDto.getManager());
        assertNotNull(taskDto.getEmployees());
        assertEquals(3, taskDto.getEmployees().size());
    }

}
