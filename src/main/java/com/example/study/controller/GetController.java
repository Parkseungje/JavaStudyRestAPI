package com.example.study.controller;

import com.example.study.model.SearchParam;
import com.example.study.model.network.Header;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 그냥 Controller는 뷰를 반환하지만 RestController는 Controller에 Responsebody를 붙인것처럼 데이터를 반환한다.(데이터 형식은 기본적으로 json이다)
@RequestMapping("/api") //localhost:8080/api
public class GetController {

    @GetMapping("/getMethod")
    public String getRequest() {

        return "Hi getMethod";
    }

    @GetMapping("/getParameter") //localhost:8080/api/getParameter?id=1234&password=abcd
    public String getParameter(@RequestParam String id, @RequestParam(name = "password") String pwd) {
        // @RequsetParam을 이용하면 인자를 받아 url 주소창에 넣는다. HTTP통신중 get통신에 주로사용
        // @ReauestParma(name="password")은 주소창에 password이름으로 값을 넣어야한다는 뜻
        System.out.println("id: " + id);
        System.out.println("pw: " + pwd);

        return id + pwd;
    }

    //localhost:8080/api/getMultiParameter?account=abcd&email=study@gamil.com&page=10
    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam) {

        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        //{"account" : "", "email" : "", "page" : 0}
        return searchParam;
    }

    @GetMapping("/header")
    public Header getHeader(){

        // {"resultCode" : "OK", "description" : "OK" }
        return Header.builder().resultCode("OK").description("OK").build();
    }

}
