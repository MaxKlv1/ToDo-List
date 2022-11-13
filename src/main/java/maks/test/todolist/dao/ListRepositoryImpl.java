package maks.test.todolist.dao;

import maks.test.todolist.dto.UpdateListDto;
import maks.test.todolist.model.List;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ListRepositoryImpl implements ListRepository {

    Map<Integer, List> lists = new HashMap<>();

    @Override
    public boolean addList(List list) {
        return lists.putIfAbsent(list.getId(), list) == null;
    }

    @Override
    public List findListById(int id) {
        return lists.get(id);
    }

    @Override
    public List updateList(int id, boolean isDone) {
        List list = lists.get(id);
        list.setDone(isDone);
        lists.put(id, list);
        return list;
    }

    @Override
    public List removeList(int id) {
        return lists.remove(id);
    }
}
