package com.example.web_backend.entitys;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    //временно string
    private String scriptName = "test.jar";

    private String description = "тут описание";

    //временно string
    private String options;

    @OneToMany(mappedBy = "id")
    private List<TaskInstance> instances;

    public Task(String name){
        this.name = name;
    }
}
