# Spring security task

### Add new user
POST http://localhost:8080/signup
Content-Type: application/json

{
"email": "test2@me.com",
"password": "1233"
}

### Set "authority" column manually for granting authorities to the users (use ',' as separator)
Ex1: "view_info"
Ex2: "view_info, view_admin"
