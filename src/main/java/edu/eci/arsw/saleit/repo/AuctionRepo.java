package edu.eci.arsw.saleit.repo;

import edu.eci.arsw.saleit.model.Auction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionRepo extends JpaRepository<Auction, String> {
}
