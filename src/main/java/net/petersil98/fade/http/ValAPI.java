package net.petersil98.fade.http;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeBase;
import com.fasterxml.jackson.databind.type.TypeFactory;
import net.petersil98.core.http.RiotAPI;
import net.petersil98.core.util.settings.Settings;
import net.petersil98.fade.constants.ValRegion;

import java.util.HashMap;
import java.util.Map;

public class ValAPI extends RiotAPI {

    private static final String VAL_RANKED_V1 = "ranked/v1/";
    private static final String VAL_MATCH_V1 = "match/v1/";

    /**
     * Requests the Valorant {@link #VAL_RANKED_V1} endpoint. If successful, the Response is mapped to the desired Class <b>T</b>.
     * If caching is enabled, the cached response will be returned.
     * @see Settings#useCache(boolean)
     * @param method Method in the Endpoint that should get called
     * @param args Extra data needed for the Request
     * @param region Region to make the request to
     * @param requiredClass Class to which the response should get mapped to
     * @return An object of class <b>T</b> if casting is successful, {@code null} otherwise
     */
    public static <T> T requestValRankedEndpoint(String method, String args, ValRegion region, Class<T> requiredClass) {
        return requestValRankedEndpoint(method, args, region, requiredClass, new HashMap<>());
    }

    /**
     * Requests the Valorant {@link #VAL_RANKED_V1} endpoint. If successful, the Response is mapped to the desired {@link TypeBase}.
     * This method is intended to be used for {@link com.fasterxml.jackson.databind.type.CollectionType CollectionTypes} or
     * {@link com.fasterxml.jackson.databind.type.MapType MapTypes}.
     * If caching is enabled, the cached response will be returned.
     * @see Settings#useCache(boolean)
     * @see TypeFactory
     * @param method Method in the Endpoint that should get called
     * @param args Extra data needed for the Request
     * @param region Region to make the request to
     * @param requiredClass Class to which the response should get mapped to
     * @return An object of Type <b>{@code requiredClass}</b> if casting is successful, {@code null} otherwise
     */
    public static <T> T requestValRankedEndpoint(String method, String args, ValRegion region, TypeBase requiredClass) {
        return requestValRankedEndpoint(method, args, region, requiredClass, new HashMap<>());
    }

    /**
     * Requests the Valorant {@link #VAL_RANKED_V1} endpoint. If successful, the Response is mapped to the desired Class <b>T</b>.
     * If caching is enabled, the cached response will be returned.
     * @see Settings#useCache(boolean)
     * @param method Method in the Endpoint that should get called
     * @param args Extra data needed for the Request
     * @param region Region to make the request to
     * @param requiredClass Class to which the response should get mapped to
     * @param filter The filter that should get used for the request. <b>Note:</b> The Values in the Map need to be Strings,
     *               even if they represent an integer
     * @return An object of class <b>T</b> if casting is successful, {@code null} otherwise
     */
    public static <T> T requestValRankedEndpoint(String method, String args, ValRegion region, Class<T> requiredClass, Map<String, String> filter) {
        return requestValRankedEndpoint(method, args, region, TypeFactory.defaultInstance().constructType(requiredClass), filter);
    }

    /**
     * Requests the Valorant {@link #VAL_RANKED_V1} endpoint. If successful, the Response is mapped to the desired {@link JavaType} <b>{@code requiredClass}</b>.
     * If caching is enabled, the cached response will be returned.
     * @see Settings#useCache(boolean)
     * @see TypeFactory
     * @param method Method in the Endpoint that should get called
     * @param args Extra data needed for the Request
     * @param region Region to make the request to
     * @param requiredClass Class to which the response should get mapped to
     * @param filter The filter that should get used for the request. <b>Note:</b> The Values in the Map need to be Strings,
     *               even if they represent an integer
     * @return An object of Type <b>{@code requiredClass}</b> if casting is successful, {@code null} otherwise
     */
    public static <T> T requestValRankedEndpoint(String method, String args, ValRegion region, JavaType requiredClass, Map<String, String> filter) {
        return handleCacheAndRateLimiter(
                constructUrl(VAL_RANKED_V1 + method + args, AppType.VAL, region),
                VAL_RANKED_V1 + method, region, requiredClass, filter);
    }

    /**
     * Requests the Valorant {@link #VAL_MATCH_V1} endpoint. If successful, the Response is mapped to the desired Class <b>T</b>.
     * If caching is enabled, the cached response will be returned.
     * @see Settings#useCache(boolean)
     * @param method Method in the Endpoint that should get called
     * @param args Extra data needed for the Request
     * @param region Region to make the request to
     * @param requiredClass Class to which the response should get mapped to
     * @return An object of class <b>T</b> if casting is successful, {@code null} otherwise
     */
    public static <T> T requestValMatchEndpoint(String method, String args, ValRegion region, Class<T> requiredClass) {
        return requestValMatchEndpoint(method, args, region, requiredClass, new HashMap<>());
    }

    /**
     * Requests the Valorant {@link #VAL_MATCH_V1} endpoint. If successful, the Response is mapped to the desired {@link TypeBase}.
     * This method is intended to be used for {@link com.fasterxml.jackson.databind.type.CollectionType CollectionTypes} or
     * {@link com.fasterxml.jackson.databind.type.MapType MapTypes}.
     * If caching is enabled, the cached response will be returned.
     * @see Settings#useCache(boolean)
     * @see TypeFactory
     * @param method Method in the Endpoint that should get called
     * @param args Extra data needed for the Request
     * @param region Region to make the request to
     * @param requiredClass Class to which the response should get mapped to
     * @return An object of Type <b>{@code requiredClass}</b> if casting is successful, {@code null} otherwise
     */
    public static <T> T requestValMatchEndpoint(String method, String args, ValRegion region, TypeBase requiredClass) {
        return requestValMatchEndpoint(method, args, region, requiredClass, new HashMap<>());
    }

    /**
     * Requests the Valorant {@link #VAL_MATCH_V1} endpoint. If successful, the Response is mapped to the desired Class <b>T</b>.
     * If caching is enabled, the cached response will be returned.
     * @see Settings#useCache(boolean)
     * @param method Method in the Endpoint that should get called
     * @param args Extra data needed for the Request
     * @param region Region to make the request to
     * @param requiredClass Class to which the response should get mapped to
     * @param filter The filter that should get used for the request. <b>Note:</b> The Values in the Map need to be Strings,
     *               even if they represent an integer
     * @return An object of class <b>T</b> if casting is successful, {@code null} otherwise
     */
    public static <T> T requestValMatchEndpoint(String method, String args, ValRegion region, Class<T> requiredClass, Map<String, String> filter) {
        return requestValMatchEndpoint(method, args, region, TypeFactory.defaultInstance().constructType(requiredClass), filter);
    }

    /**
     * Requests the Valorant {@link #VAL_MATCH_V1} endpoint. If successful, the Response is mapped to the desired {@link JavaType} <b>{@code requiredClass}</b>.
     * If caching is enabled, the cached response will be returned.
     * @see Settings#useCache(boolean)
     * @see TypeFactory
     * @param method Method in the Endpoint that should get called
     * @param args Extra data needed for the Request
     * @param region Region to make the request to
     * @param requiredClass Class to which the response should get mapped to
     * @param filter The filter that should get used for the request. <b>Note:</b> The Values in the Map need to be Strings,
     *               even if they represent an integer
     * @return An object of Type <b>{@code requiredClass}</b> if casting is successful, {@code null} otherwise
     */
    public static <T> T requestValMatchEndpoint(String method, String args, ValRegion region, JavaType requiredClass, Map<String, String> filter) {
        return handleCacheAndRateLimiter(
                constructUrl(VAL_MATCH_V1 + method + args, AppType.VAL, region),
                VAL_MATCH_V1 + method, region, requiredClass, filter);
    }
}
