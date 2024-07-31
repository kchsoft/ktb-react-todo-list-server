package todo_list_server.todolist.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import todo_list_server.todolist.dto.ToDoDto;
import todo_list_server.todolist.entity.ToDo;
import todo_list_server.todolist.repository.ToDoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ToDoService {

    private final ToDoRepository toDoRepository;

    public List<ToDoDto> getAll() {
        List<ToDo> toDos = toDoRepository.findAll();
        return toDos.stream().map(ToDoDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void add(ToDoDto dto) {
        ToDo toDo = new ToDo(dto);
        toDoRepository.save(toDo);
    }

    @Transactional
    public void delete(Long toDoId) {
        ToDo toDo = toDoRepository.find(toDoId);
        toDoRepository.delete(toDo);
    }

    public void check(Long toDoId) {
        ToDo toDo = toDoRepository.find(toDoId);
        toDoRepository.updateCheck(toDoId, !toDo.getComplete());
    }


}
