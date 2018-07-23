package com.bimface.demo.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {

    public String a;


    @ApiOperation(value="文件", notes="到底该怎么解决啊！！！",httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping("/hello")
    public String hello(){
        //String markdown_file_path="src/docs/markdown/generated/paths.md";
        //String result = MDTool.markdown2Html(new File(markdown_file_path));
        return a;
    }
}
