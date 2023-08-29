package entities;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class Account extends BaseEntity{
    private Long id;
    private String numberIBAN;
    private String number;
    private String currencyType;
    private BigDecimal balance;
    private Bank bank;
    private User user;
}
