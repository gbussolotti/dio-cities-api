package com.gustavobussolotti.cities.repository;

import com.gustavobussolotti.cities.entity.City;
import com.gustavobussolotti.cities.entity.State;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Point;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface CityRepository extends PagingAndSortingRepository<City, Long>{

    Page<City> findAllByUf(State uf, Pageable pageable);

    //Return in miles
    @Query(value = "select ((POINT(?1,?2)) <@> (POINT(?3,?4))) as distance;", nativeQuery = true)
    Double distanceByPoints(final Double city1X, final Double city1Y, final Double city2X, final Double city2Y);

    //Return in meters
    @Query(value = "select earth_distance(ll_to_earth(?1,?2), ll_to_earth(?3,?4)) as distance;", nativeQuery = true)
    Double distanceByCube(final Double lat1, final Double lon1, final Double lat2, final Double lon2);

}
