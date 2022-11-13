package maks.test.todolist.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReadListDto {
    Integer id;
    String text;
}
