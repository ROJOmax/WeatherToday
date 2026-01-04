package com.rojo.weattherToday.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0004J&\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u00a6@\u00a2\u0006\u0002\u0010\fJ,\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00062\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u00a6@\u00a2\u0006\u0002\u0010\fJ\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00112\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00112\u0006\u0010\b\u001a\u00020\tH&\u00a8\u0006\u0013"}, d2 = {"Lcom/rojo/weattherToday/data/repository/WeatherRepository;", "", "clearCache", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentWeather", "Lcom/rojo/weattherToday/data/remote/Result;", "Lcom/rojo/weattherToday/data/local/WeatherEntity;", "cityName", "", "forceRefresh", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getForecast", "", "Lcom/rojo/weattherToday/data/local/ForecastEntity;", "getForecastFlow", "Lkotlinx/coroutines/flow/Flow;", "getWeatherFlow", "app_debug"})
public abstract interface WeatherRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCurrentWeather(@org.jetbrains.annotations.NotNull()
    java.lang.String cityName, boolean forceRefresh, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.rojo.weattherToday.data.remote.Result<com.rojo.weattherToday.data.local.WeatherEntity>> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.rojo.weattherToday.data.local.WeatherEntity> getWeatherFlow(@org.jetbrains.annotations.NotNull()
    java.lang.String cityName);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getForecast(@org.jetbrains.annotations.NotNull()
    java.lang.String cityName, boolean forceRefresh, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.rojo.weattherToday.data.remote.Result<? extends java.util.List<com.rojo.weattherToday.data.local.ForecastEntity>>> $completion);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.rojo.weattherToday.data.local.ForecastEntity>> getForecastFlow(@org.jetbrains.annotations.NotNull()
    java.lang.String cityName);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object clearCache(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}