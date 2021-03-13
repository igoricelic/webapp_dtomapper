package org.indigoproject.webapp_dtomapper.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private LocalDateTime deadline;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private User manager;

    @ManyToMany(mappedBy = "tasks")
    private List<User> employees;

}
