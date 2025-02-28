package com.companionly.prototype.data;

import com.companionly.prototype.models.Mood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MoodRepository extends JpaRepository<Mood, Long> {

	@Query("SELECT m FROM Mood m WHERE " +
	        "LOWER(m.journal) LIKE LOWER(CONCAT('%', :keyword, '%'))")
	List<Mood> searchMoods(@Param("keyword") String keyword);
}
