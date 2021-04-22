package com.learning.devops.currencyexchange.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Antony G.
 **/
@Entity
@Table(name = "CURRENCY_EXCHANGE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CurrencyExchange {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "from_currency")
    private String fromCurrency;
    @Column(name = "to_currency")
    private String toCurrency;
    private BigDecimal rate;
}
