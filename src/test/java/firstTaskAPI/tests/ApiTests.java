package firstTaskAPI.tests;

import com.google.gson.Gson;
import firstTaskAPI.pojo.requests.PostData;
import firstTaskAPI.pojo.responses.PostResponse;
import firstTaskAPI.specification.Specification;
import org.testng.annotations.Test;

import static firstTaskAPI.specification.Specification.id;
import static firstTaskAPI.specification.Specification.installSpec;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class ApiTests {
    @Test
    public void testGetRequest() {
        installSpec(Specification.request(), Specification.response(200));

        PostResponse response = given()
                .when()
                .get("/posts/" + id)
                .then()
                .log().all()
                .extract()
                .as(PostResponse.class);

        assertNotNull(response.getTitle(), "Title field should not be null");
        System.out.println("Title: " + response.getTitle());
    }
    @Test
    public void testPostRequest() {
        installSpec(Specification.request(), Specification.response(201));

        PostData postData = new PostData("foo", "bar", 1);

        Gson gson = new Gson();
        String payload = gson.toJson(postData);

        io.restassured.response.Response response = given()
                .body(payload)
                .when()
                .post("/posts")
                .then()
                .log().all()
                .extract()
                .response();

        assertEquals(response.statusCode(), 201, "Status code should be 201");

        String id = response.jsonPath().getString("id");
        assertNotNull(id, "ID field should not be null");

        String title = response.jsonPath().getString("title");
        assertEquals(title, "foo", "Title should match payload");

        String body = response.jsonPath().getString("body");
        assertEquals(body, "bar", "Body should match payload");

        int userId = response.jsonPath().getInt("userId");
        assertEquals(userId, 1, "UserId should match payload");

        System.out.println("POST Response: " + response.asPrettyString());
    }
}
