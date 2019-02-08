# sftp-rest-client
A REST endpoint to perform SFTP operations on any accessible server from the microservice's location.

You can use this service when you need a files be pulled from a remote servers which you 
do not have access, but a central location can be configured to. Just run this
service on the central location and issue REST calls to either transfer the file,
or echo it back on HTTP.

> Note of caution: Echoing binary files over HTTP may have unforeseen issues. 
> Recommended to use pulling to local location as file itself.
