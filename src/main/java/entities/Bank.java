package entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Bank extends BaseEntity{
    private Long id;
    private String name;
    private List<User> users;
}
