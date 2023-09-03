package by.test.testClever.entities;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Bank extends BaseEntity{
    private Long id;
    private String name;
    private List<User> users;

    public Bank(Long id) {
        this.id = id;
    }
}
