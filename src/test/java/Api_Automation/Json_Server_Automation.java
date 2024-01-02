package Api_Automation;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Json_Server_Automation {

    @Test
    public void create_User(){
        Response response = given()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"id\": 11,\n" +
                        "    \"title\": \"Post\", \n" +
                        "        \"author\": \"Sushil\"\n" +
                        "    }")
                .when()
                .post("http://localhost:3000/posts");

        response.prettyPrint();

        String author = response.path("author");
        System.out.println(author);
        Assert.assertEquals(response.statusCode(), 201);
    }
    @Test
    public void get_User(){
        Response response = given()
                .header("Content-Type", "application/json")
                .get("http://localhost:3000/posts");
        response.prettyPrint();
    }

    @Test
    public void put_User_inPosts(){
        Response response = given()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"id\": 3,\n" +
                        "    \"title\": \"json-server\",\n" +
                        "    \"author\": \"json\"\n" +
                        "}")
                .when()
                .put("http://localhost:3000/posts/3");
        response.prettyPrint();
    }

    @Test
    public void patch_User_inPosts(){
        Response response = given()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "    \"title\" : \"jsonServer\"\n" +
                        "}")
                .when()
                .patch("http://localhost:3000/posts/3");
        response.prettyPrint();
    }
    @Test
    public void delete_User_inPosts(){
        Response response = given()
                .delete(" http://localhost:3000/posts/9");
        response.prettyPrint();
    }


    @Test
    public void get_All_Comments(){
        Response response = given()
                .get(" http://localhost:3000/comments");
        response.prettyPrint();
    }

    @Test
    public void create_Comments(){
        Response response = given()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "        \"id\": 4,\n" +
                        "        \"body\": \"task done\",\n" +
                        "        \"postId\": 4\n" +
                        "    }")
                .when()
                .post("http://localhost:3000/comments");
        response.prettyPrint();
    }
    @Test
    public void update_Comments(){
        Response response = given()
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "        \"id\": 4,\n" +
                        "        \"body\": \"done\",\n" +
                        "        \"postId\": 4\n" +
                        "    }")
                .when()
                .put("http://localhost:3000/comments/4");
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void delete_Comments(){
        Response response = given()
                .when()
                .delete("http://localhost:3000/comments/4");
        response.prettyPrint();
        //Assert.assertEquals(response.statusCode(), 200);
    }

}
