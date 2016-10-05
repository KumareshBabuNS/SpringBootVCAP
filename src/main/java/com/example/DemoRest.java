package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DemoRest
{
    private static final Logger logger = LoggerFactory.getLogger(DemoRest.class);

    @RequestMapping(value = "/version", method = RequestMethod.GET)
    public String version()
    {
        return "1.0";
    }

    @RequestMapping(value = "/vcapapplication", method = RequestMethod.GET)
    public Map vcapApplication() throws Exception
    {
        return Utils.getEnvMap("VCAP_APPLICATION");
    }

    @RequestMapping(value = "/vcapservices", method = RequestMethod.GET)
    public Map vcapServices() throws Exception
    {
        return Utils.getEnvMap("VCAP_SERVICES");
    }

    @RequestMapping(value = "/vcapservices_json", method = RequestMethod.GET)
    public String vcapServicesJSON() throws Exception
    {
        return System.getenv().get("VCAP_SERVICES");
    }


    @RequestMapping(value = "/appindex", method = RequestMethod.GET)
    public String appIndex() throws Exception
    {
        String instanceIndex = "N/A";

        try
        {
            instanceIndex = Utils.getEnvMap("VCAP_APPLICATION").getOrDefault("instance_index", "N/A").toString();
        }
        catch (Exception ex)
        {
           logger.info("Exception getting application index : " + ex.getMessage());
        }

        return instanceIndex;
    }

    @RequestMapping(value = "/getEnvVariable/{env_var}", method = RequestMethod.GET)
    public String getEnvVariable(@PathVariable String env_var)
    {
        return System.getenv().get(env_var);
    }

}
