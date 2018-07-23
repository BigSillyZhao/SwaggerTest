package com.bimface.demo.controller;


import com.bimface.demo.bean.User;
import com.bimface.demo.dao.taskDao;
import com.bimface.sdk.BimfaceClient;
import com.bimface.sdk.bean.response.*;
import com.bimface.sdk.exception.BimfaceException;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
@Api(value = "TestController", description = "测试相关api")

public class TestController implements taskDao {

     @Autowired
     private BimfaceClient bimfaceClient;

     @Value(value = "aa")
     private Resource data;


     @ApiOperation(value="文件类型",notes="获取支持文件类型",httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE,response =User.class,
             responseReference = "www.bimface.com,到底是个什么鬼",responseHeaders = {@ResponseHeader(name="支持类型",response = User.class)},
             extensions = {@Extension(properties = {@ExtensionProperty(name = "test1", value = "value1"),@ExtensionProperty(name = "test2", value = "value2")})
             }
                           )

     @GetMapping("/file")

     @ApiResponses(value = {
             @ApiResponse(code = 400, message = "Invalid ID supplied"),
             @ApiResponse(code = 404, message = "Pet not found") })
     public SupportFileBean fileSupport() throws Exception{
          return bimfaceClient.getSupport();
     }





     @ApiOperation(value="文件", notes="获取文件信息",httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
     @ApiImplicitParams({
             @ApiImplicitParam(name = "fileId", value = "文件的id", required = true, dataType = "string", paramType = "path"),
             @ApiImplicitParam(name = "TOKEN", value = "Authorization token", required = true, dataType = "string", paramType = "header"),
     })
     @ApiResponses(value = {
             @ApiResponse(code = 200, message = "success",
                     responseHeaders = @ResponseHeader(name = "X-Rack-Cache", description = "Explains whether or not a cache was used", response = User.class)),
             @ApiResponse(code = 404, message = "Pet not found") })
     @GetMapping("/fileMetadata/{fileId}")
     public FileBean fileMetadata(@PathVariable("fileId") Long fileId) throws Exception{
          return bimfaceClient.getFileMetadata(fileId);
     }

     @GetMapping("/getPolicy")
     public UploadPolicyBean getPolicy(@RequestParam("name") String name) throws Exception{
          return  bimfaceClient.getPolicy(name);
     }


     @ApiOperation(value="", notes="An item can be of different type:\n" +
             "\n" +
             " type | definition\n" +
             " -----|-----------\n" +
             " Vinyl| aa\n" +
             " VHS  | bb"+
             "An item can be of different type:\n"+
             "\n" +
             " type | definition\n" +
             " -----|-----------\n" +
             " Vinyl| aa\n" +
             " VHS  | bb" +
             "An item can be of different type:\n"+
             "\n" +
             " type | definition\n" +
             " -----|-----------\n" +
             " Vinyl| aa\n" +
             " VHS  | bb",httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
     @GetMapping("/getDownloadUrl")
     public String getDownloadUrl(@RequestParam Long fileId, @RequestParam String fileName) throws BimfaceException {
          return bimfaceClient.getDownloadUrl(fileId,fileName);
     }

     @GetMapping("/getShare")//是不是谁转的文件只能用他的那个
     public ShareLinkBean createShare(@RequestParam Long fileId) throws BimfaceException {
          return bimfaceClient.createShare(fileId);
     }
     @GetMapping("/getSpecialty")
     public SpecialtyTree getSpecialty(@RequestParam Long integrateId) throws BimfaceException {
          return bimfaceClient.getSpecialtyTree(integrateId);
     }

     @GetMapping("/getFloor")
     public FloorTree getFloor(@RequestParam Long integrateId) throws BimfaceException {
          return bimfaceClient.getFloorTree(integrateId);
     }

     @GetMapping("/getCaV1")
     public List<CategoryBean> getCaV1(@RequestParam Long fileId) throws BimfaceException {
          return bimfaceClient.getCategory(fileId);
     }

     @GetMapping("/getCaV2")
     public  List<TreeNode> getCaV2(@RequestParam Long fileId) throws BimfaceException {
          return bimfaceClient.getCategoryV2(fileId);
     }

     @GetMapping("/getViewToken")
     public String getViewToken(@RequestParam Long fileId) throws BimfaceException {
          return bimfaceClient.getViewTokenByFileId(fileId);
     }

     @GetMapping("/getElements")
     public List<String> getElements(Long fileId, String categoryId, String family, String familyType) throws BimfaceException {
          return bimfaceClient.getElements(fileId,categoryId,family,familyType);
     }

     @PostMapping("/getElements1")
     public List<String> getUs(@RequestBody User user) throws BimfaceException {
          return null;
     }
    /* @GetMapping("/getFileElements")
     public PropertyBean getFileElements(Long fileId, String elementId) throws BimfaceException {
          return bimfaceClient.getElementProperty(fileId,elementId);
     }*/
}
