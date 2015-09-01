//import models.User;
import static org.fest.assertions.Assertions.assertThat;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.GET;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.fakeRequest;
import static play.test.Helpers.route;
import static play.test.Helpers.running;
import static play.test.Helpers.testServer;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

import play.libs.ws.WS;
import play.mvc.Result;

// todo: not using the right spring context when using fakeApplication()
public class ApplicationTest {

    @Test
    public void indexTemplate() {/*
        running(fakeApplication(), new Runnable() {
            public void run() {
                Form<User> form = Form.form(User.class);
                Html html = views.html.index.render(form);
                assertThat(contentType(html)).isEqualTo("text/html");
                assertThat(contentAsString(html)).contains("Welcome");
            }
        });*/
    }

    @Test
    public void callIndex() {/*
        Result result = callAction(controllers.routes.ref.Application.index());
        assertThat(status(result)).isEqualTo(OK);
        assertThat(contentType(result)).isEqualTo("text/html");
        assertThat(charset(result)).isEqualTo("utf-8");
        assertThat(contentAsString(result)).contains("Welcome");*/
    }

    @Test
    public void callAddUser() {/*
        running(fakeApplication(), new Runnable() {
            public void run() {
                Map<String, String> formParams = new HashMap<String, String>();
                formParams.put("name", "foo");
                
                FakeRequest fakeRequest = fakeRequest().withFormUrlEncodedBody(formParams);
                
                Result result = callAction(controllers.routes.ref.Application.addUser(), fakeRequest);
                assertThat(status(result)).isEqualTo(SEE_OTHER);
            }
        });*/
    }

    @Test
    public void callListUsers() {
    	/*
        running(fakeApplication(), new Runnable() {
            public void run() {
                Map<String, String> formParams = new HashMap<String, String>();
                formParams.put("name", "foo");

                FakeRequest fakeRequest = fakeRequest().withFormUrlEncodedBody(formParams);

                callAction(controllers.routes.ref.Application.addUser(), fakeRequest);
                
                Result result = callAction(controllers.routes.ref.Application.listUsers());
                assertThat(status(result)).isEqualTo(OK);
                assertThat(contentType(result)).isEqualTo("application/json");
                assertThat(contentAsString(result)).startsWith("[");
                assertThat(contentAsString(result)).contains("foo");
            }
        });*/
    }

    @Test
    public void UsersRoute() {
        running(fakeApplication(), new Runnable() {
            @Override
			public void run() {
                Result result = route(fakeRequest(GET, "/users"));
                assertThat(result).isNotNull();
            }
        });
    }

    @Test
    public void realUsersRequest() {
        running(testServer(3333), new Runnable() {
            @Override
			public void run() {
                assertThat(WS.url("http://localhost:3333/users").get().get(5, TimeUnit.SECONDS).getStatus()).isEqualTo(OK);
            }
        });
    }

}