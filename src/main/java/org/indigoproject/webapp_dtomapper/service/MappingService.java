package org.indigoproject.webapp_dtomapper.service;

import org.indigoproject.webapp_dtomapper.domain.Task;
import org.indigoproject.webapp_dtomapper.domain.User;
import org.indigoproject.webapp_dtomapper.domain.dto.TaskDto;
import org.indigoproject.webapp_dtomapper.domain.dto.UserDto;

public interface MappingService {

    UserDto mapUserBasicInfo(User user);

    UserDto mapUserWithTasks(User user);

    TaskDto mapTaskBasicInfo(Task task);

    TaskDto mapTaskWithUsers(Task task);

}
