package org.indigoproject.webapp_dtomapper.service.impl;

import lombok.RequiredArgsConstructor;
import org.indigo.dtomapper.providers.specification.Mapper;
import org.indigoproject.webapp_dtomapper.domain.User;
import org.indigoproject.webapp_dtomapper.domain.dto.UserDto;
import org.indigoproject.webapp_dtomapper.repository.UserDao;
import org.indigoproject.webapp_dtomapper.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final Mapper mapper;

    private final UserDao userDao;

    @Override
    public Page<UserDto> findAll(Pageable pageable) {
        // fetch results from database
        Page<User> results = userDao.findAll(pageable);
        // map results to desired type and return results as page
        return results.map(user -> mapper.map(user, UserDto.class));
    }

    @Override
    public UserDto findById(Long id) {
        // fetch user if exists, if doesn't exist -> throw exception
        User result = userDao.findById(id).orElseThrow(RuntimeException::new);
        // map result to desired type with depth
        UserDto mappedResult = mapper.map(result,1, UserDto.class);
        // return result
        return mappedResult;
    }

}
