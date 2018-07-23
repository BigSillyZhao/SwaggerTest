## Resources
### Node
#### Branch details
```
GET /nodes
```

##### Description

Retrieve details of the current branches of BankA.

##### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|200 OK defined in $ref file|No Content|


### Pet

Everything about your Pets

#### Finds Pets by tags
```
GET /pet/findByTags
```

##### Description

Muliple tags can be provided with comma separated strings. Use         tag1, tag2, tag3 for testing.

##### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|QueryParameter|tags|Tags to filter by|true|multi string array||


##### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|successful operation|Pet array|
|400|Invalid tag value|No Content|


##### Produces

* application/xml
* application/json

#### uploads an image
```
POST /pet/{petId}/uploadImage
```

##### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|PathParameter|petId|ID of pet to update|true|integer (int64)||
|FormDataParameter|additionalMetadata|Additional data to pass to server|false|string||
|FormDataParameter|file|file to upload|false|file||


##### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|successful operation|ApiResponse|


##### Consumes

* multipart/form-data

##### Produces

* application/json

#### Find pet by ID
```
GET /pet/{petId}
```

##### Description

Returns a single pet

##### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|PathParameter|petId|ID of pet to return|true|integer (int64)||


##### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|successful operation|Pet|
|400|Invalid ID supplied|No Content|
|404|Pet not found|No Content|


##### Produces

* application/xml
* application/json

#### Updates a pet in the store with form data
```
POST /pet/{petId}
```

##### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|PathParameter|petId|ID of pet that needs to be updated|true|integer (int64)||
|FormDataParameter|name|Updated name of the pet|false|string||
|FormDataParameter|status|Updated status of the pet|false|string||


##### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|405|Invalid input|No Content|


##### Consumes

* application/x-www-form-urlencoded

##### Produces

* application/xml
* application/json

#### Deletes a pet
```
DELETE /pet/{petId}
```

##### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|HeaderParameter|api_key||false|string||
|PathParameter|petId|Pet id to delete|true|integer (int64)||


##### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|400|Invalid ID supplied|No Content|
|404|Pet not found|No Content|


##### Produces

* application/xml
* application/json

#### Update an existing pet
```
PUT /pet
```

##### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|BodyParameter|body|Pet object that needs to be added to the store|true|Pet||


##### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|400|Invalid ID supplied|No Content|
|404|Pet not found|No Content|
|405|Validation exception|No Content|


##### Consumes

* application/json
* application/xml

##### Produces

* application/xml
* application/json

#### Add a new pet to the store
```
POST /pet
```

##### Description

An item can be of different type:

type | definition
-----|-----------
Vinyl| aa
VHS  | #/definitions/VHS


##### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|BodyParameter|body|Pet object that needs to be added to the store|true|Pet||


##### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|405|Invalid input|No Content|


##### Consumes

* application/json
* application/xml

##### Produces

* application/xml
* application/json

#### Finds Pets by status
```
GET /pet/findByStatus
```

##### Description

Multiple status values can be provided with comma separated strings

##### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|QueryParameter|status|Status values that need to be considered for filter|true|multi enum (available, pending, sold) array||


##### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|successful operation|Pet array|
|400|Invalid status value|No Content|


##### Produces

* application/xml
* application/json

### Store

Access to Petstore orders

#### Returns pet inventories by status
```
GET /store/inventory
```

##### Description

Returns a map of status codes to quantities

##### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|successful operation|object|


##### Produces

* application/json

#### Place an order for a pet
```
POST /store/order
```

##### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|BodyParameter|body|order placed for purchasing the pet|true|Order||


##### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|successful operation|Order|
|400|Invalid Order|No Content|


##### Produces

* application/xml
* application/json

#### Find purchase order by ID
```
GET /store/order/{orderId}
```

##### Description

For valid response try integer IDs with value >= 1 and <= 10.         Other values will generated exceptions

##### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|PathParameter|orderId|ID of pet that needs to be fetched|true|integer (int64)||


##### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|successful operation|Order|
|400|Invalid ID supplied|No Content|
|404|Order not found|No Content|


##### Produces

* application/xml
* application/json

#### Delete purchase order by ID
```
DELETE /store/order/{orderId}
```

##### Description

For valid response try integer IDs with positive integer value.         Negative or non-integer values will generate API errors

##### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|PathParameter|orderId|ID of the order that needs to be deleted|true|integer (int64)||


##### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|400|Invalid ID supplied|No Content|
|404|Order not found|No Content|


##### Produces

* application/xml
* application/json

### User

Operations about user

#### Logs out current logged in user session
```
GET /user/logout
```

##### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|default|successful operation|No Content|


##### Produces

* application/xml
* application/json

#### Get user by user name
```
GET /user/{username}
```

##### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|PathParameter|username|The name that needs to be fetched. Use user1 for testing. |true|string||


##### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|successful operation|User|
|400|Invalid username supplied|No Content|
|404|User not found|No Content|


##### Produces

* application/xml
* application/json

#### Updated user
```
PUT /user/{username}
```

##### Description

This can only be done by the logged in user.

##### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|PathParameter|username|name that need to be updated|true|string||
|BodyParameter|body|Updated user object|true|User||


##### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|400|Invalid user supplied|No Content|
|404|User not found|No Content|


##### Produces

* application/xml
* application/json

#### Delete user
```
DELETE /user/{username}
```

##### Description

This can only be done by the logged in user.

##### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|PathParameter|username|The name that needs to be deleted|true|string||


##### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|400|Invalid username supplied|No Content|
|404|User not found|No Content|


##### Produces

* application/xml
* application/json

#### Creates list of users with given input array
```
POST /user/createWithList
```

##### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|BodyParameter|body|List of user object|true|User array||


##### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|default|successful operation|No Content|


##### Produces

* application/xml
* application/json

#### Create user
```
POST /user
```

##### Description

This can only be done by the logged in user.

##### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|BodyParameter|body|Created user object|true|User||


##### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|default|successful operation|No Content|


##### Produces

* application/xml
* application/json

#### Creates list of users with given input array
```
POST /user/createWithArray
```

##### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|BodyParameter|body|List of user object|true|User array||


##### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|default|successful operation|No Content|


##### Produces

* application/xml
* application/json

#### Logs user into the system
```
GET /user/login
```

##### Parameters
|Type|Name|Description|Required|Schema|Default|
|----|----|----|----|----|----|
|QueryParameter|username|The user name for login|true|string||
|QueryParameter|password|The password for login in clear text|true|string||


##### Responses
|HTTP Code|Description|Schema|
|----|----|----|
|200|successful operation|string|
|400|Invalid username/password supplied|No Content|


##### Produces

* application/xml
* application/json

