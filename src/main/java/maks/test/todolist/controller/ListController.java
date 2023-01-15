package maks.test.todolist.controller;

import maks.test.todolist.dto.ListDto;
import maks.test.todolist.dto.ReadListDto;
import maks.test.todolist.dto.RemoveListDto;
import maks.test.todolist.dto.UpdateListDto;
import maks.test.todolist.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ListController {

    ListService listService;

    @Autowired
    public ListController(ListService listService) {
        this.listService = listService;
    }

    @PostMapping("/list")
    public boolean addList(@RequestBody ListDto listDto) {
        return listService.addList(listDto);
    }

    @GetMapping("/list/{id}")
    public ReadListDto findListById(@PathVariable Integer id) {
        return listService.findList(id);
    }

    @PutMapping("/list/{id}")
    public ListDto updateList(@PathVariable Integer id, @RequestBody UpdateListDto updateListDto) {
        return listService.updateList(id, updateListDto);
    }

    @DeleteMapping("/list/{id}")
    public RemoveListDto removeList(@PathVariable Integer id) {
        return listService.removeList(id);
    }
}
