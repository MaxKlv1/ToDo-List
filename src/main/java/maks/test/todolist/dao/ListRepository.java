package maks.test.todolist.dao;

import maks.test.todolist.model.List;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

public interface ListRepository {
    boolean addList(List list);

    Optional<List> findListById(int id);

    Optional<List>  updateList(List list);

    Optional<List>  removeList(int id);
}
