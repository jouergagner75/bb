/*
 * deposits
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v2
 *
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.mambu.sdk.api.auth;

import com.mambu.sdk.api.Pair;

import java.util.List;
import java.util.Map;

public interface Authentication {
    /**
     * Apply authentication settings to header and query params.
     *
     * @param queryParams  List of query parameters
     * @param headerParams Map of header parameters
     */
    void applyToParams(List<Pair> queryParams, Map<String, String> headerParams);
}
