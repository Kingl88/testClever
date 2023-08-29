package entities;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class User extends BaseEntity{
    private Long id;
    private String name;
    private String surname;
    private String lastname;
    private List<Bank> banks;
}
