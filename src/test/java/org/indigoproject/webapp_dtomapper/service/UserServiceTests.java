package org.indigoproject.webapp_dtomapper.service;

import org.indigoproject.webapp_dtomapper.domain.dto.UserDto;
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
class UserServiceTests {

    @Autowired
    private UserService userService;

    @Test
    void findAllTest() {
        Page<UserDto> results = userService.findAll(Pageable.unpaged());
        for (UserDto userDto : results) {
            assertNotNull(userDto.getId());
            assertNotNull(userDto.getUsername());
            assertNotNull(userDto.getFullName());
            assertNull(userDto.getTasks());
        }
    }

    @Test
    @Transactional
    void findByIdTest() {
        assertThrows(RuntimeException.class, () -> userService.findById(11L));
        UserDto userDto = userService.findById(1L);
        assertEquals(1L, userDto.getId());
        assertEquals("Carey Baccus", userDto.getFullName());
        assertEquals("baccuss1", userDto.getUsername());
        assertNotNull(userDto.getTasks());
    }

}
