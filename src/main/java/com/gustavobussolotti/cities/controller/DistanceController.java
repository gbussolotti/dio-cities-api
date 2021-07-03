package com.gustavobussolotti.cities.controller;

import com.gustavobussolotti.cities.entity.Distance;
import com.gustavobussolotti.cities.exception.NotFoundException;
import com.gustavobussolotti.cities.service.DistanceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distance")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class DistanceController {

    private final DistanceService distanceService;


//
//    @GetMapping("/by-points-native")
//    public Distance byPoints(@RequestParam(name = "from") final Long city1,
//                             @RequestParam(name = "to") final Long city2) {
//        return distanceService.distanceNativePostgresPoints(city1, city2);
//
//    }
//
//    @GetMapping("/by-cube")
//    public Distance byCube(@RequestParam(name = "from") final Long city1,
//                           @RequestParam(name = "to") final Long city2) {
//        return distanceService.distanceCubePostgresPoints(city1, city2);
//    }

    @GetMapping
    public Distance calculateDistance(@RequestParam(name = "from") final Long city1,
                                      @RequestParam(name = "to") final Long city2,
                                      @RequestParam(name = "method", defaultValue = "native") final String method) throws NotFoundException {
        return distanceService.calculateDistance(city1, city2, method);

    }
}
