package todo_list_server.todolist.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import todo_list_server.todolist.dto.ToDoDto;

import java.time.LocalDateTime;

@Entity
@Getter
public class ToDo {

    @Id
    @GeneratedValue
    private Long id;
    private String toDo;
    private Boolean complete;
    private LocalDateTime created_at;
    private LocalDateTime completed_at;

    public ToDo() {
    }

    public ToDo(ToDoDto dto) {
        this.id = dto.getId();
        this.toDo = dto.getToDo();
        this.complete = dto.getComplete();
        this.created_at = dto.getCreated_at();
        this.completed_at = dto.getCompleted_at();
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public void setCompleted_at(LocalDateTime completed_at) {
        this.completed_at = completed_at;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", toDo='" + toDo + '\'' +
                ", complete=" + complete +
                ", created_at=" + created_at +
                ", completed_at=" + completed_at +
                '}';
    }
}
