package maks.test.todolist.service;

import lombok.Builder;
import maks.test.todolist.dao.ListRepository;
import maks.test.todolist.dto.ListDto;
import maks.test.todolist.dto.ReadListDto;
import maks.test.todolist.dto.RemoveListDto;
import maks.test.todolist.dto.UpdateListDto;
import maks.test.todolist.exceptions.ListNotFoundException;
import maks.test.todolist.model.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ListServiceImpl implements ListService {

    ListRepository repository;

    @Autowired
    public ListServiceImpl(ListRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean addList(ListDto listDto) {
        List list = new List(listDto.getId(), listDto.getText(), listDto.isDone());
        return repository.addList(list);
    }

    @Override
    public ReadListDto findList(Integer id) {
        List list = repository.findListById(id);
        if (list == null) {
            throw new ListNotFoundException();
        }
        return ReadListDto.builder()
                .id(list.getId())
                .text(list.getText())
                .build();
    }

    @Override
    public UpdateListDto updateList(Integer id, boolean isDone) {
        List list = repository.findListById(id);
        if (list == null) {
            throw new ListNotFoundException();
        }
        list.setDone(isDone);
        return UpdateListDto.builder()
                .id(list.getId())
                .text(list.getText())
                .isDone(list.isDone())
                .build();
    }

    @Override
    public RemoveListDto removeList(Integer id) {
        List list = repository.removeList(id);
        if (list == null) {
            throw new ListNotFoundException();
        }
        return RemoveListDto.builder().id(list.getId())
                .text(list.getText())
                .build();
    }
}
