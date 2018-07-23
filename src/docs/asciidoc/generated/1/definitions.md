## Definitions
### ApiResponse
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|code||false|integer (int32)||
|type||false|string||
|message||false|string||


### Category
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|id||false|integer (int64)||
|name||false|string||


### Order
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|id||false|integer (int64)||
|petId||false|integer (int64)||
|quantity||false|integer (int32)||
|shipDate||false|string (date-time)||
|status|Order Status|false|enum (placed, approved, delivered)||
|complete||false|boolean|false|


### Pet
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|id||false|integer (int64)||
|category||false|Category||
|name||true|string||
|photoUrls||true|string array||
|tags||false|Tag array||
|status|pet status in the store|false|enum (available, pending, sold)||


### Tag
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|id||false|integer (int64)||
|name||false|string||


### User
|Name|Description|Required|Schema|Default|
|----|----|----|----|----|
|id||false|integer (int64)||
|username||false|string||
|firstName||false|string||
|lastName||false|string||
|email||false|string||
|password||false|string||
|phone||false|string||
|userStatus|User Status|false|integer (int32)||


