package todo_list_server.todolist.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import todo_list_server.todolist.dto.ToDoDto;
import todo_list_server.todolist.service.ToDoService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todo")
public class ToDoController {


    private final ToDoService toDoService;

    @GetMapping
    public List<ToDoDto> getAllToDo() {
        return toDoService.getAll();
    }

    @PostMapping("/add")
    public void addToDo(@RequestBody ToDoDto dto) {
        toDoService.add(dto);
    }

    @DeleteMapping("/delete/{toDoId}")
    public String delToDo(@PathVariable Long toDoId) {
        toDoService.delete(toDoId);
        return "성공적으로 삭제했습니다.";
    }

    @GetMapping("/check/{toDoId}")
    public void complete(@PathVariable Long toDoId) {
        toDoService.check(toDoId);
    }


}
