package com.rojo.weattherToday.data.remote;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\tJ<\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\u000eJ2\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\u0006H\u00a7@\u00a2\u0006\u0002\u0010\t\u00a8\u0006\u0011"}, d2 = {"Lcom/rojo/weattherToday/data/remote/WeatherApiService;", "", "getCurrentWeather", "Lretrofit2/Response;", "Lcom/rojo/weattherToday/data/model/WeatherResponse;", "cityName", "", "apiKey", "units", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentWeatherByCoordinates", "latitude", "", "longitude", "(DDLjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getForecast", "Lcom/rojo/weattherToday/data/model/ForecastResponse;", "app_debug"})
public abstract interface WeatherApiService {
    
    /**
     * Fetches current weather for a city
     * @param cityName Name of the city
     * @param apiKey Your OpenWeatherMap API key
     * @param units Temperature unit (metric, imperial, standard)
     */
    @retrofit2.http.GET(value = "weather")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCurrentWeather(@retrofit2.http.Query(value = "q")
    @org.jetbrains.annotations.NotNull()
    java.lang.String cityName, @retrofit2.http.Query(value = "appid")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @retrofit2.http.Query(value = "units")
    @org.jetbrains.annotations.NotNull()
    java.lang.String units, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.rojo.weattherToday.data.model.WeatherResponse>> $completion);
    
    /**
     * Fetches 5-day weather forecast
     * @param cityName Name of the city
     * @param apiKey Your OpenWeatherMap API key
     * @param units Temperature unit
     */
    @retrofit2.http.GET(value = "forecast")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getForecast(@retrofit2.http.Query(value = "q")
    @org.jetbrains.annotations.NotNull()
    java.lang.String cityName, @retrofit2.http.Query(value = "appid")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @retrofit2.http.Query(value = "units")
    @org.jetbrains.annotations.NotNull()
    java.lang.String units, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.rojo.weattherToday.data.model.ForecastResponse>> $completion);
    
    /**
     * Fetches current weather by coordinates
     */
    @retrofit2.http.GET(value = "weather")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCurrentWeatherByCoordinates(@retrofit2.http.Query(value = "lat")
    double latitude, @retrofit2.http.Query(value = "lon")
    double longitude, @retrofit2.http.Query(value = "appid")
    @org.jetbrains.annotations.NotNull()
    java.lang.String apiKey, @retrofit2.http.Query(value = "units")
    @org.jetbrains.annotations.NotNull()
    java.lang.String units, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.rojo.weattherToday.data.model.WeatherResponse>> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}