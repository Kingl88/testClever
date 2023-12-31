package by.test.testClever.entities;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Setter
@Getter
public class Transaction extends BaseEntity{
    private Long id;
    private String type;
    private String currencyType;
    private BigDecimal count;
    private Account from;
    private Account to;
}
