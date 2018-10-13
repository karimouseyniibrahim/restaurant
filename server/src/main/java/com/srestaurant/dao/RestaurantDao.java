package com.srestaurant.dao;

        import com.srestaurant.model.Restaurant;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

        import java.util.List;


@Repository
public interface RestaurantDao extends JpaRepository<Restaurant, Integer>{
       //public List<Restaurant> findAllOrderBymoyenDesc();
}
