# User ingest

## User Technical Coding Challenge
I used this technical coding challenge to learn about how to make a connection with [HTTPClient](https://docs.oracle.com/en/java/javase/12/docs/api/java.net.http/java/net/http/HttpClient.html) , send a [HTTPRequest](https://docs.oracle.com/en/java/javase/12/docs/api/java.net.http/java/net/http/HttpRequest.html), retrieve the [HTTPResponse](https://docs.oracle.com/en/java/javase/12/docs/api/java.net.http/java/net/http/HttpResponse.html) and manipulate the JSONObject to populate a Java Object for ease of use internally. It was a good task to learn about the web components that are available to use in Java which I had minimum exposure previously.

### Previous commit in [abpai94/coding-tests](https://github.com/abpai94/coding-tests)
* [Commit 6d26547](https://github.com/abpai94/coding-tests/commit/2fac63e61decb4cf5f3ec1b6e512fbf59d9db846) Created a User object framework, tested out HTTPClient, HTTPRequest, HTTPResponse, JSONObject and JSONArray in order to create a connection, create a request, GET a response, read the object, obtain the user data and create Java User object using the JSON object response.
* [Commit 2fac63e](https://github.com/abpai94/coding-tests/commit/7752f50ce14236e2d7a5ba902f7b142a8723c144) Modified pom.xml structure to highlight the purpose of each dependency being added as well as adding new dependencies for HTTP, JSON and Logging components.
* [Commit 9d524c4](https://github.com/abpai94/coding-tests/commit/fd22a01a6baaf9f1b9678bd01db382bd5de9d5a1) Finished implementing UserClient, cleaned up User object and wrote UserClientTest.
* [Commit fd22a01](https://github.com/abpai94/coding-tests/commit/2da6e4b53c6caa790ff51100cfd12bfe9075ef9d) Completed the Users challenge, moved to the completed package.