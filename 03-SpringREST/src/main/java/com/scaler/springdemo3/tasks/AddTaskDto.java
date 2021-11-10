package com.scaler.springdemo3.tasks;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Size;

@Data
@Valid
class AddTaskDto {
    @Size(min = 8, max = 240, message = "Task name must be between 8 and 240 chars in length")
    String task;
}
