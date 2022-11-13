package maks.test.todolist.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ListDto {
    Integer id;
    String text;
    boolean isDone;
}
