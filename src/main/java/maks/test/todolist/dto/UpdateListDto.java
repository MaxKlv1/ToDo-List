package maks.test.todolist.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UpdateListDto {
    Integer id;
    String text;
    boolean isDone;
}
