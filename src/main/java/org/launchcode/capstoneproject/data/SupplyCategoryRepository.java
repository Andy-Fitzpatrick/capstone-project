package org.launchcode.capstoneproject.data;

import org.launchcode.capstoneproject.models.SupplyCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplyCategoryRepository extends CrudRepository<SupplyCategory, Integer> {
}
