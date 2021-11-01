package com.scaler.springdemo1.tasks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Size;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tasks {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long taskId;
   @Size(min=3, max = 8, message = "Name should have at-least 4 characters")
   private String taskName;
   private boolean done;

}
