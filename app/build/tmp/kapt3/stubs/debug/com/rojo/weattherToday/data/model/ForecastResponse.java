package com.rojo.weattherToday.data.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u000bH\u00c6\u0003JA\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u00c6\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001f\u001a\u00020\u0005H\u00d6\u0001J\t\u0010 \u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012\u00a8\u0006!"}, d2 = {"Lcom/rojo/weattherToday/data/model/ForecastResponse;", "", "cod", "", "message", "", "count", "forecastList", "", "Lcom/rojo/weattherToday/data/model/ForecastItem;", "city", "Lcom/rojo/weattherToday/data/model/City;", "(Ljava/lang/String;IILjava/util/List;Lcom/rojo/weattherToday/data/model/City;)V", "getCity", "()Lcom/rojo/weattherToday/data/model/City;", "getCod", "()Ljava/lang/String;", "getCount", "()I", "getForecastList", "()Ljava/util/List;", "getMessage", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class ForecastResponse {
    @com.google.gson.annotations.SerializedName(value = "cod")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String cod = null;
    @com.google.gson.annotations.SerializedName(value = "message")
    private final int message = 0;
    @com.google.gson.annotations.SerializedName(value = "cnt")
    private final int count = 0;
    @com.google.gson.annotations.SerializedName(value = "list")
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.rojo.weattherToday.data.model.ForecastItem> forecastList = null;
    @com.google.gson.annotations.SerializedName(value = "city")
    @org.jetbrains.annotations.NotNull()
    private final com.rojo.weattherToday.data.model.City city = null;
    
    public ForecastResponse(@org.jetbrains.annotations.NotNull()
    java.lang.String cod, int message, int count, @org.jetbrains.annotations.NotNull()
    java.util.List<com.rojo.weattherToday.data.model.ForecastItem> forecastList, @org.jetbrains.annotations.NotNull()
    com.rojo.weattherToday.data.model.City city) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCod() {
        return null;
    }
    
    public final int getMessage() {
        return 0;
    }
    
    public final int getCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.rojo.weattherToday.data.model.ForecastItem> getForecastList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rojo.weattherToday.data.model.City getCity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final int component3() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.rojo.weattherToday.data.model.ForecastItem> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rojo.weattherToday.data.model.City component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.rojo.weattherToday.data.model.ForecastResponse copy(@org.jetbrains.annotations.NotNull()
    java.lang.String cod, int message, int count, @org.jetbrains.annotations.NotNull()
    java.util.List<com.rojo.weattherToday.data.model.ForecastItem> forecastList, @org.jetbrains.annotations.NotNull()
    com.rojo.weattherToday.data.model.City city) {
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