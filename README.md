# openfeign-issue-example-master
This is an example to reproduce the problem reported in [Feign compression is not working when using ApacheHttpClient in certain scenarios #725](https://github.com/spring-cloud/spring-cloud-openfeign/issues/725).

Steps:
1. Run the server application
2. Run the client application
3. set "custom.okhttp.enabled=false" in application.yml
4. HTTP GET from http://localhost:8002/client/get (you will get [accept-encoding:"gzip", "deflate", accept:"*/*", content-length:"0", host:"localhost:8001", connection:"Keep-Alive", user-agent:"Apache-HttpClient/4.5.13 (Java/11.0.1)"])
5. set "custom.okhttp.enabled=true" in application.yml
6. Rerun the client application
7. HTTP GET from http://localhost:8002/client/get (you will get [accept:"*/*", content-length:"0", host:"localhost:8001", connection:"Keep-Alive", user-agent:"Apache-HttpClient/4.5.13 (Java/11.0.1)"])


Phenomenon:
1. The header of FeignRequest is expected to be added with Accept-Encoding: gzip, deflate, because it is the function of FeignAcceptGzipEncodingAutoConfiguration and FeignAcceptGzipEncodingInterceptor, but it does not work now.
