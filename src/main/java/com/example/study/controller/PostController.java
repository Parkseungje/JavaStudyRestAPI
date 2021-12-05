package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PostController {

    @PostMapping("postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam){
    //@Requestbody는 HTTP통신에서 값을 받아 body에 넣어 보낸다는 뜻으로 주로 post통신에 이용된다.

        return searchParam;
    }

    @PutMapping("")
    public void put(){

    }

    @PatchMapping("")
    public void patch(){

    }
}
