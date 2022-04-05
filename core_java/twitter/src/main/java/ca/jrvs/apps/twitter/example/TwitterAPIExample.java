package ca.jrvs.apps.twitter.example;

import com.google.gdata.util.common.base.PercentEscaper;
import java.util.Arrays;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class TwitterAPIExample {
	private static String CONSUMER_KEY;// = "GDENQbQDpn0Lql3L9B8NVq0gv";// System.getenv("consumerKey");
	private static String CONSUMER_SECRET;// = "5F6hpBuQ4Z5cNLLnS3DjWvTnRJ41LOMZqsuMDzjmcXpMdEDfsf";// System.getenv("consumerSecret");
	private static String ACCESS_TOKEN;// = "1489336471282753536-DC8XZkcZPu0wsYV6c1X0kKOd1AZF3O";// System.getenv("accessToken");
	private static String TOKEN_SECRET;// = "MOOGFcNTOZMrTW9y5wbW9QtooUeOaTyMruFUejBSHyijg";// System.getenv("accessSecret");

	public static void main(String[] args) throws Exception {
		CONSUMER_KEY = args[0];
		CONSUMER_SECRET = args[1];
		ACCESS_TOKEN = args[2];
		TOKEN_SECRET = args[3];

		OAuthConsumer consumer = new CommonsHttpOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
		consumer.setTokenWithSecret(ACCESS_TOKEN, TOKEN_SECRET);

		String username = "danny_nucci";
		PercentEscaper percentEscaper = new PercentEscaper("", false);
		HttpGet request = new HttpGet("https://api.twitter.com/1.1/users/lookup.json?screen_name=" + percentEscaper.escape(username));

		consumer.sign(request);

		System.out.println("Http Request Headers:");
		Arrays.stream(request.getAllHeaders()).forEach(System.out::println);

		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpResponse response = httpClient.execute(request);
		System.out.println(EntityUtils.toString(response.getEntity()));
	}
}