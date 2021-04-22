package com.learning.devops.currencyexchange.repo;

import com.learning.devops.currencyexchange.model.CurrencyExchange;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Antony G.
 **/
public interface CurrencyRepo extends JpaRepository<CurrencyExchange, Integer> {
    Optional<CurrencyExchange> findByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);
}
