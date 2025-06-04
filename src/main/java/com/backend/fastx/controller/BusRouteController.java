package com.backend.fastx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.backend.fastx.model.BusRoute;
import com.backend.fastx.service.BusRouteService;

@RestController
@RequestMapping("/api/busroutes")
public class BusRouteController {

    @Autowired
    private BusRouteService busRouteService;

    //  POST endpoint to add new bus route
    @PostMapping("/add")
    public ResponseEntity<BusRoute> addBusRoute(@RequestBody BusRoute busRoute) {
        BusRoute createdRoute = busRouteService.addBusRoute(busRoute);
        return ResponseEntity.ok(createdRoute);
    }

    // GET all routes matching filter 
    @GetMapping("/get")
    public ResponseEntity<List<BusRoute>> getBusRoutes(@RequestBody BusRoute busRoute) {
        List<BusRoute> getRoutes = busRouteService.getBusRoute(busRoute);
        return ResponseEntity.ok(getRoutes);
    }

    // GET a single bus route by ID
    @GetMapping("/get-one/{id}")
    public ResponseEntity<BusRoute> getRouteById(@PathVariable int id) {
        BusRoute route = busRouteService.getBusRouteById(id);
        if (route != null) {
            return ResponseEntity.ok(route);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    	
    	
}

