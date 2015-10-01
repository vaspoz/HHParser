package mongodb;

import com.google.code.linkedinapi.client.LinkedInApiClient;
import com.google.code.linkedinapi.client.LinkedInApiClientFactory;
import com.google.code.linkedinapi.schema.Person;

public class LinkedinJ {
    public static void main(String[] args) {
        String CONSUMER_KEY = "77o13rztd0g9ow";
        String CONSUMER_SECRET = "ZyKZSwYL5M1z3UQS";

        String ACCESS_TOKEN = "acd851cf-d360-4acd-96da-8c0006e666d3";
        String TOKEN_SECRET = "6dd484c4-5a65-457d-a365-138d95a10987";

        LinkedInApiClientFactory factory = LinkedInApiClientFactory.newInstance(CONSUMER_KEY, CONSUMER_SECRET);
        LinkedInApiClient client = factory.createLinkedInApiClient(ACCESS_TOKEN, TOKEN_SECRET);


        Person profile = client.getProfileById("132");
        System.out.println("Name:" + profile.getFirstName() + " " + profile.getLastName());
        System.out.println("Headline:" + profile.getHeadline());
        System.out.println("Summary:" + profile.getSummary());
        System.out.println("Industry:" + profile.getIndustry());
        System.out.println("Picture:" + profile.getPictureUrl());

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
