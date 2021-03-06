package edu.neu.cs5200.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.neu.cs5200.entity.HuskyOrder;

public interface HuskyOrderRepository extends CrudRepository<HuskyOrder, Integer> {

    @Query("from HuskyOrder h where h.customer.id=:customerId")
    public Iterable<HuskyOrder> findByCustomerId(@Param("customerId") int customerId);

    @Query("from HuskyOrder h where h.husky.id=:huskyId")
    public Iterable<HuskyOrder> findByHuskyId(@Param("huskyId") int huskyId);

    @Query("from HuskyOrder h where h.status='PENDING'")
    public Iterable<HuskyOrder> findAvailable();
}
