package com.services;

import com.model.Taxes;

import java.util.List;

public interface TaxesService {
    List<Taxes> getTaxes();

    Taxes createTaxes(Taxes taxes);
    Taxes getTaxesById(int id);

    Taxes updateTaxes(Taxes taxes);

    Taxes deleteTaxesById(int id);
}
