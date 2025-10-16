package com.fundify.fundify.investment.controller;

import com.fundify.fundify.investment.exception.InvestmentNotFoundException;
import com.fundify.fundify.investment.model.Investment;
import com.fundify.fundify.investment.repository.InvestmentRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/investment")
public class InvestmentController {
    private final InvestmentRepository investmentRepository;

    public InvestmentController(InvestmentRepository investmentRepository) {
        this.investmentRepository = investmentRepository;
    }

    @GetMapping("/")
    List<Investment> get() {
        return investmentRepository.get();
    }

    @GetMapping("/{funder}")
    List<Investment> get(
            @PathVariable String funder
    ) {
        return investmentRepository.get(funder);
    }

    @GetMapping("/project/{owner}/{index}")
    List<Investment> get(
            @PathVariable String owner,
            @PathVariable int index
    ) {
        return investmentRepository.get(owner, index);
    }

    @GetMapping("/{funder}/{index}")
    Optional<Investment> find(
            @PathVariable String funder,
            @PathVariable int index
    ) {
        Optional<Investment> investment = investmentRepository.find(funder, index);
        if (investment.isEmpty()) {
            throw new InvestmentNotFoundException();
        }
        return investment;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    void create(
            @Valid @RequestBody Investment investment
    ) {
        investmentRepository.create(investment);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{funder}/{index}")
    void update(
            @PathVariable String funder,
            @PathVariable int index,
            @Valid @RequestBody Investment investment
    ) {
        investmentRepository.update(investment, funder, index);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{funder}/{index}")
    void delete(
            @PathVariable String funder,
            @PathVariable int index
    ) {
        investmentRepository.delete(funder, index);
    }
}

