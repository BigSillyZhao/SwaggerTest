## Paths
### findAllTask
```
GET /task/
```

#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|string|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* */*

#### Tags

* task-controller

### 文件类型
```
GET /test/file
```
```
 public String hello(){
        String markdown_file_path="src/docs/markdown/generated/paths.md";
        String result = MDTool.markdown2Html(new File(markdown_file_path));
        return result;
    }
```
#### Description

获取支持文件类型

#### Responses
HTTP Code|Description|Schema
----|----|----
200|OK|user对象
400|Invalid ID supplied|No Content
401|Unauthorized|No Content
403|Forbidden|No Content
404|Pet not found|No Content


#### Consumes

* application/json

#### Produces

* application/json
* */*

#### Tags

* test-controller

### 文件
```
GET /test/fileMetadata/{fileId}
```

#### Description

获取文件信息

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|HeaderParameter|TOKEN|Authorization token|true|string||
|PathParameter|fileId|文件的id|true|string||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|success|FileBean|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Pet not found|No Content|


#### Consumes

* application/json

#### Produces

* application/json
* */*

#### Tags

* test-controller

### getCaV1
```
GET /test/getCaV1
```

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|QueryParameter|fileId|fileId|true|integer (int64)||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|CategoryBean array|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* */*

#### Tags

* test-controller

### getCaV2
```
GET /test/getCaV2
```

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|QueryParameter|fileId|fileId|true|integer (int64)||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|TreeNode array|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* */*

#### Tags

* test-controller

### getDownloadUrl
```
GET /test/getDownloadUrl
```

#### Description

获取文件信息

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|QueryParameter|fileId|fileId|true|integer (int64)||
|QueryParameter|fileName|fileName|true|string||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|string|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* application/json
* */*

#### Tags

* test-controller

### getElements
```
GET /test/getElements
```

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|QueryParameter|fileId|fileId|false|integer (int64)||
|QueryParameter|categoryId|categoryId|false|string||
|QueryParameter|family|family|false|string||
|QueryParameter|familyType|familyType|false|string||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|string array|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* */*

#### Tags

* test-controller

### getUs
```
POST /test/getElements1
```

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|BodyParameter|user|user|true|user对象||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|string array|
|201|Created|No Content|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* */*

#### Tags

* test-controller

### getFloor
```
GET /test/getFloor
```

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|QueryParameter|integrateId|integrateId|true|integer (int64)||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|FloorTree|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* */*

#### Tags

* test-controller

### getPolicy
```
GET /test/getPolicy
```

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|QueryParameter|name|name|true|string||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|UploadPolicyBean|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* */*

#### Tags

* test-controller

### createShare
```
GET /test/getShare
```

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|QueryParameter|fileId|fileId|true|integer (int64)||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|ShareLinkBean|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* */*

#### Tags

* test-controller

### getSpecialty
```
GET /test/getSpecialty
```

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|QueryParameter|integrateId|integrateId|true|integer (int64)||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|SpecialtyTree|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* */*

#### Tags

* test-controller

### getViewToken
```
GET /test/getViewToken
```

#### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|QueryParameter|fileId|fileId|true|integer (int64)||


#### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|OK|string|
|401|Unauthorized|No Content|
|403|Forbidden|No Content|
|404|Not Found|No Content|


#### Consumes

* application/json

#### Produces

* */*

#### Tags

* test-controller

