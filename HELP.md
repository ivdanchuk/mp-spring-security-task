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

### Tasks
##Task
(1 star)
1. CREATE SPRING BOOT MVC PROJECT.
2. CREATE REST ENDPOINT "GET /INFO" THAT PROVIDE RANDOM STATS (EX: "MVC APPLICATION"). TEST THIS ENDPOINT.
3. ADD SPRING SECURITY MODULE TO YOUR PROJECT AND CONFIGURE IT FOR AUTHENTICATED ACCESS TO ALL RESOURCES. USE EMAIL/PASSWORD COMBINATION FOR IT.
   (2 stars)
4. 
5. USE A NON-EMBEDDED DB TO STORE USERS.
5. USE SALT AND HASHING TO STORE USER PASSWORDS.
6. CREATE ADDITIONAL REST ENDPOINT "GET /ABOUT" AND CONFIGURE NON-AUTHENTICATED ACCESS TO IT.
   (3-4 stars)
7. 
8. CREATE ONE MORE REST ENDPOINT "GET /ADMIN".
8. NOW YOU NEED TO ADD AUTHORISED ACCESS TO "GET /INFO" AND "GET /ADMIN", ADD " VIEW_INFO", "VIEW_ADMIN" PERMISSIONS FOR IT. CREATE 3 USERS WITH DIFFERENT COMBINATION OF PERMISSIONS.
9. CREATE NEW LOGIN/LOGOUT PAGES AND CONFIGURE SPRING SECURITY TO USE NEW LOGIN/LOGOUT.
10. ADD BRUTE FORCE PROTECTOR. BLOCK USER EMAIL FOR 5 MINUTE ON 3 UNSUCCESSFUL LOGIN.
11. CREATE AN ENDPOINT TO SHOW BLOCKED USERS
    (5 stars)
