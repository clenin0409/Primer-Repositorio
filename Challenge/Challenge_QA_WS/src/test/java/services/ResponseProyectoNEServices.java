package services;

import com.proyecto.WebServices.configs.Settings;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ResponseProyectoNEServices {

    public static String baseApiUri = Settings.UrlApiBase;
    public static String baseUriServices = Settings.UrlApiNEPath;

    public static Response postUser(String body) {
        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification(baseApiUri, baseUriServices, 0);
        String strBody = CommonServicesUtil.getBody(body);
        return new RestAssuredConfiguration().getResponsePost(requestSpecification.body(strBody), EndPointProyecto.POST_ADD);
    }
    public static Response putUser(String body) {
        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification(baseApiUri, baseUriServices, 0);
        String strBody = CommonServicesUtil.getBody(body);
        return new RestAssuredConfiguration().getResponsePost(requestSpecification.body(strBody), EndPointProyecto.PUT_EDIT);
    }
    public static Response getPet(String body) {
        RequestSpecification requestSpecification = new RestAssuredConfiguration().getRequestSpecification(baseApiUri, baseUriServices, 0);
        //String strBody = CommonServicesUtil.getBody(body);
        return new RestAssuredConfiguration().getResponseGet(requestSpecification, EndPointProyecto.GET_ID);
    }
}
