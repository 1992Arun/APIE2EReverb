package org.utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.postRequest.Condition;
import org.postRequest.Domestic;
import org.postRequest.Parent;
import org.postRequest.Price;
import org.postRequest.Shipping;
import org.putRequestBody.PutCondition;
import org.putRequestBody.PutParent;
import org.putRequestBody.PutPrice;

import io.restassured.response.Response;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Utility {


	public static String getResponseBody(Response response) {

		return response.getBody().asString();

	}

	public static int getResponseCode(Response response) {

		return response.getStatusCode();

	}

	public static String schema() {
		
		return "{\r\n" + 
				"  \"type\": \"object\",\r\n" + 
				"  \"properties\": {\r\n" + 
				"    \"message\": {\r\n" + 
				"      \"type\": \"string\"\r\n" + 
				"    },\r\n" + 
				"    \"listing\": {\r\n" + 
				"      \"type\": \"object\",\r\n" + 
				"      \"properties\": {\r\n" + 
				"        \"id\": {\r\n" + 
				"          \"type\": \"integer\"\r\n" + 
				"        },\r\n" + 
				"        \"make\": {\r\n" + 
				"          \"type\": \"string\"\r\n" + 
				"        },\r\n" + 
				"        \"model\": {\r\n" + 
				"          \"type\": \"string\"\r\n" + 
				"        },\r\n" + 
				"        \"finish\": {\r\n" + 
				"          \"type\": \"string\"\r\n" + 
				"        },\r\n" + 
				"        \"year\": {\r\n" + 
				"          \"type\": \"string\"\r\n" + 
				"        },\r\n" + 
				"        \"title\": {\r\n" + 
				"          \"type\": \"string\"\r\n" + 
				"        },\r\n" + 
				"        \"created_at\": {\r\n" + 
				"          \"type\": \"string\"\r\n" + 
				"        },\r\n" + 
				"        \"description\": {\r\n" + 
				"          \"type\": \"string\"\r\n" + 
				"        },\r\n" + 
				"        \"condition\": {\r\n" + 
				"          \"type\": \"object\",\r\n" + 
				"          \"properties\": {\r\n" + 
				"            \"uuid\": {\r\n" + 
				"              \"type\": \"string\"\r\n" + 
				"            },\r\n" + 
				"            \"display_name\": {\r\n" + 
				"              \"type\": \"string\"\r\n" + 
				"            },\r\n" + 
				"            \"description\": {\r\n" + 
				"              \"type\": \"string\"\r\n" + 
				"            }\r\n" + 
				"          },\r\n" + 
				"          \"required\": [\r\n" + 
				"            \"uuid\",\r\n" + 
				"            \"display_name\",\r\n" + 
				"            \"description\"\r\n" + 
				"          ]\r\n" + 
				"        },\r\n" + 
				"        \"price\": {\r\n" + 
				"          \"type\": \"object\",\r\n" + 
				"          \"properties\": {\r\n" + 
				"            \"amount\": {\r\n" + 
				"              \"type\": \"string\"\r\n" + 
				"            },\r\n" + 
				"            \"amount_cents\": {\r\n" + 
				"              \"type\": \"integer\"\r\n" + 
				"            },\r\n" + 
				"            \"currency\": {\r\n" + 
				"              \"type\": \"string\"\r\n" + 
				"            },\r\n" + 
				"            \"symbol\": {\r\n" + 
				"              \"type\": \"string\"\r\n" + 
				"            },\r\n" + 
				"            \"display\": {\r\n" + 
				"              \"type\": \"string\"\r\n" + 
				"            }\r\n" + 
				"          },\r\n" + 
				"          \"required\": [\r\n" + 
				"            \"amount\",\r\n" + 
				"            \"amount_cents\",\r\n" + 
				"            \"currency\",\r\n" + 
				"            \"symbol\",\r\n" + 
				"            \"display\"\r\n" + 
				"          ]\r\n" + 
				"        },\r\n" + 
				"        \"inventory\": {\r\n" + 
				"          \"type\": \"integer\"\r\n" + 
				"        },\r\n" + 
				"        \"has_inventory\": {\r\n" + 
				"          \"type\": \"boolean\"\r\n" + 
				"        },\r\n" + 
				"        \"offers_enabled\": {\r\n" + 
				"          \"type\": \"boolean\"\r\n" + 
				"        },\r\n" + 
				"        \"auction\": {\r\n" + 
				"          \"type\": \"boolean\"\r\n" + 
				"        },\r\n" + 
				"        \"categories\": {\r\n" + 
				"          \"type\": \"array\",\r\n" + 
				"          \"items\": {}\r\n" + 
				"        },\r\n" + 
				"        \"listing_currency\": {\r\n" + 
				"          \"type\": \"string\"\r\n" + 
				"        },\r\n" + 
				"        \"buyer_price\": {\r\n" + 
				"          \"type\": \"object\",\r\n" + 
				"          \"properties\": {\r\n" + 
				"            \"amount\": {\r\n" + 
				"              \"type\": \"string\"\r\n" + 
				"            },\r\n" + 
				"            \"amount_cents\": {\r\n" + 
				"              \"type\": \"integer\"\r\n" + 
				"            },\r\n" + 
				"            \"currency\": {\r\n" + 
				"              \"type\": \"string\"\r\n" + 
				"            },\r\n" + 
				"            \"symbol\": {\r\n" + 
				"              \"type\": \"string\"\r\n" + 
				"            },\r\n" + 
				"            \"display\": {\r\n" + 
				"              \"type\": \"string\"\r\n" + 
				"            },\r\n" + 
				"            \"tax_included_hint\": {\r\n" + 
				"              \"type\": \"string\"\r\n" + 
				"            },\r\n" + 
				"            \"tax_included\": {\r\n" + 
				"              \"type\": \"boolean\"\r\n" + 
				"            },\r\n" + 
				"            \"tax_included_rate\": {\r\n" + 
				"              \"type\": \"integer\"\r\n" + 
				"            }\r\n" + 
				"          },\r\n" + 
				"          \"required\": [\r\n" + 
				"            \"amount\",\r\n" + 
				"            \"amount_cents\",\r\n" + 
				"            \"currency\",\r\n" + 
				"            \"symbol\",\r\n" + 
				"            \"display\",\r\n" + 
				"            \"tax_included_hint\",\r\n" + 
				"            \"tax_included\",\r\n" + 
				"            \"tax_included_rate\"\r\n" + 
				"          ]\r\n" + 
				"        },\r\n" + 
				"        \"seller_price\": {\r\n" + 
				"          \"type\": \"object\",\r\n" + 
				"          \"properties\": {\r\n" + 
				"            \"amount\": {\r\n" + 
				"              \"type\": \"string\"\r\n" + 
				"            },\r\n" + 
				"            \"amount_cents\": {\r\n" + 
				"              \"type\": \"integer\"\r\n" + 
				"            },\r\n" + 
				"            \"currency\": {\r\n" + 
				"              \"type\": \"string\"\r\n" + 
				"            },\r\n" + 
				"            \"symbol\": {\r\n" + 
				"              \"type\": \"string\"\r\n" + 
				"            },\r\n" + 
				"            \"display\": {\r\n" + 
				"              \"type\": \"string\"\r\n" + 
				"            }\r\n" + 
				"          },\r\n" + 
				"          \"required\": [\r\n" + 
				"            \"amount\",\r\n" + 
				"            \"amount_cents\",\r\n" + 
				"            \"currency\",\r\n" + 
				"            \"symbol\",\r\n" + 
				"            \"display\"\r\n" + 
				"          ]\r\n" + 
				"        },\r\n" + 
				"        \"state\": {\r\n" + 
				"          \"type\": \"object\",\r\n" + 
				"          \"properties\": {\r\n" + 
				"            \"slug\": {\r\n" + 
				"              \"type\": \"string\"\r\n" + 
				"            },\r\n" + 
				"            \"description\": {\r\n" + 
				"              \"type\": \"string\"\r\n" + 
				"            }\r\n" + 
				"          },\r\n" + 
				"          \"required\": [\r\n" + 
				"            \"slug\",\r\n" + 
				"            \"description\"\r\n" + 
				"          ]\r\n" + 
				"        },\r\n" + 
				"        \"wanted\": {\r\n" + 
				"          \"type\": \"boolean\"\r\n" + 
				"        },\r\n" + 
				"        \"accepted_payment_methods\": {\r\n" + 
				"          \"type\": \"array\",\r\n" + 
				"          \"items\": {}\r\n" + 
				"        },\r\n" + 
				"        \"location\": {\r\n" + 
				"          \"type\": \"object\",\r\n" + 
				"          \"properties\": {\r\n" + 
				"            \"display_location\": {\r\n" + 
				"              \"type\": \"null\"\r\n" + 
				"            }\r\n" + 
				"          },\r\n" + 
				"          \"required\": [\r\n" + 
				"            \"display_location\"\r\n" + 
				"          ]\r\n" + 
				"        },\r\n" + 
				"        \"draft\": {\r\n" + 
				"          \"type\": \"boolean\"\r\n" + 
				"        },\r\n" + 
				"        \"live\": {\r\n" + 
				"          \"type\": \"boolean\"\r\n" + 
				"        },\r\n" + 
				"        \"local_pickup_only\": {\r\n" + 
				"          \"type\": \"boolean\"\r\n" + 
				"        },\r\n" + 
				"        \"cloudinary_photos\": {\r\n" + 
				"          \"type\": \"array\",\r\n" + 
				"          \"items\": {}\r\n" + 
				"        },\r\n" + 
				"        \"shop\": {\r\n" + 
				"          \"type\": \"object\",\r\n" + 
				"          \"properties\": {\r\n" + 
				"            \"feedback_count\": {\r\n" + 
				"              \"type\": \"integer\"\r\n" + 
				"            },\r\n" + 
				"            \"preferred_seller\": {\r\n" + 
				"              \"type\": \"boolean\"\r\n" + 
				"            },\r\n" + 
				"            \"rating_percentage\": {\r\n" + 
				"              \"type\": \"number\"\r\n" + 
				"            }\r\n" + 
				"          },\r\n" + 
				"          \"required\": [\r\n" + 
				"            \"feedback_count\",\r\n" + 
				"            \"preferred_seller\",\r\n" + 
				"            \"rating_percentage\"\r\n" + 
				"          ]\r\n" + 
				"        },\r\n" + 
				"        \"stats\": {\r\n" + 
				"          \"type\": \"object\",\r\n" + 
				"          \"properties\": {\r\n" + 
				"            \"views\": {\r\n" + 
				"              \"type\": \"integer\"\r\n" + 
				"            },\r\n" + 
				"            \"watches\": {\r\n" + 
				"              \"type\": \"integer\"\r\n" + 
				"            }\r\n" + 
				"          },\r\n" + 
				"          \"required\": [\r\n" + 
				"            \"views\",\r\n" + 
				"            \"watches\"\r\n" + 
				"          ]\r\n" + 
				"        },\r\n" + 
				"        \"offer_count\": {\r\n" + 
				"          \"type\": \"integer\"\r\n" + 
				"        },\r\n" + 
				"        \"shipping_policy\": {\r\n" + 
				"          \"type\": \"string\"\r\n" + 
				"        },\r\n" + 
				"        \"payment_policy\": {\r\n" + 
				"          \"type\": \"string\"\r\n" + 
				"        },\r\n" + 
				"        \"sold_as_is\": {\r\n" + 
				"          \"type\": \"boolean\"\r\n" + 
				"        },\r\n" + 
				"        \"same_day_shipping_ineligible\": {\r\n" + 
				"          \"type\": \"boolean\"\r\n" + 
				"        },\r\n" + 
				"        \"return_policy\": {\r\n" + 
				"          \"type\": \"object\"\r\n" + 
				"        },\r\n" + 
				"        \"videos\": {\r\n" + 
				"          \"type\": \"array\",\r\n" + 
				"          \"items\": {}\r\n" + 
				"        },\r\n" + 
				"        \"is_my_listing\": {\r\n" + 
				"          \"type\": \"boolean\"\r\n" + 
				"        },\r\n" + 
				"        \"photos\": {\r\n" + 
				"          \"type\": \"array\",\r\n" + 
				"          \"items\": {}\r\n" + 
				"        },\r\n" + 
				"        \"shipping\": {\r\n" + 
				"          \"type\": \"object\",\r\n" + 
				"          \"properties\": {\r\n" + 
				"            \"local\": {\r\n" + 
				"              \"type\": \"boolean\"\r\n" + 
				"            },\r\n" + 
				"            \"rates\": {\r\n" + 
				"              \"type\": \"array\",\r\n" + 
				"              \"items\": {}\r\n" + 
				"            },\r\n" + 
				"            \"initial_offer_rate\": {\r\n" + 
				"              \"type\": \"object\",\r\n" + 
				"              \"properties\": {\r\n" + 
				"                \"region_code\": {\r\n" + 
				"                  \"type\": \"null\"\r\n" + 
				"                },\r\n" + 
				"                \"rate\": {\r\n" + 
				"                  \"type\": \"object\",\r\n" + 
				"                  \"properties\": {\r\n" + 
				"                    \"original\": {\r\n" + 
				"                      \"type\": \"object\",\r\n" + 
				"                      \"properties\": {\r\n" + 
				"                        \"amount\": {\r\n" + 
				"                          \"type\": \"string\"\r\n" + 
				"                        },\r\n" + 
				"                        \"amount_cents\": {\r\n" + 
				"                          \"type\": \"integer\"\r\n" + 
				"                        },\r\n" + 
				"                        \"currency\": {\r\n" + 
				"                          \"type\": \"string\"\r\n" + 
				"                        },\r\n" + 
				"                        \"symbol\": {\r\n" + 
				"                          \"type\": \"string\"\r\n" + 
				"                        },\r\n" + 
				"                        \"display\": {\r\n" + 
				"                          \"type\": \"string\"\r\n" + 
				"                        }\r\n" + 
				"                      },\r\n" + 
				"                      \"required\": [\r\n" + 
				"                        \"amount\",\r\n" + 
				"                        \"amount_cents\",\r\n" + 
				"                        \"currency\",\r\n" + 
				"                        \"symbol\",\r\n" + 
				"                        \"display\"\r\n" + 
				"                      ]\r\n" + 
				"                    },\r\n" + 
				"                    \"display\": {\r\n" + 
				"                      \"type\": \"object\",\r\n" + 
				"                      \"properties\": {\r\n" + 
				"                        \"amount\": {\r\n" + 
				"                          \"type\": \"string\"\r\n" + 
				"                        },\r\n" + 
				"                        \"amount_cents\": {\r\n" + 
				"                          \"type\": \"integer\"\r\n" + 
				"                        },\r\n" + 
				"                        \"currency\": {\r\n" + 
				"                          \"type\": \"string\"\r\n" + 
				"                        },\r\n" + 
				"                        \"symbol\": {\r\n" + 
				"                          \"type\": \"string\"\r\n" + 
				"                        },\r\n" + 
				"                        \"display\": {\r\n" + 
				"                          \"type\": \"string\"\r\n" + 
				"                        }\r\n" + 
				"                      },\r\n" + 
				"                      \"required\": [\r\n" + 
				"                        \"amount\",\r\n" + 
				"                        \"amount_cents\",\r\n" + 
				"                        \"currency\",\r\n" + 
				"                        \"symbol\",\r\n" + 
				"                        \"display\"\r\n" + 
				"                      ]\r\n" + 
				"                    }\r\n" + 
				"                  },\r\n" + 
				"                  \"required\": [\r\n" + 
				"                    \"original\",\r\n" + 
				"                    \"display\"\r\n" + 
				"                  ]\r\n" + 
				"                },\r\n" + 
				"                \"carrier_calculated\": {\r\n" + 
				"                  \"type\": \"boolean\"\r\n" + 
				"                },\r\n" + 
				"                \"regional\": {\r\n" + 
				"                  \"type\": \"boolean\"\r\n" + 
				"                },\r\n" + 
				"                \"destination_postal_code_needed\": {\r\n" + 
				"                  \"type\": \"boolean\"\r\n" + 
				"                }\r\n" + 
				"              },\r\n" + 
				"              \"required\": [\r\n" + 
				"                \"region_code\",\r\n" + 
				"                \"rate\",\r\n" + 
				"                \"carrier_calculated\",\r\n" + 
				"                \"regional\",\r\n" + 
				"                \"destination_postal_code_needed\"\r\n" + 
				"              ]\r\n" + 
				"            },\r\n" + 
				"            \"free_expedited_shipping\": {\r\n" + 
				"              \"type\": \"boolean\"\r\n" + 
				"            }\r\n" + 
				"          },\r\n" + 
				"          \"required\": [\r\n" + 
				"            \"local\",\r\n" + 
				"            \"rates\",\r\n" + 
				"            \"initial_offer_rate\",\r\n" + 
				"            \"free_expedited_shipping\"\r\n" + 
				"          ]\r\n" + 
				"        },\r\n" + 
				"        \"seller\": {\r\n" + 
				"          \"type\": \"object\",\r\n" + 
				"          \"properties\": {\r\n" + 
				"            \"paypal_email\": {\r\n" + 
				"              \"type\": \"null\"\r\n" + 
				"            }\r\n" + 
				"          },\r\n" + 
				"          \"required\": [\r\n" + 
				"            \"paypal_email\"\r\n" + 
				"          ]\r\n" + 
				"        },\r\n" + 
				"        \"_links\": {\r\n" + 
				"          \"type\": \"object\",\r\n" + 
				"          \"properties\": {\r\n" + 
				"            \"photo\": {\r\n" + 
				"              \"type\": \"object\",\r\n" + 
				"              \"properties\": {\r\n" + 
				"                \"href\": {\r\n" + 
				"                  \"type\": \"string\"\r\n" + 
				"                }\r\n" + 
				"              },\r\n" + 
				"              \"required\": [\r\n" + 
				"                \"href\"\r\n" + 
				"              ]\r\n" + 
				"            },\r\n" + 
				"            \"self\": {\r\n" + 
				"              \"type\": \"object\",\r\n" + 
				"              \"properties\": {\r\n" + 
				"                \"href\": {\r\n" + 
				"                  \"type\": \"string\"\r\n" + 
				"                }\r\n" + 
				"              },\r\n" + 
				"              \"required\": [\r\n" + 
				"                \"href\"\r\n" + 
				"              ]\r\n" + 
				"            },\r\n" + 
				"            \"update\": {\r\n" + 
				"              \"type\": \"object\",\r\n" + 
				"              \"properties\": {\r\n" + 
				"                \"method\": {\r\n" + 
				"                  \"type\": \"string\"\r\n" + 
				"                },\r\n" + 
				"                \"href\": {\r\n" + 
				"                  \"type\": \"string\"\r\n" + 
				"                }\r\n" + 
				"              },\r\n" + 
				"              \"required\": [\r\n" + 
				"                \"method\",\r\n" + 
				"                \"href\"\r\n" + 
				"              ]\r\n" + 
				"            },\r\n" + 
				"            \"end\": {\r\n" + 
				"              \"type\": \"object\",\r\n" + 
				"              \"properties\": {\r\n" + 
				"                \"method\": {\r\n" + 
				"                  \"type\": \"string\"\r\n" + 
				"                },\r\n" + 
				"                \"href\": {\r\n" + 
				"                  \"type\": \"string\"\r\n" + 
				"                }\r\n" + 
				"              },\r\n" + 
				"              \"required\": [\r\n" + 
				"                \"method\",\r\n" + 
				"                \"href\"\r\n" + 
				"              ]\r\n" + 
				"            },\r\n" + 
				"            \"want\": {\r\n" + 
				"              \"type\": \"object\",\r\n" + 
				"              \"properties\": {\r\n" + 
				"                \"method\": {\r\n" + 
				"                  \"type\": \"string\"\r\n" + 
				"                },\r\n" + 
				"                \"href\": {\r\n" + 
				"                  \"type\": \"string\"\r\n" + 
				"                }\r\n" + 
				"              },\r\n" + 
				"              \"required\": [\r\n" + 
				"                \"method\",\r\n" + 
				"                \"href\"\r\n" + 
				"              ]\r\n" + 
				"            },\r\n" + 
				"            \"unwant\": {\r\n" + 
				"              \"type\": \"object\",\r\n" + 
				"              \"properties\": {\r\n" + 
				"                \"method\": {\r\n" + 
				"                  \"type\": \"string\"\r\n" + 
				"                },\r\n" + 
				"                \"href\": {\r\n" + 
				"                  \"type\": \"string\"\r\n" + 
				"                }\r\n" + 
				"              },\r\n" + 
				"              \"required\": [\r\n" + 
				"                \"method\",\r\n" + 
				"                \"href\"\r\n" + 
				"              ]\r\n" + 
				"            },\r\n" + 
				"            \"edit\": {\r\n" + 
				"              \"type\": \"object\",\r\n" + 
				"              \"properties\": {\r\n" + 
				"                \"href\": {\r\n" + 
				"                  \"type\": \"string\"\r\n" + 
				"                }\r\n" + 
				"              },\r\n" + 
				"              \"required\": [\r\n" + 
				"                \"href\"\r\n" + 
				"              ]\r\n" + 
				"            },\r\n" + 
				"            \"web\": {\r\n" + 
				"              \"type\": \"object\",\r\n" + 
				"              \"properties\": {\r\n" + 
				"                \"href\": {\r\n" + 
				"                  \"type\": \"string\"\r\n" + 
				"                }\r\n" + 
				"              },\r\n" + 
				"              \"required\": [\r\n" + 
				"                \"href\"\r\n" + 
				"              ]\r\n" + 
				"            },\r\n" + 
				"            \"make_offer\": {\r\n" + 
				"              \"type\": \"object\",\r\n" + 
				"              \"properties\": {\r\n" + 
				"                \"method\": {\r\n" + 
				"                  \"type\": \"string\"\r\n" + 
				"                },\r\n" + 
				"                \"href\": {\r\n" + 
				"                  \"type\": \"string\"\r\n" + 
				"                }\r\n" + 
				"              },\r\n" + 
				"              \"required\": [\r\n" + 
				"                \"method\",\r\n" + 
				"                \"href\"\r\n" + 
				"              ]\r\n" + 
				"            },\r\n" + 
				"            \"cart\": {\r\n" + 
				"              \"type\": \"object\",\r\n" + 
				"              \"properties\": {\r\n" + 
				"                \"href\": {\r\n" + 
				"                  \"type\": \"string\"\r\n" + 
				"                }\r\n" + 
				"              },\r\n" + 
				"              \"required\": [\r\n" + 
				"                \"href\"\r\n" + 
				"              ]\r\n" + 
				"            },\r\n" + 
				"            \"buy\": {\r\n" + 
				"              \"type\": \"object\",\r\n" + 
				"              \"properties\": {\r\n" + 
				"                \"href\": {\r\n" + 
				"                  \"type\": \"string\"\r\n" + 
				"                }\r\n" + 
				"              },\r\n" + 
				"              \"required\": [\r\n" + 
				"                \"href\"\r\n" + 
				"              ]\r\n" + 
				"            },\r\n" + 
				"            \"flag\": {\r\n" + 
				"              \"type\": \"object\",\r\n" + 
				"              \"properties\": {\r\n" + 
				"                \"href\": {\r\n" + 
				"                  \"type\": \"string\"\r\n" + 
				"                }\r\n" + 
				"              },\r\n" + 
				"              \"required\": [\r\n" + 
				"                \"href\"\r\n" + 
				"              ]\r\n" + 
				"            },\r\n" + 
				"            \"contact_seller\": {\r\n" + 
				"              \"type\": \"object\",\r\n" + 
				"              \"properties\": {\r\n" + 
				"                \"web\": {\r\n" + 
				"                  \"type\": \"object\",\r\n" + 
				"                  \"properties\": {\r\n" + 
				"                    \"href\": {\r\n" + 
				"                      \"type\": \"string\"\r\n" + 
				"                    }\r\n" + 
				"                  },\r\n" + 
				"                  \"required\": [\r\n" + 
				"                    \"href\"\r\n" + 
				"                  ]\r\n" + 
				"                }\r\n" + 
				"              },\r\n" + 
				"              \"required\": [\r\n" + 
				"                \"web\"\r\n" + 
				"              ]\r\n" + 
				"            },\r\n" + 
				"            \"conversations\": {\r\n" + 
				"              \"type\": \"object\",\r\n" + 
				"              \"properties\": {\r\n" + 
				"                \"href\": {\r\n" + 
				"                  \"type\": \"string\"\r\n" + 
				"                }\r\n" + 
				"              },\r\n" + 
				"              \"required\": [\r\n" + 
				"                \"href\"\r\n" + 
				"              ]\r\n" + 
				"            },\r\n" + 
				"            \"shop\": {\r\n" + 
				"              \"type\": \"object\",\r\n" + 
				"              \"properties\": {\r\n" + 
				"                \"href\": {\r\n" + 
				"                  \"type\": \"string\"\r\n" + 
				"                },\r\n" + 
				"                \"web\": {\r\n" + 
				"                  \"type\": \"object\",\r\n" + 
				"                  \"properties\": {\r\n" + 
				"                    \"href\": {\r\n" + 
				"                      \"type\": \"string\"\r\n" + 
				"                    }\r\n" + 
				"                  },\r\n" + 
				"                  \"required\": [\r\n" + 
				"                    \"href\"\r\n" + 
				"                  ]\r\n" + 
				"                }\r\n" + 
				"              },\r\n" + 
				"              \"required\": [\r\n" + 
				"                \"href\",\r\n" + 
				"                \"web\"\r\n" + 
				"              ]\r\n" + 
				"            },\r\n" + 
				"            \"sales\": {\r\n" + 
				"              \"type\": \"object\",\r\n" + 
				"              \"properties\": {\r\n" + 
				"                \"href\": {\r\n" + 
				"                  \"type\": \"string\"\r\n" + 
				"                }\r\n" + 
				"              },\r\n" + 
				"              \"required\": [\r\n" + 
				"                \"href\"\r\n" + 
				"              ]\r\n" + 
				"            }\r\n" + 
				"          },\r\n" + 
				"          \"required\": [\r\n" + 
				"            \"photo\",\r\n" + 
				"            \"self\",\r\n" + 
				"            \"update\",\r\n" + 
				"            \"end\",\r\n" + 
				"            \"want\",\r\n" + 
				"            \"unwant\",\r\n" + 
				"            \"edit\",\r\n" + 
				"            \"web\",\r\n" + 
				"            \"make_offer\",\r\n" + 
				"            \"cart\",\r\n" + 
				"            \"buy\",\r\n" + 
				"            \"flag\",\r\n" + 
				"            \"contact_seller\",\r\n" + 
				"            \"conversations\",\r\n" + 
				"            \"shop\",\r\n" + 
				"            \"sales\"\r\n" + 
				"          ]\r\n" + 
				"        }\r\n" + 
				"      },\r\n" + 
				"      \"required\": [\r\n" + 
				"        \"id\",\r\n" + 
				"        \"make\",\r\n" + 
				"        \"model\",\r\n" + 
				"        \"finish\",\r\n" + 
				"        \"year\",\r\n" + 
				"        \"title\",\r\n" + 
				"        \"created_at\",\r\n" + 
				"        \"description\",\r\n" + 
				"        \"condition\",\r\n" + 
				"        \"price\",\r\n" + 
				"        \"inventory\",\r\n" + 
				"        \"has_inventory\",\r\n" + 
				"        \"offers_enabled\",\r\n" + 
				"        \"auction\",\r\n" + 
				"        \"categories\",\r\n" + 
				"        \"listing_currency\",\r\n" + 
				"        \"buyer_price\",\r\n" + 
				"        \"seller_price\",\r\n" + 
				"        \"state\",\r\n" + 
				"        \"wanted\",\r\n" + 
				"        \"accepted_payment_methods\",\r\n" + 
				"        \"location\",\r\n" + 
				"        \"draft\",\r\n" + 
				"        \"live\",\r\n" + 
				"        \"local_pickup_only\",\r\n" + 
				"        \"cloudinary_photos\",\r\n" + 
				"        \"shop\",\r\n" + 
				"        \"stats\",\r\n" + 
				"        \"offer_count\",\r\n" + 
				"        \"shipping_policy\",\r\n" + 
				"        \"payment_policy\",\r\n" + 
				"        \"sold_as_is\",\r\n" + 
				"        \"same_day_shipping_ineligible\",\r\n" + 
				"        \"return_policy\",\r\n" + 
				"        \"videos\",\r\n" + 
				"        \"is_my_listing\",\r\n" + 
				"        \"photos\",\r\n" + 
				"        \"shipping\",\r\n" + 
				"        \"seller\",\r\n" + 
				"        \"_links\"\r\n" + 
				"      ]\r\n" + 
				"    },\r\n" + 
				"    \"errors\": {\r\n" + 
				"      \"type\": \"object\"\r\n" + 
				"    },\r\n" + 
				"    \"warnings\": {\r\n" + 
				"      \"type\": \"array\",\r\n" + 
				"      \"items\": [\r\n" + 
				"        {\r\n" + 
				"          \"type\": \"string\"\r\n" + 
				"        }\r\n" + 
				"      ]\r\n" + 
				"    }\r\n" + 
				"  },\r\n" + 
				"  \"required\": [\r\n" + 
				"    \"message\",\r\n" + 
				"    \"listing\",\r\n" + 
				"    \"errors\",\r\n" + 
				"    \"warnings\"\r\n" + 
				"  ]\r\n" + 
				"}";
		
	}



	public static String getProperty(String key) {

		Properties p = null ;

		try {

			FileReader f = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\Confic.properties");

			p = new Properties();

			p.load(f);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return p.getProperty(key);

	}



	public static Parent postRequestBody(String title, String description, String amount, String currency, String uuid, String price, String region )  {
		
		Parent p = new Parent();

		Domestic d = new Domestic();

		d.setPrice(price);
		
		d.setRegion(region);

		Shipping s = new Shipping();

		s.setDomestic(d);

		Condition c = new Condition();

		c.setUuid(uuid);

		Price pr = new Price();

		pr.setAmount(amount);

		pr.setCurrency(currency);

		p.setDescription(description);

		p.setTitle(title);

		p.setPrice(pr);

		p.setShipping(s);

		p.setCondition(c);

//		ObjectMapper ob = new ObjectMapper();
//
//		String writer = ob.writeValueAsString(p);
//
//		System.out.println(writer);
		return p;
	
	}
		
		public static Parent postRequestBody() {

		Parent p = new Parent();

		Domestic d = new Domestic();

		d.setPrice(getProperty("price"));
		
		d.setRegion(getProperty("region"));

		Shipping s = new Shipping();

		s.setDomestic(d);

		Condition c = new Condition();

		c.setUuid(getProperty("uuid"));

		Price pr = new Price();

		pr.setAmount(getProperty("amount"));

		pr.setCurrency(getProperty("currency"));

		p.setDescription(getProperty("description"));

		p.setTitle(getProperty("title"));

		p.setPrice(pr);

		p.setShipping(s);

		p.setCondition(c);

//		ObjectMapper ob = new ObjectMapper();
//
//		String writer = ob.writeValueAsString(p);
//
//		System.out.println(writer);
		return p;


	}
	
		
		public static PutParent putRequestbody(String  updatedtitle, String updateddescription, String updatedamount, String currency, String uuid){
			
			PutParent pput = new PutParent();
			
			PutPrice pr = new PutPrice();
			
			PutCondition c = new PutCondition();
			
			pr.setAmount(updatedamount);
			
			pr.setCurrency(currency);
			
			c.setUuid(uuid);
			
			pput.setCondition(c);
			
			pput.setPrice(pr);
			
			pput.setDescription(updateddescription);
			
			pput.setTitle(updatedtitle);
			
			return pput;
			
//			ObjectMapper ob = new ObjectMapper();
	//
//			String writer = ob.writeValueAsString(pput);
	//
//			System.out.println(writer);
			
		}
	
	
	public static PutParent putRequestbody(){
		
		PutParent pput = new PutParent();
		
		PutPrice pr = new PutPrice();
		
		PutCondition c = new PutCondition();
		
		pr.setAmount(getProperty("updatedamount"));
		
		pr.setCurrency(getProperty("currency"));
		
		c.setUuid(getProperty("uuid"));
		
		pput.setCondition(c);
		
		pput.setPrice(pr);
		
		pput.setDescription(getProperty("updateddescription"));
		
		pput.setTitle(getProperty("updatedtitle"));
		
		return pput;
		
//		ObjectMapper ob = new ObjectMapper();
//
//		String writer = ob.writeValueAsString(pput);
//
//		System.out.println(writer);
		
	}
	
	
	public static void getJVMReport(String json) {
		
		File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Reports\\JVM.html");
		
		Configuration conf = new Configuration(f, "API Requests");
		
		conf.addClassifications("UserName", System.getProperty("user.name"));
		
		List<String> li = new LinkedList();
		
		li.add(json);
		
		ReportBuilder rb = new ReportBuilder(li, conf);
		
		rb.generateReports();
		
	}
	

}
