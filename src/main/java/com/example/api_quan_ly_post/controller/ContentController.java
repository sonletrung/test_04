package com.example.api_quan_ly_post.controller;

import com.example.api_quan_ly_post.model.Content;
import com.example.api_quan_ly_post.service.ControllerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/profile")
public class ContentController {
    @Autowired
    ControllerRepository controllerRepository;
    @GetMapping
    public ResponseEntity findAll(){
        return new ResponseEntity(controllerRepository.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity save(@RequestBody Content content){
        return new ResponseEntity(controllerRepository.save(content), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity save(@RequestBody Content blog,@PathVariable Long id){
        blog.setId(id);
        return new ResponseEntity(controllerRepository.save(blog), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        controllerRepository.deleteById(id);
        return new ResponseEntity("dele oki", HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity findbyid(@PathVariable Long id){
        return new ResponseEntity(controllerRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping("/titler/{value}")
    public ResponseEntity searchtitle(@PathVariable String value){

        return new ResponseEntity(controllerRepository.findByTitle(value),HttpStatus.OK);
    }
//    @GetMapping("/filter")
//    public ResponseEntity filer(){
//        List<Content> dataList = controllerRepository.findAll();
//        dataList.sort((a, b) -> Integer.compare(b.getLikes(), a.getLikes()));
//        return new ResponseEntity(dataList,HttpStatus.OK);
//    }
//    @GetMapping("/filters")
//    public ResponseEntity filers(){
//        List<Content> dataList = controllerRepository.findAll();
//        dataList.sort((a, b) -> Integer.compare(b.getLikes(), a.getLikes()));
//        List<Content> datalists = dataList.subList(0,4);
//        return new ResponseEntity(datalists,HttpStatus.OK);
//    }
    @GetMapping("/filter")
    public ResponseEntity filer(){
    return new ResponseEntity(controllerRepository.findByOrderByLikesDesc(),HttpStatus.OK);
}
    @GetMapping("/filters")
    public ResponseEntity filers(){
        return new ResponseEntity(controllerRepository.findTop4ByOrderByLikesDesc(),HttpStatus.OK);
    }
    @GetMapping("/status/{value}")
    public ResponseEntity status(@PathVariable String value){
        return new ResponseEntity(controllerRepository.findByStatus(value),HttpStatus.OK);
    }
}
