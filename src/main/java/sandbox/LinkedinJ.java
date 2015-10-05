package sandbox;

import com.google.code.linkedinapi.client.JobsApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClientFactory;
import com.google.code.linkedinapi.client.enumeration.SearchParameter;
import com.google.code.linkedinapi.schema.Job;
import com.google.code.linkedinapi.schema.Jobs;
import com.google.code.linkedinapi.schema.Person;

import java.util.EnumMap;
import java.util.Map;

public class LinkedinJ {
    public static void main(String[] args) {
        String CONSUMER_KEY = "77o13rztd0g9ow";
        String CONSUMER_SECRET = "ZyKZSwYL5M1z3UQS";

//        LinkedInOAuthService oauthService = LinkedInOAuthServiceFactory.getInstance().createLinkedInOAuthService(CONSUMER_KEY, CONSUMER_SECRET);
//        LinkedInRequestToken requestToken = oauthService.getOAuthRequestToken();
//        String authUrl = requestToken.getAuthorizationUrl();
//
//        System.out.println("Copy below link in web browser to authorize. Copy the PIN obtained\n" + authUrl);
//        System.out.println("Enter the PIN code:");
//
//        String pin;
//
//
//        Scanner s = new Scanner(System.in);
//        pin = s.next();
//        System.out.println("Fetching access token from LinkedIn...");
//
//        LinkedInAccessToken accessToken = oauthService.getOAuthAccessToken(requestToken, pin);
//        System.out.println("Access token : " + accessToken.getToken());
//        System.out.println("Token secret : " + accessToken.getTokenSecret());
//        final LinkedInApiClientFactory factory = LinkedInApiClientFactory.newInstance(CONSUMER_KEY, CONSUMER_SECRET);
//        final LinkedInApiClient client = factory.createLinkedInApiClient(accessToken);
//

        String ACCESS_TOKEN = "5bad4550-e624-4c3b-8cb0-f152c2d0e4cc";
        String TOKEN_SECRET = "4cc47e13-a2a2-46f1-8e41-59f11ce68394";

        LinkedInApiClientFactory factory = LinkedInApiClientFactory.newInstance(CONSUMER_KEY, CONSUMER_SECRET);
        LinkedInApiClient client = factory.createLinkedInApiClient(ACCESS_TOKEN, TOKEN_SECRET);


        JobsApiClient jobsApiClient = factory.createJobsApiClient(ACCESS_TOKEN, TOKEN_SECRET);

        Person profile = client.getProfileForCurrentUser();
        System.out.println("Name:" + profile.getFirstName() + " " + profile.getLastName());
        System.out.println("Headline:" + profile.getHeadline());
        System.out.println("Summary:" + profile.getSummary());

        Map<SearchParameter, String> searchParameters = new EnumMap<>(SearchParameter.class);
        searchParameters.put(SearchParameter.KEYWORDS, "Java developer");

        Jobs jobs = client.searchJobs(searchParameters);
        System.out.println("Total search result: " + jobs.getCount());
        for (Job job : jobs.getJobList()) {
            System.out.println("Description: " + job.getDescriptionSnippet());
            System.out.println("Company: " + job.getCompany().getName());
            System.out.println();
        }

//        LinkedInOAuthService oauthService;
//        LinkedInRequestToken requestToken;
//
//        com.google.code.linkedinapi.client.examples.ProfileApiExample
//        System.out.println("Fetching token..");
//        String authUrl = null;
//        String authToken, authTokenSecret;
//
//        oauthService = LinkedInOAuthServiceFactory.getInstance().createLinkedInOAuthService(CONSUMER_KEY, CONSUMER_SECRET);
//        requestToken = oauthService.getOAuthRequestToken();
//        authToken = requestToken.getToken();
//        authTokenSecret = requestToken.getTokenSecret();
//
//        System.out.println("Request token: " + requestToken);
//        System.out.println("Auth token: " + authToken);
//        System.out.println("Auth token secret: " + authTokenSecret);
//
//        authUrl = requestToken.getAuthorizationUrl();
//
//        System.out.println("Copy below link in web browser to authorize. Copy the PIN obtained\n" + authUrl);
//        System.out.println("Enter the PIN code:");
//
//        String pin;
//
//        try
//        {
//
//            Scanner s = new Scanner(System.in);
//            pin = s.next();
//            System.out.println("Fetching access token from LinkedIn...");
//
//            LinkedInAccessToken accessToken =  oauthService.getOAuthAccessToken(requestToken, pin);
//            System.out.println("Access token : " +  accessToken.getToken());
//            System.out.println("Token secret : " +  accessToken.getTokenSecret());
//            final LinkedInApiClientFactory factory =  LinkedInApiClientFactory.newInstance(CONSUMER_KEY, CONSUMER_SECRET);
//            final LinkedInApiClient client =  factory.createLinkedInApiClient(accessToken);
//
//            //posting status to profile
//            client.updateCurrentStatus("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX!");
//
//        }
//        finally
//        {
//            System.out.println("Updated status!");
//        }
//
//
//        Map<SearchParameter, String> searchParameters = new EnumMap<SearchParameter, String>(SearchParameter.class);
//        searchParameters.put(SearchParameter.KEYWORDS, "Java developer");


    }
}

