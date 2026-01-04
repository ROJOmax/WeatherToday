package com.rojo.weattherToday.data.model;

import com.google.gson.annotations.SerializedName;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bs\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\f\u0012\u0006\u0010\u0017\u001a\u00020\b\u0012\u0006\u0010\u0018\u001a\u00020\f\u00a2\u0006\u0002\u0010\u0019J\t\u00100\u001a\u00020\u0003H\u00c6\u0003J\t\u00101\u001a\u00020\fH\u00c6\u0003J\t\u00102\u001a\u00020\fH\u00c6\u0003J\t\u00103\u001a\u00020\bH\u00c6\u0003J\t\u00104\u001a\u00020\fH\u00c6\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\t\u00106\u001a\u00020\bH\u00c6\u0003J\t\u00107\u001a\u00020\nH\u00c6\u0003J\t\u00108\u001a\u00020\fH\u00c6\u0003J\t\u00109\u001a\u00020\u000eH\u00c6\u0003J\t\u0010:\u001a\u00020\u0010H\u00c6\u0003J\t\u0010;\u001a\u00020\u0012H\u00c6\u0003J\t\u0010<\u001a\u00020\u0014H\u00c6\u0003J\u0091\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\fH\u00c6\u0001J\u0013\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010A\u001a\u00020\fH\u00d6\u0001J\t\u0010B\u001a\u00020\bH\u00d6\u0001R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0016\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0017\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u0018\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010\u0013\u001a\u00020\u00148\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\'R\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0016\u0010\u0015\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001dR\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001dR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/\u00a8\u0006C"}, d2 = {"Lcom/rojo/weattherToday/data/model/WeatherResponse;", "", "coordinates", "Lcom/rojo/weattherToday/data/model/Coordinates;", "weather", "", "Lcom/rojo/weattherToday/data/model/Weather;", "base", "", "main", "Lcom/rojo/weattherToday/data/model/Main;", "visibility", "", "wind", "Lcom/rojo/weattherToday/data/model/Wind;", "clouds", "Lcom/rojo/weattherToday/data/model/Clouds;", "timestamp", "", "sys", "Lcom/rojo/weattherToday/data/model/Sys;", "timezone", "cityId", "cityName", "cod", "(Lcom/rojo/weattherToday/data/model/Coordinates;Ljava/util/List;Ljava/lang/String;Lcom/rojo/weattherToday/data/model/Main;ILcom/rojo/weattherToday/data/model/Wind;Lcom/rojo/weattherToday/data/model/Clouds;JLcom/rojo/weattherToday/data/model/Sys;IILjava/lang/String;I)V", "getBase", "()Ljava/lang/String;", "getCityId", "()I", "getCityName", "getClouds", "()Lcom/rojo/weattherToday/data/model/Clouds;", "getCod", "getCoordinates", "()Lcom/rojo/weattherToday/data/model/Coordinates;", "getMain", "()Lcom/rojo/weattherToday/data/model/Main;", "getSys", "()Lcom/rojo/weattherToday/data/model/Sys;", "getTimestamp", "()J", "getTimezone", "getVisibility", "getWeather", "()Ljava/util/List;", "getWind", "()Lcom/rojo/weattherToday/data/model/Wind;", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class WeatherResponse {
    @com.google.gson.annotations.SerializedName(value = "coord")
    @org.jetbrains.annotations.NotNull()
    private final com.rojo.weattherToday.data.model.Coordinates coordinates = null;
    @com.google.gson.annotations.SerializedName(value = "weather")
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.rojo.weattherToday.data.model.Weather> weather = null;
    @com.google.gson.annotations.SerializedName(value = "base")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String base = null;
    @com.google.gson.annotations.SerializedName(value = "main")
    @org.jetbrains.annotations.NotNull()
    private final com.rojo.weattherToday.data.model.Main main = null;
    @com.google.gson.annotations.SerializedName(value = "visibility")
    private final int visibility = 0;
    @com.google.gson.annotations.SerializedName(value = "wind")
    @org.jetbrains.annotations.NotNull()
    private final com.rojo.weattherToday.data.model.Wind wind = null;
    @com.google.gson.annotations.SerializedName(value = "clouds")
    @org.jetbrains.annotations.NotNull()
    private final com.rojo.weattherToday.data.model.Clouds clouds = null;
    @com.google.gson.annotations.SerializedName(value = "dt")
    private final long timestamp = 0L;
    @com.google.gson.annotations.SerializedName(value = "sys")
    @org.jetbrains.annotations.NotNull()
    private final com.rojo.weattherToday.data.model.Sys sys = null;
    @com.google.gson.annotations.SerializedName(value = "timezone")
    private final int timezone = 0;
    @com.google.gson.annotations.SerializedName(value = "id")
    private final int cityId = 0;
    @com.google.gson.annotations.SerializedName(value = "name")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String cityName = null;
    @com.google.gson.annotations.SerializedName(value = "cod")
    private final int cod = 0;
    
    public WeatherResponse(@org.jetbrains.annotations.NotNull()
    com.rojo.weattherToday.data.model.Coordinates coordinates, @org.jetbrains.annotations.NotNull()
    java.util.List<com.rojo.weattherToday.data.model.Weather> weather, @org.jetbrains.annotations.NotNull()
    java.lang.String base, @org.jetbrains.annotations.NotNull()
    com.rojo.weattherToday.data.model.Main main, int visibility, @org.jetbrains.annotations.NotNull()
    com.rojo.weattherToday.data.model.Wind wind, @org.jetbrains.annotations.NotNull()
    com.rojo.weattherToday.data.model.Clouds clouds, long timestamp, @org.jetbrains.annotations.NotNull()
    com.rojo.weattherToday.data.model.Sys sys, int timezone, int cityId, @org.jetbrains.annotations.NotNull()
    java.lang.String cityName, int cod) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rojo.weattherToday.data.model.Coordinates getCoordinates() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.rojo.weattherToday.data.model.Weather> getWeather() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBase() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rojo.weattherToday.data.model.Main getMain() {
        return null;
    }
    
    public final int getVisibility() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rojo.weattherToday.data.model.Wind getWind() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rojo.weattherToday.data.model.Clouds getClouds() {
        return null;
    }
    
    public final long getTimestamp() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rojo.weattherToday.data.model.Sys getSys() {
        return null;
    }
    
    public final int getTimezone() {
        return 0;
    }
    
    public final int getCityId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCityName() {
        return null;
    }
    
    public final int getCod() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rojo.weattherToday.data.model.Coordinates component1() {
        return null;
    }
    
    public final int component10() {
        return 0;
    }
    
    public final int component11() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component12() {
        return null;
    }
    
    public final int component13() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.rojo.weattherToday.data.model.Weather> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rojo.weattherToday.data.model.Main component4() {
        return null;
    }
    
    public final int component5() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rojo.weattherToday.data.model.Wind component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rojo.weattherToday.data.model.Clouds component7() {
        return null;
    }
    
    public final long component8() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rojo.weattherToday.data.model.Sys component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rojo.weattherToday.data.model.WeatherResponse copy(@org.jetbrains.annotations.NotNull()
    com.rojo.weattherToday.data.model.Coordinates coordinates, @org.jetbrains.annotations.NotNull()
    java.util.List<com.rojo.weattherToday.data.model.Weather> weather, @org.jetbrains.annotations.NotNull()
    java.lang.String base, @org.jetbrains.annotations.NotNull()
    com.rojo.weattherToday.data.model.Main main, int visibility, @org.jetbrains.annotations.NotNull()
    com.rojo.weattherToday.data.model.Wind wind, @org.jetbrains.annotations.NotNull()
    com.rojo.weattherToday.data.model.Clouds clouds, long timestamp, @org.jetbrains.annotations.NotNull()
    com.rojo.weattherToday.data.model.Sys sys, int timezone, int cityId, @org.jetbrains.annotations.NotNull()
    java.lang.String cityName, int cod) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}