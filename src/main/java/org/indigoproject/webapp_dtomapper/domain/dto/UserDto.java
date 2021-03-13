package org.indigoproject.webapp_dtomapper.domain.dto;

import lombok.Data;
import org.indigo.dtomapper.annotations.Property;

import java.util.List;

@Data
public class UserDto {

    private Long id;

    private String fullName;

    private String username;

    @Property(depth = 1)
    private List<TaskDto> tasks;

}
