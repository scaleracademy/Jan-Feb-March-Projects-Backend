package com.scaler.springdemo3.tasks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Task {

    public Task(String name, Boolean done) {
        this.name = name;
        this.done = done;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(nullable = false)
    String name;

    @Column()
    Boolean done;
}
