Please start project with docker compose.
Here are the requested endpoints:


###
GET http://localhost:8080/api/supervisors



###
POST http://localhost:8080/api/submit
Content-Type: application/json

{
"firstName": "John",
"lastName": "Smith",
"email": "johnsmith@gmail.com",
"phoneNumber": "",
"supervisor": "f"
}