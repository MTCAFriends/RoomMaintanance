package com.roommaintanance.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.roommaintanance.model.CurrencyRate;

@Controller

public class CurrencyRateController {

	@RequestMapping(value = "/main", method = RequestMethod.GET)
  public String mainView(Model model) {
		 model.addAttribute("todayCurrencyRates", getTodayForexRates());
	      return "forexView";
     // return "main";
  }


  @RequestMapping(value = "/exchangeRates", method = RequestMethod.GET)
  public String handleForexRequest(Model model) {
      model.addAttribute("todayCurrencyRates", getTodayForexRates());
      return "forexView";
  }

  private List<CurrencyRate> getTodayForexRates() {
      //dummy rates
      List<CurrencyRate> currencyRates = new ArrayList<CurrencyRate>();
      Date today = new Date();
      List<Currency> currencies = new ArrayList<Currency>(Currency.getAvailableCurrencies());

      for (int i = 0; i < currencies.size(); i++) {
          String currencyPair = currencies.get(i)+"";
          CurrencyRate cr = new CurrencyRate();
          cr.setCurrencyPair(currencyPair);
          cr.setDate(today);
          BigDecimal bidPrice = new BigDecimal(Math.random() * 5 + 1);
          bidPrice = bidPrice.setScale(3, RoundingMode.CEILING);
          cr.setBidPrice(bidPrice);
          BigDecimal askPrice = new BigDecimal(bidPrice.doubleValue() + Math.random() * 2 + 0.5);
          askPrice = askPrice.setScale(3, RoundingMode.CEILING);
          cr.setAskPrice(askPrice);

          currencyRates.add(cr);
      }
      return currencyRates;
  }
}
