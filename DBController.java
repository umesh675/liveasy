package com.liveasy.liveasy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RestController
public class DBController {

    @Autowired
    DBOperation dbOperation;

    @PostMapping("/load")
    public String insertData(@RequestBody Shipping shipping){

        dbOperation.saveAll(Collections.singleton(shipping));
        return "loads details added successfully";
    }

    @GetMapping("/load")
    public List<Shipping> getDataList(){

        return dbOperation.findList("shipper:<UUID>");
    }

    @GetMapping("/load/{loadId}")
    public Shipping getData(@RequestParam(value = "id") String id){

        return dbOperation.findById(Integer.parseInt(id)).get();
    }

    @PutMapping("load/{loadId}")
    public String updateData( @PathVariable int id,@RequestBody Shipping shipping){


          Shipping shipping1 = dbOperation.findById(id).get();

          if(shipping1 == null){
              return "error";
          }
          shipping1.setComment(shipping.getComment());
          shipping1.setDate(shipping.getDate());
          shipping1.setLoadingPoint(shipping.getLoadingPoint());
          shipping1.setNoOfTrucks(shipping.getNoOfTrucks());
          shipping1.setProductType(shipping.getProductType());
          shipping1.setTruckType(shipping.getTruckType());
          shipping1.setUnloadingPoint(shipping.getUnloadingPoint());
          shipping1.setWeight(shipping.getWeight());

          return "success";
    }

    @DeleteMapping("/load/{loadId}")
    public void deleteData(@PathVariable int id){

        dbOperation.deleteById(id);
    }


}
