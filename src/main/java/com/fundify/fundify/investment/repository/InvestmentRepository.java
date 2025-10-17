package com.fundify.fundify.investment.repository;

import com.fundify.fundify.investment.model.Investment;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class InvestmentRepository {
    private final List<Investment> investments = new ArrayList<>();

    public List<Investment> get() {
        return investments;
    }

    public List<Investment> get(String funder) {
        return investments.stream().filter(investment -> investment.funder().equals(funder)).collect(Collectors.toList());
    }

    public List<Investment> get(String projectOwner, int index) {
        return investments.stream().filter(investment -> investment.projectOwner().equals(projectOwner) && investment.projectIndex() == index).collect(Collectors.toList());
    }

    public Optional<Investment> find(String funder, int index) {
        return investments.stream().filter(investment -> investment.funder().equals(funder) && investment.investmentIndex() == index).findFirst();
    }

    public void create(Investment investment) {
        investments.add(investment);
    }

    public void update(Investment investment, String funder, int index) {
        Optional<Investment> existingInvestment = find(funder, index);
        existingInvestment.ifPresent(value -> investments.set(investments.indexOf(value), investment));
    }

    public void delete(String funder, int index) {
        investments.removeIf(investment -> investment.funder().equals(funder) && investment.investmentIndex() == index);
    }

    @PostConstruct
    private void init() {
        investments.add(new Investment(
                "1",
                "pavan.eth",
                1,
                "arav.eth",
                1,
                1.0,
                154387
        ));
        investments.add(new Investment(
                "2",
                "kartik.eth",
                1,
                "arav.eth",
                1,
                1.0,
                154387
        ));
        investments.add(new Investment(
                "3",
                "pavan.eth",
                1,
                "arav.eth",
                1,
                1.0,
                154387
        ));
        investments.add(new Investment(
                "4",
                "pavan.eth",
                1,
                "kartik.eth",
                1,
                1.0,
                154387
        ));
        investments.add(new Investment(
                "5",
                "arav.eth",
                1,
                "kartik.eth",
                1,
                1.0,
                154387
        ));
        investments.add(new Investment(
                "6",
                "pavan.eth",
                1,
                "kartik.eth",
                1,
                1.0,
                154387
        ));
        investments.add(new Investment(
                "7",
                "kartik.eth",
                1,
                "pavan.eth",
                1,
                1.0,
                154387
        ));
        investments.add(new Investment(
                "8",
                "arav.eth",
                1,
                "pavan.eth",
                1,
                1.0,
                154387
        ));
        investments.add(new Investment(
                "9",
                "kartik.eth",
                1,
                "pavan.eth",
                1,
                1.0,
                154387
        ));
    }
}
