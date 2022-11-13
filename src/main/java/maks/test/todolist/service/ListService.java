package maks.test.todolist.service;

import maks.test.todolist.dto.ListDto;
import maks.test.todolist.dto.ReadListDto;
import maks.test.todolist.dto.RemoveListDto;
import maks.test.todolist.dto.UpdateListDto;

public interface ListService {

    boolean addList(ListDto listDto);

    ReadListDto findList(Integer id);

    UpdateListDto updateList(Integer id, boolean isDone);

    RemoveListDto removeList(Integer id);
}
