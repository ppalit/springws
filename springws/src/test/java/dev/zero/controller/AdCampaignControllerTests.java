package dev.zero.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import dev.zero.Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class AdCampaignControllerTests {

	@Autowired
	private WebApplicationContext ctx;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	

	@Test
	public void testPostAdForPartnerId() throws Exception {
		String requestBody = new String("{" + "\"partner_id\": \"partner1\"," + "\"duration\": \"253500\","
				+ "\"ad_content\": \"string_of_content_to_display_as_ad\"" + "}");
	    this.mockMvc
				.perform(
						MockMvcRequestBuilders.post("/ad").content(requestBody).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
	

	}

	@Test
	public void testGetAdForPartnerId() throws Exception {

		String requestBody = new String("{" + "\"partner_id\": \"partner2\"," + "\"duration\": \"253500\","
				+ "\"ad_content\": \"string_of_content_to_display_as_ad\"" + "}");
		this.mockMvc
				.perform(
						MockMvcRequestBuilders.post("/ad").content(requestBody).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
		
		this.mockMvc.perform(get("/ad/partner2")).andDo(print()).andExpect(status().isOk())
				.andExpect(status().isOk());
	}
	
	@Test
	public void testGetAllAds() throws Exception {

		this.mockMvc.perform(get("/ad")).andDo(print()).andExpect(status().isOk())
				.andExpect(status().isOk());
	}
	
	@Test
	public void testPostAdForPartnerIdError() throws Exception {
		
		String requestBody = new String("{" + "\"partner_id\": \"partner3\"," + "\"duration\": \"253500\","
				+ "\"ad_content\": \"string_of_content_to_display_as_ad\"" + "}");
		this.mockMvc
				.perform(
						MockMvcRequestBuilders.post("/ad").content(requestBody).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
		
		String requestBody2 = new String("{" + "\"partner_id\": \"partner3\"," + "\"duration\": \"253500\","
				+ "\"ad_content\": \"string_of_content_to_display_as_ad\"" + "}");
		this.mockMvc
				.perform(
						MockMvcRequestBuilders.post("/ad").content(requestBody2).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isServiceUnavailable());

	}
	
	@Test
	public void testPostAdForPartnerIdMultiple() throws Exception {
		String requestBody = new String("{" + "\"partner_id\": \"partner4\"," + "\"duration\": \"100\","
				+ "\"ad_content\": \"string_of_content_to_display_as_ad\"" + "}");
		this.mockMvc
				.perform(
						MockMvcRequestBuilders.post("/ad").content(requestBody).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());
		Thread.sleep(110);
		this.mockMvc
		.perform(
				MockMvcRequestBuilders.post("/ad").content(requestBody).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isCreated());

	}
	

}