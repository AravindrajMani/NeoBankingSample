package com.neo.resources;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.ws.rs.FormParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.neo.model.BalanceEntity;
import com.neo.model.User;
import com.neo.repository.BalanceRepository;
import com.neo.repository.UserRepository;

@RestController
@RequestMapping("api")
public class RestResource {

	@Autowired
	UserRepository repo;
	
	@Autowired
	BalanceRepository balanceRepo;

	
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
    

	

	@RequestMapping(value = "/register", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String registerUser(@RequestBody User user, HttpSession session) throws JsonProcessingException {

		Date date = new Date();
		BalanceEntity balance = new BalanceEntity();
		

		
		user.setCreatedAt(formatter.format(date));
		user.setUpdatedAt(formatter.format(date));
		repo.save(user);
		
		
		balance.setBalanceId(user.getAccountId());
		balance.setBalanceAmount(0);	
		balance.setCreatedAt(formatter.format(date));
		balance.setUpdatedAt(formatter.format(date));
		balanceRepo.save(balance);
		
		session.setAttribute("currentUser", user.getAccountId());
		return "success";

	}
	
	
	@RequestMapping(value = "/getBalance", method = RequestMethod.GET)
	public @ResponseBody String getBalance(HttpSession session) {
		
		Integer bId =  (Integer) session.getAttribute("currentUser");
		Optional<BalanceEntity> userBalance = balanceRepo.findById(bId);
		
		BalanceEntity userBal =  userBalance.get();
		return userBal.getBalanceAmount()+"";

	}
	
	
	@Transactional
	@RequestMapping(value = "/addAmount", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String addAmount(@FormParam("data") String amount,HttpSession session) {
		
		
		Date date = new Date();
		String updatedDate = formatter.format(date);
		Integer bId =  (Integer) session.getAttribute("currentUser");
		long balance = Long.parseLong(amount);
		
		try {
			balanceRepo.updateBalanceAmount(balance,updatedDate, bId);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return "success";

	}
	
	@Transactional
	@RequestMapping(value = "/withdrawAmount", method = RequestMethod.POST,  produces = "application/json")
	public @ResponseBody String withdrawAmount(@FormParam("data") String withdrawAmount,HttpSession session) {
		
		Date date = new Date();
		String updatedDate = formatter.format(date);
		long withdrawnAmount = Long.parseLong(withdrawAmount);
		Integer bId =  (Integer) session.getAttribute("currentUser");
		Optional<BalanceEntity> userBalance = balanceRepo.findById(bId);
		
		long oldBalance =  userBalance.get().getBalanceAmount();
		long newBalance = oldBalance - withdrawnAmount;
		try {
		balanceRepo.updateBalanceAmount(newBalance,updatedDate, bId);
		}
		catch(Exception e) {
			
		}
		return "success";

	}
	
	
}