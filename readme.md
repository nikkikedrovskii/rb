## Required technology for startup and testing: 
 * Postgresql  
    *Note: You can deploy DB in the docker with the command:
    "docker run -it -d --restart=always --name rbtestDB -e POSTGRES_USER=rbtest -e POSTGRES_PASSWORD=password -p 5002:5432 postgres:12-alpine"*
 * Postman

# API Endpoints
This repository contains an application with the following 7 endpoints:

# 1. POST /api/v1/document - create document
    Request Body Schema: application/json
     * documentName - String 
     * creatorName - String 
     * documentType - String
# 2. DELETE /api/v1/document/{documentId} - delete document
    Request Body Schema: application/json
     * documentId - Long
# 3. PUT /api/v1/document/{documentId} - update document
    Request Body Schema: application/json
     * documentId - Long 
     * documentName - String 
     * creatorName - String 
     * documentType - String
# 4. POST /api/v1/protocol - create protocol 
    Request Body Schema: application/json
     * creatorName - String 
     * protocolState - String - (NEW,PREPARE_FOR_SHIPMENT, CANCELED)
     * listOfDocument - List<Long>
# 5. PUT /api/v1/protocol/{protocolId} - update protocol 
    Request Body Schema: application/json
     * protocolId - Long
     * creatorName - String 
     * protocolState - String - (NEW,PREPARE_FOR_SHIPMENT, CANCELED)
     * listOfDocument - List<Long>
# 6. PUT /api/v1/{protocolId}/state update state of selected protocol
    Request Body Schema: application/json
     * protocolId - Long 
     * protocolState - String - (NEW,PREPARE_FOR_SHIPMENT, CANCELED)
# 7. POST /api/v1/auth/authenticate - authenticate 
    Request Body Schema: application/json
     * email - String 
     * password - String 

     *Note: To avoid complicating the system, the mail and password were 
      set statically in class UserDao. email - email@gmail.com, password - password*

To get started, you need to authenticate first by using to authenticate endpoint to obtain an access token. This token will be used to access other endpoints.

## Here's how you can get started:
   1. Call to authenticate endpoint and retrieve the accessToken from the response.
   2. Copy the accessToken and use it as a Bearer token in subsequent requests.

