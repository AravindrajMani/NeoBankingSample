package com.neo.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.neo.model.BalanceEntity;

public interface BalanceRepository extends CrudRepository<BalanceEntity, Integer> {
	
	@Modifying
	@Query(value="update tamil.balance_entity b  set b.balance_amount = ?1, b.updated_at=?2 where b.balance_id = ?3",
			nativeQuery = true)
	void updateBalanceAmount(long balanceAmount, String updatedAt ,Integer bId);

}
	 