package mongodb;

import freemarker.template.Configuration;
import freemarker.template.SimpleHash;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.bson.Document;
import spark.*;

import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import static spark.Spark.*;

public class SearcherController {
    private final Configuration cfg;
    private final LocalDatabase db;


    public SearcherController() throws IOException {

        db = new LocalDatabase();
        cfg = createFreemarkerConfiguration();
        setPort(8787);
        externalStaticFileLocation("src\\main\\resources\\freemarker");
        initializeRouts();

    }


    private Configuration createFreemarkerConfiguration() {

        Configuration retValue = new Configuration();
        retValue.setClassForTemplateLoading(SearcherController.class, "/freemarker");
        return retValue;

    }


    private void initializeRouts() throws IOException {

        get(new FreemarkerBaseRoutes("/", "") {
            @Override
            protected void doHandle(Request request, Response response, Writer writer) throws IOException, TemplateException {
                response.redirect("/hello");
            }
        });

        get(new FreemarkerBaseRoutes("/hello", "searchForm.html") {
            @Override
            protected void doHandle(Request request, Response response, Writer writer) throws IOException, TemplateException {
                SimpleHash root = new SimpleHash();

                root.put("defaultTitle", "Java Developer");
                root.put("defaultCountry", "Russia");

                template.process(root, writer);
            }
        });

        post(new FreemarkerBaseRoutes("/hello", "searchForm.html") {
            @Override
            protected void doHandle(Request request, Response response, Writer writer) throws IOException, TemplateException {
                String title = request.queryParams("title");
                String country = request.queryParams("country");

                String clearDB = request.queryParams("clearDBase");
                if (clearDB != null) {
                    db.clearDatabases();
                }

                db.collectDBfor(title, country);

                response.redirect("/results");
            }
        });

        get(new FreemarkerBaseRoutes("/results", "results-template.html") {
            @Override
            protected void doHandle(Request request, Response response, Writer writer) throws IOException, TemplateException {
                List<Document> vacancies = db.getCollectedVacancies();

                SimpleHash root = new SimpleHash();
                root.put("vacancies", vacancies);

                template.process(root, writer);
            }
        });

    }


    abstract class FreemarkerBaseRoutes extends Route {

        final Template template;

        protected FreemarkerBaseRoutes(final String path, final String templateName) throws IOException {
            super(path);
            template = cfg.getTemplate(templateName);
        }

        @Override
        public Object handle(Request request, Response response) {
            StringWriter writer = new StringWriter();
            try {
                doHandle(request, response, writer);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return writer;
        }

        protected abstract void doHandle(final Request request, final Response response, final Writer writer)
                throws IOException, TemplateException;

    }


    private String getFromCookie(Request request, String cookieName) {

        if (request.raw().getCookies() == null) {
            return null;
        }

        for (Cookie cookie : request.raw().getCookies()) {
            if (cookie.getName().equals(cookieName)) {
                return cookie.getValue();
            }
        }
        return null;

    }


    public static void main(String[] args) throws IOException {

        new SearcherController();

    }
}
