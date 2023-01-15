package maks.test.todolist.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ListDto {
    int id;
    String text;
    boolean isDone;
}
