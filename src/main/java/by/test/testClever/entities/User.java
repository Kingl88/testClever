package by.test.testClever.entities;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User extends BaseEntity{
    private Long id;
    private String name;
    private String surname;
    private String lastname;
    private List<Bank> banks;

    public User(Long id) {
        this.id = id;
    }
}
