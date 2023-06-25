package com.app.budgetme.controller;

import com.app.budgetme.dao.HomeDAOImpl;
import com.app.budgetme.utility.homeRes;
import com.app.budgetme.entity.planning;
import com.app.budgetme.entity.transaction;
import com.app.budgetme.service.PlanningService;
import com.app.budgetme.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
public class RestController {

    private TransactionService transactionService;
    private PlanningService planningService;

    private HomeDAOImpl homeDAOImpl;

    public RestController(TransactionService theTransactionService, PlanningService thePlanningService, HomeDAOImpl theHomeDAOImpl){
        transactionService = theTransactionService;
        planningService = thePlanningService;
        homeDAOImpl = theHomeDAOImpl;
    }
    
    @GetMapping("/")
    public String showHome(Model theModel){

        String monthOptions[] = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG",
                "SEP", "OCT", "NOV", "DEC"};

        theModel.addAttribute("monthOptions", monthOptions);
        return "home";
    }

    @PostMapping("/showHomeforMonth")
    public String showHomeforMonth(@RequestParam("selectMonth") String selectMonth, Model theModel){

        // category, actual, planned, category balance, total actual, total planned, total balance
        Double totalActual=0.0;
        Double totalPlanned=0.0;
        Double totalBalance=0.0;
        List<homeRes>[] resList = homeDAOImpl.fetchHomeData(selectMonth);

        System.out.println(resList);
        for (List<homeRes> homeResList : resList ){
            System.out.println(homeResList);
            for (homeRes aHomeRes: homeResList) {
                totalActual = totalActual + aHomeRes.getActual();
                totalPlanned = totalPlanned + aHomeRes.getPlanned();
            }
        }

        totalBalance=totalPlanned-totalActual;

        theModel.addAttribute("resList", resList);
        theModel.addAttribute("totalActual", totalActual);
        theModel.addAttribute("totalPlanned", totalPlanned);
        theModel.addAttribute("totalBalance", totalBalance);

        return "home-monthly";
    }

    @GetMapping("/transaction")
    public String showTransaction(Model theModel){

        List<transaction> theTransactions = transactionService.findAll();
        theModel.addAttribute("transactions", theTransactions);

        return "transaction";
    }

    @GetMapping("/addTransaction")
    public String addTransaction(Model theModel){

        transaction theTransaction = new transaction();

        theModel.addAttribute("transaction", theTransaction);

        String monthOptions[] = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG",
        "SEP", "OCT", "NOV", "DEC"};

        theModel.addAttribute("monthOptions", monthOptions);

        return "transaction-form";
    }

    @GetMapping("/updateTransaction")
    public String updateTransaction(@RequestParam("transactionId") int theId, Model theModel){

        transaction theTransaction = transactionService.findById(theId);

        theModel.addAttribute("transaction", theTransaction);

        String monthOptions[] = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG",
                "SEP", "OCT", "NOV", "DEC"};

        theModel.addAttribute("monthOptions", monthOptions);

        return "transaction-form";
    }

    @PostMapping("/saveTransaction")
    public String saveTransaction(@ModelAttribute("transaction") transaction theTransaction){

        transactionService.save(theTransaction);

        return "redirect:/transaction";
    }

    @GetMapping("/deleteTransaction")
    public String deleteTransaction(@RequestParam("transactionId") int theId){

        transactionService.deleteById(theId);

        return "redirect:/transaction";
    }

    @PostMapping("/showPlanningforMonth")
    public String showPlanningforMonth(@RequestParam("selectMonth") String selectMonth, Model theModel){

        List<planning> theplannings = planningService.findAllByMonth(selectMonth);
        theModel.addAttribute("plannings", theplannings);

        return "planning";
    }

    @GetMapping("/planning")
    public String planning(Model theModel){
        String monthOptions[] = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG",
                "SEP", "OCT", "NOV", "DEC"};

        theModel.addAttribute("monthOptions", monthOptions);
        return "planning-select";
    }
/*
    @GetMapping("/planning")
    public String showPlanning(Model theModel){

        List<planning> theplannings = planningService.findAll();
        theModel.addAttribute("plannings", theplannings);

        return "planning";
    }
*/
    @GetMapping("/addPlanning")
    public String addPlanning(Model theModel){

        planning thePlanning = new planning();

        theModel.addAttribute("planning", thePlanning);

        String monthOptions[] = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG",
                "SEP", "OCT", "NOV", "DEC"};

        theModel.addAttribute("monthOptions", monthOptions);

        return "planning-form";
    }

    @GetMapping("/updatePlanning")
    public String updatePlanning(@RequestParam("planningId") int theId, Model theModel){

        planning thePlanning = planningService.findById(theId);

        theModel.addAttribute("planning", thePlanning);

        String monthOptions[] = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG",
                "SEP", "OCT", "NOV", "DEC"};

        theModel.addAttribute("monthOptions", monthOptions);

        return "planning-form";
    }

    @PostMapping("/savePlanning")
    public String saveTransaction(@ModelAttribute("planning") planning thePlanning){

        planningService.save(thePlanning);

        return "redirect:/planning";
    }

    @GetMapping("/deletePlanning")
    public String deletePlanning(@RequestParam("planningId") int theId){

        planningService.deleteById(theId);

        return "redirect:/planning";
    }
}
