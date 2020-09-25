package edu.eci.arsw.saleit.repo;

import edu.eci.arsw.saleit.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidArticle extends JpaRepository<Bid, String> {
}
