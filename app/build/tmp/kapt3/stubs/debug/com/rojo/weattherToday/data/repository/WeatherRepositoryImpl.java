package com.rojo.weattherToday.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\nH\u0096@\u00a2\u0006\u0002\u0010\u000bJ$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@\u00a2\u0006\u0002\u0010\u0013J*\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@\u00a2\u0006\u0002\u0010\u0013J\u001c\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u00182\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u00182\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020!H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/rojo/weattherToday/data/repository/WeatherRepositoryImpl;", "Lcom/rojo/weattherToday/data/repository/WeatherRepository;", "apiService", "Lcom/rojo/weattherToday/data/remote/WeatherApiService;", "weatherDao", "Lcom/rojo/weattherToday/data/local/WeatherDao;", "forecastDao", "Lcom/rojo/weattherToday/data/local/ForecastDao;", "(Lcom/rojo/weattherToday/data/remote/WeatherApiService;Lcom/rojo/weattherToday/data/local/WeatherDao;Lcom/rojo/weattherToday/data/local/ForecastDao;)V", "clearCache", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentWeather", "Lcom/rojo/weattherToday/data/remote/Result;", "Lcom/rojo/weattherToday/data/local/WeatherEntity;", "cityName", "", "forceRefresh", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getForecast", "", "Lcom/rojo/weattherToday/data/local/ForecastEntity;", "getForecastFlow", "Lkotlinx/coroutines/flow/Flow;", "getWeatherFlow", "isCacheExpired", "cacheTimestamp", "", "mapForecastResponseToEntities", "response", "Lcom/rojo/weattherToday/data/model/ForecastResponse;", "mapWeatherResponseToEntity", "Lcom/rojo/weattherToday/data/model/WeatherResponse;", "Companion", "app_debug"})
public final class WeatherRepositoryImpl implements com.rojo.weattherToday.data.repository.WeatherRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.rojo.weattherToday.data.remote.WeatherApiService apiService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.rojo.weattherToday.data.local.WeatherDao weatherDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.rojo.weattherToday.data.local.ForecastDao forecastDao = null;
    private static final long CACHE_TIMEOUT = 1800000L;
    @org.jetbrains.annotations.NotNull()
    public static final com.rojo.weattherToday.data.repository.WeatherRepositoryImpl.Companion Companion = null;
    
    @javax.inject.Inject()
    public WeatherRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.rojo.weattherToday.data.remote.WeatherApiService apiService, @org.jetbrains.annotations.NotNull()
    com.rojo.weattherToday.data.local.WeatherDao weatherDao, @org.jetbrains.annotations.NotNull()
    com.rojo.weattherToday.data.local.ForecastDao forecastDao) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getCurrentWeather(@org.jetbrains.annotations.NotNull()
    java.lang.String cityName, boolean forceRefresh, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.rojo.weattherToday.data.remote.Result<com.rojo.weattherToday.data.local.WeatherEntity>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<com.rojo.weattherToday.data.local.WeatherEntity> getWeatherFlow(@org.jetbrains.annotations.NotNull()
    java.lang.String cityName) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object getForecast(@org.jetbrains.annotations.NotNull()
    java.lang.String cityName, boolean forceRefresh, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.rojo.weattherToday.data.remote.Result<? extends java.util.List<com.rojo.weattherToday.data.local.ForecastEntity>>> $completion) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.util.List<com.rojo.weattherToday.data.local.ForecastEntity>> getForecastFlow(@org.jetbrains.annotations.NotNull()
    java.lang.String cityName) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object clearCache(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final boolean isCacheExpired(long cacheTimestamp) {
        return false;
    }
    
    private final com.rojo.weattherToday.data.local.WeatherEntity mapWeatherResponseToEntity(com.rojo.weattherToday.data.model.WeatherResponse response) {
        return null;
    }
    
    private final java.util.List<com.rojo.weattherToday.data.local.ForecastEntity> mapForecastResponseToEntities(com.rojo.weattherToday.data.model.ForecastResponse response, java.lang.String cityName) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/rojo/weattherToday/data/repository/WeatherRepositoryImpl$Companion;", "", "()V", "CACHE_TIMEOUT", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}