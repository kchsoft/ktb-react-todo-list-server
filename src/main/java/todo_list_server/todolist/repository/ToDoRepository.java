package todo_list_server.todolist.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import todo_list_server.todolist.dto.ToDoDto;
import todo_list_server.todolist.entity.ToDo;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ToDoRepository {

    private final EntityManager em;

    public void save(ToDo toDo) {
        toDo.setCreated_at(LocalDateTime.now());
        toDo.setCompleted_at(LocalDateTime.now());
        System.out.println("toDo = " + toDo);
        em.persist(toDo);
    }

    public List<ToDo> findAll() {
        return em.createQuery("select t from ToDo t", ToDo.class)
                .getResultList();
    }

    public ToDo find(Long toDoId) {
        return em.find(ToDo.class,toDoId);
    }

    public void delete(ToDo toDo) {
        em.remove(toDo);
    }

    public void updateCheck(Long toDoId, Boolean complete) {
        em.createQuery("update ToDo t set t.complete = :complete where t.id = :id")
                .setParameter("complete", complete)
                .setParameter("id", toDoId)
                .executeUpdate();
    }

}
