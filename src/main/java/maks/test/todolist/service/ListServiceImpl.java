package maks.test.todolist.service;

import maks.test.todolist.dao.ListRepository;
import maks.test.todolist.dto.ListDto;
import maks.test.todolist.dto.ReadListDto;
import maks.test.todolist.dto.RemoveListDto;
import maks.test.todolist.dto.UpdateListDto;
import maks.test.todolist.exceptions.ListNotFoundException;
import maks.test.todolist.model.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListServiceImpl implements ListService {

    ListRepository repository;
    ModelMapper modelMapper;

    @Autowired
    public ListServiceImpl(ListRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean addList(ListDto listDto) {
        List list = modelMapper.map(listDto, List.class);
        return repository.addList(list);
    }

    @Override
    public ReadListDto findList(Integer id) {
        List list = repository.findListById(id).orElseThrow(ListNotFoundException::new);
        return modelMapper.map(list, ReadListDto.class);
    }

    @Override
    public ListDto updateList(Integer id, UpdateListDto updateListDto) {
        List list = repository.findListById(id).orElseThrow(ListNotFoundException::new);
        list.setText(updateListDto.getText());
        list.setDone(updateListDto.isDone());
        repository.updateList(list);
        return modelMapper.map(list, ListDto.class);
    }

    @Override
    public RemoveListDto removeList(Integer id) {
        List list = repository.removeList(id).orElseThrow(ListNotFoundException::new);
        return modelMapper.map(list, RemoveListDto.class);
    }
}
