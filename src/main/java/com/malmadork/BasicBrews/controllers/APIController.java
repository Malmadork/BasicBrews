package com.malmadork.BasicBrews.controllers;

import com.google.gson.Gson;

/**
 * Superclass for API controllers, defines functionality
 * for serializing messages in JSON.
 *
 * @author Marie Schwartz
 */
public abstract class APIController {
    /** Base path of API */
    static final protected String BASE_PATH = "/api/v1/";

    /** Used to serialize data and messages to JSON */
    static final private Gson GSON = new Gson();

    /**
     * Turns the provided object into JSON
     *
     * @param obj The object to serialize/stringify
     * @return The resulting JSON String
     */
    static final protected String toJson ( final Object obj ) {
        return GSON.toJson( obj );
    }

    /**
     * Turns the provided object into JSON, providing the class of the object to
     * give a better serialization. Use this if the type is known.
     *
     * @param obj The object to serialize to JSON
     * @param cls The class of the object
     * @return The resulting JSON String
     */
    static final protected String toJson ( final Object obj, final Class<JSONResponse> cls ) {
        return GSON.toJson( obj, cls );
    }

    /**
     * Creates a JSONResponse that contains a provided status
     * and a provided message.
     *
     * @param status The status of the request to send
     * @param message The message to send
     * @return The resulting JSON String
     */
    static final protected String responseMessage ( final String status, final String message ) {
        return toJson( new JSONResponse( status, message ), JSONResponse.class );
    }

    /**
     * Creates a JSONResponse with a failed status and a
     * contains a provided message.
     *
     * @param message A detailed message to send
     * @return The resulting JSON String
     */
    static final protected String errorResponse ( final String message ) {
        return responseMessage( "failed", message );
    }

    /**
     * Creates a JSONResponse with a success status and a
     * contains a provided message.
     *
     * @param message A detailed message to send
     * @return The resulting JSON String
     */
    static final protected String successResponse ( final String message ) {
        return responseMessage( "success", message );
    }

    /**
     * Used to create simple success/error messages to return via REST API.
     * Contains a status and a message.
     *
     */
    static protected class JSONResponse {

        /**
         * Status of the response (success/failed)
         */
        String status;

        /**
         * Message
         */
        String message;

        /**
         * Default constructor for JSONResponse.
         *
         * @param status Response status (success/failed)
         * @param message Response message
         */
        public JSONResponse ( final String status, final String message ) {
            this.status = status;
            this.message = message;
        }
    }
}
