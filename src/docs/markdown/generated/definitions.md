## Definitions
### CategoryBean
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|categoryId||false|string||
|categoryName||false|string||
|families||false|Family array||


### Family
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|family||false|string||
|familyTypes||false|string array||


### FileBean
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|createTime||false|string||
|etag||false|string||
|fileId||false|integer (int64)||
|length||false|integer (int64)||
|name||false|string||
|status||false|string||
|suffix||false|string||


### Floor
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|categories||false|CategoryBean array||
|floor||false|string||
|specialties||false|Specialty array||


### FloorTree
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|tree||false|Floor array||
|treeType||false|integer (int32)||


### ShareLinkBean
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|expireTime||false|string||
|url||false|string||


### Specialty
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|categories||false|CategoryBean array||
|floors||false|Floor array||
|specialty||false|string||


### SpecialtyTree
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|tree||false|Specialty array||
|treeType||false|integer (int32)||


### SupportFileBean
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|length||false|integer (int64)||
|types||false|string array||


### TreeNode
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|elementCount||false|integer (int32)||
|id||false|string||
|items||false|TreeNode array||
|name||false|string||
|type||false|string||


### UploadPolicyBean
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|accessId||false|string||
|callbackBody||false|string||
|expire||false|integer (int64)||
|host||false|string||
|objectKey||false|string||
|policy||false|string||
|signature||false|string||


### user对象

用户对象user

|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|age|年龄|false|integer (int32)||
|id|id|false|integer (int64)||
|name|用户名|false|string||


