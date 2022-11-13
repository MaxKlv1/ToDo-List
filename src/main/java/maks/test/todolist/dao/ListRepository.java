package maks.test.todolist.dao;

import maks.test.todolist.model.List;
import org.springframework.context.annotation.Bean;

public interface ListRepository {
    boolean addList(List list);

    List findListById(int id);

    List updateList(int id, boolean isDone);

    List removeList(int id);
}
