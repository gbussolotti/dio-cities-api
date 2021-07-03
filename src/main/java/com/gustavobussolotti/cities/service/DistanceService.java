package com.gustavobussolotti.cities.service;

import com.gustavobussolotti.cities.entity.City;
import com.gustavobussolotti.cities.entity.Distance;
import com.gustavobussolotti.cities.entity.DistanceMethod;
import com.gustavobussolotti.cities.exception.NotFoundException;
import com.gustavobussolotti.cities.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DistanceService {

    private final CityRepository cityRepository;

    public Distance calculateDistance(final Long city1, final Long city2, String method) throws NotFoundException {
        DistanceMethod defaultMethod = DistanceMethod.NATIVE;
        if(method!= null && !method.isEmpty()){
            for (DistanceMethod d: DistanceMethod.values()) {
                if(d.getMethod().equalsIgnoreCase(method)){
                    defaultMethod = d;
                    break;
                }
            }
        }

        switch (defaultMethod){
            case NATIVE:
                return distanceNativePostgresPoints(city1, city2);
            case CUBE:
               return distanceCubePostgresPoints(city1, city2);

        }
        return distanceCubePostgresPoints(city1, city2);
    }

    private Distance distanceNativePostgresPoints(final Long city1, final Long city2) throws NotFoundException {
        final List<Point> citiesPoints = getCitiesPoints(city1, city2);

        Double distance =  cityRepository.distanceByPoints(
                citiesPoints.get(0).getX(),
                citiesPoints.get(0).getY(),
                citiesPoints.get(1).getX(),
                citiesPoints.get(1).getY()
                );
        return Distance.builder()
                .value(new BigDecimal(distance).setScale(2, RoundingMode.HALF_DOWN))
                .unit(Distance.UNIT_MILES)
                .build();

    }

    private Distance distanceCubePostgresPoints(final Long city1, final Long city2) throws NotFoundException {
        final List<Point> citiesPoints = getCitiesPoints(city1, city2);

        Double distance = cityRepository.distanceByCube( citiesPoints.get(0).getX(),
                citiesPoints.get(0).getY(),
                citiesPoints.get(1).getX(),
                citiesPoints.get(1).getY()
        );

        return Distance.builder()
                .value(new BigDecimal(distance).setScale(2, RoundingMode.HALF_DOWN))
                .unit(Distance.UNIT_METERS)
                .build();
    }

    private List<Point> getCitiesPoints(final Long city1, final Long city2) throws NotFoundException {
        final List<City> cities = (List<City>) cityRepository.findAllById((Arrays.asList(city1, city2)));
        if (cities == null || cities.isEmpty()){
            throw new NotFoundException("Cities with ID: "+city1+" and ID: "+city2+" not founded");
        }

        if(cities.size() == 1){
            throw new NotFoundException("Citie with ID: "+(cities.get(0).getId().equals(city1) ? city2 : city1)+" not founded");
        }
        return Arrays.asList(cities.get(0).getLocation(), cities.get(1).getLocation());

    }


//    public Double distanceUsingPoints(final Long city1, final Long city2) {
//        final List<City> cities = (List<City>) cityRepository.findAllById((Arrays.asList(city1, city2)));
//
//        Point p1 = cities.get(0).getLocation();
//        Point p2 = cities.get(1).getLocation();
//
//        return calculateDistance(p1.getX(), p1.getY(), p2.getX(), p2.getY(), 0, 0);
//    }


    /**
     * Calculate distance between two points in latitude and longitude taking
     * into account height difference. If you are not interested in height
     * difference pass 0.0. Uses Haversine method as its base.
     *
     * lat1, lon1 Start point lat2, lon2 End point el1 Start altitude in meters
     * el2 End altitude in meters
     * @returns Distance in Meters
     *
     *
     *
     * https://stackoverflow.com/questions/3694380/calculating-distance-between-two-points-using-latitude-longitudehttps://stackoverflow.com/questions/3694380/calculating-distance-between-two-points-using-latitude-longitude
     */

//    private double calculateDistance(double lat1, double lat2, double lon1,
//                                  double lon2, double el1, double el2) {
//
//        final int R = 6371; // Radius of the earth
//
//        double latDistance = Math.toRadians(lat2 - lat1);
//        double lonDistance = Math.toRadians(lon2 - lon1);
//        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
//                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
//                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
//        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
//        double distance = R * c * 1000; // convert to meters
//
//        double height = el1 - el2;
//
//        distance = Math.pow(distance, 2) + Math.pow(height, 2);
//
//        return Math.sqrt(distance);
//    }


}
