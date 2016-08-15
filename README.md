# springws
simple web application that allows a user to create ad campaigns

instructions for deploying and running the application

        Step1:download or clone git repository
        Step2:go to the downloaded folder and /springws/mvn clean install spring-boot:run
Alternatively the jar may be created using mvn clean package
and then run java -jar springws-0.0.1-SNAPSHOT.jar
The service should be up and running within a few seconds.

EXECTUTION STEPS:

        Create Ad Campaign
        URL:http://localhost:8080/ad 
        METHOD: POST 
        Content-Type:application/json
        SAMPLE REQUEST BODY:
                {
                "partner_id": "partner1",
                "duration": "6565",
                "ad_content": "string_of_content_to_display_as_ad"
                }
        SAMPLE OUTPUT:
        
        
            {
                "statusCode": "200",
                "message": "Ad created at Sun Aug 14 23:33:24 EDT 2016"
            }




        Fetch Ad Campaign for a Partner
        URL:http://localhost:8080/ad/partner1
        METHOD: GET
            {
                "partner_id": "partner1",
                "duration": "190000",
                "ad_content": "string_of_content_to_display_as_ad",
                "adStatus": "ACTIVE"
            }


URL to return a list of all campaigns
        URL:http://localhost:8080/ad
        METHOD: GET
        SAMPLE OUTPUT:

            {
                "partner2":
                [
                    {
                        "partner_id": "partner2",
                        "duration": "90000",
                        "ad_content": "string_of_content_to_display_as_ad",
                        "adStatus": "EXPIRED"
                    }
                ],
                "partner1":
                [
                    {
                        "partner_id": "partner1",
                        "duration": "6565",
                        "ad_content": "string_of_content_to_display_as_ad",
                        "adStatus": "EXPIRED"
                    },
                    {
                        "partner_id": "partner1",
                        "duration": "200",
                        "ad_content": "string_of_content_to_display_as_ad",
                        "adStatus": "EXPIRED"
                    },
                    {
                        "partner_id": "partner1",
                        "duration": "20000",
                        "ad_content": "string_of_content_to_display_as_ad",
                        "adStatus": "EXPIRED"
                    },
                    {
                        "partner_id": "partner1",
                        "duration": "190000",
                        "ad_content": "string_of_content_to_display_as_ad",
                        "adStatus": "ACTIVE"
                    }
                ]
            }
        
