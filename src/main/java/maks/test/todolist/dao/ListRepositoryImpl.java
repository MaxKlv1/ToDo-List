package maks.test.todolist.dao;

import maks.test.todolist.model.List;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ListRepositoryImpl implements ListRepository {

    Map<Integer, List> lists = new ConcurrentHashMap<>();

    @Override
    public boolean addList(List list) {
        return lists.putIfAbsent(list.getId(), list) == null;
    }

    @Override
    public Optional<List> findListById(int id) {
        return Optional.ofNullable(lists.get(id));
    }

    @Override
    public Optional<List> updateList(List list) {
        return Optional.ofNullable(lists.replace(list.getId(), list));
    }

    @Override
    public Optional<List> removeList(int id) {
        return Optional.ofNullable(lists.remove(id));
    }
}
