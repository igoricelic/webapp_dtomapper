package org.indigoproject.webapp_dtomapper.service;

import org.indigoproject.webapp_dtomapper.domain.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<UserDto> findAll(Pageable pageable);

    UserDto findById(Long id);

}
