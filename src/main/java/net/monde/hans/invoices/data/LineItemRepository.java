package net.monde.hans.invoices.data;

import net.monde.hans.invoices.model.LineItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LineItemRepository extends CrudRepository<LineItem, Long> {
}
