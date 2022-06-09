
/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.listener.ResponseValidationFailureListener;
import io.restassured.path.json.mapper.factory.Jackson2ObjectMapperFactory;

import static io.restassured.config.FailureConfig.failureConfig;
import static io.restassured.config.RedirectConfig.redirectConfig;

/**
 * declare configurations to run api request with {@link io.restassured}
 * @author Tali Rabinovitz
 * @since Dec 2021
 * @see io.restassured
 */
public class ConfigFactory {

    /**
     * get author custom configurations of Rest-assured
     * @return RestAssuredConfig
     */
    public static RestAssuredConfig getAnotherCostumConfig(){
        //..
        return null;
    }

    /**
     * get default configuration of Rest-assured
     * @return RestAssuredConfig
     */
    public static RestAssuredConfig getDefaultConfig(){

        ResponseValidationFailureListener failureListener =
                (reqSpec, resSpec, response) ->
                        System.out.printf("We have a failure, ",
                                "response status was %s and the body contained %s",
                                response.getStatusCode(), response.body().asPrettyString());

        return RestAssured.config()
                .logConfig(LogConfig.logConfig().enableLoggingOfRequestAndResponseIfValidationFails(LogDetail.ALL))
                .failureConfig(failureConfig().failureListeners(failureListener))
                .redirect(redirectConfig().maxRedirects(1))
                .objectMapperConfig(ObjectMapperConfig.objectMapperConfig()
                        .jackson2ObjectMapperFactory(getDefaultMapper()));


    }

    /**
     * get default mapper from json
     * @return Jackson2ObjectMapperFactory
     */
    private static Jackson2ObjectMapperFactory getDefaultMapper(){
        return (type, s) -> {
            ObjectMapper om = new ObjectMapper();
            om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return om;
        };
    }
}
