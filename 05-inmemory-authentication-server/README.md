#in-memory oauthorization server 
SpringBoot Cloud based on the dependencies: <br>
- spring-cloud-starter-oauth2
- spring-cloud-starter-security
- spring-boot-starter-web

requestMatchers=[Ant [pattern='/oauth/token'], Ant [pattern='/oauth/token_key'], Ant [pattern='/oauth/check_token']]

Obtaining token:<br>
URL: port/oauth/token <br>
Method:POST<br>
Basic authorization: [username:client-id, password:client-secret] <br> 
Body:<br> 
    -grant_type:password<br>
    -username:user1<br>
    -password:userpass<br>
    -scope -> optional paramter<br>
<br>
Checking token:<br>
URL: http://localhost:8282/oauth/check_token?token={{token}} <br>
Method:GET<br>
*permitAll security setting allowed to access without client secret and id
<br>
 



