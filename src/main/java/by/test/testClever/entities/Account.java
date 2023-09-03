package by.test.testClever.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
public class Account extends BaseEntity{
    private Long id;
    private String numberIBAN;
    private String number;
    private String currencyType;
    private BigDecimal balance;
    private Bank bank;
    private User user;

    public Account(Long id) {

        this.id = id;
    }
}
