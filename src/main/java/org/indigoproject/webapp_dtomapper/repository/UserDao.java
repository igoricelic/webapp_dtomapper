package org.indigoproject.webapp_dtomapper.repository;

import org.indigoproject.webapp_dtomapper.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
}
