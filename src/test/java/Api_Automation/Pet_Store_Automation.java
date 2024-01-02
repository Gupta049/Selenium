package Api_Automation;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class Pet_Store_Automation {
    @Test
    public void create_User(){
        Response response = given()
        .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"username\": \"Sushil\",\n" +
                        "  \"firstName\": \"sushil\",\n" +
                        "  \"lastName\": \"kumar gupta\",\n" +
                        "  \"email\": \"sushilgupta049@gmail.com\",\n" +
                        "  \"password\": \"Sushil\",\n" +
                        "  \"phone\": \"6205806083\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/user");
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void logs_user_into_System(){
        Response response = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .pathParam("userName", "Sushil")
                .pathParam("pass", "Sushil")
                .when()
                .get("https://petstore.swagger.io/v2/user/login?username={userName}&password={pass}");
        response.prettyPrint();

    }

    @Test
    public void update_User(){
        Response response = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"username\": \"Sushil\",\n" +
                        "  \"firstName\": \"Sushil\",\n" +
                        "  \"lastName\": \"Gupta\",\n" +
                        "  \"email\": \"skg123@gmail.com\",\n" +
                        "  \"password\": \"Sushil\",\n" +
                        "  \"phone\": \"6205806082\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .when()
                .put("https://petstore.swagger.io/v2/user/Sushil");
        response.prettyPrint();
    }
    @Test
    public void get_User_By_User_Name(){
        Response response = given()
                .header("accept", "application/json")
                .when()
                .get("https://petstore.swagger.io/v2/user/string");
        response.prettyPrint();
    }
    @Test
    public void create_List_of_User_withGiven_Array(){
        Response response = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body("[{\n" +
                        "  \"id\": 1,\n" +
                        "  \"username\": \"Sushil\",\n" +
                        "  \"firstName\": \"sushil\",\n" +
                        "  \"lastName\": \"kumar gupta\",\n" +
                        "  \"email\": \"sushilgupta049@gmail.com\",\n" +
                        "  \"password\": \"Sushil\",\n" +
                        "  \"phone\": \"6205806083\",\n" +
                        "  \"userStatus\": 0\n" +
                        "},\n" +
                        "{\n" +
                        "  \"id\": 2,\n" +
                        "  \"username\": \"Sandeep\",\n" +
                        "  \"firstName\": \"sandeep\",\n" +
                        "  \"lastName\": \"kumar gupta\",\n" +
                        "  \"email\": \"sg6717988@gmail.com\",\n" +
                        "  \"password\": \"Sandeep\",\n" +
                        "  \"phone\": \"6205806053\",\n" +
                        "  \"userStatus\": 1\n" +
                        "},\n" +
                        "{\n" +
                        "  \"id\": 3,\n" +
                        "  \"username\": \"Sheshnath\",\n" +
                        "  \"firstName\": \"sheshnath\",\n" +
                        "  \"lastName\": \"kumar gupta\",\n" +
                        "  \"email\": \"sheshnath432@gmail.com\",\n" +
                        "  \"password\": \"Sheshnath\",\n" +
                        "  \"phone\": \"6205806453\",\n" +
                        "  \"userStatus\": 2\n" +
                        "}\n" +
                        "]")
                .when()
                .post("https://petstore.swagger.io/v2/user/createWithArray");
        response.prettyPrint();
    }

    @Test
    public void create_List_of_User_withGiven_List(){
        Response response = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body("[{\n" +
                        "  \"id\": 1,\n" +
                        "  \"username\": \"Sushil\",\n" +
                        "  \"firstName\": \"sushil\",\n" +
                        "  \"lastName\": \"kumar gupta\",\n" +
                        "  \"email\": \"sushilgupta049@gmail.com\",\n" +
                        "  \"password\": \"Sushil\",\n" +
                        "  \"phone\": \"6205806083\",\n" +
                        "  \"userStatus\": 0\n" +
                        "},\n" +
                        "{\n" +
                        "  \"id\": 2,\n" +
                        "  \"username\": \"Sandeep\",\n" +
                        "  \"firstName\": \"sandeep\",\n" +
                        "  \"lastName\": \"kumar gupta\",\n" +
                        "  \"email\": \"sg6717988@gmail.com\",\n" +
                        "  \"password\": \"Sandeep\",\n" +
                        "  \"phone\": \"6205806053\",\n" +
                        "  \"userStatus\": 1\n" +
                        "},\n" +
                        "{\n" +
                        "  \"id\": 3,\n" +
                        "  \"username\": \"Sheshnath\",\n" +
                        "  \"firstName\": \"sheshnath\",\n" +
                        "  \"lastName\": \"kumar gupta\",\n" +
                        "  \"email\": \"sheshnath432@gmail.com\",\n" +
                        "  \"password\": \"Sheshnath\",\n" +
                        "  \"phone\": \"6205806453\",\n" +
                        "  \"userStatus\": 2\n" +
                        "}\n" +
                        "]")
                .when()
                .post("https://petstore.swagger.io/v2/user/createWithList");
        response.prettyPrint();
    }
    @Test
    public void delete_User(){
        Response response = given()
                .header("accept", "application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/user/string");
        response.prettyPrint();
    }

    @Test
    public  void logout_User(){
        Response response = given()
                .header("accept", "application")
                .when()
                .get("https://petstore.swagger.io/v2/user/logout");
        response.prettyPrint();
    }

    @Test
    public void uploads_anImage(){
        File file = new File("C:\\Users\\Sushil\\Desktop\\New_folder\\dog.jpg");

         Response response = given()
                .header("accept", "application/json")
                .header("Content-Type", "multipart/form-data")
                .multiPart(file)
                .when()
                 .post("https://petstore.swagger.io/v2/pet/123/uploadImage");
    response.prettyPrint();
    }
    @Test
    public void add_new_Pet_to_Store(){
        Response response = given()
                .header("accept", "application/json")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 11,\n" +
                        "    \"name\": \"beagle\"\n" +
                        "  },\n" +
                        "  \"name\": \"doggie\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"https://stock.adobe.com/in/images/adorable-golden-puppy/199007925\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 21,\n" +
                        "      \"name\": \"Small Dog Breeds\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/pet");
        response.prettyPrint();
    }

    @Test
    public void find_pet_by_Id(){
        Response response = given()
                .header("accept", "application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/1");
        response.prettyPrint();

        String photoUrl = response.path("photoUrls");
        System.out.println(photoUrl);

        Assert.assertEquals(response.statusCode(), 200);
    }
}
