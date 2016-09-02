//package org.nzcn.landing.rest;
//
//import org.nzcn.landing.models.Item;
//import org.nzcn.landing.services.BaseRestService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
///**
// * Created by kinlin on 8/27/16.
// */
//
//@RestController
//@RequestMapping("/item")
//public class ItemController {
//
//    @Autowired
//    private BaseRestService<Item> itemService;
//
//    @RequestMapping(method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.CREATED)
//    public Item createItem(@RequestBody Item item){
//        Item newItem = itemService.create(item);
//        return newItem;
//    }
//
//    @RequestMapping(value = "/{itemId}", method = RequestMethod.PUT)
//    @ResponseStatus(HttpStatus.OK)
//    public Item updateItem(@RequestBody Item item,
//                           @PathVariable String itemId){
//        return itemService.update(itemId, item);
//    }
//
//}
