package todo_list_server.todolist.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import todo_list_server.todolist.entity.ToDo;

import java.time.LocalDateTime;

@Getter @Setter
@Component
public class ToDoDto {

    private Long id;
    private String toDo;
    private Boolean complete;
    private LocalDateTime created_at;
    private LocalDateTime completed_at;

    public ToDoDto() {

    }

    public ToDoDto(ToDo toDo) {
        this.id = toDo.getId();
        this.toDo = toDo.getToDo();
        this.complete = toDo.getComplete();
        this.created_at = toDo.getCreated_at();
        this.completed_at = toDo.getCompleted_at();
    }

}
