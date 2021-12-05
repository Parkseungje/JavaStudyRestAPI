package com.example.study.model;

import lombok.AllArgsConstructor;
import lombok.Data;
/*
lombok 사용법
1. File -> Settings -> Plugins -> lombok 설치
2. build.gradle에 lombok 디펜던시를 추가한다.
3. File -> Settings -> Build, Execution, Deployment -> Compiler -> Annotation Processors -> Enable annotation processing 체크
 */

@Data // 기본생성자와 getter, setter 생성
@AllArgsConstructor // 모든 멤버변수의 파라미터를 가지는 생성자를 생성
public class SearchParam {

    private String account;
    private String email;
    private int page;

}
