package client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class GetUser {

	public void getUser(String user) {
		try {
			Client client = Client.create();

			WebResource webResource = client.resource("http://localhost:8080/YAB-CVC-WS/REST/user/getUser?");

			ClientResponse response = webResource.queryParam("loginID", user).get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed: HTTP error code: " + response.getStatus());

			}

			String output = response.getEntity(String.class);

			System.out.println(output);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
