package org.indigoproject.webapp_dtomapper.domain.dto;

import lombok.Data;
import org.indigo.dtomapper.annotations.Property;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class TaskDto {

    private Long id;

    private String title;

    private String description;

    private LocalDateTime deadline;

    @Property(path = "manager.fullName")
    private String manager;

    @Property(depth = 1)
    private List<UserDto> employees;

}
