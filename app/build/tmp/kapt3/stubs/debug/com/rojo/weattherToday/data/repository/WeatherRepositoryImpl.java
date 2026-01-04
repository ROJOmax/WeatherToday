package com.rojo.weattherToday.data.repository;

import com.rojo.weattherToday.data.local.ForecastDao;
import com.rojo.weattherToday.data.local.WeatherDao;
import com.rojo.weattherToday.data.local.WeatherEntity;
import com.rojo.weattherToday.data.remote.WeatherApiService;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ,\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0016"}, d2 = {"Lcom/rojo/weattherToday/data/repository/WeatherRepositoryImpl;", "Lcom/rojo/weattherToday/data/repository/WeatherRepository;", "apiService", "Lcom/rojo/weattherToday/data/remote/WeatherApiService;", "weatherDao", "Lcom/rojo/weattherToday/data/local/WeatherDao;", "forecastDao", "Lcom/rojo/weattherToday/data/local/ForecastDao;", "(Lcom/rojo/weattherToday/data/remote/WeatherApiService;Lcom/rojo/weattherToday/data/local/WeatherDao;Lcom/rojo/weattherToday/data/local/ForecastDao;)V", "getCurrentWeather", "Lkotlin/Result;", "Lcom/rojo/weattherToday/data/local/WeatherEntity;", "cityName", "", "forceRefresh", "", "getCurrentWeather-0E7RQCE", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isCacheExpired", "cacheTimestamp", "", "Companion", "app_debug"})
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
    
    private final boolean isCacheExpired(long cacheTimestamp) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/rojo/weattherToday/data/repository/WeatherRepositoryImpl$Companion;", "", "()V", "CACHE_TIMEOUT", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}