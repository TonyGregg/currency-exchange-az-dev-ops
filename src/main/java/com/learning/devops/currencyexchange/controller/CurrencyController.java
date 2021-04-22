package com.learning.devops.currencyexchange.controller;

import com.learning.devops.currencyexchange.model.CurrencyExchange;
import com.learning.devops.currencyexchange.repo.CurrencyRepo;
import java.math.BigDecimal;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Antony G.
 **/
@RestController
@RequestMapping("/api/currencyExchange")
@Slf4j
public class CurrencyController {

    @Autowired
    private CurrencyRepo currencyRepo;
    @PostMapping("/v1/create")
    public CurrencyExchange createCurrencyExchange(@RequestBody CurrencyExchange currencyExchange) {
        log.info("Received currency exchange {} ", currencyRepo);
        return currencyRepo.save(currencyExchange);
    }

    @GetMapping("/v1/{from}/{to}/{value}")
    public BigDecimal getExchangeRate(@PathVariable("from") String fromCurrency,
            @PathVariable("to") String toCurrency, @PathVariable("value") BigDecimal value) {
        Optional<CurrencyExchange> optionalCurrencyExchange = currencyRepo
                .findByFromCurrencyAndToCurrency(fromCurrency, toCurrency);

        if (optionalCurrencyExchange.isPresent()){
            BigDecimal conversionRate =  optionalCurrencyExchange.get().getRate();
            return value.multiply(conversionRate);
        } else {
            log.error("Sorry this from / to combination do not exist in our DB");
            return BigDecimal.valueOf(0l);
        }
    }
    @GetMapping("/v1/findById/{id}")
    public CurrencyExchange findById(@PathVariable(name = "id")Integer id) {
        final Optional<CurrencyExchange> optionalCurrencyExchange = currencyRepo.findById(id);
        if (optionalCurrencyExchange.isPresent()) {
            return optionalCurrencyExchange.get();
        } else {
            return optionalCurrencyExchange.get();
        }
    }

}
