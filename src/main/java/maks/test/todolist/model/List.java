package maks.test.todolist.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class List {
    int id;
    @Setter
    String text;
    @Setter
    boolean isDone;


}
